package com.dpkrcks.user.service.controller;

import com.dpkrcks.user.service.entities.User;
import com.dpkrcks.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Create user

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody  User user){

        User user1 = userService.saveUser(user);

        return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //get User
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){

        User user = userService.getUser(userId);

        return ResponseEntity.ok(user);

    }


    //get all Users

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){

        List<User> allUser = userService.getAllUser();

        return ResponseEntity.ok(allUser);

    }

    //delete a user
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId){

        userService.deleteUser(userId);
        return ResponseEntity.ok("User is deleted Successfully");
    }

    //update a user
    @PostMapping("/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user ,@PathVariable String userId){

        User user1 = userService.updateUser(userId, user);

        return ResponseEntity.ok(user1);
    }


}
