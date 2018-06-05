/**
 * OutsourcedPart Class
 * 
 * @author Mitchell Bryant 
 * @version 08/23/2017
 */
package Model;

import javafx.beans.property.SimpleStringProperty;

public class OutsourcedPart extends Part {

    public SimpleStringProperty companyName = new SimpleStringProperty("");
    
    
    public OutsourcedPart(int partID, String name, int inStock, double price, int min, int max, String companyName )  
    {
       super(partID, name, inStock, price, min, max);
       this.companyName = new SimpleStringProperty(companyName);
       
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = new SimpleStringProperty(companyName);
    }
    public String getCompanyName()
    {
        return companyName.get();
    }
}
    

