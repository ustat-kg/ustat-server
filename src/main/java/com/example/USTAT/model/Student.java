package com.example.USTAT.model;

import com.example.USTAT.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Data
@Table(name = "ustat_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OnDelete(action = OnDeleteAction.CASCADE)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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
            student.user = user;
            return student;
        }
    }
}
