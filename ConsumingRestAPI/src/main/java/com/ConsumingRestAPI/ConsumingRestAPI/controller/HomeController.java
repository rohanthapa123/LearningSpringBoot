package com.ConsumingRestAPI.ConsumingRestAPI.controller;

import com.ConsumingRestAPI.ConsumingRestAPI.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    private final AppService appService;

    @Autowired
    public HomeController(AppService appService){
        this.appService = appService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Map<String, Object>>> getPosts(){
        return new ResponseEntity<>(appService.getPosts() , HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Map<String, Object>> getPostByID(@PathVariable int id){
        return new ResponseEntity<>(appService.getPostsById(id) , HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<Map<String, Object>> insertPost(@RequestBody Map<String, Object> post){
        return new ResponseEntity<>(appService.insertPosts(post) , HttpStatus.OK);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Map<String, Object>> updatePost(@RequestBody Map<String, Object> post, @PathVariable int id){
        return new ResponseEntity<>(appService.updatePost(post,id) , HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Map<String, Object>> deletePostByID(@PathVariable int id){
        return new ResponseEntity<>(appService.deletePostByID(id) , HttpStatus.OK);
    }

}
