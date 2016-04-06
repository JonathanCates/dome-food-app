package com.example.jcate478.seat_suite;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jcate478.seat_suite.vendorInfo.User;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class Registration extends AppCompatActivity {

    private String emailS;
    private String password;
    private String firstName;
    private String lastName;
    private final Firebase firebaseRef = new Firebase("https://glowing-inferno-5513.firebaseio.com/");
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        TextView titleFont = (TextView) findViewById(R.id.seatSuite);
        Typeface signPainter = Typeface.createFromAsset(getAssets(), "SignPainter-HouseScript.ttf");
        titleFont.setTypeface(signPainter);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Creating");
        mProgressDialog.setMessage("Adding new user to database...");
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        mProgressDialog.hide();



        Button nextButt = (Button) findViewById(R.id.next);

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

        EditText first = (EditText) findViewById(R.id.firstName);
        EditText last = (EditText) findViewById(R.id.lastName);
        EditText email = (EditText) findViewById(R.id.email);
        EditText pwrd = (EditText) findViewById(R.id.pword);
        EditText pwrdCheck = (EditText) findViewById(R.id.pwordCheck);
        firstName = first.getText().toString();
        lastName = last.getText().toString();
        emailS = email.getText().toString();
        password = pwrd.getText().toString();
        String passwordCheck = pwrdCheck.getText().toString();

        if(password.equals(passwordCheck))
        {
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
        else
        {
            showDialog("Passwords are not the same, please ensure that they are the same.", true);
        }
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

        public AuthResultHandler(String provider) {this.provider = provider;}

        @Override
        public void onAuthenticated(AuthData authData) {

            //User newUser = new User(firstName, lastName, emailS, authData.getUid());
            Firebase child = firebaseRef.child("Consumers").child("Pool");
            child.setValue(new User(firstName, lastName, emailS, authData.getUid()));
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
