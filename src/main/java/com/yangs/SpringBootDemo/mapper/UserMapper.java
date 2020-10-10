package com.yangs.SpringBootDemo.mapper;

import com.yangs.SpringBootDemo.domain.User;

import java.util.HashMap;
import java.util.Map;

public class UserMapper {

    private static Map<Integer, User> userMap = new HashMap<>();

    static {
        userMap.put(1,new User("1","yangs","123"));
        userMap.put(1,new User("2","yangsong","123"));
    }

}
