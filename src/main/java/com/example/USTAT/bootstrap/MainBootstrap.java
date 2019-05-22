package com.example.USTAT.bootstrap;

import com.example.USTAT.enums.Gender;
import com.example.USTAT.enums.Level;
import com.example.USTAT.model.Student;
import com.example.USTAT.model.User;
import com.example.USTAT.repository.StudentRepository;
import com.example.USTAT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainBootstrap implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User.Builder("aselia", "123").build();

        Student student = new Student.Builder( user1, "Aselia Azimkanova", 16, Gender.Female, "+123",
                "aselia.azimkanova@gmail.com").withLevelOfSubject(Level.Advanced).build();

        userRepository.save(user1);
        studentRepository.save(student);
    }
}
