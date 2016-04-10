package com.example.jcate478.seat_suite.customFunctionality;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jcate478.seat_suite.R;
import com.example.jcate478.seat_suite.vendorInfo.Food;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by jcate478 on 3/2/2016.
 */
public class FoodListAdapter extends ArrayAdapter<Food> {

    private ArrayList<Food> foods;
    private Context context;
    private int layoutResourceId;
    private DecimalFormat df;


    public FoodListAdapter(Context context, int layoutResourceId, ArrayList<Food> foods)
    {
        super(context, layoutResourceId, foods);
        this.foods = foods;
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        df = new DecimalFormat("#.00");
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(layoutResourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.item = (TextView) convertView.findViewById(R.id.childTextView);
            viewHolder.price = (TextView) convertView.findViewById(R.id.priceTag);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Food temp = foods.get(position);
        viewHolder.item.setText(temp.getName());
        viewHolder.price.setText(df.format(temp.getPrice()));

        return convertView;
    }

    public class ViewHolder {
        TextView item;
        TextView price;
    }

}
