package com.lee.zoey.travelmate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Copyright (c) 2017 Eunji Lee
 * This work is available under the "MIT license".
 * Please see the file COPYING in this distribution for license terms.
 */


public class RegisterActivity extends Activity {
    protected UserInfo user;
    protected UserList listOfUsers = new UserList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerdetails);

        final EditText newName = (EditText) findViewById(R.id.newName);
        final EditText newAge = (EditText) findViewById(R.id.newAge);
        final EditText newUsername = (EditText) findViewById(R.id.newUser);
        final EditText newPassword = (EditText) findViewById(R.id.newPwd);
        final EditText newLanguage = (EditText) findViewById(R.id.newLang);
        final RadioGroup genderGroup = (RadioGroup) findViewById(R.id.gender);
        final Button newRegister = (Button) findViewById(R.id.newRegister);
        final Button login = (Button) findViewById(R.id.loginbt);

        newRegister.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   final String name = newName.getText().toString();
                   final String username = newUsername.getText().toString();
                   final int age = Integer.parseInt(newAge.getText().toString());
                   final String password = newPassword.getText().toString();
                   final String lang = newLanguage.getText().toString();

                   // Give an error message if name is not entered
                   if(name.isEmpty()){
                       newName.setError("Name not entered");
                       newName.requestFocus();
                   }

                   // Give an error message if name is not entered
                   if(username.isEmpty()){
                       newUsername.setError("Username not entered");
                       newUsername.requestFocus();
                   }

                   // Give an error message if name is not unique
                   if(listOfUsers.idCheck(username)) {
                       newUsername.setError("Username not unique");
                       newUsername.requestFocus();
                   }

                   // Give an error message if age is not entered or age is not in valid boundary
                   if(newAge.getText().toString().length()==0 || age<=0 || age>130){
                       newAge.setError("Invalid age");
                       newName.requestFocus();
                   }

                   // Give an error message if language is not entered
                   if(lang.isEmpty()){
                       newLanguage.setError("Required at least one language");
                       newLanguage.requestFocus();
                   }

                   // Give an error message if password is not entered or is less than 8 characters
                   if(password.isEmpty() || password.length()<8){
                       newPassword.setError("Required at least 8 characters");
                       newPassword.requestFocus();
                   }
                   if(newName.getError()==null && newUsername.getError()==null && newAge.getError()==null
                       && newLanguage.getError()==null && newPassword.getError()==null){
                           String gender;
                           int genderid = genderGroup.getCheckedRadioButtonId();
                           if(((RadioButton)genderGroup.findViewById(genderid)).getText().toString().equals("female"))
                              gender = "Female";
                           else
                              gender = "Male";

                           // if user inserated valid information, create a Userlist object with those information
                           user = new UserInfo(name, username, age, password, lang, gender);
                           // add the user into the list of users
                           listOfUsers.addUser(user);
                           Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();
                    }
               }
           });
        // Button to go back to the login page
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent backtologin = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(backtologin);
            }
        });
    }
}