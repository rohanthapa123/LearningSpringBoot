package com.Caching.Redis.repo;

import com.Caching.Redis.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Student , String> {
    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.college = ?1 WHERE s.studentId = ?2")
    int updateStudentCollege(String college, String id);
}
