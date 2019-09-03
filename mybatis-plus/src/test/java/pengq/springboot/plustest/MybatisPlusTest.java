package pengq.springboot.plustest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pengq.springboot.mybatisplus.MybatisPlusApplication;
import pengq.springboot.mybatisplus.dao.UserDao;
import pengq.springboot.mybatisplus.entity.Users;

import java.util.Date;
import java.util.List;

/**
 * Created by pengq on 2019/9/2 14:37.
 */
@SpringBootTest(classes = MybatisPlusApplication.class)
@RunWith(SpringRunner.class)
public class MybatisPlusTest {
    @Autowired
    UserDao userDao;

    @Test
    public void testPlus(){
        Users userItem = new Users();
        userItem.setNickname("通通大脸猫");
        userItem.setUsername("pengq");
        userItem.setPassword("admin");
        userItem.setAvatar("sada");
        userItem.setSex(1);
        userItem.setStatus(false);
        userItem.setCreateTime(new Date());
        //插入
        int i = userDao.insert(userItem);
        Assert.assertEquals(1, i);

        //通过id查询
        Users user =  userDao.selectById(1);
        Assert.assertNotNull(user);

        //查询所有
        List<Users> users = userDao.selectList(null);
        Assert.assertTrue(users != null && !users.isEmpty());
        //自定义查询
        List<Users> usersList = userDao.findAllBySex(1);
        Assert.assertNotNull(usersList);
    }
}
