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

    /*@Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(layoutResourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.text = (TextView) convertView
                    .findViewById(R.id.childTextView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Order temp = orders.get(position);
        viewHolder.text.setText(temp.getOrderName());

        return convertView;
    }*/

    @Override
    protected void populateView(View v, Order newOrder)
    {
        String name = newOrder.getOrderName();
        TextView orderNameText = (TextView) v.findViewById(R.id.orderName);
        orderNameText.setText(name);
    }

    /*(public class ViewHolder {
        TextView text;
    }*/

}
