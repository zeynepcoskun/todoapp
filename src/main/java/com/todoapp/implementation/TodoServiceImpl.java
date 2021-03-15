package com.todoapp.implementation;



import com.todoapp.model.Todo;
import com.todoapp.repository.TodoRepository;
import com.todoapp.service.TodoService;
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
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public List<Todo> todos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodo(long todoId) {
        return todoRepository.findById(todoId).get();
    }

    @Override
    public void deleteTodo(long todoId) {
        todoRepository.deleteById(todoId);
    }
}
