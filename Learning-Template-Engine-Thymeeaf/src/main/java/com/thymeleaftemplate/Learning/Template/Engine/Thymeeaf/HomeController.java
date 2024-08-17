package com.thymeleaftemplate.Learning.Template.Engine.Thymeeaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {



    @GetMapping("/")
    public String Home(Model model){
        model.addAttribute("name","Rohan Thapa");
        model.addAttribute("message","Welcome to my webpage");

        List<String> colors = Arrays.asList("Red", "Green", "Blue");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        model.addAttribute("colors", colors);
        model.addAttribute("numbers", numbers);


        return "index";
    }

}
