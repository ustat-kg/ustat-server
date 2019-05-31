package com.example.USTAT.controller;

import com.example.USTAT.model.Subject;
import com.example.USTAT.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(SubjectController.URL_SUBJECT)
public class SubjectController {

    public static final String URL_SUBJECT = "/ustat/";

    @Autowired
    private SubjectService subjectService;

    @GetMapping(path = "/subject/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Subject getSubjectById(@PathVariable Long id){
        return subjectService.findSubjectById(id);
    }

    @GetMapping(path = "/getAllSubject",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Subject> getAllSubject(){
        return subjectService.getAllSubjects();
    }

    @PostMapping(path = "/saveSubject",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Subject addSubject(@RequestBody Subject subject){
        return subjectService.addSubject(subject);
    }

    @DeleteMapping(path = "/admin/deleteSubject/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    private void deleteSubjectById(@PathVariable Long id){
        subjectService.deleteSubjectById(id);
    }

    @DeleteMapping(path = "/admin/deleteAllSubjects" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAllSubjects(){
        subjectService.deleteAllSubjects();
    }
}
