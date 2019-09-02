package pengq.springboot.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by pengq on 2019/9/2 11:39.
 */
@SpringBootApplication
@MapperScan("pengq.springboot.mybatisplus.dao")
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class,args);
    }
}
