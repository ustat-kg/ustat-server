package com.example.USTAT.Helper;

import com.example.USTAT.model.Request;
import com.example.USTAT.model.Student;
import com.example.USTAT.model.Subject;
import com.example.USTAT.model.Teacher;

public class ToGetAllRequestsByTeacher2 {
    Long Id;
    String Massage;
    Student Student;
    Teacher Teacher;
    Request Request;
    Subject Subject;

    public ToGetAllRequestsByTeacher2(Long id, String massage, com.example.USTAT.model.Student student, com.example.USTAT.model.Teacher teacher,
                                      com.example.USTAT.model.Request request, com.example.USTAT.model.Subject subject) {
        Id = id;
        Massage = massage;
        Student = student;
        Teacher = teacher;
        Request = request;
        Subject = subject;
    }

    public ToGetAllRequestsByTeacher2() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMassage() {
        return Massage;
    }

    public void setMassage(String massage) {
        Massage = massage;
    }

    public com.example.USTAT.model.Student getStudent() {
        return Student;
    }

    public void setStudent(com.example.USTAT.model.Student student) {
        Student = student;
    }

    public com.example.USTAT.model.Teacher getTeacher() {
        return Teacher;
    }

    public void setTeacher(com.example.USTAT.model.Teacher teacher) {
        Teacher = teacher;
    }

    public com.example.USTAT.model.Request getRequest() {
        return Request;
    }

    public void setRequest(com.example.USTAT.model.Request request) {
        Request = request;
    }

    public com.example.USTAT.model.Subject getSubject() {
        return Subject;
    }

    public void setSubject(com.example.USTAT.model.Subject subject) {
        Subject = subject;
    }
}
