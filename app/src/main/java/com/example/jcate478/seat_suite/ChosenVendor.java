package com.example.jcate478.seat_suite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jcate478.seat_suite.customFunctionality.FoodListAdapter;
import com.example.jcate478.seat_suite.vendorInfo.*;

import java.util.ArrayList;

public class ChosenVendor extends AppCompatActivity {

    private vendor vendor;
    private ArrayList<food> food;
    private ArrayAdapter<food> arrayAdapter;
    private ArrayList<food> shoppingCart;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_vendor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        shoppingCart = new ArrayList<>();
        Intent i = getIntent();
        vendor = (vendor) i.getParcelableExtra("chosenVendor");
        food = vendor.getFoodItems();

        listView = (ListView)findViewById(R.id.chosen_vendor_food);
        listFoodItems();
    }

    private void listFoodItems()
    {
        arrayAdapter = new FoodListAdapter(ChosenVendor.this, R.layout.child_lineview, food);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                shoppingCart.add(food.get(position));
            }
        });
    }

}
