package com.example.USTAT.repository;

import com.example.USTAT.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
   // boolean checkingUserByLoginAndPassword(String login, String password);
}