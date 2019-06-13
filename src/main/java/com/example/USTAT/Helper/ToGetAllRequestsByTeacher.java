package com.example.USTAT.Helper;

import com.example.USTAT.model.Request;
import com.example.USTAT.model.Student;
import com.example.USTAT.model.Subject;
import com.example.USTAT.model.Teacher;

import java.util.List;

public interface ToGetAllRequestsByTeacher {
    Long getId();
    String getMassage();
    Student getStudent();
    Teacher getTeacher();
    Request getRequest();
    Subject getSubject();


}
