package com.example.USTAT.controller;

import com.example.USTAT.Helper.ToGetCurrentUser;
import com.example.USTAT.model.FirstFilter;
import com.example.USTAT.model.Response;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstFilterController {

    private ToGetCurrentUser toGetCurrentUser;

    @PostMapping(path = "/ustat/" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response saveFirstRequest(@RequestBody FirstFilter firstRequest){
        toGetCurrentUser.getCurrentUser();
        FirstFilter request = new FirstFilter();
        request.setLevelOfTeacher(firstRequest.getLevelOfTeacher());
        request.setAge(firstRequest.getAge());
        request.setCost(firstRequest.getCost());
        request.setGender(firstRequest.getGender());
        request.setLocation(firstRequest.getLocation());
        return new Response(true,"saving first request" , null);
    }
}
