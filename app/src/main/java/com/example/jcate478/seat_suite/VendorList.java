package com.example.jcate478.seat_suite;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jcate478.seat_suite.vendorInfo.*;

import java.util.ArrayList;

public class VendorList extends AppCompatActivity {

    ArrayList<vendor> vendors;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_list);

        listView = (ListView)findViewById(R.id.vendor_list);

        vendors = new ArrayList<>();
        populateVendors();
    }

    /**
     * Temporarily hardcoded should access our predetermined list of vendors and populate based on that
     */
    private void populateVendors()
    {
        vendors.add(new vendor("Jimmy's Hot Dogs", 222));
        vendors.add(new vendor("Burgers, Burgers, Burgers", 231));
        vendors.add(new vendor("Just Food", 220));
        vendors.add(new vendor("BEER maybe", 184));
        vendors.add(new vendor("Churro Zone", 150));

        for(int i = 0; i < vendors.size(); i++)
        {
            vendors.get(i).addFood("Chicken" + i, 20.00);
            vendors.get(i).addFood("Burger" + i, 18.21);
            vendors.get(i).addFood("Churro" + i, 9.99);
            vendors.get(i).addFood("Other Crap" + i, 14.68);
        }

        //for(int i = 0; i < vendors.size(); i++)
       // {
            ArrayAdapter<vendor> arrayAdapter = new ArrayAdapter<vendor>(this, android.R.layout.simple_list_item_1, vendors);

            listView.setAdapter(arrayAdapter);
        //}
    }

}
