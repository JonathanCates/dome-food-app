package com.example.jcate478.seat_suite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jcate478.seat_suite.customFunctionality.FoodListAdapter;
import com.example.jcate478.seat_suite.vendorInfo.Food;

import java.util.ArrayList;

public class FoodList extends AppCompatActivity {

    private ArrayList<Food> itemTypes;
    private ListView listViewOfItemTypes;
    private ArrayAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        listViewOfItemTypes = (ListView)findViewById(R.id.food_list);

        itemTypes = new ArrayList<>();
        populateItemTypes();

        clickAction();

    }

    private void populateItemTypes()
    {
        itemTypes.add(new Food("Beer", Food.BEER_TYPE));
        itemTypes.add(new Food("Burgers", Food.BURGER_TYPE));
        itemTypes.add(new Food("Chicken Fingers", Food.CHICKEN_FINGERS_TYPE));
        itemTypes.add(new Food("Churro", Food.CHURRO_TYPE));
        itemTypes.add(new Food("Snacks", Food.SNACKS_TYPE));
        itemTypes.add(new Food("Hot Dog", Food.HOT_DOG_TYPE));


        listAdapter = new FoodListAdapter(FoodList.this, R.layout.child_lineview, itemTypes);
        listViewOfItemTypes.setAdapter(listAdapter);

    }

    private void clickAction()
    {
        listViewOfItemTypes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent session = new Intent(getBaseContext(), VendorList.class);
                int foodType = itemTypes.get(position).getItemType();
                session.putExtra("foodtype", foodType);
                startActivity(session);
            }
        });
    }

}
