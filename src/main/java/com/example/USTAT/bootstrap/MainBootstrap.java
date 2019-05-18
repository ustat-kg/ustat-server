package com.example.USTAT.bootstrap;

import com.example.USTAT.enums.Level;
import com.example.USTAT.model.Student;
import com.example.USTAT.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainBootstrap implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student.Builder("Aselia Azimkanoava" ,
                "aselia" , "123", "+123","aselia.azimkanova@gmail.com")
                .withAge(16)
                .withLevelOfSubject(Level.Advanced)
                .build();
        studentRepository.save(student);
    }
}
