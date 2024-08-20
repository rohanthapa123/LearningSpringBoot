//package com.Caching.Redis.dao;
//
//import com.Caching.Redis.model.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class StudentDao {
//
//    private final RedisTemplate<String, Object> redisTemplate;
//
//    @Autowired
//    public StudentDao(RedisTemplate<String, Object> redisTemplate){
//        this.redisTemplate = redisTemplate;
//    }
//
//    private static final String KEY="STUDENT";
//
//    public Student save(Student student){
//        redisTemplate.opsForHash().put(KEY , student.getStudentId(), student);
//        return  student;
//    }
//
//    public Student get(String studentId){
//        return (Student) redisTemplate.opsForHash().get(KEY, studentId);
//    }
//
//}
