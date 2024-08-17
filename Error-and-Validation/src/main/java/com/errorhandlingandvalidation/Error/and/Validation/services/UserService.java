package com.errorhandlingandvalidation.Error.and.Validation.services;

import com.errorhandlingandvalidation.Error.and.Validation.model.Users;
import com.errorhandlingandvalidation.Error.and.Validation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<Users> getAllUsers(){
        return userRepo.findAll();
    }


    public Optional<Users> getUserById(Long id){
        return userRepo.findById(id);
    }


    public Users registerUser(Users user){
        return userRepo.save(user);
    }


    public void deleteUserById(Long id){
        userRepo.deleteById(id);
    }


}
