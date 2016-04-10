package com.example.jcate478.seat_suite;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jcate478.seat_suite.vendorInfo.Order;
import com.example.jcate478.seat_suite.customFunctionality.OrdersListAdapter;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class VendorDash extends AppCompatActivity {

    private Firebase firebaseRef;
    private ArrayList<Order> pendingOrders;
    private ListView listView;
    private OrdersListAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_dash);

        Firebase.setAndroidContext(this);

        firebaseRef = new Firebase("https://glowing-inferno-5513.firebaseio.com/Vendors");
        firebaseRef = firebaseRef.child(firebaseRef.getAuth().getUid());

        pendingOrders = new ArrayList<Order>();
        listView = (ListView)findViewById(R.id.orders);



        populateOrderList();
        setClick();

    }

    private void populateOrderList()
    {
        Firebase ordersRef = firebaseRef.child("Orders");
        arrayAdapter = new OrdersListAdapter(ordersRef.limit(500), this, R.layout.printed_order);
        listView.setAdapter(arrayAdapter);
    }

    private void showDialog(String message, boolean error) {
        if(error) {
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, null)
                    .show();
        }
        else
        {
            new AlertDialog.Builder(this)
                    .setTitle("Success")
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, null)
                    .show();
        }
    }

    private void setClick()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Order chosenOrder = (Order) arrayAdapter.getItem(position);
                showDialog(chosenOrder.string(), false);
            }
        });
    }
}
