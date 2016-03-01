package com.example.jcate478.seat_suite.suite.users;

import java.util.ArrayList;

/**
 * Created by jcate478 on 2/24/2016.
 */
public class vendor {

    String vendorName;
    ArrayList<food> foodItems;

    public vendor(String vendorName)
    {
        this.vendorName = vendorName;
    }

    public String getVendorName()
    {
        return vendorName;
    }

    public ArrayList<food> getFoodItems()
    {
        return foodItems;
    }

    public void addFood(String name, double price)
    {
        foodItems.add(new food(name, price));
    }

    public void setVendorName(String newName)
    {
        vendorName = newName;
    }

}
