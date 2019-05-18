package com.example.USTAT.service;

import com.example.USTAT.model.Student;
import com.example.USTAT.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentById(Long id) {
        return this.studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Student updateStudentById(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public void deleteAllStudents() {
        this.studentRepository.deleteAll();
    }
}
