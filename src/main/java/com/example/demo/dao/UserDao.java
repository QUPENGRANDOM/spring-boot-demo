package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDao {
    @Select("select * from demo.user;")
    List<User> findAll();
}
