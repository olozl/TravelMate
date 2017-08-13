package com.lee.zoey.travelmate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Copyright (c) 2017 Eunji Lee
 * This work is available under the "MIT license".
 * Please see the file COPYING in this distribution for license terms.
 */

public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logindetails);

        final EditText exUser = (EditText) findViewById(R.id.exUser);
        final EditText exPwd = (EditText) findViewById(R.id.exPwd);
        final TextView registerLink = (TextView) findViewById(R.id.registerLink);
        final Button bLogin = (Button) findViewById(R.id.bSignIn);

        // send user to registration page
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
        // Allow login only if username and corresponding password are valid
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = exUser.getText().toString();
                final String password = exPwd.getText().toString();
                UserList listOfUsers = new UserList();
                if(listOfUsers.userCheck(username, password)){
                    Toast.makeText(LoginActivity.this, "Welcome "+username+"!",
                            Toast.LENGTH_SHORT).show();

                    Intent startShopping = new Intent(getBaseContext(), CityActivity.class);
                    startActivity(startShopping);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid username and/or password",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
