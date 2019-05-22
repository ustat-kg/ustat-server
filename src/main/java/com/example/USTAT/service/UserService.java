package com.example.USTAT.service;

import com.example.USTAT.model.User;

import java.util.List;


public interface UserService {
    User getUserById(Long id);
    List<User> getAllUsers();
    User saveUser(User user);
    User updateUser(User user);
    void deleteUserById(Long id);
    void deleteAllUsers();
}
