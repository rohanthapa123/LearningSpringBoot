package com.Caching.Redis.services;

import com.Caching.Redis.model.Student;
import com.Caching.Redis.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentServices(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    @Cacheable(value = "students", key = "'allStudents'")
    public List<Student> getStudents(){
        System.out.println("Fetching from DB");
        return studentRepo.findAll();
    }

    @Cacheable(cacheNames = "student" , key = "#id")
    public Optional<Student> getStudentById(String id){
        return studentRepo.findById(id);
    }

    @CacheEvict(cacheNames = "students" , allEntries = true)
    public Student registerStudent(Student student){
        return studentRepo.save(student);
    }

    @CachePut(cacheNames = "students" , key = "#student.id")
    public Student updateStudentCollege(Student student){
        studentRepo.updateStudentCollege(student.getCollege() , student.getStudentId());
        return student;
    }

    @CacheEvict(cacheNames = "students" , key = "#id")
    public void deleteStudentById(String id){
        studentRepo.deleteById(id);
    }

}
