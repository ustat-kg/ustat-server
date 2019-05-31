package com.example.USTAT.bootstrap;

import com.example.USTAT.enums.Gender;
import com.example.USTAT.model.*;
import com.example.USTAT.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

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

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private SubjectRepository subjectRepository;



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
        user1.setEmail("aselia.azimkanova@gmail.com");
        user1.setActive(1);
        user1.setRoles(new HashSet<>(Arrays.asList(admin,user,guest)));
        userRepository.save(user1);

        Student student1 = new Student.Builder
                (user1,16, Gender.Female,"+123").build();
        studentRepository.save(student1);


        Location location1 = new Location("Bishkek,KG");
        Location location2 = new Location("Osh,KG");
        Location location3 = new Location("Chuy,KG");
        Location location4 = new Location("Issyk-Kul,KG");
        Location location5 = new Location("Naryn,KG");
        Location location6 = new Location("Jalal-Abad,KG");
        Location location7 = new Location("Batken,KG");
        Location location8 = new Location("Talas,KG");
        locationRepository.save(location1);
        locationRepository.save(location2);
        locationRepository.save(location3);
        locationRepository.save(location4);
        locationRepository.save(location5);
        locationRepository.save(location6);
        locationRepository.save(location7);
        locationRepository.save(location8);

    }
}
