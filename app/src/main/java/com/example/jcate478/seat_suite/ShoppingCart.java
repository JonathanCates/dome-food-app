package com.example.jcate478.seat_suite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jcate478.seat_suite.customFunctionality.FoodListAdapter;
import com.example.jcate478.seat_suite.vendorInfo.Food;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {


    private ArrayList<Food> foodCart;
    private ListView listView;
    private FoodListAdapter arrayAdapter;
    private double price;
    private TextView preGst;
    private TextView gst;
    private TextView totalCost;
    private DecimalFormat df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        foodCart = i.getParcelableArrayListExtra("cart");
        listView = (ListView)findViewById(R.id.shopping_cart);

        df = new DecimalFormat("#.##");

        preGst = (TextView) findViewById(R.id.preTaxCost);
        gst = (TextView) findViewById(R.id.gst);
        totalCost = (TextView) findViewById(R.id.finalCost);

        listShoppingCart();
    }

    private void listShoppingCart()
    {
        arrayAdapter = new FoodListAdapter(ShoppingCart.this, R.layout.child_lineview, foodCart);
        listView.setAdapter(arrayAdapter);

        for (int i = 0; i < foodCart.size(); i++)
        {
            price += foodCart.get(i).getPrice();
        }

        preGst.setText(df.format(price));
        gst.setText(df.format(price * 0.05)); // Canadian GST is 5%, Alberta has no PST so not added in hardcode, will change if expanded outside AB
        totalCost.setText(df.format(price * 1.05));

    }
}
