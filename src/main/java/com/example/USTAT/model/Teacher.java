package com.example.USTAT.model;

import com.example.USTAT.enums.Gender;
import org.jboss.logging.Message;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ustat_teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotEmpty(message = "Please tell us about yourself ")
    private String shortInfoAboutYou;

    @NotEmpty(message = "How old are you?")
    private int age;

    @NotEmpty(message = "Your gender")
    private Gender gender;

    private String avatar;

    @NotEmpty(message = "Please tell us about you studies")
    private String formalBackground;

    private Float raiting;


    private Double costOfHour;




}
