package pengq.springboot.mybatisplus.service;

import pengq.springboot.mybatisplus.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> listUser();
    Users getUserById(Integer id);
    Users getUserByUsername(String username);
    boolean register(Users users);
    boolean login(String username,String password);
}
