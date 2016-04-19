# Seat Suite

Android app designed to cut down on the amount of people in the concourse at stadiums, by letting people pre-order and pay for their food during the event so that during intermissions they can simply go and pick up their order. Orders will be validated by a generated key that the customer shows cashiers of the concessions to validate their order.

## Installation

Seat Suite was created using Android Studio. All needed APIs are included in the project, just pull and open using Android Studio and run using the programs built-in emulator

## Current State

Currently, Seat Suite can register users by using Firebase's email authentication. The first name, and last name fields are not fully incorporated for the users. 

Once logged in, the users can choose 3 ways to search for a vendor in our fake stadium

1. Food Type: Designed for users to pick what kind of food they want, and displays the vendors with that food (not sorted in any particular order)
2. Vendor: Lists all vendors in the systems in no order
3. Section Search: Enter the section they are seated in, and displays all vendors from closest to furtherest away.

Once a user chooses the vendor they want to purchase from, they are given a choice of all items that the vendor has. Tapping on an item adds that item to their cart. If a user is done with their order, they can click on "See Cart" to see their order, and remove items from their cart by tapping on them. Once the user is satisfied they can checkout (payment is not implemented), and the order is sent to a single vendor account which can display all of the orders once logged in to.

## Known Bugs

Section Search: Doesn't check for any inputs other than a number
                Not all sections that are in the arrays initiate the search (putting in some specific sections and selecting search will cause nothing to happen, no crash, but no continuation)
                
## Future Features

Unsure if any of us will get around to continuing development of Seat Suite, howeverthe following are features that would be ideal in the continuation of Seat Suite.

Required before deployment:

- [ ] More user information stored (name, phone number)
- [ ] On completion of order, vendor is able to send notification to user (and user can receive notication)
- [ ] Vendor can take in the correct key to confirm the order is picked up
- [ ] Vendors are sorted in a logical order for each search (distance, or otherwise)
- [ ] Tracking previous user orders (to a certain date)

Wanted:
- [ ] Estimate on wait time for vendors
- [ ] Point system for users. Users that are quick to pick up orders will receive points that can be exchanged for themed goods (would have to be negotiated with each stadium, and designed fully)
- [ ] Customization for application on both vendor and user side

## Frequently Asked Questions 
From April 13, 2016 Showcase

**How will payment be processed?**

  We would like to use Stripe as our main option of payment. It seems to be the quickest and most secure option for us to use currently. Ideally we would like to offer more than one option of payment as well, however this detail will have to be more fully fleshed out if the app takes off as a business.
  
**Will delivery be an option?**

  This would have to be discussed more with each stadium, however we will pitch the app as not having delivery as an option. Already many people are employed to walk up and down the aisles with various snacks and beer to sell, so delivery could be viable. However, many stadiums have VIP seating where one of the main selling points are that their orders are delivered to them. By offering delivery it could be perceived that we are trying to undercut the sale of the VIP seats, and thus become an overall loss for stadiums. If stadiums are interested in offering delivery as an option then we will discuss logistics, but for now Seat Suite is a pick up only service.
  



Seat Suite is created by team Javahaus, Jonathan Cates, Nicole Waldern, and Petar Lazinica as a term long project for Mount Royal University's Programming IV (COMP 3504) course taught by Jordan Kidney.
