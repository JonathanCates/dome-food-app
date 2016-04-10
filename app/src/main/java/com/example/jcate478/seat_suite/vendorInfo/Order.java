package com.example.jcate478.seat_suite.vendorInfo;

import java.util.ArrayList;

/**
 * Created by Jonathan on 08/04/2016.
 */
public class Order {

    private String orderName;
    private ArrayList<Food> order;

    public Order()
    {}

    public Order(ArrayList<Food> order, String orderName)
    {
        this.order = order;
        this.orderName = orderName;
    }

    public String getOrderName()
    {
        return orderName;
    }

    public ArrayList<Food> getOrder()
    {
        return order;
    }

    public String printOrder()
    {
        String print = "";

        for(int i = 0; i < order.size(); i++)
        {
            print += order.get(i).getName() + "\n";
        }

        return print;
    }
}
