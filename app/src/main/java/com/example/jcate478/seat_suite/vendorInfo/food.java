package com.example.jcate478.seat_suite.vendorInfo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jcate478 on 2/24/2016.
 */
public class Food implements Parcelable{

    private String name;
    private int itemType;
    private Double price;

    public static int BURGER_TYPE = 0;
    public static int HOT_DOG_TYPE = 1;
    public static int SOFT_DRINK_TYPE = 2;
    public static int POPCORN_TYPE = 3;
    public static int CHURRO_TYPE = 4;
    public static int CHICKEN_FINGERS_TYPE = 5;
    public static int SNACKS_TYPE = 6;
    public static int BEER_TYPE = 7;
    public static int DEFAULT_TYPE = -1; // main placeholder to indicate that the foodlist was not the initial choice for a customer

    /**
     * empty constructor for Firebase
     */
    public Food()
    {}

    /**
     * constructor specifically made to make a list of generic food types (burgers, popcorn etc) for the class FoodList
     * @param name name of food type
     * @param itemType int related to food type
     */
    public Food(String name, int itemType)
    {
        this.name = name;
        this.itemType = itemType;
    }

    /**
     * Constructor that is called for normal food items
     * @param name name of the food item
     * @param itemType int related to food type
     * @param price price of item
     */
    public Food(String name, int itemType, Double price)
    {
        this.name = name;
        this.itemType = itemType;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public int getItemType() { return itemType;}

    public Double getPrice()
    {
        return price;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setitemType(int itemType) { this.itemType = itemType;}

    public void setPrice(Double price)
    {
        this.price = price;
    }

   public static final Parcelable.Creator<Food> CREATOR
            = new Parcelable.Creator<Food>() {
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    private Food(Parcel in) {
        name = in.readString();
        itemType = in.readInt();
        price = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeInt(itemType);
        out.writeDouble(price);
    }
}
