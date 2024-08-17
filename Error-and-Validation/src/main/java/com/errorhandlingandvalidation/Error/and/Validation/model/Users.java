package com.errorhandlingandvalidation.Error.and.Validation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 12 , message = "Username must be between 3 to 12 character")
    private String username;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50 , message = "Name must be 2 character ")
    private String name;

    @NotBlank(message = "password is required")
    @Size(min = 8 , max = 16 , message = "Password must be in between 8 to 16 characters")
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email must be valid")
    private String email;

}
