package com.lee.zoey.travelmate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user1 on 2017-08-11.
 */

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
    public boolean idCheck(String newUser) {
        if (listOfUsers == null) return false;
        for (UserInfo ele : listOfUsers) {
            if (ele.getUser().equals(newUser)) {
                return true;
            }
        }
        return false;
    }
    public boolean userCheck(String usernmae, String pwd){
        if(listOfUsers==null) return false;
        for(UserInfo ele : listOfUsers){
            if(ele.equals(usernmae, pwd))
                return true;
        }
        return false;
    }
    public List<UserInfo> getList(){
        return listOfUsers;
    }
}
