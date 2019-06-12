package com.example.USTAT.Helper;

import com.example.USTAT.repository.UserRepository;
import com.example.USTAT.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class ToGetCurrentUser {

    private final UserService userService;

    private final UserRepository userRepository;

    public ToGetCurrentUser(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

//    public User getCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication instanceof AnonymousAuthenticationToken) {
//            return null;
//        }
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        return userService.findUserByLogin(userDetails.getUsername());
//    }

    public String getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails){
            String login = ((UserDetails)principal).getUsername();
            return login;
        }else {
            String login = principal.toString();
            return login;
        }
    }
}