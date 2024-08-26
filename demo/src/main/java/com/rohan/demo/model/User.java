package com.rohan.demo.model;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class User {


    public User() {
        System.out.println("User bean initialized");
    }

    @PostConstruct
    public void preConstruct(){
        System.out.println("User bean hashcode = " + this.hashCode());
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("This is run before destroying");
    }



}

