/*
Authors: Moe yaziji, Grey Steinberg
DATE: 5/21/2018
PURPOSE: this is the class program for service requests, it creates instance objects 
of each service request 
*/
package IS;

import java.util.LinkedList;


public class serviceRequest {
    public String serviceID;
    public int PhoneNumber;
    public boolean completed;
    public String technicanID;
    
    LinkedList <serviceRequest> newList = new LinkedList<serviceRequest>(); 
    
    public serviceRequest(String serviceID, int PhoneNumber, boolean completed, String technicanID) 
    {
        this.serviceID = serviceID;
        this.PhoneNumber = PhoneNumber;
        this.completed = completed;
        this.technicanID = technicanID;
    }
    
    public void addToList(serviceRequest newRequest)
    {
        newList.add(newRequest);
    }
    

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getTechnicanID() {
        return technicanID;
    }

    public void setTechnicanID(String technicanID) {
        this.technicanID = technicanID;
    }
    
    
    
    
    
    
    
    
}
