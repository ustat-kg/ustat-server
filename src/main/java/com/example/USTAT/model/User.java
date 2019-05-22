package com.example.USTAT.model;

import jdk.jfr.DataAmount;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "ustat_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login", nullable = false, unique = true, length = 50)
    private String login;

    @Column(name = "password", nullable = false, length = 50)
    //@JsonIgnore
    private String password;

    @Column(name = "is_active", nullable = false)
    private int isActive;

    public static class Builder{
        private Long id;
        private String login;
        private String password;
        private int isActive;

        public Builder(String login, String password){
            this.login = login;
            this.password = password;
        }

        public User build(){
            User user = new User();
            user.login = login;
            user.password = password;
            return user;
        }
    }
}
