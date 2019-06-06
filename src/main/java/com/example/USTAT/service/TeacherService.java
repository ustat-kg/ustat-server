package com.example.USTAT.service;

import com.example.USTAT.model.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher getTeacherById(Long id);
    List<Teacher> getAllTeachers();
    Teacher addTeacher(Teacher teacher);
    Teacher updateTeacher(Teacher teacher);
    void deleteTeacherById(Long id);
    void deleteAllTeachers();
}
