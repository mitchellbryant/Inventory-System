
package View_Controller;

import Model.InHousePart;
import Model.Inventory;
import Model.OutsourcedPart;
import Model.Part;
import static Model.Part.*;
import static Model.Product.*;
import Model.Product;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Mitch
 */
public class MainScreenController implements Initializable {
    
    
    public static ObservableList<Part> partData = FXCollections.observableArrayList();
    public static ObservableList<Product> productData = FXCollections.observableArrayList();
    public static ObservableList<Part> oldParts;
    public Stage partStage = new Stage();
    public Stage partStageOutsourced = new Stage();
    public Stage productStage = new Stage();
    public Button closeButton;
    public Button cancelButton;
    public Button saveButton;
    private boolean okClicked = false;
    public ArrayList<Part> productParts = new ArrayList();
    private InHousePart part = new InHousePart(0,"", 0, 0.00, 0, 0, 0);
    private OutsourcedPart outsourcedPart = new OutsourcedPart(0,"",0,0.00,0,0,"");
    private Product product = new Product(null, 0, "", 0.00, 0, 0, 0);

    final ToggleGroup group = new ToggleGroup();
    @FXML
    private final RadioButton rb1 = new RadioButton("In House");
    @FXML
    private final RadioButton rb2 = new RadioButton("Outsourced");

    @FXML
    private  TableView<Part> partTable = new TableView();
    @FXML
    private  TableColumn<Part, Integer> part_ID = new TableColumn();
    @FXML
    private  TableColumn<Part, String> part_name = new TableColumn();
    @FXML
    private  TableColumn<Part, Integer> part_inv_lvl = new TableColumn();
    @FXML
    private  TableColumn<Part, Double> part_price = new TableColumn();
    @FXML
    private TableView<Product> productTable = new TableView();
    @FXML
    private  TableColumn<Product, Integer> product_ID = new TableColumn();
    @FXML
    private  TableColumn<Product, String> product_name = new TableColumn();
    @FXML
    private  TableColumn<Product, Integer> product_inv_lvl = new TableColumn();
    @FXML
    private  TableColumn<Product, Double> product_price = new TableColumn();
    @FXML
    private TableView<Part> productPartTable = new TableView();
    @FXML
    private  TableColumn<Part, Integer> product_part_ID = new TableColumn();
    @FXML
    private  TableColumn<Part, String> product_part_name = new TableColumn();
    @FXML
    private  TableColumn<Part, Integer> product_part_inv_lvl = new TableColumn();
    @FXML
    private  TableColumn<Part, Double> product_part_price = new TableColumn();
    @FXML
    private Pane outSourced;
    @FXML
    private TextField PartID;
    @FXML
    private TextField ProductID;
    @FXML 
    private TextField Name;
    @FXML 
    private TextField Inv;
    @FXML 
    private TextField Price;
    @FXML 
    private TextField Max;
    @FXML 
    private TextField Min;
    @FXML 
    private TextField MachineID;
    @FXML
    private TextField CompanyName;
    @FXML
    private TextField SearchFieldParts;
    @FXML 
    private TextField SearchFieldProducts;
    
       public MainScreenController(){
     /* Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.*/
    } 
    private mitchellbryant.MitchellBryant mainApp;
        /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public void setMainApp(mitchellbryant.MitchellBryant mainApp)
    {
        this.mainApp = mainApp;
        partTable.setItems(Inventory.getAllParts());
        productTable.setItems(Inventory.getProducts());
        
        
        
    }
    


    @FXML
    public void exitMainApp(){
        System.exit(1);
    }
    @FXML
    public String returnPartCount(){
        return String.valueOf(partCount);
    }
    @FXML
    private void handleOKinHouse() {
        
        partStage = (Stage) MachineID.getScene().getWindow();
        
        part.setPartID(Integer.parseInt(PartID.getText()));
        part.setName(Name.getText());
        part.setStock(Integer.parseInt(Inv.getText()));
        part.setPrice(Double.parseDouble(Price.getText()));
        part.setMax(Integer.parseInt(Max.getText()));
        part.setMin(Integer.parseInt(Min.getText()));
        part.setMachineID(Integer.parseInt(MachineID.getText()));
        okClicked = true;
        if (part.getMax() >= part.getStock() && part.getMin() <= part.getStock() && part.getMin() < part.getMax())
        {
        Inventory.getAllParts().remove(Inventory.getSelectedPart());
        Inventory.getAllParts().add(part);
        partStage.close();
        }
        else {
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Alert: Invalid values");
           alert.setHeaderText("Error: Inventory level must be between Max and Min values");
           alert.setContentText("Max and Min values cannot be the same");
           alert.showAndWait();
        }

    }
    @FXML 
    private void handleOKoutsourced() {
           partStageOutsourced = (Stage) CompanyName.getScene().getWindow();
           
           outsourcedPart.setPartID(Integer.parseInt(PartID.getText()));
           outsourcedPart.setName(Name.getText());
           outsourcedPart.setStock(Integer.parseInt(Inv.getText()));
           outsourcedPart.setPrice(Double.parseDouble(Price.getText()));
           outsourcedPart.setMax(Integer.parseInt(Max.getText()));
           outsourcedPart.setMin(Integer.parseInt(Min.getText())); 
           outsourcedPart.setCompanyName(CompanyName.getText());
           okClicked =true;
           if (outsourcedPart.getMax() >= outsourcedPart.getStock() && outsourcedPart.getMin() <= outsourcedPart.getStock() && outsourcedPart.getMin() < outsourcedPart.getMax())
        {
        Inventory.getAllParts().remove(Inventory.getSelectedPart());
        Inventory.getAllParts().add(outsourcedPart);
        partStageOutsourced.close();
        }
        else {
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Alert: Invalid values");
           alert.setHeaderText("Error: Inventory level must be between Max and Min values");
           alert.setContentText("Max and Min values cannot be the same");
           alert.showAndWait();
        }
    }
    @FXML
    public void addPartButton(ActionEvent event) throws Exception{
        partCount++;
        partTable.setItems(Inventory.getAllParts());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(View_Controller.MainScreenController.class.getResource("AddPartInHouse.fxml"));
            Parent root4 = (Parent) fxmlLoader.load();
            partStage.setTitle("Add Part");
            Scene scene = new Scene(root4);
            partStage.setScene(scene);  
            partStage.show();
            MainScreenController controller = fxmlLoader.getController();
            controller.PartID.setText(String.valueOf(partCount));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void inHousePartButton(ActionEvent event) throws Exception{
        Stage s = (Stage) CompanyName.getScene().getWindow();
        s.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPartInHouse.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        partStage.setTitle("Add Part");
        partStage.setScene(new Scene(root1));  
        partStage.show();
        MainScreenController controller = fxmlLoader.getController();
        controller.PartID.setText(String.valueOf(partCount));
    }
        @FXML   
    private void inHousePartModifyButton(ActionEvent event) throws Exception{
        Stage s = (Stage) CompanyName.getScene().getWindow();
        s.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(View_Controller.MainScreenController.class.getResource("ModifyPartInHouse.fxml"));
            Parent root4 = (Parent) fxmlLoader.load();
            partStage.setTitle("Modify Part");
            Scene scene = new Scene(root4);
            partStage.setScene(scene);  
            partStage.show();
            MainScreenController controller = fxmlLoader.getController();
            controller.PartID.setText(String.valueOf(Inventory.getSelectedPart().getPartID()));
            controller.Name.setText(Inventory.getSelectedPart().getName());
            controller.Inv.setText(String.valueOf(Inventory.getSelectedPart().getStock()));
            controller.Price.setText(String.valueOf(Inventory.getSelectedPart().getPrice()));
            controller.Min.setText(String.valueOf(Inventory.getSelectedPart().getMin()));
            controller.Max.setText(String.valueOf(Inventory.getSelectedPart().getMax())); 
            }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void outSourcedPartButton(ActionEvent event) throws Exception{
        Stage s = (Stage) MachineID.getScene().getWindow();
        s.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPartOutsourced.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        partStage.setTitle("Add Outsourced Part");
        partStage.setScene(new Scene(root1));  
        partStage.show();
        MainScreenController controller = fxmlLoader.getController();
        controller.PartID.setText(String.valueOf(partCount));
    }
    @FXML   
    private void outSourcedPartModifyButton(ActionEvent event) throws Exception{
        Stage s = (Stage) MachineID.getScene().getWindow();
        s.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(View_Controller.MainScreenController.class.getResource("ModifyPartOutsourced.fxml"));
            Parent root4 = (Parent) fxmlLoader.load();
            partStage.setTitle("Modify Part");
            Scene scene = new Scene(root4);
            partStage.setScene(scene);  
            partStage.show();
            MainScreenController controller = fxmlLoader.getController();
            controller.PartID.setText(String.valueOf(Inventory.getSelectedPart().getPartID()));
            controller.Name.setText(Inventory.getSelectedPart().getName());
            controller.Inv.setText(String.valueOf(Inventory.getSelectedPart().getStock()));
            controller.Price.setText(String.valueOf(Inventory.getSelectedPart().getPrice()));
            controller.Min.setText(String.valueOf(Inventory.getSelectedPart().getMin()));
            controller.Max.setText(String.valueOf(Inventory.getSelectedPart().getMax())); 
            }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void modifyPartButton(ActionEvent event) throws Exception{
        Inventory.setSelectedPart(partTable.getSelectionModel().getSelectedItem());
        if (Inventory.getSelectedPart() instanceof InHousePart ){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(View_Controller.MainScreenController.class.getResource("ModifyPartInHouse.fxml"));
            Parent root5 = (Parent) fxmlLoader.load();
            partStage.setTitle("Modify Part");
            Scene scene = new Scene(root5);
            partStage.setScene(scene);  
            partStage.show();
            MainScreenController controller = fxmlLoader.getController();
            controller.PartID.setText(String.valueOf(Inventory.getSelectedPart().getPartID()));
            controller.Name.setText(Inventory.getSelectedPart().getName());
            controller.Inv.setText(String.valueOf(Inventory.getSelectedPart().getStock()));
            controller.Price.setText(String.valueOf(Inventory.getSelectedPart().getPrice()));
            controller.Min.setText(String.valueOf(Inventory.getSelectedPart().getMin()));
            controller.Max.setText(String.valueOf(Inventory.getSelectedPart().getMax()));
            controller.MachineID.setText(String.valueOf(((InHousePart)Inventory.getSelectedPart()).getMachineID()));
//            controller.
        } catch(Exception e) {
            e.printStackTrace();
        }
        }
        else 
            try {
               FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(View_Controller.MainScreenController.class.getResource("ModifyPartOutsourced.fxml"));
            Parent root4 = (Parent) fxmlLoader.load();
            partStage.setTitle("Modify Part");
            Scene scene = new Scene(root4);
            partStage.setScene(scene);  
            partStage.show();
            MainScreenController controller = fxmlLoader.getController();
            controller.PartID.setText(String.valueOf(Inventory.getSelectedPart().getPartID()));
            controller.Name.setText(Inventory.getSelectedPart().getName());
            controller.Inv.setText(String.valueOf(Inventory.getSelectedPart().getStock()));
            controller.Price.setText(String.valueOf(Inventory.getSelectedPart().getPrice()));
            controller.Min.setText(String.valueOf(Inventory.getSelectedPart().getMin()));
            controller.Max.setText(String.valueOf(Inventory.getSelectedPart().getMax()));
            controller.CompanyName.setText(((OutsourcedPart)Inventory.getSelectedPart()).getCompanyName()); 
            }
        catch(Exception e) {
            e.printStackTrace();
        }
//        System.out.println(Name + "" + Inventory.getSelectedPart());

    }
    @FXML
    public void deletePartButton(ActionEvent event) throws Exception{
        Inventory.setSelectedPart(partTable.getSelectionModel().getSelectedItem());
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Delete");
        alert.setContentText("Are you sure you want to delete this Part?");
        Optional <ButtonType> action = alert.showAndWait();
        
        if (action.get() == ButtonType.OK) {
           Inventory.getAllParts().remove(Inventory.getSelectedPart());
        }
    }
    @FXML
    public void addProductButton(ActionEvent event) throws Exception{
        productCount++;
//        productPartTable.setItems(Inventory.getSelectedPart().getAssociatedParts());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(View_Controller.MainScreenController.class.getResource("AddProductScreen.fxml")) ;     
            Parent root2 = (Parent) fxmlLoader.load();
            productStage.setTitle("Add Product");
            productStage.setScene(new Scene(root2));  
            productStage.show();
            MainScreenController controller = fxmlLoader.getController();
           
            productParts.add(Inventory.getAllParts().get(0));
            ObservableList<Part> parts = FXCollections.observableArrayList(productParts);
            parts = FXCollections.observableArrayList(productParts);
            productParts.remove(0);
//          controller.productPartTable.setItems(parts);
            controller.ProductID.setText(String.valueOf(productCount));
            
        } catch(Exception f) {
            f.printStackTrace();
        }
    }
        @FXML 
    private void handleOKproduct() {
           productStage = (Stage) ProductID.getScene().getWindow();
           double partPrices = 0.00;
           for (int i= 0; i < productPartTable.getItems().size(); i++){
               partPrices = partPrices + productPartTable.getItems().get(i).getPrice();
           }
           Alert alert = new Alert(AlertType.INFORMATION);
           alert.setTitle("Error: Values required");
           alert.setHeaderText("Certain values must be filled in");
           alert.setContentText("Product Name and Price must be filled in");
           Alert alert2 = new Alert(AlertType.INFORMATION);
           alert2.setTitle("Alert: Invalid values");
           alert2.setHeaderText("Error: Inventory level must be between Max and Min values");
           alert2.setContentText("Max and Min values cannot be the same. If Inventory is left blank, Min must be 0");
           Alert alert3 = new Alert(AlertType.INFORMATION);
           alert3.setTitle("Alert: Missing Component");
           alert3.setHeaderText("Error: Missing Part");
           alert3.setContentText("There must be at least one Part assigned to each product");
           Alert alert4 = new Alert(AlertType.INFORMATION);
           alert4.setTitle("Alert: Invalid values");
           alert4.setHeaderText("Error: Associated Parts cost exceeds Product cost");
           alert4.setContentText("The total cost of associated Parts cannot exceed the cost of the Product");
           product.setAssociatedParts(productPartTable.getItems());
           product.setProductID(Integer.parseInt(ProductID.getText()));
           product.setName(Name.getText());
           if (Price.getText().isEmpty()){ }
           else {product.setPrice(Double.parseDouble(Price.getText()));}
           if (Inv.getText().isEmpty()){product.setStock(0);}
           else {product.setStock(Integer.parseInt(Inv.getText()));}
           product.setMax(Integer.parseInt(Max.getText()));
           product.setMin(Integer.parseInt(Min.getText()));
           okClicked =true;
           if (Name.getText().isEmpty() || Price.getText().isEmpty()){
           alert.showAndWait();}
           else if (product.getMax() < product.getStock() || product.getMin() > product.getStock() || product.getMin() == product.getMax()){
           alert2.showAndWait();}
           else if (product.getAssociatedParts().isEmpty()){
           alert3.showAndWait();}
           else if (product.getPrice() < partPrices){
           alert4.showAndWait();}
           else{Inventory.getProducts().remove(Inventory.getSelectedProduct());
           Inventory.getProducts().add(product);
           productStage.close();
           }
    }
        @FXML
    public void modifyPartToProductButton(ActionEvent event) throws Exception{
        Inventory.setSelectedPart(partTable.getSelectionModel().getSelectedItem());
        productPartTable.getItems().add(Inventory.getSelectedPart());
//        Inventory.getSelectedProduct().addAssociatedPart(Inventory.getSelectedPart());
    }
        @FXML
    public void addPartToProductButton(ActionEvent event) throws Exception{
        Inventory.setSelectedPart(partTable.getSelectionModel().getSelectedItem());
        productPartTable.getItems().add(Inventory.getSelectedPart());
//        ObservableList<Part> parts = FXCollections.observableArrayList(productParts);
//            productPartTable.setItems(parts);
    }
        @FXML
    public void modifyProductButton(ActionEvent event) throws Exception{
        
        Inventory.setSelectedProduct(productTable.getSelectionModel().getSelectedItem());
        oldParts = FXCollections.observableArrayList(Inventory.getSelectedProduct().getAssociatedParts());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(View_Controller.MainScreenController.class.getResource("ModifyProductScreen.fxml"));
            Parent root5 = (Parent) fxmlLoader.load();
            productStage.setTitle("Modify Product");
            Scene scene = new Scene(root5);
            productStage.setScene(scene);  
            productStage.show();
            MainScreenController controller = fxmlLoader.getController();
            controller.productPartTable.setItems(Inventory.getSelectedProduct().getAssociatedParts());
            controller.ProductID.setText(String.valueOf(Inventory.getSelectedProduct().getProductID()));
            controller.Name.setText(Inventory.getSelectedProduct().getName());
            controller.Inv.setText(String.valueOf(Inventory.getSelectedProduct().getStock()));
            controller.Price.setText(String.valueOf(Inventory.getSelectedProduct().getPrice()));
            controller.Min.setText(String.valueOf(Inventory.getSelectedProduct().getMin()));
            controller.Max.setText(String.valueOf(Inventory.getSelectedProduct().getMax()));
            
        } catch(Exception e) {
            e.printStackTrace();
        } 
    }
    @FXML
    public void deleteAssociatedPartButton(ActionEvent event) throws Exception{
        Product.setSelectedPart(productPartTable.getSelectionModel().getSelectedItem());
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Delete");
        alert.setContentText("Are you sure you want to delete this Part?");
        Optional <ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            Inventory.getSelectedProduct().getAssociatedParts().remove(Product.getSelectedPart());
//           productParts.remove(Product.getSelectedPart());
//           ObservableList<Part> parts = FXCollections.observableArrayList(productParts);
//           productPartTable.setItems(parts);
        }
    }
    @FXML
    public void deleteAssociatedPartButton2(ActionEvent event) throws Exception{
       Product.setSelectedPart(productPartTable.getSelectionModel().getSelectedItem());
       productPartTable.getItems().remove(Product.getSelectedPart());
    }
     @FXML
    public void deleteProductButton(ActionEvent event) throws Exception{
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Delete");
        alert.setHeaderText("This Product has one or more Parts assigned to it");
        alert.setContentText("Are you sure you want to delete this Product?");
        Optional <ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            Inventory.getProducts().remove(selectedProduct);
        }
    }
    
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Cancel");
        alert.setContentText("Are you sure you want to cancel?");
        Optional <ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            partStage = (Stage) closeButton.getScene().getWindow();
        partStage.close();
        }
        
    }
        @FXML
    public void handleProductCloseButtonAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Cancel");
        alert.setContentText("Are you sure you want to cancel?");
        Optional <ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            productStage = (Stage) cancelButton.getScene().getWindow();
            Inventory.getSelectedProduct().setAssociatedParts(oldParts);
            productStage.close();
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        part_ID.setCellValueFactory(cellData -> cellData.getValue().intProperty().asObject());
        part_name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        part_inv_lvl.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        part_price.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        partTable.setItems(Inventory.getAllParts());
        product_ID.setCellValueFactory(cellData -> cellData.getValue().intProperty().asObject());
        product_name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        product_inv_lvl.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        product_price.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        productTable.setItems(Inventory.getProducts());
        product_part_ID.setCellValueFactory(cellData -> cellData.getValue().intProperty().asObject());
        product_part_name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        product_part_inv_lvl.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        product_part_price.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

//        productPartTable.setItems(product.getAssociatedParts());
        
    }    
@FXML
public void searchParts(ActionEvent event){

        String searchText = SearchFieldParts.getText();
        FilteredList<Part> searchPartResults = Inventory.getAllParts().filtered(p -> p.getName().toLowerCase().contains(searchText.toLowerCase()));
        SortedList<Part> sortedData = new SortedList<>(searchPartResults);
        sortedData.comparatorProperty().bind(partTable.comparatorProperty());
        partTable.setItems(sortedData);
    }  
@FXML
public void searchProducts(ActionEvent event){

        String searchText = SearchFieldProducts.getText();
        FilteredList<Product> searchProductResults = Inventory.getProducts().filtered(p -> p.getName().toLowerCase().contains(searchText.toLowerCase()));
        SortedList<Product> sortedData = new SortedList<>(searchProductResults);
        sortedData.comparatorProperty().bind(productTable.comparatorProperty());
        productTable.setItems(sortedData);
    }  
}

//    @FXML
//    public void initialize(){
//
//        FilteredList<Part> filteredParts = new FilteredList<>(Inventory.allParts.contains(SearchFieldParts.getText().toLowerCase()) );
//        SearchFieldParts.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredParts.setPredicate(partz -> {
//                if (newValue == null || newValue.isEmpty()){
//                    return true;
//                }
//                
//                String lowerCaseFilter = newValue.toLowerCase();
//                
//                if (part.getName().toLowerCase().indexOf(lowerCaseFilter) != 1){
//                    return true;
//                }
//                else if (part.getPartID() != 0){
//                    return true;
//                }
//                return false;
//            });
//        });
//        SortedList<Part> sortedParts = new SortedList<>(filteredParts);
//        
//        sortedParts.comparatorProperty().bind(partTable.comparatorProperty());
//        
//        partTable.setItems(sortedParts);
//    }
    
