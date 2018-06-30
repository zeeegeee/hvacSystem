/*
Author: Moe 
Purpose: This class is designed to create customer instance objects everytime it is called
         This class has different attributes which are added, deleted, or edited based on 
         client request. 
Date: 5/13/2018
*/
package IS;

import java.util.ArrayList;

public class customer {
    private String customerID;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String address;
    public String city;
    public String state;
    public String zipCode;
    
    public static ArrayList <customer> customerList = new ArrayList<customer>();
    public static int custCount=1;
    
    public customer(String uniqueId, String firstName, String lastName, String phoneNumber, String address, String city, String state, String zipCode) {
        this.customerID = uniqueId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    public void addCustomer(customer newCustomer)
    {
        customerList.add(newCustomer);
    }

    public void removeCustomer(customer newCustomer)
    {
        customerList.remove(newCustomer);
    }
    
    
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public static ArrayList<customer> getCustomerList() {
        return customerList;
    }

    public static void setCustomerList(ArrayList<customer> customerList) {
        customer.customerList = customerList;
    }

    public static int getCustCount() {
        return custCount;
    }

    public static void setCustCount(int custCount) {
        customer.custCount = custCount;
    }
    
    @Override 
    public String toString()
    {
        return "ID: " + this.getCustomerID() + " Name: "+ this.firstName + " " + this.lastName+
                "\nAddress " + this.address + ", "+ this.city + "," + this.state +"\n"
                        + this.zipCode +"\nPhone Number"+ this.phoneNumber;
    }
    
    
  
    
}
