package com.todoapp.controller;

import com.todoapp.model.Todo;
import com.todoapp.model.User;
import com.todoapp.service.TodoService;
import com.todoapp.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 *
 *
 */
@Controller
public class TodoController {

    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoService;

    private static Logger LOGGER = LogManager.getLogger(TodoController.class);

    @RequestMapping("/todo/add")
    public String openAddTodoPage(Model model) {

        Todo todo = new Todo();
        model.addAttribute("todo", todo);

        final List<User> users = userService.usersWithoutTodo();
        model.addAttribute("users", users);
        return "addtodo";
    }

    @RequestMapping("/todo/save")
    public String saveTodo(@Valid @ModelAttribute("todo") Todo todo,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            final List<User> users = userService.usersWithoutTodo();
            model.addAttribute("users", users);
            return "addtodo";
        }

        final User userFounded = userService.getUser(todo.getUser().getId());
        todo.setUser(userFounded);
        todoService.saveTodo(todo);
        return "redirect:/";
    }

    @RequestMapping("/todo/update/{id}")
    public ModelAndView showEditTodoForm(@PathVariable(name = "id") Long id) {
        ModelAndView myModel = new ModelAndView("updatetodo");
        Todo todo = todoService.getTodo(id);
        myModel.addObject("todo", todo);
        return myModel;
    }

    @RequestMapping("/todo/delete/{id}")
    public String deleteTodo(@PathVariable(name = "id") Long id) {
        todoService.deleteTodo(id);
        return "redirect:/";
    }
}
