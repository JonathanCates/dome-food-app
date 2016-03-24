package com.example.jcate478.seat_suite;

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

public class Selection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        TextView titleFont = (TextView) findViewById(R.id.seatSuite);
        TextView searchFont = (TextView) findViewById(R.id.chooseyourfood);
        Typeface signPainter = Typeface.createFromAsset(getAssets(), "Fonts/signPainter");
        titleFont.setTypeface(signPainter);
        searchFont.setTypeface(signPainter);

        buttons();
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
                        startActivity(new Intent(Selection.this, SectionSearch.class));
                    }
                });
        foodButt.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        startActivity(new Intent(Selection.this, FoodList.class));
                    }
                });
        vendorButt.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        startActivity(new Intent(Selection.this, VendorList.class));
                    }
                });
    }

}
