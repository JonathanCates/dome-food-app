package com.example.jcate478.seat_suite;

import android.app.AlertDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        TextView titleFont = (TextView) findViewById(R.id.seatSuite);
        Typeface signPainter = Typeface.createFromAsset(getAssets(), "SignPainter-HouseScript.ttf");
        titleFont.setTypeface(signPainter);


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
        Firebase firebaseRef = new Firebase("https://glowing-inferno-5513.firebaseio.com/");

        EditText first = (EditText) findViewById(R.id.firstName);
        EditText last = (EditText) findViewById(R.id.lastName);
        EditText email = (EditText) findViewById(R.id.email);
        EditText pwrd = (EditText) findViewById(R.id.pword);
        EditText pwrdCheck = (EditText) findViewById(R.id.pwordCheck);
        String firstName = first.getText().toString();
        String lastName = last.getText().toString();
        String emailS = email.getText().toString();
        String password = pwrd.getText().toString();
        String passwordCheck = pwrdCheck.getText().toString();

        if(password.equals(passwordCheck))
        {
            firebaseRef.createUser(emailS, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
                @Override
                public void onSuccess(Map<String, Object> result) {
                    Toast.makeText(Registration.this, "Account created successfully", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onError(FirebaseError firebaseError) {
                    showErrorDialog(firebaseError.toString());
                }
            });
        }
        else
        {
            Toast.makeText(Registration.this, "Passwords don't match, please check", Toast.LENGTH_LONG).show();
        }
    }

    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

}
