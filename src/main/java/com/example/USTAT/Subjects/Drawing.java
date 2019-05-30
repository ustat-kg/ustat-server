package com.example.USTAT.Subjects;

import javax.persistence.Entity;

public class Drawing {

    private int id;
    private String name;
    private double costOfHour;

    public Drawing() {
    }

    public Drawing(int id, String name, double costOfHour) {
        this.id = id;
        this.name = name;
        this.costOfHour = costOfHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCostOfHour() {
        return costOfHour;
    }

    public void setCostOfHour(double costOfHour) {
        this.costOfHour = costOfHour;
    }
}
