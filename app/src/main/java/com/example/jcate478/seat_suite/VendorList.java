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
import com.firebase.client.Firebase;

import java.util.ArrayList;

public class VendorList extends AppCompatActivity {

    private ArrayList<Vendor> vendors;
    private ListView listView;
    private ArrayAdapter<Vendor> arrayAdapter;
    private ArrayList<Vendor> vendorsHaveItemType;
    private int foodType;
    private Firebase firebaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_list);

        listView = (ListView)findViewById(R.id.vendor_list);

        Intent i = getIntent();
        foodType = i.getIntExtra("foodtype", Food.DEFAULT_TYPE);

        firebaseRef = new Firebase("https://glowing-inferno-5513.firebaseio.com/");


        vendors = new ArrayList<>();
        vendorsHaveItemType = new ArrayList<>();
        populateVendors();

        setClick();
    }

    /**
     * Temporarily hardcoded should access our predetermined list of vendors and populate based on that
     */
    private void populateVendors()
    {
        vendors.add(new Vendor("Jimmy's Hot Dogs", 222, "i9hweriuthsduogi"));
        vendors.add(new Vendor("Burgers, Burgers, Burgers", 231, "9yq3287054y3287hy"));
        vendors.add(new Vendor("Just Food", 220, "87yq34287ghds"));
        vendors.add(new Vendor("BEER maybe", 184, "9q3489ye8y934"));
        vendors.add(new Vendor("Churro Zone", 150, "ght8y340y73tw87ht"));

        for(int i = 0; i < vendors.size(); i++)
        {
            if(i <= 2)
            {
            vendors.get(i).addFood("Chicken Fingers", Food.CHICKEN_FINGERS_TYPE, 20.00);
            vendors.get(i).addFood("Burger", Food.BURGER_TYPE, 18.21);
            vendors.get(i).addFood("Churro", Food.CHURRO_TYPE, 9.99);
            }
            vendors.get(i).addFood("Snacks", Food.SNACKS_TYPE, 14.68);
            if(i > 2)
            {
            vendors.get(i).addFood("Beer", Food.BEER_TYPE, 6.67);
            vendors.get(i).addFood("Hot Dog", Food.HOT_DOG_TYPE, 3.28);
            }
        }

        if(foodType != Food.DEFAULT_TYPE)
        {
            for (int i = 0; i < vendors.size(); i++)
            {
                ArrayList<Integer> vendorFoodTypes = vendors.get(i).getVendorFoodTypes();
                for (int j = 0; j < vendorFoodTypes.size(); j++)
                {
                    if(vendorFoodTypes.get(j) == foodType)
                    {
                        vendorsHaveItemType.add(vendors.get(i));
                    }
                }
            }
            arrayAdapter = new VendorListAdapter(VendorList.this, R.layout.child_lineview, vendorsHaveItemType);
        }
        else {
            arrayAdapter = new VendorListAdapter(VendorList.this, R.layout.child_lineview, vendors);
        }

        for(int i =0; i< vendors.size(); i++)
        {
            Firebase child = firebaseRef.child("Vendors").child(vendors.get(i).getuID());
            child.setValue(vendors.get(i));
        }

        listView.setAdapter(arrayAdapter);

    }

    private void setClick()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent session = new Intent(getBaseContext(), ChosenVendor.class);
                Vendor chosenVendor = vendors.get(position);
                session.putExtra("chosenVendor", chosenVendor);
                startActivity(session);
            }
        });
    }

}
