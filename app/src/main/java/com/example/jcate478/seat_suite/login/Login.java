package com.example.jcate478.seat_suite.login;

import com.firebase.client.Firebase;

import java.util.Map;

/**
 * Created by jcate478 on 2/10/2016.
 */
public class Login {

    Firebase firebaseRef;

    public Login()
    {
        firebaseRef = new Firebase("https://glowing-inferno-5513.firebaseio.com/");
    }

    public void createUser(String user, String pword)
    {
        firebaseRef.createUser(user, pword, new ResultHandler());
    }

    public void authWithPassword(String user, String pword)
    {
        firebaseRef.authWithPassword(user,pword, new AuthResultHandler());
    }

}
