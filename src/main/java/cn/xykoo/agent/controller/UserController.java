package cn.xykoo.agent.controller;

import cn.xykoo.agent.common.annotation.Authorization;
import cn.xykoo.agent.common.http.KVResult;
import cn.xykoo.agent.common.http.ServerResponse;
import cn.xykoo.agent.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 用户
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/21
 * @email : seven_tjb@163.com
 **/

@Api(value = "用户", description = "user")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "登录")
    @PostMapping(value = "/signIn")
    public ServerResponse signIn(@RequestParam String name, @RequestParam String password) {
        KVResult result = userService.signIn(name, password);
        return ServerResponse.createMessage(result);
    }

    @Authorization
    @ApiOperation(value = "修改密码")
    @PostMapping(value = "/changePassword")
    public ServerResponse changePassword(@RequestParam String password,@ApiIgnore @RequestAttribute Integer agentId) {
        KVResult result = userService.changePassword(agentId,password);
        return ServerResponse.createMessage(result);
    }

    @Authorization
    @ApiOperation(value = "获取个人信息")
    @GetMapping(value = "/getUserInfo")
    public ServerResponse getUserInfo(@ApiIgnore @RequestAttribute Integer agentId) {
        KVResult result = userService.getUserInfo(agentId);
        return ServerResponse.createMessage(result);
    }
}
