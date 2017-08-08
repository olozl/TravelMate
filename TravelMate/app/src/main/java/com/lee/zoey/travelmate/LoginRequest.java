//package com.lee.zoey.travelmate;
//
//import com.android.volley.Response;
//import com.android.volley.toolbox.StringRequest;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Copyright (c) 2017 Eunji Lee
// * This work is available under the "MIT license".
// * Please see the file COPYING in this distribution for license terms.
// */
//
//public class LoginRequest extends StringRequest {
//    private static final String LOGIN_REQUEST_URL = "";//http://localhost/mysqltest.php";
//    private Map<String, String> params;
//
//    public LoginRequest(String username, String password, Response.Listener<String> listener) {
//        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
//        params = new HashMap<>();
//        params.put("username", username);
//        params.put("password", password);
//    }
//
//    @Override
//    public Map<String, String> getParams() {
//        return params;
//    }
//}
