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


        Subject subject1 = new Subject("Drawing");
        Subject subject2 = new Subject("Painting");
        Subject subject3 = new Subject("Making Origami");
        Subject subject4 = new Subject("Piano");
        Subject subject5 = new Subject("Violin");
        Subject subject6 = new Subject("Acting Skills");
        Subject subject7 = new Subject("Marketing");
        Subject subject8 = new Subject("Research");
        Subject subject9 = new Subject("SMM");
        Subject subject10 = new Subject("Couching");
        Subject subject11 = new Subject("Java");
        Subject subject12 = new Subject("Python");
        Subject subject13 = new Subject("HTML And CSS");
        Subject subject14 = new Subject("JavaScript");
        Subject subject15 = new Subject("PHP");
        Subject subject16 = new Subject("Android");
        Subject subject17 = new Subject("IOS");
        Subject subject18 = new Subject("English Language");
        Subject subject19 = new Subject("Russian Language");
        Subject subject20 = new Subject("Kyrgyz Language");
        Subject subject21 = new Subject("French Language");
        Subject subject22 = new Subject("German Language");
        Subject subject23 = new Subject("Chinese Language");
        Subject subject24 = new Subject("Korean Language");
        Subject subject25 = new Subject("Spanish Language");
        Subject subject26 = new Subject("Algebra");
        Subject subject27 = new Subject("Math");
        Subject subject28 = new Subject("Biology");
        Subject subject29 = new Subject("Geographic");
        Subject subject30 = new Subject("Preschool Education");
        Subject subject31 = new Subject("Geometry");
        Subject subject32 = new Subject("C1");
        Subject subject33 = new Subject("Excel");
        Subject subject34 = new Subject("Word");

        subjectRepository.save(subject1);
        subjectRepository.save(subject2);
        subjectRepository.save(subject3);
        subjectRepository.save(subject4);
        subjectRepository.save(subject5);
        subjectRepository.save(subject6);
        subjectRepository.save(subject7);
        subjectRepository.save(subject8);
        subjectRepository.save(subject9);
        subjectRepository.save(subject10);
        subjectRepository.save(subject11);
        subjectRepository.save(subject12);
        subjectRepository.save(subject13);
        subjectRepository.save(subject14);
        subjectRepository.save(subject15);
        subjectRepository.save(subject16);
        subjectRepository.save(subject17);
        subjectRepository.save(subject18);
        subjectRepository.save(subject19);
        subjectRepository.save(subject20);
        subjectRepository.save(subject21);
        subjectRepository.save(subject22);
        subjectRepository.save(subject23);
        subjectRepository.save(subject24);
        subjectRepository.save(subject25);
        subjectRepository.save(subject26);
        subjectRepository.save(subject27);
        subjectRepository.save(subject28);
        subjectRepository.save(subject29);
        subjectRepository.save(subject30);
        subjectRepository.save(subject31);
        subjectRepository.save(subject32);
        subjectRepository.save(subject33);
        subjectRepository.save(subject34);




    }
}
