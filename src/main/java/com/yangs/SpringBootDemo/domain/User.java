package com.yangs.SpringBootDemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
    private String id;

    private String userName;

    @JsonIgnore
    private String password;

    public User(){}

    public User(String id,String userName,String pwd){
        this.id = id;
        this.userName = userName;
        this.password = pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
