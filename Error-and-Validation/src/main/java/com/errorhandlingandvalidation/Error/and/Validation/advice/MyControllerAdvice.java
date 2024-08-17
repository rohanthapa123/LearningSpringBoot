package com.errorhandlingandvalidation.Error.and.Validation.advice;

import com.errorhandlingandvalidation.Error.and.Validation.exception.ResourceNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> noResouceFoundException(NoResourceFoundException exception){
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException exception){
        return new ResponseEntity<>("Invalid User Details",HttpStatus.BAD_REQUEST);
    }


}
