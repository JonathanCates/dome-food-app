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

    private ArrayList<Vendor> vendors;
    private ListView listView;
    private ArrayAdapter<Vendor> arrayAdapter;
    private ArrayList<Vendor> vendorsHaveItemType;
    private int foodType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_list);

        listView = (ListView)findViewById(R.id.vendor_list);

        Intent i = getIntent();
        foodType = i.getIntExtra("foodtype", Food.DEFAULT_TYPE);


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
        vendors.add(new Vendor("Jimmy's Hot Dogs", 215));
        vendors.add(new Vendor("Burgers, Burgers, Burgers", 213));
        vendors.add(new Vendor("Just Food", 210));
        vendors.add(new Vendor("BEER maybe", 224));
        vendors.add(new Vendor("Churro Zone", 226));

        for(int i = 0; i < vendors.size(); i++)
        {
            if(i <= 2)
            {
            vendors.get(i).addFood("Chicken Fingers " + i, Food.CHICKEN_FINGERS_TYPE, 20.00);
            vendors.get(i).addFood("Burger " + i, Food.BURGER_TYPE, 18.21);
            vendors.get(i).addFood("Churro " + i, Food.CHURRO_TYPE, 9.99);
            }
            vendors.get(i).addFood("Snacks " + i, Food.SNACKS_TYPE, 14.68);
            if(i > 2)
            {
            vendors.get(i).addFood("Beer " + i, Food.BEER_TYPE, 6.67);
            vendors.get(i).addFood("Hot Dog " + i, Food.HOT_DOG_TYPE, 3.28);
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

        listView.setAdapter(arrayAdapter);

    }


    private void setClick()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent session = new Intent(VendorList.this, ChosenVendor.class);
                Vendor chosenVendor = vendors.get(position);
                session.putExtra("chosenVendor", chosenVendor);
                startActivity(session);
            }
        });
    }

}
