package pengq.springboot.mybatisplus.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pengq.springboot.mybatisplus.entity.Users;
import pengq.springboot.mybatisplus.service.UserService;

/**
 * Created by pengq on 2019/9/3 9:12.
 */

@RestController
@RequestMapping(value = "/api")
@Api(value = "/UserController", tags = "用户接口")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("查询所有用户")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功", response = Users.class),
            @ApiResponse(code = 500, message = "服务器内部异常")
    })
    @GetMapping(value = "/v1/users/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getAllUser() {
        return userService.listUser();
    }

    @ApiOperation("用户注册")
    @PostMapping(value = "/v1/users/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object register(@RequestBody Users users) {
        return userService.register(users);
    }

    @ApiOperation("查询用户详情")
    @ApiImplicitParam(paramType = "path", name = "id")
    @GetMapping(value = "/v1/users/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getUserInfo(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "username", value = "登录名"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "登录密码")
    })
    @PostMapping(value = "/v1/users/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password) {
        return userService.login(username, password);
    }

    @ApiOperation("header 测试")
    @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "token")
    @PostMapping(value = "/v1/users/check", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object check(@RequestHeader("token") String token) {
        return token;
    }
}
