package com.example.userms.Services.Impl;

import com.example.userms.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface  userImpl {

    public ResponseEntity<List<User>> getUser();


    public ResponseEntity<User> getUserById(String id) ;

    public  ResponseEntity<String> addUser(User user);

//    public  ResponseEntity<List<User>> getUsersByPropertyId(String id);

    public ResponseEntity<String> updateUser(User user) ;

    public ResponseEntity<String> deleteUser(String id) ;

}
