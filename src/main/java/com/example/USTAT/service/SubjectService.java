package com.example.USTAT.service;

import com.example.USTAT.model.Subject;

import java.util.List;

public interface SubjectService {
    Subject addSubject(Subject subject);
    Subject findSubjectById(Long id);
    List<Subject> getAllSubjects();
    void deleteSubjectById(Long id);
    void deleteAllSubjects();
}
