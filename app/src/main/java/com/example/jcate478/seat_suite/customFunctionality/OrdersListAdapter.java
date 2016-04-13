package com.example.jcate478.seat_suite.customFunctionality;

import android.content.Context;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.jcate478.seat_suite.R;
import com.example.jcate478.seat_suite.vendorInfo.Order;
import com.firebase.client.Query;

/**
 * Created by Jonathan on 08/04/2016.
 */
public class OrdersListAdapter extends FirebaseListAdapter<Order>{


    public OrdersListAdapter(Query ref, Activity activity, int layoutResourceId)
    {
        super(ref, Order.class, layoutResourceId, activity);
    }


    @Override
    protected void populateView(View v, Order newOrder)
    {
        String name = newOrder.getOrderName();
        TextView orderNameText = (TextView) v.findViewById(R.id.orderName);
        orderNameText.setText(name);
    }
}
