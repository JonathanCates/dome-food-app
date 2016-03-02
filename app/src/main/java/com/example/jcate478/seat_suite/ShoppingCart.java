package com.example.jcate478.seat_suite;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.jcate478.seat_suite.vendorInfo.food;
import com.example.jcate478.seat_suite.vendorInfo.vendor;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {

    vendor chosenVendor;
    ArrayList<food> foodCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void addFood(food foodToAdd)
    {
        foodCart.add(foodToAdd);
    }

    public void removeFood(food foodToAdd)
    {
        foodCart.remove(foodToAdd);
    }

}
