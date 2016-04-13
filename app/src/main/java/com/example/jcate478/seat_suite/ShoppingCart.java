package com.example.jcate478.seat_suite;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jcate478.seat_suite.customFunctionality.FoodListAdapter;
import com.example.jcate478.seat_suite.vendorInfo.Food;
import com.example.jcate478.seat_suite.vendorInfo.Order;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart extends AppCompatActivity {


    private ArrayList<Food> foodCart;
    private ListView listView;
    private FoodListAdapter arrayAdapter;
    private double price;
    private TextView preGst;
    private TextView gst;
    private TextView totalCost;
    private DecimalFormat df;
    private String vendorName; //will find by vendor id in the end, name is passed for now
    private String testVendorID; // links to table that seat.suite@gmail.com accesses

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        Firebase.setAndroidContext(this);

        Intent i = getIntent();
        foodCart = i.getParcelableArrayListExtra("cart");
        listView = (ListView)findViewById(R.id.shopping_cart);
        vendorName = i.getStringExtra("vendorName");
        testVendorID = "1e54ba52-baa1-4609-bd24-e752c0bc337d";

        df = new DecimalFormat("#.00");

        preGst = (TextView) findViewById(R.id.preTaxCost);
        gst = (TextView) findViewById(R.id.gst);
        totalCost = (TextView) findViewById(R.id.finalCost);

        listShoppingCart();
        calculateCost();
        buttons();
    }

    private void listShoppingCart()
    {
        arrayAdapter = new FoodListAdapter(ShoppingCart.this, R.layout.food_layout, foodCart);
        listView.setAdapter(arrayAdapter);
    }

    private void calculateCost()
    {
        price = 0;
        for (int i = 0; i < foodCart.size(); i++)
        {
            price += foodCart.get(i).getPrice();
        }

        preGst.setText("Before Tax: $" + df.format(price));
        gst.setText("Tax: $" + df.format(price * 0.05)); // Canadian GST is 5%, Alberta has no PST so not added in hardcode, will change if expanded outside AB
        totalCost.setText("Total: $" + df.format(price * 1.05));
    }

    private void buttons()
    {
        Button checkout = (Button) findViewById(R.id.checkout);

        checkout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(hasItemsInCart()) {
                            Firebase vendorRef = new Firebase("https://glowing-inferno-5513.firebaseio.com/Vendors").child(testVendorID);

                            String userID = vendorRef.getAuth().getUid();
                            String userEmail = (String) vendorRef.getAuth().getProviderData().get("email");
                            String orderName = userID + "'s order";

                            Order newOrder = new Order(foodCart, orderName, userID, userEmail, vendorName);

                            vendorRef.child("Orders").child(orderName).setValue(newOrder, new Firebase.CompletionListener() {
                                @Override
                                public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                                    if (firebaseError != null) {
                                        showDialog("Data could not be saved. " + firebaseError.getMessage(), true);
                                    } else {
                                        showDialog("Order sent to chosen vendor.", false);
                                    }
                                }
                            });
                        }
                        else
                        {
                            showDialog("Cart has nothing in it!", true);
                        }
                    }
                });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                foodCart.remove(position);
                listShoppingCart();
                calculateCost();
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
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent session = new Intent(getBaseContext(), Checkout.class);
                            session.putExtra("cost", price);
                            startActivity(session);
                        }
                    })
                    .show();
        }
    }
    private boolean hasItemsInCart() {
        boolean cartHas;
        if(foodCart.size() != 0) {
            cartHas = true;
        }
        else
        {
            cartHas = false;
        }
        return cartHas;
    }
}
