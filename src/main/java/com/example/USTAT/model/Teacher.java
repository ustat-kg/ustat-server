package com.example.USTAT.model;

import com.example.USTAT.enums.Gender;
import org.hibernate.validator.constraints.Length;
import org.jboss.logging.Message;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "ustat_teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Please tell us about yourself")
    @Length(max = 150)
    private String shortInfoAboutYou;

    @NotEmpty(message = "How old are you?")
    private int age;

    @NotEmpty(message = "Your gender")
    private Gender gender;

    private String avatar;

    @NotEmpty(message = "Please tell us about you studies")
    @Length(max = 500)
    private String formalBackground;

    private Float raiting;

    private Double costOfHour;

    @NotEmpty(message = "What is your phone number?")
    @Length(max = 12)
    private String phoneNumber;

    private String importantLinks;

    private List<Subject> subjects;

    private Location location;

    //private List<Request> requests;




}
