package com.example.jcate478.seat_suite;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseRef = new Firebase("https://glowing-inferno-5513.firebaseio.com/" + firebaseRef.getAuth().getUid());

        pendingOrders = new ArrayList<Order>();
        listView = (ListView)findViewById(R.id.orders);

        populateOrderList();

    }

    private void populateOrderList()
    {
        Firebase ordersRef = firebaseRef.child("Orders");


        ordersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                showDialog("There are " + snapshot.getChildrenCount() + " orders", false);
                for (DataSnapshot orderSnapshot : snapshot.getChildren()) {
                    Order order = orderSnapshot.getValue(Order.class);
                    pendingOrders.add(order);
                    arrayAdapter = new OrdersListAdapter(VendorDash.this, R.layout.child_lineview, pendingOrders);
                    listView.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                showDialog("There are no orders / nothing was read", true);
            }
        });



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
}
