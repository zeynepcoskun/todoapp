package com.todoapp.service;

import com.todoapp.model.User;

import java.util.List;

/**
 * 
 * 
 */
public interface UserService {
    
    List<User> getAllUsers();
    List<User> usersWithoutTodo();
    User getUser(long userId);
    void saveUser(User user);
    void deleteUser(long userId);
}
