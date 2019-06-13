package com.example.USTAT.controller;

import com.example.USTAT.model.Request;
import com.example.USTAT.model.Response;
import com.example.USTAT.model.Subject;
import com.example.USTAT.repository.RequestRepository;
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

    @Autowired
    private RequestRepository requestRepository;


    @GetMapping(path = "/getRequest/{id}")
    public Response getRequestById(@PathVariable Long id){
        return new Response(true,"Getting request by id",requestService.getRequestById(id));
    }

    @GetMapping(path = "/getAllRequests/{teacher_id}")
    public Response getAllRequests(@PathVariable Long teacher_id) {
        return new Response(true, "Getting all requests by teacher id", requestRepository.getAllRequests(teacher_id));
    }



    @PostMapping(path = "/saveRequest")
    public Response addRequest(@RequestBody Request request){
        return new Response(true,"Saving request",requestService.saveRequest(request));
    }

    @DeleteMapping(path = "/deleteRequest/{id}")
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
