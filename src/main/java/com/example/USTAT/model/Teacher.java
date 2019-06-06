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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

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

    private Float rating;

    @NotEmpty(message = "What is your phone number?")
    @Length(max = 12)
    private String phoneNumber;

    private String importantLinks;

    @ManyToOne(targetEntity = Subject.class)
    private List<Subject> subjects;

    @OneToOne
    private Location location;

    //private List<Request> requests;

    public static class Builder{
        private Long id;
        private User user;
        private String shortInfoAboutYou;
        private int age;
        private Gender gender;
        private String avatar;
        private String formalBackground;
        private Float rating;
        private String phoneNumber;
        private String importantLinks;
        private List<Subject> subjects;
        private Location location;

        public Builder(User user,String shortInfoAboutYou, int age,Gender gender,
                       String formalBackground,String phoneNumber,List<Subject> subjects,Location location){
            this.user = user;
            this.shortInfoAboutYou = shortInfoAboutYou;
            this.age = age;
            this.gender = gender;
            this.formalBackground = formalBackground;
            this.phoneNumber = phoneNumber;
            this.subjects = subjects;
            this.location = location;
        }

        public Teacher build() {
            Teacher teacher = new Teacher();
            teacher.user = user;
            teacher.shortInfoAboutYou = shortInfoAboutYou;
            teacher.age = age;
            teacher.gender = gender;
            teacher.formalBackground = formalBackground;
            teacher.phoneNumber = phoneNumber;
            teacher.subjects = subjects;
            teacher.location = location;
            return teacher;
        }

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
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
        return rating;
    }

    public void setRaiting(Float rating) {
        this.rating = rating;
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
