package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@Api(tags = "用户数据管理")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value="获取所有用户信息", notes="获取所有用户信息")
    @GetMapping(value = "",produces = {"application/json;charset=UTF-8"})
    public List<User> getAllUser(){
        return userService.listUser();
    }

    @ApiOperation(value="获取所有用户信息", notes="获取所有用户信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping(value = "/{userId}",produces = {"application/json;charset=UTF-8"})
    public User getAllUser(@PathVariable(value = "userId") int userId){
        return userService.getUserById(userId);
    }

}
