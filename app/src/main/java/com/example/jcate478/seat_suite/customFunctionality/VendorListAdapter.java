package com.example.jcate478.seat_suite.customFunctionality;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Button;

import com.example.jcate478.seat_suite.R;
import com.example.jcate478.seat_suite.vendorInfo.vendor;

import java.util.ArrayList;

/**
 * Created by jcate478 on 3/2/2016.
 */
public class VendorListAdapter extends ArrayAdapter<vendor> {

    private ArrayList<vendor> vendors;
    private Context context;
    private int layoutResourceId;

    public VendorListAdapter(Context context, int layoutResourceId, ArrayList<vendor> vendors)
    {
        super(context, layoutResourceId, vendors);
        this.vendors= vendors;
        this.context = context;
        this.layoutResourceId = layoutResourceId;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.child_lineview, null);
            viewHolder = new ViewHolder();
            viewHolder.text = (TextView) convertView
                    .findViewById(R.id.childTextView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        vendor temp = vendors.get(position);
        viewHolder.text.setText(temp.getVendorName());

        return convertView;
    }

    public class ViewHolder {
        TextView text;
    }

}
