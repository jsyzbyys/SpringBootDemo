package com.yangs.SpringBootDemo.controller;

import com.yangs.SpringBootDemo.domain.User;
import com.yangs.SpringBootDemo.service.UserService;
import com.yangs.SpringBootDemo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

   /* @PostMapping("login")
    //前端用json格式传递信息时需要在参数前加入@RequestBody注解
    public JsonData login(User user){
        System.out.println("userName="+user.getUserName()+" pwd="+user.getPassword());
        return JsonData.buildSuccess("");
    }*/

    @PostMapping("login")
    //前端用json格式传递信息时需要在参数前加入@RequestBody注解
    public JsonData login(@RequestBody User user){
       String token = userService.login(user.getUserName(),user.getPassword());
       return token !=null ? JsonData.buildSuccess(token):JsonData.buildError("账号密码错误");
    }

    @PostMapping("list_user")
    public JsonData listUser(){
        return JsonData.buildSuccess(userService.listUser());
    }
}
