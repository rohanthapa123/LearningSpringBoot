package com.rohan.demo.model;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Employee {

    @Autowired
    User user;

    public Employee() {
        System.out.println("Employee initialized");
    }

    @PostConstruct
    public void init(){
        System.out.println("Employee initialized" + this.hashCode());
        System.out.println("User initialized in employee component" + user.hashCode());
    }


}
