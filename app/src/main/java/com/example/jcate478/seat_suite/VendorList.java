package com.example.jcate478.seat_suite;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jcate478.seat_suite.customFunctionality.VendorListAdapter;
import com.example.jcate478.seat_suite.vendorInfo.*;

import java.util.ArrayList;

public class VendorList extends AppCompatActivity {

    private ArrayList<vendor> vendors;
    private ListView listView;
    private ArrayAdapter<vendor> arrayAdapter;


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
            vendors.get(i).addFood("Chicken" + i, 4, 20.00);
            vendors.get(i).addFood("Burger" + i, 2, 18.21);
            vendors.get(i).addFood("Churro" + i, 5, 9.99);
            vendors.get(i).addFood("Other Crap" + i, 6, 14.68);
            vendors.get(i).addFood("Beer" + i, 1, 14.68);
            vendors.get(i).addFood("Hot Dog" + i, 3, 14.68);
        }
        arrayAdapter = new VendorListAdapter(VendorList.this, R.layout.child_lineview, vendors);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent session = new Intent(VendorList.this, ChosenVendor.class);
                vendor chosenVendor = vendors.get(position);
                session.putExtra("chosenVendor", chosenVendor);
                startActivity(session);
            }
        });
    }

}
