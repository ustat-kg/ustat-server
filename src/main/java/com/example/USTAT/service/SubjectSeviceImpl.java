package com.example.USTAT.service;

import com.example.USTAT.model.Subject;
import com.example.USTAT.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectSeviceImpl implements SubjectService {

    @Qualifier("subjectRepository")
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject findSubjectById(Long id) {
        return subjectRepository.findById(id).get();
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public void deleteSubjectById(Long id) {
         subjectRepository.deleteById(id);
    }

    @Override
    public void deleteAllSubjects() {
        subjectRepository.deleteAll();
    }
}
