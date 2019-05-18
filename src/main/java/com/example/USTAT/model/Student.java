package com.example.USTAT.model;

import com.example.USTAT.enums.Level;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Table(name = "ustat_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fio", nullable = false, length = 100)
    private String fio;

    @Column(name = "login", nullable = false, unique = true, length = 50)
    private String login;

    @Column(name = "password", nullable = false, length = 50)
    @JsonIgnore
    private String password;

    @Column(name = "is_active", nullable = false)
    private int isActive;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "level_of_subject", nullable = false)
    private Level levelOfSubject;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Email
    @Column(name = "email")
    private String email;


    public static class Builder {
        private Long id;
        private String fio;
        private String login;
        private String password;
        private int isActive;
        private Integer age;
        private String avatar;
        private Level levelOfSubject;
        private String phoneNumber;
        private String email;

        public Builder(String fio, String login, String password,
                       String phoneNumber) {
            this.fio = fio;
            this.login = login;
            this.password = password;
            this.phoneNumber = phoneNumber;
        }

        public Builder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder withAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public Builder withLevelOfSubject(Level levelOfSubject) {
            this.levelOfSubject = levelOfSubject;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.fio = fio;
            student.login = login;
            student.password = password;
            student.age = age;
            student.avatar = avatar;
            student.levelOfSubject = levelOfSubject;
            student.phoneNumber = phoneNumber;
            student.email = email;
            return student;
        }
    }
}
