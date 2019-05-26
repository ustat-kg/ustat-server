package com.example.USTAT.model;

import com.example.USTAT.enums.Gender;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Table(name = "ustat_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "phone_number", nullable = false, length = 15,unique = true)
    private String phoneNumber;


    public static class Builder {
        private Long id;
        private User user;
        private Integer age;
        private Gender gender;
        private String avatar;
        private String phoneNumber;

        public Builder(User user, Integer age, Gender gender,
                       String phoneNumber) {
            this.user = user;
            this.age = age;
            this.gender = gender;
            this.phoneNumber = phoneNumber;
        }


        public Builder withAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }


        public Student build() {
            Student student = new Student();
            student.age = age;
            student.gender = gender;
            student.avatar = avatar;
            student.phoneNumber = phoneNumber;
            return student;
        }
    }
}
