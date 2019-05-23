package com.example.USTAT.model;

import jdk.jfr.DataAmount;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public static class Builder{
        private Long id;
        private String login;
        private String password;
        private int isActive;
        private Set<Role> roles;

        public Builder(String login, String password,Set<Role> roles ){
            this.login = login;
            this.password = password;
            this.roles = roles;
        }

        public User build(){
            User user = new User();
            user.login = login;
            user.password = password;
            user.roles = roles;
            return user;
        }
    }
}
