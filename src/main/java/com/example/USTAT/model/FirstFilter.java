package com.example.USTAT.model;

import com.example.USTAT.enums.Cost;
import com.example.USTAT.enums.Gender;
import com.example.USTAT.enums.Level;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class FirstFilter {
    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Subject subject;

    @JsonIgnore
    private Level levelOfTeacher;

    @JsonIgnore
    private Integer age;

    @JsonIgnore
    private Gender gender;

    @JsonIgnore
    private Cost cost;

    @JsonIgnore
    private Location location;


    public FirstFilter() {
    }

    public FirstFilter(Long id, Level levelOfTeacher, Integer age,
                       Gender gender, Cost cost, Location location) {
        this.id = id;
        this.levelOfTeacher = levelOfTeacher;
        this.age = age;
        this.gender = gender;
        this.cost = cost;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Level getLevelOfTeacher() {
        return levelOfTeacher;
    }

    public void setLevelOfTeacher(Level levelOfTeacher) {
        this.levelOfTeacher = levelOfTeacher;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
