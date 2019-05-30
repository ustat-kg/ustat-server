package com.example.USTAT.bootstrap;

import com.example.USTAT.enums.Gender;
import com.example.USTAT.model.Role;
import com.example.USTAT.model.Student;
import com.example.USTAT.model.User;
import com.example.USTAT.repository.RoleRepository;
import com.example.USTAT.repository.StudentRepository;
import com.example.USTAT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class MainBootstrap implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder cryptPasswordEncoder;



    @Override
    public void run(String... args) throws Exception {

        Role admin = new Role("ADMIN");
        Role user = new Role("USER");
        Role guest = new Role("GUEST");
//        roleRepository.save(admin);
//        roleRepository.save(user);
//        roleRepository.save(guest);

        User user1 = new User();
        user1.setLogin("aselia");
        user1.setPassword(cryptPasswordEncoder.encode("123456"));
        user1.setName("Aselia");
        user1.setLastName("Azimkanova");
       // user1.setEmail("aselia.azimkanova@gmail.com");
        user1.setActive(1);
        user1.setRoles(new HashSet<>(Arrays.asList(admin,user,guest)));
        userRepository.save(user1);

        Student student1 = new Student.Builder
                (user1,16, Gender.Female,"+123").build();
        studentRepository.save(student1);

    }
}
