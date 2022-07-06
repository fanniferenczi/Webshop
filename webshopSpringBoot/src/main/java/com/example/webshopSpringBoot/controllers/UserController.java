package com.example.webshopSpringBoot.controllers;

import com.example.webshopSpringBoot.models.User;
import com.example.webshopSpringBoot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerNewUser")
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }

    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUser();
    }

    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('Admin')")  //meg kell egyezzen azzal, ami az adatb-ben van
    public String forAdmin(){
        return "This URL is only accessible to admin.";
    }


    @GetMapping("/forUser")
    @PreAuthorize("hasAnyRole('User','Admin')")
    public String forUsers(){
        return "this URL is only accessible to user";
    }
}
