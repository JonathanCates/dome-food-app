package com.example.jcate478.seat_suite.vendorInfo;

import java.util.ArrayList;

/**
 * Created by jcate478 on 2/24/2016.
 */
public class vendor {

    private String vendorName;
    private ArrayList<food> foodItems;
    private int closestSection;

    public vendor(String vendorName, int closestSection)
    {
        this.vendorName = vendorName;
        this.closestSection = closestSection;
        foodItems = new ArrayList<>();
    }

    public String getVendorName()
    {
        return vendorName;
    }

    public int getClosestSection() {return closestSection;}

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

    public String toString()
    {
        String listIt;

        listIt = "Vendor name is: " + vendorName + "\n\n";

        for (int i = 0; i < foodItems.size(); i++)
        {
            listIt += foodItems.get(i).getName() + "\n" + foodItems.get(i).getPrice() + "\n\n";
        }

        return listIt;
    }

}
