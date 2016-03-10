package com.example.jcate478.seat_suite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.jcate478.seat_suite.customFunctionality.FoodListAdapter;
import com.example.jcate478.seat_suite.vendorInfo.food;
import com.example.jcate478.seat_suite.vendorInfo.vendor;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {

    private vendor chosenVendor;
    private ArrayList<food> foodCart;
    private ListView listView;
    private FoodListAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        foodCart = i.getParcelableArrayListExtra("cart");

        listView = (ListView)findViewById(R.id.shopping_cart);
    }

    private void listShoppingCart()
    {
        arrayAdapter = new FoodListAdapter(ShoppingCart.this, R.layout.child_lineview, foodCart);
        listView.setAdapter(arrayAdapter);
    }
}
