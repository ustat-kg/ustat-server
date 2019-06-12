package com.example.USTAT.controller;

import com.example.USTAT.model.Response;
import com.example.USTAT.model.Subject;
import com.example.USTAT.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SubjectController.URL_SUBJECT)
public class SubjectController {

    public static final String URL_SUBJECT = "/ustat/";

    @Autowired
    private SubjectService subjectService;

    @GetMapping(path = "/getSubject/{id}")
    public Response getSubjectById(@PathVariable Long id){
        return new Response(true,"Getting subject by id",subjectService.findSubjectById(id));
    }

    @GetMapping(path = "/getAllSubject")
    public Response getAllSubject(){
        return new Response(true,"Getting all subjects" , subjectService.getAllSubjects());
    }



    @PostMapping(path = "/saveSubject")
    public Response addSubject(@RequestBody Subject subject){
        return new Response(true,"Saving subject",subjectService.addSubject(subject));
    }

    @DeleteMapping(path = "/admin/deleteSubject/{id}")
    private Response deleteSubjectById(@PathVariable Long id){
        subjectService.deleteSubjectById(id);
        return new Response(true,"Deleting subject by id",null);
    }

    @DeleteMapping(path = "/admin/deleteAllSubjects")
    public Response deleteAllSubjects(){
        subjectService.deleteAllSubjects();
        return new Response(true,"Deleting all subjects",null);
    }
}
