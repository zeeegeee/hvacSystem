/*
Authors: Moe yaziji, Grey Steinberg
DATE: 5/21/2018
PURPOSE: This class stores all transactions occuring in the program
*/
package IS;

import java.util.ArrayList;

public class sale {
    public String productID;
    public String customerID;
    public String supplierID;
    public String description;
    
    public double productPrice;
    public String productName;
    public static ArrayList<sale> salelist = new ArrayList<sale>();

    public sale(String productID, String customerID, String supplierID, double productPrice, String description) {
        this.productID = productID;
        this.customerID = customerID;
        this.supplierID = supplierID;
        this.productPrice = productPrice;
        this.description= description;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public ArrayList<sale> getSalelist() {
        return salelist;
    }

    public void setSalelist(ArrayList<sale> salelist) {
        this.salelist = salelist;
    }

 
    
    
    
    
    
}
