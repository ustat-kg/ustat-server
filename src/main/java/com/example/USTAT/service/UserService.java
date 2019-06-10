package com.example.USTAT.service;

import com.example.USTAT.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User findUserById(Long id);
    List<User> getAllUsers();
    boolean addUser(User user);
    void deleteUserById(Long id);
    void deleteAllUsers();
    User findUserByLogin(String login);

}