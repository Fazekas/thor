package com.mythology.thor.controller;

import com.mythology.thor.model.User;
import com.mythology.thor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public void login() {

    }

    // POST Mapping
    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // GET Mapping
    @GetMapping(path = "/users")
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping(path="/email/{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping(path = "/username/{username}")
    public User findByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }





}
