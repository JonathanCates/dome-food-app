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
    private ArrayAdapter<Vendor> arrayAdapter1;
    private ArrayAdapter<Vendor> arrayAdapter2;
    private ArrayAdapter<Vendor> arrayAdapter3;
    private ArrayAdapter<Vendor> arrayAdapter4;
    private ArrayAdapter<Vendor> arrayAdapter5;
    private ArrayList<Vendor> vendors;

    private ListView listViewGroup;
    private ListView listViewLeftGroup;
    private ListView listViewRightGroup;
    private ListView listView2ndLeftGroup;
    private ListView listView2ndRightGroup;

    private ArrayList<Vendor> inGroup;
    private ArrayList<Vendor> nextLeft;
    private ArrayList<Vendor> nextRight;
    private ArrayList<Vendor> nextTwoLeft;
    private ArrayList<Vendor> nextTwoRight;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_section);

        listViewGroup = (ListView)findViewById(R.id.vendor_in_group);
        listViewLeftGroup = (ListView)findViewById(R.id.vendor_in_closest_group_left);
        listViewRightGroup = (ListView)findViewById(R.id.vendor_in_closest_group_right);
        listView2ndLeftGroup = (ListView)findViewById(R.id.vendor_in_second_closest_group_left);
        listView2ndRightGroup = (ListView)findViewById(R.id.vendor_in_second_closest_group_right);

        Intent i = getIntent();
        int chosenSection = i.getIntExtra("chosenSection",0);
        vendors = i.getParcelableArrayListExtra("vendors");

        grid.populateGrid();

        listVendorsInGroup(chosenSection);
        listVendorsInClosetGroup(chosenSection);
        listVendorsInSecondClosestGroup(chosenSection);

        listViewGroup.setAdapter(arrayAdapter1);
        listViewLeftGroup.setAdapter(arrayAdapter2);
        listViewRightGroup.setAdapter(arrayAdapter3);
        listView2ndLeftGroup.setAdapter(arrayAdapter4);
        listView2ndRightGroup.setAdapter(arrayAdapter5);

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

        for(int i = 0; i < vendors.size(); i++)
        {
            Vendor thisOne = vendors.get(i);
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

        inGroup = getVendorsByGroup(group);

        arrayAdapter1 = new VendorListAdapter(getBaseContext(), R.layout.child_lineview, inGroup);
        //listViewGroup.setAdapter(arrayAdapter);



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

        nextLeft = getVendorsByGroup(groupLeft);
        nextRight = getVendorsByGroup(groupRight);

        arrayAdapter2 = new VendorListAdapter(getBaseContext(), R.layout.child_lineview, nextLeft);
        //listViewLeftGroup.setAdapter(arrayAdapter);

        arrayAdapter3 = new VendorListAdapter(getBaseContext(), R.layout.child_lineview, nextRight);
        //listViewRightGroup.setAdapter(arrayAdapter);
    }

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

        nextTwoLeft = getVendorsByGroup(groupTwoLeft);
        nextTwoRight = getVendorsByGroup(groupTwoRight);

        arrayAdapter4 = new VendorListAdapter(getBaseContext(), R.layout.child_lineview, nextTwoLeft);
        //listView2ndLeftGroup.setAdapter(arrayAdapter);

        arrayAdapter5 = new VendorListAdapter(getBaseContext(), R.layout.child_lineview, nextTwoRight);
        //listView2ndRightGroup.setAdapter(arrayAdapter);

    }

}
