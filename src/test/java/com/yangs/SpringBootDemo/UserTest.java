package com.yangs.SpringBootDemo;

import com.yangs.SpringBootDemo.controller.UserController;
import com.yangs.SpringBootDemo.domain.User;
import com.yangs.SpringBootDemo.utils.JsonData;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootDemoApplication.class})
public class UserTest {
    @Autowired
    private UserController userController;

    @Test
    public void loginTest(){
        User user = new User();
        user.setUserName("yangs");
        user.setPassword("1235");
        JsonData jsonData = userController.login(user);
        System.out.println(jsonData.toString());
        TestCase.assertEquals(0,jsonData.getCode());
    }
}
