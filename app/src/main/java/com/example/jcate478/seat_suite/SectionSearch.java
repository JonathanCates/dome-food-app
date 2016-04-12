package com.example.jcate478.seat_suite;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jcate478.seat_suite.customFunctionality.VendorListAdapter;
import com.example.jcate478.seat_suite.saddledome.saddledomeGrid;
import com.example.jcate478.seat_suite.vendorInfo.Food;
import com.example.jcate478.seat_suite.vendorInfo.Vendor;

import java.util.ArrayList;

public class SectionSearch extends AppCompatActivity {

    private ArrayList<Vendor> vendors;
    private saddledomeGrid grid = new saddledomeGrid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        vendors = new ArrayList<>();

        populateVendors();
        setButton();
    }

    private void setButton()
    {
        Button sectionToGet = (Button) findViewById(R.id.sectionSearch);

        sectionToGet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        search();
                    }
                });
    }

    private void populateVendors()
    {
        vendors.add(new Vendor("Jimmy's Hot Dogs", 215, "i9hweriuthsduogi"));
        vendors.add(new Vendor("Burgers, Burgers, Burgers", 213, "9yq3287054y3287hy"));
        vendors.add(new Vendor("Just Food", 210, "87yq34287ghds"));
        vendors.add(new Vendor("BEER maybe", 224, "9q3489ye8y934"));
        vendors.add(new Vendor("Churro Zone", 226, "ght8y340y73tw87ht"));

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
    }

    private void search()
    {
        EditText searchText = (EditText) findViewById(R.id.sectionText);
        boolean notfound = false;
        int chosenSection = Integer.parseInt(searchText.getText().toString());
        grid.populateGrid();
        int checkFor = grid.searchGrid(chosenSection);
        if(checkFor > -1)
        {
            int[] groupOfSections = grid.getGroup(checkFor);

            for(int searchArray = 0; searchArray < groupOfSections.length; searchArray++) {
                int findThis = groupOfSections[searchArray];

                for (int searchSection = 0; searchSection < vendors.size(); searchSection++) {
                    if (findThis == vendors.get(searchSection).getClosestSection()) {
                        notfound = false;
                        Intent intent = new Intent(getBaseContext(), ChosenSection.class);
                        intent.putExtra("chosenSection", chosenSection);
                        intent.putParcelableArrayListExtra("vendors", vendors);
                        startActivity(intent);
                    }
                }
                if (notfound == true) {
                    showErrorDialog("Section Not found");
                }
            }
        }
        else
        {
            showErrorDialog("Section does not exist in system");
        }
    }

    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Error, Invalid Section")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }



}
