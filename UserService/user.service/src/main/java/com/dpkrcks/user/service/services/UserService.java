package com.dpkrcks.user.service.services;

import com.dpkrcks.user.service.entities.User;

import java.util.List;

public interface UserService {

    //create user

    public User saveUser(User user);

    //get all users
    public List<User> getAllUser();

    //get a single user

    public User getUser(String userId);

    //delete a user
    public void deleteUser(String userId);

    //update a user.
    public User updateUser(String userId , User user);

}
