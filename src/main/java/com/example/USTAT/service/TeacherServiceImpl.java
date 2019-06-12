package com.example.USTAT.service;

import com.example.USTAT.model.Role;
import com.example.USTAT.model.Teacher;
import com.example.USTAT.repository.RoleRepository;
import com.example.USTAT.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Qualifier("teacherRepository")
    @Autowired
    private TeacherRepository teacherRepository;


    @Qualifier("roleRepository")
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Teacher getTeacherById(Long id) {
        return this.teacherRepository.findById(id).get();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return this.teacherRepository.findAll();
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
     //   Role role = roleRepository.findAll().stream().filter(x -> x.getRole().equals("USER")).findFirst().get();
       // teacher.getUser().setRoles(new HashSet<>(Arrays.asList(role)));
        return this.teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        this.teacherRepository.deleteById(id);
    }

    @Override
    public void deleteAllTeachers() {
        this.teacherRepository.deleteAll();
    }

//    @Override
//    public List<Teacher> getAllByAge(Integer age) {
//        return this.teacherRepository.getAllByAge(age);
//    }
}
