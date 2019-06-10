package com.example.USTAT.bootstrap;

import com.example.USTAT.enums.Gender;
import com.example.USTAT.model.*;
import com.example.USTAT.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

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


    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public void run(String... args) throws Exception {

        Role admin = new Role("ADMIN");
        Role user = new Role("USER");
        Role guest = new Role("GUEST");
        roleRepository.save(admin);
        roleRepository.save(user);
        roleRepository.save(guest);

        User user1 = new User();
        user1.setLogin("aselia");
        user1.setPassword(cryptPasswordEncoder.encode("123456"));
        user1.setName("Aselia");
        user1.setLastName("Azimkanova");
        user1.setEmail("aselia.azimkanova@gmail.com");
        user1.setActive(1);
        userRepository.save(user1);
        user1.setRoles(new HashSet<>(Arrays.asList(admin, user, guest)));
        userRepository.save(user1);


        User user2 = new User();
        user2.setLogin("don");
        user2.setPassword(cryptPasswordEncoder.encode("123456"));
        user2.setName("Alex");
        user2.setLastName("Don");
        user2.setEmail("alex.don@gmail.com");
        user2.setActive(1);
        userRepository.save(user2);
        user2.setRoles(new HashSet<>(Arrays.asList(user)));
        userRepository.save(user2);


        User user3 = new User();
        user3.setLogin("mike");
        user3.setPassword(cryptPasswordEncoder.encode("123456"));
        user3.setName("Mike");
        user3.setLastName("Smith");
        user3.setEmail("mike.smith@gmail.com");
        user3.setActive(1);
        userRepository.save(user3);
        user3.setRoles(new HashSet<>(Arrays.asList(user)));
        userRepository.save(user3);

        User user4 = new User();
        user4.setLogin("sam");
        user4.setPassword(cryptPasswordEncoder.encode("123456"));
        user4.setName("Sam");
        user4.setLastName("Danvers");
        user4.setEmail("sam.danvers@gmail.com");
        user4.setActive(1);
        userRepository.save(user4);
        user4.setRoles(new HashSet<>(Arrays.asList(user)));
        userRepository.save(user4);


        ArrayList<Location> locations = new ArrayList<>();
        Location bishkek = new Location("Bishkek,KG");
        locations.add(bishkek);
        locations.add(new Location("Osh,KG"));
        locations.add(new Location("Chuy,KG"));
        locations.add(new Location("Issyk-Kul,KG"));
        locations.add(new Location("Naryn,KG"));
        locations.add(new Location("Jalal-Abad,KG"));
        locations.add(new Location("Batken,KG"));
        locations.add(new Location("Talas,KG"));
        for (int i = 0; i < locations.size(); i++) {
            locationRepository.save(locations.get(i));
        }


        ArrayList<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Drawing"));
        subjects.add(new Subject("Painting"));
        subjects.add(new Subject("Making Origami"));
        subjects.add(new Subject("Piano"));
        subjects.add(new Subject("Violin"));
        subjects.add(new Subject("Acting Skills"));
        subjects.add(new Subject("Marketing"));
        subjects.add(new Subject("Research"));
        subjects.add(new Subject("SMM"));
        subjects.add(new Subject("Couching"));
        subjects.add(new Subject("Java"));
        subjects.add(new Subject("Python"));
        subjects.add(new Subject("HTML And CSS"));
        subjects.add(new Subject("JavaScript"));
        subjects.add(new Subject("PHP"));
        subjects.add(new Subject("Android"));
        subjects.add(new Subject("IOS"));
        subjects.add(new Subject("English Language"));
        subjects.add(new Subject("Russian Language"));
        subjects.add(new Subject("Kyrgyz Language"));
        subjects.add(new Subject("French Language"));
        subjects.add(new Subject("German Language"));
        subjects.add(new Subject("Chinese Language"));
        subjects.add(new Subject("Korean Language"));
        subjects.add(new Subject("Spanish Language"));
        subjects.add(new Subject("Algebra"));
        subjects.add(new Subject("Math"));
        subjects.add(new Subject("Biology"));
        subjects.add(new Subject("Geographic"));
        subjects.add(new Subject("Preschool Education"));
        subjects.add(new Subject("Geometry"));
        subjects.add(new Subject("C1"));
        subjects.add(new Subject("Excel"));
        subjects.add(new Subject("Word"));



        for (int i = 0; i < subjects.size(); i++) {
            subjectRepository.save(subjects.get(i));
        }


        Student student1 = new Student.Builder
                (user1, 16, Gender.Female, "+123").build();
        studentRepository.save(student1);

        Student student2 = new Student.Builder
                (user2, 20, Gender.Female, "+456").build();
        studentRepository.save(student2);

        HashSet<Subject> subjectHashSet = new HashSet<>();
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getName().equals("Math")
                    || subjects.get(i).getName().equals("English Language")) {
                subjectHashSet.add(subjects.get(i));
            }
        }


        Teacher teacher = new Teacher.Builder(user3,"My name is Mike",35,Gender.Male,
                "Know JAVA","+1234567",bishkek).avatar("").build();
        teacherRepository.save(teacher);
        teacher.setSubjects(subjectHashSet);
        teacherRepository.save(teacher);

    }
}
