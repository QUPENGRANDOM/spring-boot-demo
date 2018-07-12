package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "",produces = {"application/json;charset=UTF-8"})
    public List<User> getAllUser(){
        return userService.listUser();
    }
}
