package com.example.jcate478.seat_suite.customFunctionality;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Button;

import com.example.jcate478.seat_suite.R;
import com.example.jcate478.seat_suite.vendorInfo.vendor;

import java.util.ArrayList;

/**
 * Created by jcate478 on 3/2/2016.
 */
public class ListAdapter extends ArrayAdapter<vendor> {

    private ArrayList<vendor> vendors;
    private Context context;
    private customButtonListener buttonListener;

    public ListAdapter(Context context, ArrayList<vendor> vendors)
    {
        super(context, R.layout.child_lineview, vendors);
        this.vendors= vendors;
        this.context = context;
    }

    public interface customButtonListener
    {
        public void onButtonClick(int position, String value);
    }

    public void setCustomButtonListener(customButtonListener buttonListener)
    {
        this.buttonListener = buttonListener;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.child_lineview, null);
            viewHolder = new ViewHolder();
            viewHolder.text = (TextView) convertView
                    .findViewById(R.id.childTextView);
            viewHolder.button = (Button) convertView
                    .findViewById(R.id.childButton);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final String temp = getItem(position);
        viewHolder.text.setText(temp);
        viewHolder.button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (buttonListener != null) {
                    buttonListener.onButtonClickListener(position,temp);
                }

            }
        });

        return convertView;
    }

    public class ViewHolder {
        TextView text;
        Button button;
    }

}
