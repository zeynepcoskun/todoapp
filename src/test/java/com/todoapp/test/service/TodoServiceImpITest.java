package com.todoapp.test.service;


import com.todoapp.implementation.TodoServiceImpl;
import com.todoapp.model.Todo;
import com.todoapp.model.User;
import com.todoapp.repository.TodoRepository;
import com.todoapp.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 *
 * @author Zeynep Coşkun
 */
@RunWith(MockitoJUnitRunner.class)
public class TodoServiceImpITest {

    @Mock
    private TodoRepository todoRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TodoServiceImpl todoService;

    private Todo todo;
    private List<Todo> todoList;

    @Before
    public void setUp() {
        composeTestTodo();
        composeMultipleTestTodo();
    }

    @Test
    public void getTodo() {
        List<Todo> todo = todoService.todos();
        assertEquals(0, todo.size());
    }

    @Test
    public void saveTodo() {
        todoService.saveTodo(todo);
        verify(todoRepository, times(1)).save(todo);
    }

    @Test
    public void getTodoList() {
        when(todoRepository.findAll()).thenReturn(todoList);
        List<Todo> todoList = todoService.todos();
        assertNotNull(todoList);
        assertEquals(2, todoList.size());
        verify(todoRepository, times(1)).findAll();
    }

    @Test()
    public void composeTestTodo() {

        User user = new User();
        user.setTitle("test");
        user.setFirstName("fname");
        user.setLastName("lname");
        user.setEmail("ghdh");
        
        Todo todo = new Todo();
        todo.setUser(user);
        List<Todo> todos = new ArrayList<Todo>();
        todos.add(todo);
        user.setTodos(todos);
        userRepository.save(user);
    }

    public void composeMultipleTestTodo() {
        todoList = new ArrayList<>();
        todoList.add(todo);

        User user = new User();
        user.setTitle("test");
        user.setFirstName("fname");
        user.setLastName("lname");
        user.setEmail("ghdh");
        
        Todo todo2 = new Todo();
        todo2.setUser(user);
        List<Todo> todos = new ArrayList<Todo>();
        todos.add(todo2);
        user.setTodos(todos);

        todoList.add(todo2);
    }

}
