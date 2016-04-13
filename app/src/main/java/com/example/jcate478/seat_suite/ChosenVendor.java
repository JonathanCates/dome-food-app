package com.example.jcate478.seat_suite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jcate478.seat_suite.customFunctionality.FoodListAdapter;
import com.example.jcate478.seat_suite.vendorInfo.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ChosenVendor extends AppCompatActivity {

    private Vendor vendor;
    private ArrayList<Food> food;
    private ArrayAdapter<Food> arrayAdapter;
    private ArrayList<Food> shoppingCart;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_vendor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        shoppingCart = new ArrayList<>();
        Intent i = getIntent();
        vendor = (Vendor) i.getParcelableExtra("chosenVendor");
        food = vendor.getFoodItems();

        listView = (ListView)findViewById(R.id.chosen_vendor_food);
        listFoodItems();
    }

    private void listFoodItems()
    {
        arrayAdapter = new FoodListAdapter(ChosenVendor.this, R.layout.food_layout, food);
        listView.setAdapter(arrayAdapter);

        Button cartButt = (Button) findViewById(R.id.cart);


        cartButt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent session = new Intent(getBaseContext(), ShoppingCart.class);
                        session.putExtra("vendorName", vendor.getVendorName());
                        session.putParcelableArrayListExtra("cart", shoppingCart);
                        startActivity(session);
                    }
                });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                shoppingCart.add(food.get(position));
                Toast.makeText(ChosenVendor.this, food.get(position).getName() + " added to cart", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
