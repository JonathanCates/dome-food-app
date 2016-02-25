package com.example.jcate478.seat_suite.login;

import com.firebase.client.Firebase;

/**
 * Created by jcate478 on 2/10/2016.
 */
public class Login {

    Firebase firebaseRef;

    public Login(Firebase firebaseRef)
    {
        this.firebaseRef = firebaseRef;
    }

    public void createUser(String user, String pword)
    {
        //ResultHandler results = new ResultHandler();
       // firebaseRef.createUser(user, pword, results);
    }

}
