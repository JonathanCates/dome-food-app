package com.example.jcate478.seat_suite.customFunctionality;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jcate478.seat_suite.R;
import com.example.jcate478.seat_suite.vendorInfo.food;

import java.util.ArrayList;

/**
 * Created by jcate478 on 3/2/2016.
 */
public class FoodListAdapter extends ArrayAdapter<food> {

    private ArrayList<food> foods;
    private Context context;
    private int layoutResourceId;

    public FoodListAdapter(Context context, int layoutResourceId, ArrayList<food> foods)
    {
        super(context, layoutResourceId, foods);
        this.foods = foods;
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
            viewHolder.text = (TextView) convertView
                    .findViewById(R.id.priceTag);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        food temp = foods.get(position);
        viewHolder.text.setText(temp.getName());

        return convertView;
    }

    public class ViewHolder {
        TextView text;
    }

}
