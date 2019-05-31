package com.example.USTAT.model;

import com.example.USTAT.enums.Gender;
import org.hibernate.validator.constraints.Length;

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

    @NotEmpty(message = "What is your phone number?")
    @Length(max = 12)
    private String phoneNumber;

    private String importantLinks;

    @ManyToOne(targetEntity = Subject.class)
    private List<Subject> subjects;

    @OneToOne
    private Location location;

    //private List<Request> requests;


    public Teacher(@NotEmpty(message = "Please tell us about yourself") @Length(max = 150) String shortInfoAboutYou, @NotEmpty(message = "How old are you?") int age, @NotEmpty(message = "Your gender") Gender gender, String avatar, @NotEmpty(message = "Please tell us about you studies") @Length(max = 500) String formalBackground, @NotEmpty(message = "What is your phone number?") @Length(max = 12) String phoneNumber,
                   String importantLinks, List<Subject> subjects, Location location) {
        this.shortInfoAboutYou = shortInfoAboutYou;
        this.age = age;
        this.gender = gender;
        this.avatar = avatar;
        this.formalBackground = formalBackground;
        this.phoneNumber = phoneNumber;
        this.importantLinks = importantLinks;
        this.subjects = subjects;
        this.location = location;
    }

    public Teacher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortInfoAboutYou() {
        return shortInfoAboutYou;
    }

    public void setShortInfoAboutYou(String shortInfoAboutYou) {
        this.shortInfoAboutYou = shortInfoAboutYou;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFormalBackground() {
        return formalBackground;
    }

    public void setFormalBackground(String formalBackground) {
        this.formalBackground = formalBackground;
    }

    public Float getRaiting() {
        return raiting;
    }

    public void setRaiting(Float raiting) {
        this.raiting = raiting;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImportantLinks() {
        return importantLinks;
    }

    public void setImportantLinks(String importantLinks) {
        this.importantLinks = importantLinks;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
