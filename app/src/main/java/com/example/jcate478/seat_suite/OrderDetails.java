package com.example.jcate478.seat_suite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class OrderDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonFunctionality();
    }


    private void buttonFunctionality()
    {
        Button returnButt = (Button) findViewById(R.id.return_selection);
        Button returnLogin = (Button) findViewById(R.id.return_login);

        returnButt.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent i= new Intent(OrderDetails.this, Selection.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                });

        returnLogin.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        finish();
                    }
                });
    }

}
