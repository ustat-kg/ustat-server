package com.example.USTAT.controller;

import com.example.USTAT.model.Request;
import com.example.USTAT.model.Response;
import com.example.USTAT.model.Subject;
import com.example.USTAT.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RequestMapping(RequestController.URL_REQUEST)
public class RequestController {

    public static final String URL_REQUEST = "/ustat/"; /*start url for all requests
     in class Request*/

    @Autowired
    private RequestService requestService;


    @GetMapping(path = "/getRequest/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response getRequestById(@PathVariable Long id){
        return new Response(true,"Getting request by id",requestService.getRequestById(id));
    }

    @GetMapping(path = "/getAllRequests/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response getAllRequests(@PathVariable Long id){
        return new Response(true,"Getting all requests by teacher id" , requestService.getAllRequestsById(id));
    }



    @PostMapping(path = "/saveRequest",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response addRequest(@RequestBody Request request){
        return new Response(true,"Saving request",requestService.saveRequest(request));
    }

    @DeleteMapping(path = "/deleteRequest/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    private Response deleteRequestById(@PathVariable Long id){
        requestService.deleteRequestById(id);
        return new Response(true,"Deleting request by id",null);
    }

    @DeleteMapping(path = "/admin/deleteAllRequests" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response deleteAllRequests(){
        requestService.deleteAllRequests();
        return new Response(true,"Deleting all requests",null);
    }

}
