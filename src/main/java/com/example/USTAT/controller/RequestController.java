package com.example.USTAT.controller;

import com.example.USTAT.Helper.ToGetAllRequestsByTeacher;
import com.example.USTAT.model.*;
import com.example.USTAT.repository.RequestRepository;
import com.example.USTAT.service.RequestService;
import com.example.USTAT.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Component
@RequestMapping(RequestController.URL_REQUEST)
public class RequestController {

    public static final String URL_REQUEST = "/ustat"; /*start url for all requests
     in class Request*/

    @Autowired
    private RequestService requestService;

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private StudentService studentService;


    @GetMapping(path = "/getRequest/{id}")
    public Response getRequestById(@PathVariable Long id){
        return new Response(true,"Getting request by id",requestService.getRequestById(id));
    }

    @GetMapping(path = "/getAllRequests/{teacher_id}")
    @ResponseBody
    public Response getAllRequests(@PathVariable Long teacher_id) {
        ArrayList<ToGetAllRequestsByTeacher> requests1 = new ArrayList<>(requestRepository.getAllRequests(teacher_id));
        ToGetAllRequestsByTeacher requestss = new ToGetAllRequestsByTeacher() {
            @Override
            public Long getId() {
                for(int i = 0; i < requests1.size(); i++){
                    return requests1.get(i).getId();
                }
                return null;
            }

            @Override
            public String getMassage() {
                for(int i = 0; i < requests1.size(); i++){
                    return requests1.get(i).getMassage();
                }
                return null;
            }

            @Override
            public Student getStudent() {
                for(int i = 0; i < requests1.size(); i++){
               //    return studentService.getStudentById(requests1.get(i).getStudent());

                }
                return null;
            }

            @Override
            public Teacher getTeacher() {
                for(int i = 0; i < requests1.size(); i++){
                    return requests1.get(i).getTeacher();
                }
                return null;
            }

            @Override
            public Request getRequest() {
                for(int i = 0; i < requests1.size(); i++){
                    return requests1.get(i).getRequest();
                }
                return null;
            }

            @Override
            public Subject getSubject() {
                for(int i = 0; i < requests1.size(); i++){
                    return requests1.get(i).getSubject();
                }
                return null;
            }
        };
        return new Response(true, "Getting all requests by teacher id", requestss );
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
