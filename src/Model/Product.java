/**
 * Product Class
 * 
 * @author Mitchell Bryant 
 * @version 08/23/2017
 */

package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;


public class Product{
    private  SimpleIntegerProperty productID = new SimpleIntegerProperty();
    private  SimpleStringProperty name = new SimpleStringProperty("");
    private  SimpleIntegerProperty inStock = new SimpleIntegerProperty();
    private  SimpleDoubleProperty price = new SimpleDoubleProperty();
    public  ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private SimpleIntegerProperty min = new SimpleIntegerProperty();
    private SimpleIntegerProperty max = new SimpleIntegerProperty();
    public static int productCount = 5;
    private static Part selectedPart;
//    private final SimpleIntegerProperty partID = Part.partID;
         
    public Product(int productID, String name, int inStock, double price)
    {
        this.productID = new SimpleIntegerProperty(0);
        this.name = new SimpleStringProperty("");
        this.inStock = new SimpleIntegerProperty(0);
        this.price = new SimpleDoubleProperty(0.00);
    }
    public Product(ObservableList<Part> associatedParts, int productID, String name, double price, int inStock, int min, int max )  
    {
        if (associatedParts!= null) {this.associatedParts = associatedParts;}
        this.productID = new SimpleIntegerProperty(productID);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.inStock = new SimpleIntegerProperty(inStock);
        this.min = new SimpleIntegerProperty(min);
        this.max = new SimpleIntegerProperty(max);
//        addAssociatedPart(associatedParts);
//        setProductID(productID);
//        setName(name);
//        setPrice(price);
//        setStock(inStock);
//        setMin(min);
//        setMax(max);
    };
                  
    public static Part getSelectedPart() {
        return selectedPart;
    }
    public static void setSelectedPart(Part selectedPart) {
        Product.selectedPart = selectedPart;
    }             
    public int getProductID()
    {
        return productID.get();
    }
        public IntegerProperty intProperty()
    {
        return productID;
    }
    public void setProductID(int productID)
    {
        this.productID = new SimpleIntegerProperty(productID);
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
        this.price = new SimpleDoubleProperty(price);
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
    public void addAssociatedPart(Part associatedPart)
    {
        associatedParts.add(associatedPart);
    }
    public  boolean removeAssociatedPart(int partID)
    {
        associatedParts.remove(partID);
        return true;
    }
    public Part lookupAssociatedPart(int partID)
    {
        for (Part p: associatedParts){
            if (partID == p.getPartID()){
                return p;
            }
        }
        return null;
    }
    public  ObservableList<Part> getAssociatedParts() {
        return associatedParts;
    }
    public void setAssociatedParts(ObservableList<Part> associatedParts){
        this.associatedParts = FXCollections.observableArrayList(associatedParts);
    }
    
    
}
