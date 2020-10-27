package com.yangs.SpringBootDemo.service.impl;

import com.yangs.SpringBootDemo.domain.User;
import com.yangs.SpringBootDemo.mapper.UserMapper;
import com.yangs.SpringBootDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static Map<String,User> sessionMap = new HashMap<>();

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String userName, String pwd) {
       User user = userMapper.login(userName,pwd);
       if(user == null){
           return null;
       }
       String token = UUID.randomUUID().toString();
       System.out.println(token);
       sessionMap.put(token,user);
       return token;
    }

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }
}
