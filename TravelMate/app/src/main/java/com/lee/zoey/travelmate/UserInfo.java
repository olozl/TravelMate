package com.lee.zoey.travelmate;

/**
 * Copyright (c) 2017 Eunji Lee
 * This work is available under the "MIT license".
 * Please see the file COPYING in this distribution for license terms.
 */

public class UserInfo {
    String name;
    String username;
    int age;
    String password;
    String lang;
    String gender;

    UserInfo(String name, String username, int age, String password, String lang, String gender) {
        this.name = name;
        this.username = username;
        this.age = age;
        this.lang = lang;
        this.password = password;
        this.gender = gender;
    }

    public boolean equals(UserInfo users){
        if (this.username.equals(users.username) && this.password.equals(users.password))
            return true;
        return false;
    }

    public boolean existing_id(String username){
        if(this.username.equals(username))
            return true;
        return false;
    }

    public String getUser(){
        return this.username;
    }
}
