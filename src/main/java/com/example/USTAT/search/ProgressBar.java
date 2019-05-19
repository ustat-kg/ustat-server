package com.example.USTAT.search;


import com.example.USTAT.enums.Gender;
import com.example.USTAT.enums.Level;

import java.math.BigDecimal;

//first filter in web. Where by data that was filled out by student we will find teachers
public class ProgressBar {
    private Long id;
    private String subject;
    private Level levelofTeacher;
    private int age;
    private Gender genderOfTeacher;
    private BigDecimal cost;
}