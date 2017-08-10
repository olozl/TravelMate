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

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = exUser.getText().toString();
                final String password = exPwd.getText().toString();
                // need to check if username and password are matching with userlist
                Intent startShopping = new Intent(getBaseContext(), CityActivity.class);
                startActivity(startShopping);
//                // Response received from the server
//                Response.Listener<String> responseListener = new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonResponse = new JSONObject(response);
//                            boolean success = jsonResponse.getBoolean("success");
//
//                            if (success) {
//                                String name = jsonResponse.getString("name");
//                                int age = jsonResponse.getInt("age");
//
//                                Intent intent = new Intent(LoginActivity.this, ShoppingCartActivity.class);
//                                intent.putExtra("name", name);
//                                intent.putExtra("age", age);
//                                intent.putExtra("username", username);
//                                LoginActivity.this.startActivity(intent);
//                            } else {
//                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                                builder.setMessage("Login Failed")
//                                        .setNegativeButton("Retry", null)
//                                        .create()
//                                        .show();
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                };
//
////                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
////                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
////                queue.add(loginRequest);
            }
        });
    }
}