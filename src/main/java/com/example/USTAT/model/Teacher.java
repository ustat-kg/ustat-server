package com.example.USTAT.model;

import com.example.USTAT.enums.Gender;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "ustat_teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ustat_teacher_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Length(max = 150)
    private String shortInfoAboutYou;

    @NotNull
    private Integer age;

    @NotNull
    private Gender gender;

    private String avatar;

    @NotNull
    @Length(max = 500)
    private String formalBackground;

    private Float rating;

    @NotNull
    @Length(max = 12)
    private String phoneNumber;

    private String importantLinks;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_subject",
    joinColumns = @JoinColumn(name = "ustat_teacher_id"),
    inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects;

    @OneToOne
    private Location location;

    //private List<Request> requests;

    public static class Builder{
        private Long id;
        private User user;
        private String shortInfoAboutYou;
        private Integer age;
        private Gender gender;
        private String avatar;
        private String formalBackground;
        private Float rating;
        private String phoneNumber;
        private String importantLinks;
        private Set<Subject> subjects;
        private Location location;

        public Builder(User user,String shortInfoAboutYou,Integer age,Gender gender,
                       String formalBackground,String phoneNumber,Location location /*, List<Subject> subjects*/){
            this.user = user;
            this.shortInfoAboutYou = shortInfoAboutYou;
            this.age = age;
            this.gender = gender;
            this.formalBackground = formalBackground;
            this.phoneNumber = phoneNumber;
            this.location = location;
           // this.subjects = subjects;
        }

        public Builder subjects(Set<Subject> subjects){
            this.subjects = subjects;
            return this;
        }

        public Teacher build() {
            Teacher teacher = new Teacher();
            teacher.user = user;
            teacher.shortInfoAboutYou = shortInfoAboutYou;
            teacher.age = age;
            teacher.gender = gender;
            teacher.formalBackground = formalBackground;
            teacher.phoneNumber = phoneNumber;
            teacher.location = location;
            return teacher;
        }

    }

//
//    public Teacher(@NotNull @Length(max = 150) String shortInfoAboutYou, @NotNull Integer age, @NotNull Gender gender, String avatar, @NotNull @Length(max = 500) String formalBackground, Float rating, @NotNull @Length(max = 12) String phoneNumber,
//                   String importantLinks, Set<Subject> subjects, Location location) {
//        this.shortInfoAboutYou = shortInfoAboutYou;
//        this.age = age;
//        this.gender = gender;
//        this.avatar = avatar;
//        this.formalBackground = formalBackground;
//        this.rating = rating;
//        this.phoneNumber = phoneNumber;
//        this.importantLinks = importantLinks;
//        this.subjects = subjects;
//        this.location = location;
//    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
