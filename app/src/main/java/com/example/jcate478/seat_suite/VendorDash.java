package com.example.jcate478.seat_suite;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jcate478.seat_suite.vendorInfo.Order;
import com.example.jcate478.seat_suite.customFunctionality.OrdersListAdapter;
import com.firebase.client.Firebase;

import java.util.ArrayList;

public class VendorDash extends AppCompatActivity {

    private Firebase firebaseRef;
    private Firebase ordersRef;
    private ListView listView;
    private OrdersListAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_dash);

        Firebase.setAndroidContext(this);

        firebaseRef = new Firebase("https://glowing-inferno-5513.firebaseio.com/Vendors");
        firebaseRef = firebaseRef.child(firebaseRef.getAuth().getUid());
        ordersRef = firebaseRef.child("Orders");

        listView = (ListView)findViewById(R.id.orders);



        populateOrderList();
        setClick();

    }

    private void populateOrderList()
    {
        arrayAdapter = new OrdersListAdapter(ordersRef.limit(500), this, R.layout.printed_order);
        listView.setAdapter(arrayAdapter);
    }

    private void showDialog(String title, String message, final int position, boolean error) {
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
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, null)
                    .setNegativeButton("Remove Order", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            removeOrder(position);
                        }
                    })
                    .show();
        }
    }

    private void removeOrder(int position)
    {
        Order toRemove = (Order) arrayAdapter.getItem(position);
        ordersRef.child(toRemove.getOrderName()).removeValue();
        populateOrderList();
    }

    private void setClick()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Order chosenOrder = (Order) arrayAdapter.getItem(position);
                showDialog(chosenOrder.getUserEmail(), chosenOrder.printOrder(), position, false);
            }
        });
    }
}
