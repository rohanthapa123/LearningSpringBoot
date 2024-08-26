package com.rohan.demo.controller;

import com.rohan.demo.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("session")
@RequestMapping("/user")
public class UserController {

    @Autowired
    User user;

    public UserController(){
        System.out.println("User Controller initialized");
    }

    @PostConstruct
    public void init(){
        System.out.println("User controller bean = "+ this.hashCode());
        System.out.println("User bean in user Controller" + user.hashCode());
    }

    @GetMapping
    public String getData(){
        System.out.println("Api fetch");
        return  "OK";
    }

}
