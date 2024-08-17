package com.profiles.MutipleProfile.controller;

import com.profiles.MutipleProfile.model.User;
import com.profiles.MutipleProfile.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/user")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping("/user")
    public void InsertUser(@RequestBody User user){
        userRepo.save(user);
    }
}
