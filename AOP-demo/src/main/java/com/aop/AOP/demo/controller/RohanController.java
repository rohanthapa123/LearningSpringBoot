package com.aop.AOP.demo.controller;

import com.aop.AOP.demo.services.RohanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RohanController {

    @Autowired
    private RohanService rohanService;

    @GetMapping("/books")
    public String getBooks(){
        return rohanService.geBooks();
    }

}
