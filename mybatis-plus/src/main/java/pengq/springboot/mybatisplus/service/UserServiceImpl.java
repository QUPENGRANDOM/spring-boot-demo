package pengq.springboot.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pengq.springboot.mybatisplus.dao.UserDao;
import pengq.springboot.mybatisplus.entity.Users;

import java.util.List;

/**
 * Created by pengq on 2019/9/3 8:59.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<Users> listUser() {
        return userDao.selectList(null);
    }

    @Override
    public Users getUserById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public Users getUserByUsername(String username) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return userDao.selectOne(wrapper);
    }

    @Override
    public boolean register(Users users) {
        return userDao.insert(users) == 1;
    }

    @Override
    public boolean login(String username, String password) {
        Users user = this.getUserByUsername(username);
        return password.equals(user.getPassword());
    }
}
