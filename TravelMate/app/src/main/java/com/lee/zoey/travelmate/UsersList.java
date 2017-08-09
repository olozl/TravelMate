package com.lee.zoey.travelmate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user1 on 2017-08-09.
 */

public class UsersList {
    List<UserInfo> listOfUsers;
    UsersList(){
        listOfUsers = new ArrayList<UserInfo>();
    }

    public void setList(UserInfo info){
        listOfUsers.add(info);
    }

    public List<UserInfo> getList(){
        return listOfUsers;
    }

    public int getSize(){
        return listOfUsers.size();
    }
}
