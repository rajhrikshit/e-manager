package com.pracdev.emanager.utils;

import java.io.Serializable;

public class UserProfile implements Serializable {

    private String userName;
    private String name;

    public UserProfile() {
    }

    public UserProfile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
