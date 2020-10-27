package com.yangs.SpringBootDemo.service;

import com.yangs.SpringBootDemo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    String login(String userName,String pwd);
    List<User> listUser();
}
