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
                "aselia" , "123", "+123")
                .withAge(16)
                .withLevelOfSubject(Level.Advanced)
                .withEmail("aselia.azimkanova@gmail.com")
                .build();
        studentRepository.save(student);
    }
}
