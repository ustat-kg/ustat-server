package com.example.USTAT.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ustat_subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
    private Long id;

    @NotEmpty
    @Column(name = "subject")
    private String name;

    @NotEmpty
    @Column(name = "costOfHour")
    private Double costOfHour;

    public Subject() {
    }

    public Subject(@NotEmpty String name, @NotEmpty Double costOfHour) {
        this.name = name;
        this.costOfHour = costOfHour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCostOfHour() {
        return costOfHour;
    }

    public void setCostOfHour(Double costOfHour) {
        this.costOfHour = costOfHour;
    }
}
