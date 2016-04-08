package com.example.jcate478.seat_suite.customFunctionality;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jcate478.seat_suite.R;
import com.example.jcate478.seat_suite.vendorInfo.Order;
import com.firebase.client.DataSnapshot;

import java.util.ArrayList;

/**
 * Created by Jonathan on 08/04/2016.
 */
public class OrdersListAdapter extends ArrayAdapter<Order>{

    private ArrayList<Order> orders;
    private Context context;
    private int layoutResourceId;

    public OrdersListAdapter(Context context, int layoutResourceId, ArrayList<Order> orders)
    {
        super(context, layoutResourceId, orders);
        this.orders = orders;
        this.context = context;
        this.layoutResourceId = layoutResourceId;
    }

    @Override
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
    }

    public class ViewHolder {
        TextView text;
    }

}
