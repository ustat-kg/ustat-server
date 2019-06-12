package com.example.USTAT.controller;


import com.example.USTAT.Helper.ToGetCurrentUser;
import com.example.USTAT.model.Response;
import com.example.USTAT.model.User;
import com.example.USTAT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserController.URL_USER)
public class UserController {

    public static final String URL_USER = "/ustat/"; /*start url for all requests
     in class User*/


    @Autowired
    private UserService userService;

    @Autowired
    private ToGetCurrentUser toGetCurrentUser;

    @GetMapping(path = "/getUser/{id}") //returns one User by id
    public Response getUserById(@PathVariable Long id) {
        return new Response(true,"Getting User by id", this.userService.findUserById(id));
    }

    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public String handleHttpMediaTypeNotAcceptableException() {
        return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
    }

    @GetMapping(path = "/getAllUsers") //returns all Users
    public Response getAllUsers() {
        return new Response(true,"Getting all Users" ,this.userService.getAllUsers());
    }

    @PostMapping(path = "/saveUser") //saves one User in DataBase
    public Response saveUser(@RequestBody User user) {
        return new Response(true,"Saving User",this.userService.addUser(user));
    }

    @PostMapping(path = "/updateUser")// updates data of one User
    public Response updateUser(@RequestBody User user) {
        return new Response(true,"Updating User",this.userService.addUser(user));
    }

    @DeleteMapping(path = "/deleteUser/{id}") //deletes one User by id
    public Response deleteUserById(@PathVariable Long id) {
        this.userService.deleteUserById(id);
        return new Response(true,"Deleting User by id",null);
    }

    @DeleteMapping(path = "/admin/deleteAllUsers") //deletes all Users
    public Response deleteAllUsers() {
        this.userService.deleteAllUsers();
        return new Response(true,"Deleting all Users",null);
    }


    @GetMapping(path = "/catchUser/") //returns one User by id
    public Response getUserById() {
        return new Response(true,"Getting User by login", toGetCurrentUser.getCurrentUser());
    }

}
