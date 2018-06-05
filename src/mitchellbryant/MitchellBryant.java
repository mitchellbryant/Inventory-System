
package mitchellbryant;


import Model.Part;
import  Model.*;
import Model.Product;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * Last edited 08/23/2017
 * @author Mitchell Bryant
 */
public class MitchellBryant extends Application {

    public static ArrayList<Part> associatedParts = new ArrayList();
    final static ToggleGroup group = new ToggleGroup();
    static RadioButton rb1 = new RadioButton("In House");
    static RadioButton rb2 = new RadioButton("Outsourced");
    private Stage primaryStage;
    private BorderPane rootLayout;
    ArrayList<Part> product1Parts = new ArrayList();
    ArrayList<Part> product2Parts = new ArrayList();
    ArrayList<Part> product3Parts = new ArrayList();
    ArrayList<Part> product4Parts = new ArrayList();
    ArrayList<Part> product5Parts = new ArrayList();

    //Filling Part and Product Tables with sample Data
    public MitchellBryant(){
        Inventory.addPart(new InHousePart(1, "Motherboard", 27, 75.99, 6, 51, 26));
        Inventory.addPart(new InHousePart(2, "CPU", 21, 129.99, 5, 59, 27));
        Inventory.addPart(new InHousePart(3, "RAM", 15, 5.99, 10, 250, 28));
        Inventory.getAllParts().add(new InHousePart(4, "HDD / Hard Drive", 34, 59.29, 3, 500, 29));
        Inventory.getAllParts().add(new OutsourcedPart(5, "Monitor", 52, 79.49, 50, 1000, "MonitorzRus"));
        product1Parts.add(Inventory.getAllParts().get(4));
        product2Parts.add(Inventory.getAllParts().get(3));
        product3Parts.add(Inventory.getAllParts().get(2));
        product4Parts.add(Inventory.getAllParts().get(1));
        product5Parts.add(Inventory.getAllParts().get(0));
        ObservableList<Part> parts1 = FXCollections.observableArrayList(product1Parts);
        ObservableList<Part> parts2 = FXCollections.observableArrayList(product2Parts);
        ObservableList<Part> parts3 = FXCollections.observableArrayList(product3Parts);
        ObservableList<Part> parts4 = FXCollections.observableArrayList(product4Parts);
        ObservableList<Part> parts5 = FXCollections.observableArrayList(product5Parts);
        Inventory.addProduct(new Product(parts1, 1, "Desktop", 359.99, 21, 10, 500 ));
        Inventory.addProduct(new Product(parts2, 2, "Laptop", 239.99, 29, 5, 200 ));
        Inventory.addProduct(new Product(parts3, 3, "PC", 329.99, 52, 0, 100 ));
        Inventory.addProduct(new Product(parts4, 4, "Notebook", 139.99, 5, 4, 50 ));
        Inventory.getProducts().add(new Product(parts5, 5, "Supercomputer", 1999.99, 19, 10, 20 ));
          
    }
    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Inv Mgmt System");
        initLayout();
        showMainScreen(); 
    }
    
    public void initLayout(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(View_Controller.MainScreenController.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public void showMainScreen(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(View_Controller.MainScreenController.class.getResource("MainScreen.fxml"));
            AnchorPane  mainScreenOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(mainScreenOverview);

            View_Controller.MainScreenController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
