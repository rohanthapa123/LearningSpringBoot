package com.profiles.MutipleProfile.repo;

import com.profiles.MutipleProfile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User , Long> {
}
