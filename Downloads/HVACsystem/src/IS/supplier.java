
/*
Authors: Moe yaziji, Grey Steinberg
DATE: 5/21/2018
PURPOSE: this is the class program for supplier, it has an array list of suppliers and creates instance objects of them 
with constructor call
*/
package IS;

import java.util.ArrayList;

public class supplier {
    private String supplierID;
    public String supplierName;
    public String phoneNum;
            
    public String address;
    public String city;
    public String state;
    public String zipCode;
    
    public static ArrayList<supplier> supplierList = new ArrayList<>();
    public static int supCount;

    public supplier(String supplierID, String supplierName, String address, String city, String state, String zipCode,String phoneNum) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNum= phoneNum;
    }
    
    public void addSupplier(supplier newSupplier)
    {
        supplierList.add(newSupplier);
    }
    
    public void removeSupplier(supplier newSupplier)
    {
        supplierList.remove(newSupplier);
    }
    
    public String getSupplierID()
    {
        return supplierID;
    }
    
    public void setSupplierID(String supplierID)
    {
        this.supplierID = supplierID;
    }
    
    public String getSupplierName()
    {
        return supplierName;
    }
    
    public void setSupplierName(String supplierName)
    {
        this.supplierName = supplierName;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public String getState()
    {
        return state;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public String getZipCode()
    {
        return zipCode;
    }
    
    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }
    
    public static ArrayList<supplier> getSupplierList()
    {
        return supplierList;
    }
    
    public static void setSupplierList(ArrayList<supplier> supplierList)
    {
        supplier.supplierList = supplierList;
    }
    
    public static int getSupCount()
    {
        return supCount;
    }
    
    public static void setSupCount(int supCount)
    {
        supplier.supCount = supCount;
    }
    
    @Override
    public String toString()
    {
        return "ID: " + this.getSupplierID() + " Supplier Name: " + this.supplierName;
    }
    
}
