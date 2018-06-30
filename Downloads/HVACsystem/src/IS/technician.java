/*
Authors: Moe yaziji, Grey Steinberg
DATE: 5/21/2018
PURPOSE: this is the class program for technician, it has an array list of technician and creates instance objects
of them. 
*/
package IS;
import java.util.ArrayList;

public class technician {
    private String technicianID;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    
    public static ArrayList<technician> technicianList = new ArrayList<>();
    public static int techCount;

    public technician(String technianID, String firstName, String lastName, String phoneNumber) {
        this.technicianID =technianID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(String technicianID) {
        this.technicianID = technicianID;
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

    public static int getTechCount() {
        return techCount;
    }

    public static void setTechCount(int techCount) {
        technician.techCount = techCount;
    }
    
    


    
    
    
}
