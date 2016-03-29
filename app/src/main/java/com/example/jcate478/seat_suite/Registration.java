package com.example.jcate478.seat_suite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jcate478.seat_suite.login.Login;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


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
        Login log = new Login();

        EditText first = (EditText) findViewById(R.id.firstName);
        EditText last = (EditText) findViewById(R.id.lastName);
        EditText email = (EditText) findViewById(R.id.emailText);
        EditText pwrd = (EditText) findViewById(R.id.pword);
        EditText pwrdCheck = (EditText) findViewById(R.id.pwordCheck);
        String firstName = first.getText().toString();
        String lastName = last.getText().toString();
        String emailS = email.getText().toString();
        String password = pwrd.getText().toString();
        String passwordCheck = pwrdCheck.getText().toString();

        if(password.equals(passwordCheck))
        {
            log.createUser(emailS, password);
            Toast.makeText(Registration.this, "Account created successfully", Toast.LENGTH_LONG).show();
        }
        else
        {

        }


    }

}
