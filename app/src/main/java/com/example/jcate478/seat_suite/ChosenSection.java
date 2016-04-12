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

import com.example.jcate478.seat_suite.customFunctionality.VendorListAdapter;
import com.example.jcate478.seat_suite.saddledome.*;
import com.example.jcate478.seat_suite.vendorInfo.*;

import java.util.ArrayList;
import java.util.List;

public class ChosenSection extends AppCompatActivity {

    private saddledomeGrid grid = new saddledomeGrid();
    private ArrayAdapter<Vendor> arrayAdapter;
    private ArrayList<Vendor> unOrderedVendors;

    private ListView listViewGroup;

    private ArrayList<Vendor> orderedVendors;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_section);

        listViewGroup = (ListView)findViewById(R.id.vendor_in_group);

        Intent i = getIntent();
        int chosenSection = i.getIntExtra("chosenSection", 0);
        unOrderedVendors = i.getParcelableArrayListExtra("vendors");

        grid.populateGrid();

        orderedVendors = new ArrayList<>();

        listVendorsInGroup(chosenSection);
        listVendorsInClosetGroup(chosenSection);
        listVendorsInSecondClosestGroup(chosenSection);


        arrayAdapter = new VendorListAdapter(ChosenSection.this, R.layout.child_lineview, orderedVendors);
        listViewGroup.setAdapter(arrayAdapter);

    }


    public ArrayList<Vendor> getVendorsByGroup(int group)
    {
        ArrayList<Vendor> listToReturn = new ArrayList<Vendor>();

        int[] groupToSearch = grid.getGroup(group);

        for(int i = 0; i < groupToSearch.length; i ++)
        {
            Vendor vendorInSection;
            vendorInSection = getVendorInSection(groupToSearch[i]);
            if(vendorInSection!=null)
            {
                listToReturn.add(vendorInSection);
            }

        }

        return listToReturn;

    }

    public Vendor getVendorInSection(int section)
    {

        for(int i = 0; i < unOrderedVendors.size(); i++)
        {
            Vendor thisOne = unOrderedVendors.get(i);
            if(thisOne.getClosestSection()==section)
            {
                return thisOne;
            }
        }

        return null;
    }


    public void listVendorsInGroup(int section)
    {
        int group = grid.searchGrid(section);

        orderedVendors = getVendorsByGroup(group);
    }

    public void listVendorsInClosetGroup(int section)
    {
        int group = grid.searchGrid(section);
        int groupLeft;
        int groupRight;

        if(group==0)
        {
            groupLeft = 10;
            groupRight = 1;
        }
        else if(group==11)
        {
            groupLeft=10;
            groupRight=0;
        }
        else
        {
            groupLeft=group-1;
            groupRight=group+1;
        }

        orderedVendors.addAll(getVendorsByGroup(groupLeft));
        orderedVendors.addAll(getVendorsByGroup(groupRight));


    }

    /*public void listVendorsInClosetGroup(int section)
    {
        int group = grid.searchGrid(section);
        int groupLeft;
        int groupRight;

        if(group==0)
        {
            groupLeft = 10;
            groupRight = 1;
        }
        else if(group==11)
        {
            groupLeft=10;
            groupRight=0;
        }
        else
        {
            groupLeft=group-1;
            groupRight=group+1;
        }

        orderedVendors.addAll(getVendorsByGroup(groupLeft));
        orderedVendors.addAll(getVendorsByGroup(groupRight));


    }*/

    public void listVendorsInSecondClosestGroup(int section)
    {
        int group = grid.searchGrid(section);
        int groupTwoLeft;
        int groupTwoRight;

        if(group==0)
        {
            groupTwoLeft = 9;
            groupTwoRight = 2;
        }

        else if(group==9)
        {
            groupTwoLeft=7;
            groupTwoRight=0;
        }

        else if(group==1)
        {
            groupTwoLeft=10;
            groupTwoRight=3;
        }

        else if(group==10)
        {
            groupTwoLeft=8;
            groupTwoRight=1;
        }
        else
        {
            groupTwoLeft=group-2;
            groupTwoRight=group+2;
        }

        orderedVendors.addAll(getVendorsByGroup(groupTwoLeft));
        orderedVendors.addAll(getVendorsByGroup(groupTwoRight));
    }

}
