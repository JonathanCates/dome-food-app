package com.example.jcate478.seat_suite.vendorInfo;

/**
 * Created by Jonathan on 3/28/2016.
 */
public class User
{
    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email)
    {
        firstName = this.firstName;
        lastName = this.lastName;
        email = this.email;
    }

    public String getFirstName()
    {return firstName;}

    public String getLastName()
    {return lastName;}

    public String getEmail()
    {return email;}

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
}
