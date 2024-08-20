package com.Caching.Redis.controller;

import com.Caching.Redis.model.Student;
import com.Caching.Redis.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentServices studentServices;

    @Autowired
    public StudentController(StudentServices studentServices){
        this.studentServices = studentServices;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentServices.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable String id){
        return new ResponseEntity<>(studentServices.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentServices.registerStudent(student), HttpStatus.OK);
    }

    @PutMapping("/student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentServices.updateStudentCollege(student), HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable String id){
        studentServices.deleteStudentById(id);
        return new ResponseEntity<>("Book Deleted Success" , HttpStatus.OK);
    }

}
