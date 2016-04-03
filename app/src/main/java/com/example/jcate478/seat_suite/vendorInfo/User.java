package com.example.jcate478.seat_suite.vendorInfo;

/**
 * Created by Jonathan on 3/28/2016.
 */
public class User
{
    private String firstName;
    private String lastName;
    private String email;
    private String uid;
    private final String provider = "password";

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

    public String toString()
    {
        return "First name is: " + firstName + " Last Name is: " + lastName + " email is: " + email + " uID is: " + uid;
    }
}
