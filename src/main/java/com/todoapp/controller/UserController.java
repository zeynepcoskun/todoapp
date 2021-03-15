package com.todoapp.controller;

import com.todoapp.model.Todo;
import com.todoapp.model.User;
import com.todoapp.repository.TodoRepository;
import com.todoapp.repository.UserRepository;
import com.todoapp.service.TodoService;
import com.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import org.springframework.util.CollectionUtils;

/**
 *
 *
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping("/")
    public String openHomePage(Model model) {

        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);

        List<Todo> todoList = todoService.todos();
        model.addAttribute("todoList", todoList);

        return "main";
    }

    @RequestMapping("/user/new")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "adduser";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "adduser";
        }
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/user/update/{id}")
    public ModelAndView showEditUserForm(@PathVariable(name = "id") Long id) {
        ModelAndView myModel = new ModelAndView("updateuser");
        User user = userService.getUser(id);
        myModel.addObject("user", user);
        return myModel;
    }

    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {

        User userFounded = userService.getUser(id);

        if (!CollectionUtils.isEmpty(userFounded.getTodos())) {
            for (Todo t : userFounded.getTodos()) {
                todoRepository.deleteById(t.getTodoId());
            }
        }

        userRepository.deleteById(id);
        return "redirect:/";
    }
}
