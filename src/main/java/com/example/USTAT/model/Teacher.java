package com.example.USTAT.model;

import javax.persistence.*;

@Entity
@Table(name = "ustat_teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
