package com.example.jcate478.seat_suite;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jcate478.seat_suite.vendorInfo.Vendor;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class VendorRegistration extends AppCompatActivity {

    private final Firebase firebaseRef = new Firebase("https://glowing-inferno-5513.firebaseio.com/");
    private ProgressDialog mProgressDialog;
    private String emailS;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_registration);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Creating");
        mProgressDialog.setMessage("Adding new user to database...");
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        mProgressDialog.hide();

        Button nextButt = (Button) findViewById(R.id.vendorRegister);

        nextButt.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        register();
                    }
                });

    }

    private void register()
    {
        mProgressDialog.show();

        EditText email = (EditText) findViewById(R.id.vendorEmail);
        EditText pwrd = (EditText) findViewById(R.id.vendorPassword);
        emailS = email.getText().toString();
        password = pwrd.getText().toString();

        firebaseRef.createUser(emailS, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                addDetails();
                showDialog("Account created successfully", false);
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                   showDialog(firebaseError.toString(), true);
            }
        });
    }

    private void showDialog(String message, boolean error) {
        mProgressDialog.hide();
        if(error) {
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, null)
                    .show();
        }
        else
        {
            new AlertDialog.Builder(this)
                    .setTitle("Success")
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            returnToPrevious();
                        }
                    })
                    .show();
        }
    }

    private void addDetails()
    {
        firebaseRef.authWithPassword(emailS, password, new AuthResultHandler("password"));
    }


    private class AuthResultHandler implements Firebase.AuthResultHandler {

        private final String provider;

        public AuthResultHandler(String provider) {
            this.provider = provider;
        }

        @Override
        public void onAuthenticated(AuthData authData) {

            Firebase child = firebaseRef.child("Shitters").child("Test");
            child.setValue(new Vendor("Jimmy's Hotdogs", 221, authData.getUid()));
        }

        @Override
        public void onAuthenticationError(FirebaseError firebaseError) {
            showDialog(firebaseError.toString(), true);
        }
    }

    private void returnToPrevious()
    {
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED, returnIntent);
        finish();
    }

}
