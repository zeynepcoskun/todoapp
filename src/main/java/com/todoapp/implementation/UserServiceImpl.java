package com.todoapp.implementation;

import com.todoapp.model.User;
import com.todoapp.repository.TodoRepository;
import com.todoapp.repository.UserRepository;
import com.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 
 * 
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> usersWithoutTodo() {
        return userRepository.getUsersNoTodo();
    }

    @Override
    public User getUser(long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public void deleteUser(long userId) {
        todoRepository.deleteById(userId);
        userRepository.deleteById(userId);
    }
}
