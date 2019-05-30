package com.example.USTAT.controller;

import com.example.USTAT.model.Student;
import com.example.USTAT.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(StudentController.URL_STUDENT)
public class StudentController {

    public static final String URL_STUDENT = "/ustat/"; /*start url for all requests
     in class Student*/

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/getStudent/{id}", //returns one student by id
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Student getStudentById(@PathVariable Long id) {
        return this.studentService.getStudentById(id);
    }

    @GetMapping(path = "/getAllStudents", //returns all students
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Student> getAllStudent() {
        return this.studentService.getAllStudents();
    }

    @PostMapping(path = "/saveStudent", //saves one student in DataBase
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Student saveStudent(@RequestBody Student student) {
        return this.studentService.saveStudent(student);
    }

    @PostMapping(path = "/updateStudent", // updates data of one student
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Student udpateStudent(@RequestBody Student student) {
        return this.studentService.updateStudent(student);
    }

    @DeleteMapping(path = "/deleteStudent/{id}", //deletes one student by id
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteStudentById(@PathVariable Long id) {
        this.studentService.deleteStudentById(id);
    }

    @DeleteMapping(path = "/admin/deleteAllStudents", //deletes all students
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAllStudents() {
        this.studentService.deleteAllStudents();
    }

}

