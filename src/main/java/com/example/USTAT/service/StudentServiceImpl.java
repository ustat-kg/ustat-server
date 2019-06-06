package com.example.USTAT.service;

import com.example.USTAT.model.Role;
import com.example.USTAT.model.Student;
import com.example.USTAT.repository.RoleRepository;
import com.example.USTAT.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Qualifier("studentRepository")
    @Autowired
    private StudentRepository studentRepository;

    @Qualifier("roleRepository")
    @Autowired
    private RoleRepository roleRepository;

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
        Role role = roleRepository.findAll().stream().filter(x -> x.getRole().equals("USER")).findFirst().get();
        student.getUser().setRoles(new HashSet<>(Arrays.asList(role)));
        return this.studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
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
