package com.lee.zoey.travelmate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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


public class RegisterActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerdetails);

        final EditText newName = (EditText) findViewById(R.id.newName);
        final EditText newAge = (EditText) findViewById(R.id.newAge);
        final EditText newUsername = (EditText) findViewById(R.id.newUser);
        final EditText newPassword = (EditText) findViewById(R.id.newPwd);
        final EditText newLanguage = (EditText) findViewById(R.id.newLang);
        final Button newRegister = (Button) findViewById(R.id.newRegister);
        newRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = newName.getText().toString();
                final String username = newUsername.getText().toString();
                final int age = Integer.parseInt(newAge.getText().toString());
                final String password = newPassword.getText().toString();
                final String lang = newLanguage.getText().toString();
// without using database?
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

////                RegisterRequest registerRequest = new RegisterRequest(name, username, age, password, lang, responseListener);
////                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
////                queue.add(registerRequest);
            }
        });
    }
}
