/**
 * Part Class
 * 
 * @author Mitchell Bryant 
 * @version 07/20/2017
 */


package Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;




public abstract class Part {
    public static int partCount = 5;
    private  SimpleIntegerProperty partID = new SimpleIntegerProperty();
    private  SimpleStringProperty name = new SimpleStringProperty("");
    private  SimpleIntegerProperty inStock = new SimpleIntegerProperty();
    private  SimpleDoubleProperty price = new SimpleDoubleProperty();
    private  SimpleIntegerProperty min = new SimpleIntegerProperty();
    private  SimpleIntegerProperty max = new SimpleIntegerProperty();

    public Part(){
        this(0,"", 0, 0.00);
    }
    public Part(int partID, String name, int inStock, double price  )  
    {
        this.partID = new SimpleIntegerProperty(partID);
        this.name = new SimpleStringProperty(name);
        this.inStock = new SimpleIntegerProperty(inStock);
        this.price = new SimpleDoubleProperty(price);
    }
    
    public Part(int partID, String name, int inStock, double price, int min, int max )  
    { 
        this.partID = new SimpleIntegerProperty(partID);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.inStock = new SimpleIntegerProperty(inStock);
        this.min = new SimpleIntegerProperty(min);
        this.max = new SimpleIntegerProperty(max);
        
    }

    public int getPartID()
    {
        return partID.get();
    }
    public IntegerProperty intProperty()
    {
        return partID;
    }
    public void setPartID(int partID)
    {
        this.partID = new SimpleIntegerProperty(partID);
    }
    public String getName()
    {
        return name.get();
    }
    public StringProperty nameProperty()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = new SimpleStringProperty(name);
    }
    public double getPrice()
    {
        return price.get();
    }
    public DoubleProperty priceProperty()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price= new SimpleDoubleProperty(price);
    }
    public int getStock()
    {
        return inStock.get();
    }
    public IntegerProperty stockProperty()
    {
        return inStock;
    }
    public void setStock(int inStock)
    {
        this.inStock = new SimpleIntegerProperty(inStock);
    }
    public int getMin()
    {
        return min.get();
    }
    public void setMin(int min)
    {
        this.min = new SimpleIntegerProperty(min);
    }
    public int getMax()
    {
        return max.get();
    }
    public void setMax(int max)
    {
        this.max = new SimpleIntegerProperty(max);
    }

    
}
