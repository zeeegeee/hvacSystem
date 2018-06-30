/*
Authors: Moe yaziji, Grey Steinberg
DATE: 5/21/2018
PURPOSE: This class stores all products in the program
*/
package IS;
import java.util.ArrayList;
public class product {
    public String customerid;
   
    public String productID;
    public String pricePaid;
    public String description;
    public String productName;
    public String supplierName;
    public static ArrayList<product> productList = new ArrayList<>();
    public static int prodCount;

    public product(String productID,String pricePaid, String description, String productName, String supplierName) {
        this.productID = productID;
        this.pricePaid = pricePaid;
        this.description = description;
        this.productName = productName;
        this.supplierName = supplierName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(String pricePaid) {
        this.pricePaid = pricePaid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public static int getProdCount() {
        return prodCount;
    }

    public static void setProdCount(int prodCount) {
        product.prodCount = prodCount;
    }
    
    
    
    
    
    
}
