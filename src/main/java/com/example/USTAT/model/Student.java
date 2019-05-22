package com.example.USTAT.model;

import com.example.USTAT.enums.Gender;
import com.example.USTAT.enums.Level;
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

    @OneToOne
    @Column(name = "user_id")
    private User user;

    @Column(name = "fio", nullable = false, length = 100)
    private String fio;


    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "level_of_subject", nullable = false)
    @Enumerated(EnumType.STRING)
    private Level levelOfSubject;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Email
    @Column(name = "email")
    private String email;


    public static class Builder {
        private User user;
        private String fio;
        private Integer age;
        private Gender gender;
        private String avatar;
        private Level levelOfSubject;
        private String phoneNumber;
        private String email;

        public Builder(String fio, Integer age, Gender gender,
                       String phoneNumber , String email) {
            this.fio = fio;
            this.age = age;
            this.gender = gender;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }


        public Builder withAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public Builder withLevelOfSubject(Level levelOfSubject) {
            this.levelOfSubject = levelOfSubject;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.fio = fio;
            student.age = age;
            student.gender = gender;
            student.avatar = avatar;
            student.levelOfSubject = levelOfSubject;
            student.phoneNumber = phoneNumber;
            student.email = email;
            return student;
        }
    }
}
