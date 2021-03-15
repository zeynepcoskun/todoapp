package com.todoapp.service;

import com.todoapp.model.Todo;

import java.util.List;

/**
 * 
 * 
 */
public interface TodoService {    
    
    List<Todo> todos();
    Todo getTodo(long todoId);    
    void saveTodo(Todo todo);
    void deleteTodo(long todoId);
}
