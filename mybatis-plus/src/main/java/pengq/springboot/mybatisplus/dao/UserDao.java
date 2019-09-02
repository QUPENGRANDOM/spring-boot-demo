package pengq.springboot.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pengq.springboot.mybatisplus.entity.Users;

import java.util.List;

@Repository
public interface UserDao extends BaseMapper<Users> {

    List<Users> findAllBySex(@Param(value = "sex") Integer sex);
}
