package com.example.USTAT.controller;

import com.example.USTAT.model.FirstRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRequestController {

    @PostMapping(path = "/ustat/" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void saveFirstRequest(@RequestBody FirstRequest firstRequest){
        FirstRequest request = new FirstRequest();
        request.setId(firstRequest.getId());
        request.setLevelOfTeacher(firstRequest.getLevelOfTeacher());
        request.setAge(firstRequest.getAge());
        request.setCost(firstRequest.getCost());
        request.setGender(firstRequest.getGender());
        request.setLocation(firstRequest.getLocation());
    }
    
}
