package com.example.jcate478.seat_suite.suite.users;

/**
 * Created by jcate478 on 2/24/2016.
 */
public class food {

    String name;
    Double price;

    public food(String name, Double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }
    
    public Double getPrice()
    {
        return price;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }
}
