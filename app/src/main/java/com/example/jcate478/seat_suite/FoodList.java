package com.example.jcate478.seat_suite;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class FoodList extends AppCompatActivity {

    private ArrayList<String> itemTypes;
    private ListView listViewOfItemTypes;
    private ArrayAdapter<itemTypes> itemTypesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        listViewOfItemTypes = (ListView)findViewById(R.id.item_type);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        itemTypes = new ArrayList<>();
        populateItemTypes();

    }

    private void populateItemTypes()
    {
        itemTypes.add(new itemType("Beer");
        itemTypes.add(new itemType("Burgers");
        itemTypes.add(new itemType("Hot Dogs");
        itemTypes.add(new itemType("Churro");
        itemTypes.add(new itemType("Chicken");
        itemTypes.add(new itemType("Other"));

        listViewOfItemTypes.setAdapter(itemTypesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //TODO Function to get all food with that Item Type

                startActivity(session);
            }
        });
    }

}
