package com.transaction.Transaction.Demo.controller;

import com.transaction.Transaction.Demo.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UseController {

    private final UserServices userServices;

    public UseController(UserServices userServices){
        this.userServices = userServices;
    }

    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> getUsers(
            @RequestParam(value = "pageNumber" , defaultValue = "0" , required = false) Integer pageNumber,
            @RequestParam(value = "pageSize" , defaultValue = "5", required = false) Integer pageSize,
            @RequestParam(value = "sortBy" ,defaultValue = "accountNumber", required = false) String sortBy,
            @RequestParam(value = "sortOrder" , defaultValue = "asc" , required = false) String sortOrder
            ){
        return new ResponseEntity<>(userServices.getUsers(pageNumber, pageSize , sortBy , sortOrder), HttpStatus.OK);
    }

}
