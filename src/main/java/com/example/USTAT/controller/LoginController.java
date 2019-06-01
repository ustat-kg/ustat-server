package com.example.USTAT.controller;

import com.example.USTAT.config.SecurityConfig;
import com.example.USTAT.model.User;
import com.example.USTAT.repository.UserRepository;
import com.example.USTAT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfig securityConfig;

    @GetMapping(path = "/ustat/admin/getUser/{id}" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User getUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping(path = "/ustat/admin/getAllUsers",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<User>  getAllUsers(){
        return userService.getAllUsers();
    }


    @PostMapping(path = "/ustat/registration",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public boolean addUser(@RequestBody User user){
        User userExists = userRepository.findByLogin(user.getLogin());
        if(userExists != null){
            System.out.println("There is already a user registered with this login");
            return false;
        } else {
            userService.addUser(user);
            return true;
        }
    }

//    @GetMapping(path = "/ustat/login" ,
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public void login(@RequestParam String login , @RequestParam String password){
//        securityConfig.configure(login,password);
//    }

    @DeleteMapping(path = "/ustat/deleteUser/{id}" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @DeleteMapping(path = "/ustat/admin/deleteAllUsers",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAllUsers(){
        userService.deleteAllUsers();
    }

//    @RequestMapping(value={"/", "/ustat/login"}, method = RequestMethod.GET)
//    public ModelAndView login(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        return modelAndView;
   // }


//    @RequestMapping(value="/ustat/registration", method = RequestMethod.GET)
//    public ModelAndView registration(){
//        ModelAndView modelAndView = new ModelAndView();
//        User user = new User();
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("registration");
//        return modelAndView;
//    }
//
////    @RequestMapping(value = "/ustat/registration", method = RequestMethod.POST)
////    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
////        ModelAndView modelAndView = new ModelAndView();
////        User userExists = userService.findUserByLogin(user.getLogin());
////        if (userExists != null) {
////            bindingResult
////                    .rejectValue("login", "error.user",
////                            "There is already a user registered with this login");
////        }
////        if (bindingResult.hasErrors()) {
////            modelAndView.setViewName("registration");
////        } else {
////            userService.saveUser(user);
////            modelAndView.addObject("successMessage", "User has been registered successfully");
////            modelAndView.addObject("user", new User());
////            modelAndView.setViewName("registration");
////
////        }
////        return modelAndView;
////    }
//
//    @RequestMapping(value="/ustat/admin/home", method = RequestMethod.GET)
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByLogin(auth.getName());
//        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getLogin() + ")");
//        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
//        modelAndView.setViewName("/ustat/admin/home");
//        return modelAndView;
//    }
//
//
////    @PostMapping(path = "/ustat/registration")
////    public User saveUser{
////        return this.userService.saveUser(user);
////    }
//
//    @GetMapping(path = "/ustat/getAllUsers" ,
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public List<User> getAllUsers(){
//        return userService.getAllUsers();
//    }

}