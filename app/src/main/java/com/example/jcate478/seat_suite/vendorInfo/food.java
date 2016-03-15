package com.example.jcate478.seat_suite.vendorInfo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jcate478 on 2/24/2016.
 */
public class food implements Parcelable{

    private String name;
    private int itemType;
    private Double price;


    public food(String name, int itemType, Double price)
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

    public void setitemType(int itemType) { this.itemType = itemType}

    public void setPrice(Double price)
    {
        this.price = price;
    }

   public static final Parcelable.Creator<food> CREATOR
            = new Parcelable.Creator<food>() {
        public food createFromParcel(Parcel in) {
            return new food(in);
        }

        public food[] newArray(int size) {
            return new food[size];
        }
    };

    private food(Parcel in) {
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
