package com.example.jcate478.seat_suite;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jcate478.seat_suite.vendorInfo.User;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Selection extends AppCompatActivity {

    private Firebase firebaseRef = new Firebase("https://glowing-inferno-5513.firebaseio.com/Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        TextView titleFont = (TextView) findViewById(R.id.seatSuite);
        TextView searchFont = (TextView) findViewById(R.id.chooseyourfood);
        Typeface signPainter = Typeface.createFromAsset(getAssets(), "SignPainter-HouseScript.ttf");
        titleFont.setTypeface(signPainter);
        searchFont.setTypeface(signPainter);

        showDialog(firebaseRef.getAuth().toString());

        buttons();
    }

    private void showDialog(String message) {
            new AlertDialog.Builder(this)
                    .setTitle("Success")
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, null).show();
    }

    private void buttons()
    {
        Button secButt = (Button) findViewById(R.id.section_button);
        Button foodButt = (Button) findViewById(R.id.food_type_button);
        Button vendorButt = (Button) findViewById(R.id.vendor_button);

        secButt.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        startActivity(new Intent(getBaseContext(), SectionSearch.class));
                    }
                });
        foodButt.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        startActivity(new Intent(getBaseContext(), FoodList.class));
                    }
                });
        vendorButt.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        startActivity(new Intent(getBaseContext(), VendorList.class));
                    }
                });
    }

}
