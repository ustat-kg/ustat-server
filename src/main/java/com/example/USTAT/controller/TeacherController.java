package com.example.USTAT.controller;

import com.example.USTAT.Helper.ToGetCurrentUser;
import com.example.USTAT.model.Response;
import com.example.USTAT.model.Teacher;
import com.example.USTAT.repository.TeacherRepository;
import com.example.USTAT.service.TeacherService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(TeacherController.URL_TEACHER)
public class TeacherController {

    public static final String URL_TEACHER = "/ustat/"; /*start url for all requests
     in class Teacher*/

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ToGetCurrentUser toGetCurrentUser;

    @GetMapping(path = "/getTeacher/{id}") //returns one teacher by id
    public Response getTeacherById(@PathVariable Long id) {
        return new Response(true,"Getting teacher by id", this.teacherService.getTeacherById(id));
    }

    @GetMapping(path = "/getAllTeachers")//returns all teachers
    public Response getAllTeachers() {
        return new Response(true,"Getting all teachers" ,this.teacherService.getAllTeachers());
    }

//    @GetMapping(path = "/getAllTeacherByAge/{age}")
//    public Response getAllByAge(@PathVariable("age") Integer age){
//        return new Response(true,"Getting all teachers by age", teacherRepository.getAllByAge(age));
//    }

    @PostMapping(path = "/saveTeacher") //saves one teacher in DataBase
    public Response saveTeacher(@RequestBody Teacher teacher , Authentication authentication) {
        toGetCurrentUser.getCurrentUser();
        //teacher.setUser(toGetCurrentUser.getCurrentUser());
        return new Response(true,"Saving teacher",this.teacherService.addTeacher(teacher));
    }

    @PostMapping(path = "/updateTeacher")// updates data of one teacher
    public Response updateTeacher(@RequestBody Teacher teacher) {
        return new Response(true,"Updating teacher",this.teacherService.updateTeacher(teacher));
    }

    @DeleteMapping(path = "/deleteTeacher/{id}")//deletes one teacher by id
    public Response deleteTeacherById(@PathVariable Long id) {
        this.teacherService.deleteTeacherById(id);
        return new Response(true,"Deleting teacher by id",null);
    }

    @DeleteMapping(path = "/admin/deleteAllTeachers")//deletes all teachers
    public Response deleteAllTeachers() {
        this.teacherService.deleteAllTeachers();
        return new Response(true,"Deleting all teachers",null);
    }

    @GetMapping(path = "/getAllBySubject/{subject}")
    public Response getAllBySubject(@PathVariable Long subject){
        return new Response(true,"Getting teachers by subject",teacherRepository.getAllBySubject(subject));
    }
}
