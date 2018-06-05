/**
 * Inventory Class
 * 
 * @author Mitchell Bryant 
 * @version 08/23/2017
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;




public class Inventory {
    private static ObservableList<Product> products = FXCollections.observableArrayList();
    private static  ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static Part selectedPart;
    private static Product selectedProduct;
    public static  ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    
    public Inventory (ObservableList<Product> products, ObservableList<Part> allParts)
    {
        this.products = products;
        this.allParts = allParts;
    }

    public static ObservableList<Product> getProducts() {
        return products;
    }
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }
    public static void addProduct(Product product) {
        products.add(product);
    }
    public boolean removeProduct(int productID)
    {
        products.remove(productID);
        return true;
    }
    public static Product lookupProduct(int productID)
    {
         for (Product p: products){
            if (productID == p.getProductID()){
                return p;    }    }
        return null;
    }
//    private void updateProduct(int productID)
//    {
//        this.productID = productID;
//    }
    public static void addPart(Part part)
    {
        allParts.add(part);
    }
    public boolean deletePart(Part part)
    {
         allParts.remove(part);
         return true;
    }
    public static Part lookupPart(int partID)
    {
        for (Part p: allParts){
            if (partID == p.getPartID()){
                return p;
            }
        }
        return null;
    }
//    private void updatePart(SimpleIntegerProperty partID)
//    {
//        this.partID = partID;
//    }
//    
      public static Part getSelectedPart() {
        return selectedPart;
    }

    public static void setSelectedPart(Part selectedPart) {
        Inventory.selectedPart = selectedPart;
    }
    public static Product getSelectedProduct() {
        return selectedProduct;
    }

    public static void setSelectedProduct(Product selectedProduct) {
        Inventory.selectedProduct = selectedProduct;
    }  
    
    
}
