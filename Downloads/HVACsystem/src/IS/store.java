/*
Authors: Moe yaziji, Grey Steinberg
DATE: 5/21/2018
PURPOSE: this is the class program for store, it has an array list of stores and creates instance objects
*/
package IS;

import java.util.ArrayList;
public class store {
    public String storeID;
    public String storeName;
    public String zipcode;
    public String serviceID;
    
    public static int storeCount;
    public static ArrayList<store> storeList = new ArrayList<>();
    
    public store(String storeID, String storeName, String zipcode)
    {
        this.storeID = storeID;
        this.storeName = storeName;
        this.zipcode = zipcode;
        this.serviceID = serviceID;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public static int getStoreCount() {
        return storeCount;
    }

    public static void setStoreCount(int storeCount) {
        store.storeCount = storeCount;
    }

    public ArrayList<store> getStoreList() {
        return storeList;
    }

    public void setStoreList(ArrayList<store> storeList) {
        this.storeList = storeList;
    }
    
    
    
}

