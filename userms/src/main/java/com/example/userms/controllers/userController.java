package com.example.userms.controllers;


import com.example.userms.Services.UserService;
import com.example.userms.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/User")
public class userController {

    @Autowired
    public UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {


        return userService.getUserById(id);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        return userService.getUser();
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) {
        return  userService.addUser(user);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestBody User user) {

        return   userService.deleteUser(user.getPerosnID());
    }

}
