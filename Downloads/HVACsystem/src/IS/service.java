/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IS;

import java.util.*;

public class service extends customer{
    public String firstName;
    public String lastName;
    public String customerID;
    public String serviceID;
    public String description;
    public String completed;
    public Date dateSubmited;
    
    
    
    
    public static ArrayList <service> serviceList = new ArrayList<service>();
    public static int serviceCount =1;
    public service(String customerID, String description, Date dateSubmited, String completed
    ,String firstName, String lastName, String phoneNumber,String address,String city,String state, String zipcode ) {
        super(customerID, firstName, lastName, phoneNumber, address, city, state , zipcode );
        this.serviceID ="Service_"+ serviceCount++;
        this.customerID = customerID;
        this.description = description;
        this.dateSubmited = dateSubmited;
        this.completed= completed;
    }
     public void addService(service newService)
    {
        serviceList.add(newService);
    }

    public void removeService(service newService)
    {
        serviceList.remove(newService);
    }

    public ArrayList<service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(ArrayList<service> serviceList) {
        this.serviceList = serviceList;
    }
    

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getDateSubmited() {
        return dateSubmited;
    }

    public void setDateSubmited(Date dateSubmited) {
        this.dateSubmited = dateSubmited;
    }
    
    
    
    
    
}
