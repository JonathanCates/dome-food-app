package com.example.jcate478.seat_suite.vendorInfo;

import java.util.ArrayList;

/**
 * Created by Jonathan on 08/04/2016.
 */
public class Order {

    private String orderName;
    private ArrayList<Food> order;
    private String uID;
    private String userEmail;
    private String vendorName;

    public Order()
    {}

    public Order(ArrayList<Food> order, String orderName, String uID, String userEmail, String vendorName)
    {
        this.order = order;
        this.orderName = orderName;
        this.uID = uID;
        this.userEmail = userEmail;
        this.vendorName = vendorName;
    }

    public String getOrderName()
    {
        return orderName;
    }

    public ArrayList<Food> getOrder()
    {
        return order;
    }

    public String getuID()
    {
        return uID;
    }

    public String getUserEmail()
    {
        return userEmail;
    }

    public String getVendorName()
    {
        return vendorName;
    }

    public String printOrder()
    {
        String print = "From: " + vendorName + "\n";

        for(int i = 0; i < order.size(); i++)
        {
            print += order.get(i).getName() + "\n";
        }

        return print;
    }
}
