package com.example.USTAT.controller;


import com.example.USTAT.model.User;
import com.example.USTAT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.URL_USER)
public class UserController{

    public static final String URL_USER = "/ustat/user";

    @Autowired
    private UserService userService;


    @GetMapping(path = "/getUser/{id}", //returns one user by id
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User getUserById(@PathVariable Long id){
        return this.userService.getUserById(id);
    }

    @GetMapping(path = "/getUsers" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping(path = "/saveUser" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User saveUser(@RequestBody User user){
        return this.userService.saveUser(user);
    }

    @PostMapping(path = "/updateUser" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }


    @DeleteMapping(path = "/deleteUser/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteUserById(@PathVariable Long id){
        this.userService.deleteUserById(id);
    }

    @DeleteMapping(path = "/deleteUsers",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAllUsers(){
        this.userService.deleteAllUsers();
    }

}
