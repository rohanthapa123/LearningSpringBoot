package com.errorhandlingandvalidation.Error.and.Validation.repo;

import com.errorhandlingandvalidation.Error.and.Validation.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users , Long> {
}
