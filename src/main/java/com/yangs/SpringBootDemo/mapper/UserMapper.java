package com.yangs.SpringBootDemo.mapper;

import com.yangs.SpringBootDemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper {

    private static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("yangs",new User("1","yangs","123"));
        userMap.put("yangsong",new User("2","yangsong","123"));
    }

    public User login(String userName, String pwd){
        User user = userMap.get(userName);
        if(user == null){
            return null;
        }
        if(user.getPassword().equals(pwd)){
            return user;
        }
        return null;
    }

    public List<User> listUser(){
        List<User> userList = new ArrayList<>();
        userList.addAll(userMap.values());
        return userList;
    }

}
