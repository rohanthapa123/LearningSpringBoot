package com.Caching.Redis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Student")
public class Student implements Serializable {

    @Id
    private String studentId;

    private String name;

    private String college;

    private String email;

}
