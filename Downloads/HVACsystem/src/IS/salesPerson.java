/*
Authors: Moe yaziji, Grey Steinberg
DATE: 5/21/2018
PURPOSE: Although this class is not used in the program it is written in hopes of using it for 
later updates
*/
package IS;


public class salesPerson {
    public String spName;
    public String SalesPersonID;
    public String supplierID;
    public int salesPersonPhone;
    public String SalesPersonEmail;
    
    public static int personCount =0;
   

    public salesPerson(String spName, String SalesPersonID, String supplierID, int salesPersonPhone, String SalesPersonEmail) {
        this.spName = spName;
        this.SalesPersonID = "SalesPerson_" + personCount++ ;
        this.supplierID = supplierID;
        this.salesPersonPhone = salesPersonPhone;
        this.SalesPersonEmail = SalesPersonEmail;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public String getSalesPersonID() {
        return SalesPersonID;
    }

    public void setSalesPersonID(String SalesPersonID) {
        this.SalesPersonID = SalesPersonID;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public int getSalesPersonPhone() {
        return salesPersonPhone;
    }

    public void setSalesPersonPhone(int salesPersonPhone) {
        this.salesPersonPhone = salesPersonPhone;
    }

    public String getSalesPersonEmail() {
        return SalesPersonEmail;
    }

    public void setSalesPersonEmail(String SalesPersonEmail) {
        this.SalesPersonEmail = SalesPersonEmail;
    }

    public static int getPersonCount() {
        return personCount;
    }

    public static void setPersonCount(int personCount) {
        salesPerson.personCount = personCount;
    }
    
    
    
    
    
}
