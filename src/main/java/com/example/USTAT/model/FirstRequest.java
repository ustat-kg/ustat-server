package com.example.USTAT.model;

import com.example.USTAT.enums.Cost;
import com.example.USTAT.enums.Gender;
import com.example.USTAT.enums.Level;
import com.example.USTAT.enums.Location;

public class FirstRequest {
    private Long id;
    private Subject subject;
    private Level levelOfTeacher;
    private Integer age;
    private Gender gender;
    private Cost cost;
    private Location location;


    public FirstRequest() {
    }

    public FirstRequest(Long id, Level levelOfTeacher, Integer age,
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
