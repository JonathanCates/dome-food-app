package com.example.jcate478.seat_suite.vendorInfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jcate478 on 2/24/2016.
 */
public class Vendor implements Parcelable{

    private String vendorName;
    private ArrayList<Food> foodItems;
    private int closestSection;
    private ArrayList<Integer> vendorFoodTypes;

    public Vendor(String vendorName, int closestSection)
    {
        this.vendorName = vendorName;
        this.closestSection = closestSection;
        foodItems = new ArrayList<>();
        vendorFoodTypes = new ArrayList<>();
    }

    public String getVendorName()
    {
        return vendorName;
    }

    public int getClosestSection() {return closestSection;}

    public ArrayList<Food> getFoodItems()
    {
        return foodItems;
    }

    public ArrayList<Integer> getVendorFoodTypes() {return vendorFoodTypes;}

    public void addFood(String name, int itemType, double price)
    {
        foodItems.add(new Food(name, itemType, price));
        vendorFoodTypes.add(itemType);
    }

    public void setVendorName(String newName)
    {
        vendorName = newName;
    }

    public static final Parcelable.Creator<Vendor> CREATOR
            = new Parcelable.Creator<Vendor>() {
        public Vendor createFromParcel(Parcel in) {
            return new Vendor(in);
        }

        public Vendor[] newArray(int size) {
            return new Vendor[size];
        }
    };

    private Vendor(Parcel in) {
        vendorName = in.readString();
        closestSection = in.readInt();
        foodItems = new ArrayList<>();
        in.readTypedList(foodItems, Food.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    /**
     * writes to parcel to be passed between activities
     * Intentional does not pass in the vendorFoodTypes Arraylist as this will only be invoked once this vendor is chosen, and that is not needed at that point anymore in the flow
     */
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(vendorName);
        out.writeInt(closestSection);
        out.writeTypedList(foodItems);
    }
}
