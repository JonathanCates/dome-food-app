package com.example.jcate478.seat_suite.vendorInfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by jcate478 on 2/24/2016.
 */
public class vendor implements Parcelable{

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

    public static final Parcelable.Creator<vendor> CREATOR
            = new Parcelable.Creator<vendor>() {
        public vendor createFromParcel(Parcel in) {
            return new vendor(in);
        }

        public vendor[] newArray(int size) {
            return new vendor[size];
        }
    };

    private vendor(Parcel in) {
        vendorName = in.readString();
        closestSection = in.readInt();
        foodItems = new ArrayList<>();
        in.readTypedList(foodItems, food.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(vendorName);
        out.writeInt(closestSection);
        out.writeTypedList(foodItems);
    }
}
