package com.example.USTAT.controller;

import com.example.USTAT.model.Response;
import com.example.USTAT.model.Student;
import com.example.USTAT.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(StudentController.URL_STUDENT)
public class StudentController {

    public static final String URL_STUDENT = "/ustat/"; /*start url for all requests
     in class Student*/

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/getStudent/{id}", //returns one student by id
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response getStudentById(@PathVariable Long id) {
        return new Response(true,"Getting student by id", this.studentService.getStudentById(id));
    }

    @GetMapping(path = "/getAllStudents", //returns all students
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response getAllStudent() {
        return new Response(true,"Getting all students" ,this.studentService.getAllStudents());
    }

    @PostMapping(path = "/saveStudent", //saves one student in DataBase
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response saveStudent(@RequestBody Student student) {
        return new Response(true,"Saving student",this.studentService.saveStudent(student));
    }

    @PostMapping(path = "/updateStudent", // updates data of one student
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response updateStudent(@RequestBody Student student) {
        return new Response(true,"Updating Student",this.studentService.updateStudent(student));
    }

    @DeleteMapping(path = "/deleteStudent/{id}", //deletes one student by id
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response deleteStudentById(@PathVariable Long id) {
        this.studentService.deleteStudentById(id);
        return new Response(true,"Deleting student by id",null);
    }

    @DeleteMapping(path = "/admin/deleteAllStudents", //deletes all students
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response deleteAllStudents() {
        this.studentService.deleteAllStudents();
        return new Response(true,"Deleting all students",null);
    }

}

