package com.lee.zoey.travelmate;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2017 Eunji Lee
 * This work is available under the "MIT license".
 * Please see the file COPYING in this distribution for license terms.
 */

// Data structure to store list of users
public class UserList {
    public static List<UserInfo> listOfUsers;
    public void addUser(UserInfo newUser){
        if(listOfUsers==null){
            listOfUsers = new ArrayList<UserInfo>();
        }
        if(!idCheck(newUser.getUser())){
            listOfUsers.add(newUser);
        }
    }
    // id check to avoid same id different users
    public boolean idCheck(String newUser) {
        if (listOfUsers == null) return false;
        for (UserInfo ele : listOfUsers) {
            if (ele.getUser().equals(newUser)) {
                return true;
            }
        }
        return false;
    }
    // to check if username and corresponding password are on the user list
    public boolean userCheck(String usernmae, String pwd){
        if(listOfUsers==null) return false;
        for(UserInfo ele : listOfUsers){
            if(ele.equals(usernmae, pwd))
                return true;
        }
        return false;
    }
    // getter
    public List<UserInfo> getList(){
        return listOfUsers;
    }
}
