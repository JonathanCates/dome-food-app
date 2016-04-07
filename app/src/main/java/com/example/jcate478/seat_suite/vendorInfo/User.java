package com.example.jcate478.seat_suite.vendorInfo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jonathan on 3/28/2016.
 */
public class User implements Parcelable
{
    private String firstName;
    private String lastName;
    private String email;
    private String uid;

    public User(String firstName, String lastName, String email, String uid)
    {
        firstName = this.firstName;
        lastName = this.lastName;
        email = this.email;
        uid = this.uid;
    }

    public String getFirstName()
    {return firstName;}

    public String getLastName()
    {return lastName;}

    public String getEmail()
    {return email;}

    public String getUid()
    {return uid;}

    public void setFirstName(String firstName)
    {
        firstName = this.firstName;
    }

    public void setLastName(String lastName)
    {
        lastName = this.lastName;
    }

    public void setEmail(String email)
    {
        email = this.email;
    }

    public void setUid(String uid) {uid = this.uid;}

    private User(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        email = in.readString();
        uid = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(email);
        dest.writeString(uid);
    }
}
