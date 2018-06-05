/**
 * InHousePart Class
 * 
 * @author Mitchell Bryant 
 * @version 08/23/2017
 */
package Model;

import javafx.beans.property.SimpleIntegerProperty;

public class InHousePart extends Part {

    public SimpleIntegerProperty machineID = new SimpleIntegerProperty();
 
    
    public InHousePart(int partID, String name, int inStock, double price, int min, int max, int machineID )  
    {
       super(partID, name, inStock, price, min, max);
       this.machineID = new SimpleIntegerProperty(machineID);
      

    }
    
    public void setMachineID(int machineID)
    {
        this.machineID = new SimpleIntegerProperty(machineID);
    }
    public int getMachineID()
    {
        return machineID.get();
    }
}
