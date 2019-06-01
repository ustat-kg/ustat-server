package com.example.USTAT.controller;

import com.example.USTAT.model.User;
import com.example.USTAT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/", "/ustat/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
////        String SQL = "select count(*) as cnt from shop where login = ? and passwords = ?";
////        int count = 0;
////        try (Connection conn = connect();
////             PreparedStatement stmt = conn.prepareStatement(SQL)
////        ) {
////            stmt.setString(1, reg.getName());
////            stmt.setString(2, reg.getPassword());
////            ResultSet rs = stmt.executeQuery();
////            if (rs.next()) {
////                count = rs.getInt("cnt");
////            }
////
////        } catch (SQLException ex) {
////            System.out.println(ex.getMessage());
////            // Write Fail to Log
////            return false;
////        }
////        return true;
//        //return  ;
    }


    @RequestMapping(value="/ustat/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

//    @RequestMapping(value = "/ustat/registration", method = RequestMethod.POST)
//    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        User userExists = userService.findUserByLogin(user.getLogin());
//        if (userExists != null) {
//            bindingResult
//                    .rejectValue("login", "error.user",
//                            "There is already a user registered with this login");
//        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("registration");
//        } else {
//            userService.saveUser(user);
//            modelAndView.addObject("successMessage", "User has been registered successfully");
//            modelAndView.addObject("user", new User());
//            modelAndView.setViewName("registration");
//
//        }
//        return modelAndView;
//    }

    @RequestMapping(value="/ustat/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByLogin(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getLogin() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("/ustat/admin/home");
        return modelAndView;
    }


//    @PostMapping(path = "/ustat/registration")
//    public User saveUser{
//        return this.userService.saveUser(user);
//    }

    @GetMapping(path = "/ustat/getAllUsers" ,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }



}