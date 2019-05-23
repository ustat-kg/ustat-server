package com.example.USTAT.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ustat_role")
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role")
    private Role role;

    public static class Builder{
        private Long id;
        private String role;

        public Builder(String role){
            this.role = role;
        }

        public Role build(){
            Role role = new Role();
            role.role= role;
            return role;
        }
    }

}
