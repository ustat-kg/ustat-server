package com.example.USTAT.service;

import com.example.USTAT.model.Student;

import java.util.List;

public interface StudentService {

    Student getStudentById(Long id);
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student updateStudentById(Student student);
    void deleteStudentById(Long id);
    void deleteAllStudents();
}
