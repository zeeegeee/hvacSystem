/*
Authors: Moe yaziji, Grey Steinberg
DATE: 5/21/2018
PURPOSE: this is the window class, it has every window in the program except for customer form
the purpose of this class is to creat windows and call different window depending on the instance object method call
*/
package IS;

import java.awt.Color;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

public class window {

    //customer tab nodes
    Label customerName = new Label("Name");
    Label customerStreet = new Label("Street");
    Label customerZip = new Label("Zip");
    Label customerState = new Label("State");
    Label customerCity = new Label("City");
    Label customerPhone = new Label("Phone Number");

    TextField txtcustomerfName = new TextField();
    TextField txtcustomerlName = new TextField();
    TextField txtcustomerStreet = new TextField();
    TextField txtcustomerZip = new TextField();
    TextField txtcustomerState = new TextField();
    TextField txtcustomerCity = new TextField();
    TextField txtcustomerPhone = new TextField();
    //technician tab Nodes 
    Label technicianName = new Label("Name");
    Label technicianPhone = new Label("Phone Number");

    //supplier nodes
    Label supplierName = new Label("Product's Supplier Name");
    Label supplierStreet = new Label("Street");
    Label supplierZip = new Label("Zip");
    Label supplierState = new Label("State");
    Label supplierCity = new Label("City");
    Label supplierPhone = new Label("Phone Number");

    TextField txtsupplierName = new TextField();
    TextField txtsupplierStreet = new TextField();
    TextField txtsupplierZip = new TextField();
    TextField txtsupplierState = new TextField();
    TextField txtsupplierCity = new TextField();
    TextField txtSupplierPhone = new TextField();
    //product nodes
    Label lblproductName = new Label("Product's Name");
    Label lblproductPrice = new Label("Product's Price");
    Label lblproductDesc = new Label("Product's Description");

    TextField txtproductName = new TextField();
    TextField txtproductPrice = new TextField();
    TextField txtproductDesc = new TextField();

    //technician nodes
    Label lbltechnicianfName = new Label("Technician's Name");
    Label lbltechnicianNumber = new Label("Technician's Number");
    Label techID = new Label("Technician ID");

    TextField txttechnicianfName = new TextField();
    TextField txttechnicianlName = new TextField();
    TextField txttechnicianNumber = new TextField();

    //buttons
    Button addTechnician = new Button("Add Technician");
    Button addProduct = new Button("Add Product");
    Button addSupplier = new Button("Add Supplier");
    Button addTech = new Button("Add Technician");
    Button register = new Button("Register");
    Button addCustomer = new Button("Add Customer");
    Button showInfo = new Button("Show Information");
    Button submitRequest = new Button("Send a Request");
    Button showInfoP = new Button("Show Information");
    Button logOn = new Button("Login");
    Button deleteCustomer = new Button("Delete Customer");
    Button editProduct = new Button("Edit Product");
    Button deleteProduct = new Button("Delete Product");
    Button supplierInformation = new Button("Show Information");
    Button deleteSupplier = new Button("Delete Supplier");
    Button editSupplier = new Button("Edit Supplier");
    Button showInfoT = new Button("Show Information");
    Button deleteTechnician = new Button("Delete Technician");
    Button editTechnician = new Button("Edit Technician");
    Button deleteStore = new Button("Delete Store");
    Button editStore = new Button("Edit Store");

    // tabs
    TabPane tPane = new TabPane();
    Tab customerTab = new Tab("Customer");
    Tab technicianTab = new Tab("Technician");
    Tab StoreTab = new Tab("Store");
    Tab serviceTab = new Tab("Service");
    Tab productTab = new Tab("Product");
    Tab supplierTab = new Tab("Supplier");

    //panes
    GridPane root = new GridPane();
    GridPane customerPane = new GridPane();
    GridPane technicianPane = new GridPane();
    GridPane supplierPane = new GridPane();
    GridPane productPane = new GridPane();

    FlowPane technicianLoginPortal = new FlowPane();
    GridPane customerLoginPane = new GridPane();

    //stages     
    Stage primaryStage = new Stage();
    Stage technicianLoginStage = new Stage();
    Stage technicianStage = new Stage();

    Stage customerLoginStage = new Stage();
    Stage technicanLoginStage = new Stage();

    //tables
    //customer table
    TableView<customer> customerTable = new TableView<>();
    ObservableList<customer> customerData = FXCollections.observableArrayList();
    //service table
    TableView<service> serviceTable = new TableView<service>();
    ObservableList<service> serviceData = FXCollections.observableArrayList();
    //supplier table
    TableView<supplier> supplierTable = new TableView<>();
    ObservableList<supplier> supplierData = FXCollections.observableArrayList();
    //Technician table
    TableView<technician> technicianTable = new TableView<>();
    ObservableList<technician> technicianData = FXCollections.observableArrayList();

    //product table
    TableView<product> productTable = new TableView<>();
    ObservableList<product> productData = FXCollections.observableArrayList();    
    
    
    TableView<store> storeTable = new TableView<>();
    ObservableList<store> storeData = FXCollections.observableArrayList();
    
    

    public void customer() {
        //setting prompt texts inside textfields 
        txtcustomerfName.setPromptText("FirstName");
        txtcustomerfName.setFocusTraversable(false);
        txtcustomerlName.setPromptText("Last Name");
        txtcustomerlName.setFocusTraversable(false);

        //placing nodes on pane
        customerLoginPane.add(customerName, 0, 0);
        customerLoginPane.add(customerStreet, 0, 1);
        customerLoginPane.add(customerCity, 0, 2);
        customerLoginPane.add(customerState, 0, 3);
        customerLoginPane.add(customerZip, 0, 4);
        customerLoginPane.add(customerPhone, 0, 5);
        customerLoginPane.add(register, 0, 6);
        //customer
        customerLoginPane.add(txtcustomerfName, 1, 0);
        customerLoginPane.add(txtcustomerlName, 2, 0);
        customerLoginPane.add(txtcustomerStreet, 1, 1);
        customerLoginPane.add(txtcustomerCity, 1, 2);
        customerLoginPane.add(txtcustomerState, 1, 3);
        customerLoginPane.add(txtcustomerZip, 1, 4);
        customerLoginPane.add(txtcustomerPhone, 1, 5);
        //window setting
        Scene Customerscene = new Scene(customerLoginPane, 500, 300);
        customerLoginPane.setVgap(10);
        customerLoginPane.setHgap(10);
        customerLoginPane.setPadding(new Insets(20, 20, 20, 20));
        customerLoginPane.setPadding(new Insets(20, 20, 20, 20));
        customerLoginStage.setTitle("VENT");
        customerLoginStage.setScene(Customerscene);
        customerLoginStage.show();
        register.setOnAction(register
                -> {
            String ID = UUID.randomUUID().toString().substring(0, 8);
            customer newCustomer = new customer(ID, txtcustomerfName.getText(), txtcustomerlName.getText(), txtcustomerPhone.getText(),
                    txtcustomerStreet.getText(), txtcustomerCity.getText(), txtcustomerState.getText(), txtcustomerZip.getText());
            customerData.add(newCustomer);
            customer.customerList.add(newCustomer);
            Label update = new Label("Thank You for Registering, your Username is " + newCustomer.getCustomerID());
            //clearing text inside the textfield 

            String sqlQuery = "";
            sqlQuery += "insert into javauser.customer (customerID, firstname, lastname, phonenumber, address, city, state, zipcode) values (";
            sqlQuery += "'" + ID + "',";
            sqlQuery += "'" + txtcustomerfName.getText() + "',";
            sqlQuery += "'" + txtcustomerlName.getText() + "',";
            sqlQuery += "'" + txtcustomerPhone.getText() + "',";
            sqlQuery += "'" + txtcustomerStreet.getText() + "',";
            sqlQuery += "'" + txtcustomerCity.getText() + "',";
            sqlQuery += "'" + txtcustomerState.getText() + "',";
            sqlQuery += "'" + txtcustomerZip.getText() + "')";
            sendDBCommand(sqlQuery);

            txtcustomerfName.clear();
            txtcustomerlName.clear();
            txtcustomerPhone.clear();
            txtcustomerStreet.clear();
            txtcustomerCity.clear();
            txtcustomerState.clear();
            txtcustomerZip.clear();
            customerLoginPane.add(update, 1, 6, 3, 1);

        });
    }

    public void admin() {
        //creating basic setting for the tab
        customerPane.setVgap(10);
        customerPane.setHgap(10);
        customerPane.setPadding(new Insets(20, 20, 20, 20));
        technicianPane.setPadding(new Insets(20, 20, 20, 20));
        supplierPane.setPadding(new Insets(20, 20, 20, 20));
        productPane.setPadding(new Insets(20, 20, 20, 20));

        //setting prompt texts inside all textfields 
        txtcustomerfName.setPromptText("FirstName");
        txtcustomerfName.setFocusTraversable(false);
        txtcustomerlName.setPromptText("Last Name");
        txtcustomerlName.setFocusTraversable(false);
        txttechnicianfName.setPromptText("First Name");
        txttechnicianfName.setFocusTraversable(false);
        txttechnicianlName.setPromptText("Last Name");
        txttechnicianlName.setFocusTraversable(false);

        //customer
        customerPane.add(customerName, 0, 0);
        customerPane.add(customerStreet, 0, 1);
        customerPane.add(customerCity, 0, 2);
        customerPane.add(customerState, 0, 3);
        customerPane.add(customerZip, 0, 4);
        customerPane.add(customerPhone, 0, 5);
        customerPane.add(addCustomer, 0, 6);

        //customer
        customerPane.add(txtcustomerfName, 1, 0);
        customerPane.add(txtcustomerlName, 2, 0);
        customerPane.add(txtcustomerStreet, 1, 1);
        customerPane.add(txtcustomerCity, 1, 2);
        customerPane.add(txtcustomerState, 1, 3);
        customerPane.add(txtcustomerZip, 1, 4);
        customerPane.add(txtcustomerPhone, 1, 5);
        customerPane.add(showInfo, 3, 8);
        customerPane.add(deleteCustomer, 4, 8);
        Button editCustomer = new Button("Edit Customer");
        customerPane.add(editCustomer, 5, 8);

        //technician
        technicianPane.add(lbltechnicianfName, 0, 0);
        technicianPane.add(txttechnicianfName, 1, 0);
        technicianPane.add(txttechnicianlName, 2, 0);
        technicianPane.add(lbltechnicianNumber, 0, 1);
        technicianPane.add(txttechnicianNumber, 1, 1);
        technicianPane.add(addTechnician, 0, 2);
        technicianPane.add(showInfoT, 3, 8);
        technicianPane.add(deleteTechnician, 4, 8);
        technicianPane.add(editTechnician, 5, 8);

        //placing customer gridpane on the customer tab
        customerTab.setContent(customerPane);

        //placing all the tabs on the tab pane 
        tPane.getTabs().addAll(customerTab, technicianTab, StoreTab, supplierTab, productTab);

        //setting tabs to prevent user exiting
        customerTab.setClosable(false);
        technicianTab.setClosable(false);

        //adding the tab pane on the root gridpane     
        root.add(tPane, 0, 0);

        //main scene 
        Scene scene = new Scene(root, 1300, 700);

        //populating all the tables 
        //setting for customer pane
        customerTable.setEditable(true);
        customerPane.setVgap(10);
        customerPane.setHgap(10);
        customerPane.setPadding(new Insets(20, 20, 20, 20));
        root.setAlignment(Pos.CENTER);

        primaryStage.setTitle("VENT");
        primaryStage.setScene(scene);
        tPane.setMinHeight(scene.getHeight());
        tPane.setMinWidth(scene.getWidth());
        primaryStage.show();
        primaryStage.setOpacity(0.90);

        scene.getStylesheets().add("file:../HVACsystem/src/IS/CascadeStyleSheet.css");
        // creating an action event for adding a customer ---------------------------------------------------------------------------------
        addCustomer.setOnAction(e -> {

            String ID = UUID.randomUUID().toString().substring(0, 8);
            customer newCustomer = new customer(ID, txtcustomerfName.getText(), txtcustomerlName.getText(), txtcustomerPhone.getText(),
                    txtcustomerStreet.getText(), txtcustomerCity.getText(), txtcustomerState.getText(), txtcustomerZip.getText());
            customerData.add(newCustomer);
            customer.customerList.add(newCustomer);
            String sqlQuery = "";
            sqlQuery += "insert into javauser.customer (customerID, firstname, lastname, phonenumber, address, city, state, zipcode) values (";
            sqlQuery += "'" + ID + "',";
            sqlQuery += "'" + txtcustomerfName.getText() + "',";
            sqlQuery += "'" + txtcustomerlName.getText() + "',";
            sqlQuery += "'" + txtcustomerPhone.getText() + "',";
            sqlQuery += "'" + txtcustomerStreet.getText() + "',";
            sqlQuery += "'" + txtcustomerCity.getText() + "',";
            sqlQuery += "'" + txtcustomerState.getText() + "',";
            sqlQuery += txtcustomerZip.getText() + ")";
            sendDBCommand(sqlQuery);

            //clearing text inside the textfield 
            txtcustomerfName.clear();
            txtcustomerlName.clear();
            txtcustomerPhone.clear();
            txtcustomerStreet.clear();
            txtcustomerCity.clear();
            txtcustomerState.clear();
            txtcustomerZip.clear();

        });// end of lamda expression 
        for (customer s : customer.customerList) {
            customerData.add(s);
        }
        customerTable.setItems(customerData);

        //        initiating customer table and customer data  
        //         setting all the items in customer data into customer table 
        //creating table columns to place in the customer table 
        TableColumn COL1 = new TableColumn("Customer ID");
        TableColumn COL2 = new TableColumn("First Name");
        TableColumn COL3 = new TableColumn("Last Name");
        TableColumn COL4 = new TableColumn("Phone Number");
        TableColumn COL5 = new TableColumn("Street");
        TableColumn COL6 = new TableColumn("City");
        TableColumn COL7 = new TableColumn("State");
        TableColumn COL8 = new TableColumn("Zip");
        COL1.setPrefWidth(90);
        COL2.setPrefWidth(90);
        COL3.setPrefWidth(100);
        COL4.setPrefWidth(100);
        COL5.setPrefWidth(100);
        COL6.setPrefWidth(100);
        COL7.setPrefWidth(100);
        COL8.setPrefWidth(100);
        COL1.setCellValueFactory(new PropertyValueFactory<customer, String>("customerID"));
        COL2.setCellValueFactory(new PropertyValueFactory<customer, String>("firstName"));
        COL3.setCellValueFactory(new PropertyValueFactory<customer, String>("lastName"));
        COL4.setCellValueFactory(new PropertyValueFactory<customer, String>("phoneNumber"));
        COL5.setCellValueFactory(new PropertyValueFactory<customer, String>("address"));
        COL6.setCellValueFactory(new PropertyValueFactory<customer, String>("city"));
        COL7.setCellValueFactory(new PropertyValueFactory<customer, String>("state"));
        COL8.setCellValueFactory(new PropertyValueFactory<customer, String>("zipCode"));

        //adding all columns into the customer table
        customerTable.getColumns().addAll(COL1, COL2, COL3, COL4, COL5, COL6, COL7, COL8);
        // settings and placement for customer table 
        customerTable.setMinWidth(600);
        customerPane.add(customerTable, 3, 0, 7, 8);

        // action event for clicking show information on customer tab
        showInfo.setOnAction(y -> {
            int index = customerTable.getSelectionModel().getSelectedIndex();
            String output = "";
            output += customer.customerList.get(index).toString();
            System.out.println(index);

            Stage infoStage = new Stage();
            GridPane infoPane = new GridPane();
            Scene infoScene = new Scene(infoPane, 500, 500);
            infoPane.setAlignment(Pos.CENTER);
            TextArea m = new TextArea();
            //basic output into a textarea, this will need to be updated to be more advanced 
            m.setText(output);
            m.setMinWidth(infoScene.getWidth() - 60);
            m.setMinHeight(infoScene.getHeight() - 60);
            infoPane.add(m, 0, 0);
            infoStage.setScene(infoScene);
            infoStage.setTitle("Customer Information");
            infoStage.show();

        });

        customerTable.setOnMouseClicked(select -> {
            // finds the index of the selected item in the tables
            int indexSelection = customerTable.getSelectionModel().getSelectedIndex();
            customer customertoDelete = customerTable.getItems().get(indexSelection);

            try {
                String sqlQuery = "select * from javauser.customer where customerID =\'" + customertoDelete.getCustomerID() + "\'";
                sendDBCommand(sqlQuery);

                dbResults.next();
                txtcustomerfName.setText(dbResults.getString(2));
                txtcustomerlName.setText(dbResults.getString(3));
                txtcustomerPhone.setText(dbResults.getString(4));
                txtcustomerStreet.setText(dbResults.getString(5));
                txtcustomerCity.setText(dbResults.getString(6));
                txtcustomerState.setText(dbResults.getString(7));
                txtcustomerZip.setText(dbResults.getString(8));

            } catch (ArrayIndexOutOfBoundsException aob) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Wrong Selection");
                alert.setTitle("Please select a valid row");
                alert.show();

            } catch (Exception e) {
                System.out.println("Populate Customer method error" + e.toString());
            }
            deleteCustomer.setOnAction(g -> {

                customer.customerList.remove(customertoDelete);
                String sqlQuery = "delete from javauser.customer where customerid=\'" + customertoDelete.getCustomerID() + "\'";
                sendDBCommand(sqlQuery);
                customerData.removeAll(customerData);
                for (customer s : customer.customerList) {

                    customerData.add(s);
                }
                customerTable.setItems(customerData);
            });

            editCustomer.setOnAction(edit -> {
                String sqlQuery = "Update javauser.customer set firstname = '" + txtcustomerfName.getText()
                        + "', lastname ='" + txtcustomerlName.getText() + "', phonenumber = " + txtcustomerPhone.getText()
                        + ", address = '" + txtcustomerStreet.getText() + "', city = '" + txtcustomerCity.getText()
                        + "', state = '" + txtcustomerState.getText() + "', zipcode =" + txtcustomerZip.getText() + " where customerid=\'" + customertoDelete.getCustomerID() + "\'";
                sendDBCommand(sqlQuery);
                txtcustomerfName.clear();
                txtcustomerlName.clear();
                txtcustomerPhone.clear();
                txtcustomerStreet.clear();
                txtcustomerCity.clear();
                txtcustomerState.clear();
                txtcustomerZip.clear();

            });

        });

        //setting for supplier tab-------------------------------------------------------------------------------------------------------------------------------
        supplierTab.setContent(supplierPane);
        supplierTab.setClosable(false);

        txtsupplierName.setPromptText("Product's Supplier Name");
        txtsupplierName.setFocusTraversable(false);

        supplierPane.add(supplierName, 0, 0);
        supplierPane.add(txtsupplierName, 1, 0);
        supplierPane.add(supplierStreet, 0, 1);
        supplierPane.add(txtsupplierStreet, 1, 1);
        supplierPane.add(supplierCity, 0, 2);
        supplierPane.add(txtsupplierCity, 1, 2);
        supplierPane.add(supplierState, 0, 3);
        supplierPane.add(txtsupplierState, 1, 3);
        supplierPane.add(supplierZip, 0, 4);
        supplierPane.add(txtsupplierZip, 1, 4);
        supplierPane.add(addSupplier, 0, 6);
        supplierPane.add(supplierPhone, 0, 5);
        supplierPane.add(txtSupplierPhone, 1, 5);

        supplierPane.setVgap(10);
        supplierPane.setHgap(10);

        addSupplier.setOnAction(e -> {
            String ID = UUID.randomUUID().toString().substring(0, 8);
            supplier new_supplier = new supplier(ID, txtsupplierName.getText(), txtsupplierStreet.getText(),
                    txtsupplierCity.getText(), txtsupplierState.getText(),
                    txtsupplierZip.getText(), txtSupplierPhone.getText());
            String sqlQuery = "insert into javauser.supplier (supplierID, supplierName, address, city, state, zipcode, phonenumber) values (";
            sqlQuery += "'" + ID + "',";
            sqlQuery += "'" + txtsupplierName.getText() + "',";
            sqlQuery += "'" + txtsupplierStreet.getText() + "',";
            sqlQuery += "'" + txtsupplierCity.getText() + "',";
            sqlQuery += "'" + txtsupplierState.getText() + "',";
            sqlQuery += "'" + txtsupplierZip.getText() + "',";
            sqlQuery += "'" + txtSupplierPhone.getText() + "')";
            supplierData.add(new_supplier);
            sendDBCommand(sqlQuery);
            txtsupplierName.clear();
            txtSupplierPhone.clear();
            txtsupplierStreet.clear();
            txtsupplierCity.clear();
            txtsupplierState.clear();
            txtsupplierZip.clear();
            txtSupplierPhone.clear();

            // Database Integration  Insert SQL Query Statement
        });
        for (supplier sup : supplier.supplierList) {
            supplierData.add(sup);
        }
        supplierTable.setItems(supplierData);

        TableColumn SCOL1 = new TableColumn("Supplier ID");
        TableColumn SCOL2 = new TableColumn("Supplier Name");
        TableColumn SCOL3 = new TableColumn("Street");
        TableColumn SCOL4 = new TableColumn("City");
        TableColumn SCOL5 = new TableColumn("State");
        TableColumn SCOL6 = new TableColumn("Zipcode");
        TableColumn SCOL7 = new TableColumn("Phone number");
        SCOL1.setPrefWidth(90);
        SCOL2.setPrefWidth(90);
        SCOL3.setPrefWidth(100);
        SCOL4.setPrefWidth(100);
        SCOL5.setPrefWidth(100);
        SCOL6.setPrefWidth(100);
        SCOL7.setPrefWidth(100);
        SCOL1.setCellValueFactory(new PropertyValueFactory<supplier, String>("supplierID"));
        SCOL2.setCellValueFactory(new PropertyValueFactory<supplier, String>("supplierName"));
        SCOL3.setCellValueFactory(new PropertyValueFactory<supplier, String>("address"));
        SCOL4.setCellValueFactory(new PropertyValueFactory<supplier, String>("city"));
        SCOL5.setCellValueFactory(new PropertyValueFactory<supplier, String>("state"));
        SCOL6.setCellValueFactory(new PropertyValueFactory<supplier, String>("zipCode"));
        SCOL7.setCellValueFactory(new PropertyValueFactory<supplier, String>("phoneNum"));

        //adding all columns into the customer table
        supplierTable.getColumns().addAll(SCOL1, SCOL2, SCOL3, SCOL4, SCOL5, SCOL6, SCOL7);
        // settings and placement for customer table 
        supplierTable.setMinWidth(680);
        supplierPane.add(supplierTable, 3, 0, 7, 8);
        Button supplierInformation = new Button("Show Information");
        Button deleteSupplier = new Button("Delete Supplier");
        Button editSupplier = new Button("Edit Supplier");
        supplierPane.add(supplierInformation, 3, 8);
        supplierPane.add(deleteSupplier, 4, 8);
        supplierPane.add(editSupplier, 5, 8);

        supplierInformation.setOnAction(y -> {
            int index = supplierTable.getSelectionModel().getSelectedIndex();
            String output = "";
            output += supplier.supplierList.get(index).toString();
            System.out.println(index);

            Stage infoStage = new Stage();
            GridPane infoPane = new GridPane();
            Scene infoScene = new Scene(infoPane, 500, 500);
            infoPane.setAlignment(Pos.CENTER);
            TextArea m = new TextArea();
            //basic output into a textarea, this will need to be updated to be more advanced 
            m.setText(output);
            m.setMinWidth(infoScene.getWidth() - 60);
            m.setMinHeight(infoScene.getHeight() - 60);
            infoPane.add(m, 0, 0);
            infoStage.setScene(infoScene);
            infoStage.setTitle("Supplier Information");
            infoStage.show();

        });

        supplierTable.setOnMouseClicked(select -> {
            // finds the index of the selected item in the tables
            int indexSelection = supplierTable.getSelectionModel().getSelectedIndex();
            supplier supplierToDelete = supplierTable.getItems().get(indexSelection);

            try {
                String sqlQuery = "select * from javauser.supplier where supplierid =\'" + supplierToDelete.getSupplierID() + "\'";
                sendDBCommand(sqlQuery);

                dbResults.next();
                txtsupplierName.setText(dbResults.getString(2));
                txtsupplierStreet.setText(dbResults.getString(3));
                txtsupplierZip.setText(dbResults.getString(6));
                txtsupplierCity.setText(dbResults.getString(4));
                txtsupplierState.setText(dbResults.getString(5));
                txtSupplierPhone.setText(dbResults.getString(7));

            } catch (ArrayIndexOutOfBoundsException aob) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Wrong Selection");
                alert.setTitle("Please select a valid row");
                alert.showAndWait();

            } catch (Exception e) {
                System.out.println("");
            }
            deleteSupplier.setOnAction(g -> {

                supplier.supplierList.remove(supplierToDelete);
                String sqlQuery = "delete from javauser.supplier where supplierid=\'" + supplierToDelete.getSupplierID() + "\'";
                sendDBCommand(sqlQuery);
                supplierData.removeAll(supplierData);
                for (supplier s : supplier.supplierList) {

                    supplierData.add(s);
                }
                supplierTable.setItems(supplierData);
                txtsupplierName.clear();
                txtsupplierStreet.clear();
                txtsupplierZip.clear();
                txtsupplierCity.clear();
                txtsupplierState.clear();
                txtSupplierPhone.clear();
            });

            editSupplier.setOnAction(edit -> {

                String sqlQuery = "Update javauser.supplier set suppliername = '" + txtsupplierName.getText()
                        + "', address ='" + txtsupplierStreet.getText() + "', zipcode = " + txtsupplierZip.getText()
                        + ", city = '" + txtsupplierCity.getText() + "', state = '" + txtsupplierState.getText()
                        + "', phonenumber = '" + txtSupplierPhone.getText() + "' " + " where supplierid=\'" + supplierToDelete.getSupplierID() + "\'";
                sendDBCommand(sqlQuery);
                supplierData.removeAll(supplierData);
                for (supplier s : supplier.supplierList) {

                    supplierData.add(s);
                }
                supplierTable.setItems(supplierData);
                txtsupplierName.clear();
                txtsupplierStreet.clear();
                txtsupplierZip.clear();
                txtsupplierCity.clear();
                txtsupplierState.clear();
                txtSupplierPhone.clear();

            });

        });

        //setting for product tab----------------------------------------------------------------------------------------------------------------------------------------------                                                  
        productTab.setContent(productPane);
        productTab.setClosable(false);

        txtproductName.setPromptText("Product's Name");
        txtproductName.setFocusTraversable(false);
        Label supplierName = new Label("Supplier Name");
        TextField txtSupplierName = new TextField();
        productPane.add(lblproductName, 0, 0);
        productPane.add(txtproductName, 1, 0);
        productPane.add(lblproductPrice, 0, 1);
        productPane.add(txtproductPrice, 1, 1);
        productPane.add(lblproductDesc, 0, 2);
        productPane.add(txtproductDesc, 1, 2);
        productPane.add(supplierName, 0, 3);
        TextField txtpSupplierName = new TextField("");
        productPane.add(txtpSupplierName, 1, 3);

        productPane.add(addProduct, 0, 4);
        productPane.add(showInfoP, 3, 8);
        productPane.add(editProduct, 4, 8);
        productPane.add(deleteProduct, 5, 8);

        productPane.setVgap(10);
        productPane.setHgap(10);

        addProduct.setOnAction(e -> {
            String ID = UUID.randomUUID().toString().substring(0, 8);
            product new_product = new product(ID, txtproductPrice.getText(),
                    txtproductDesc.getText(),
                    txtproductName.getText(), txtpSupplierName.getText());
            productData.add(new_product);
            product.productList.add(new_product);
            String sqlQuery = "";
            sqlQuery += "insert into javauser.product (productID, productName, description, pricepaid, suppliername) values (";
            sqlQuery += "'" + ID + "',";
            sqlQuery += "'" + txtproductName.getText() + "',";
            sqlQuery += "'" + txtproductDesc.getText() + "',";
            sqlQuery += "'" + txtproductPrice.getText() + "',";
            sqlQuery += "'" + txtpSupplierName.getText() + "')";
            sendDBCommand(sqlQuery);

            txtproductPrice.clear();
            txtproductDesc.clear();
            txtproductName.clear();
            txtpSupplierName.clear();

            // Database Integration Insert Statement
        });

        productTable = new TableView<>();
        productData = FXCollections.observableArrayList();
        productTable.setItems(productData);
        for (product pro : product.productList) {
            productData.add(pro);
        }
        TableColumn PCOL1 = new TableColumn("Product ID");
        TableColumn PCOL2 = new TableColumn("Product Name");
        TableColumn PCOL3 = new TableColumn("Product Price");
        TableColumn PCOL4 = new TableColumn("Product Description");
        TableColumn PCOL5 = new TableColumn("Product Supplier");
        PCOL1.setPrefWidth(160);
        PCOL2.setPrefWidth(160);
        PCOL3.setPrefWidth(160);
        PCOL4.setPrefWidth(160);
        PCOL5.setPrefWidth(160);

        PCOL1.setCellValueFactory(new PropertyValueFactory<product, String>("productID"));
        PCOL2.setCellValueFactory(new PropertyValueFactory<product, String>("productName"));
        PCOL3.setCellValueFactory(new PropertyValueFactory<product, String>("pricePaid"));
        PCOL4.setCellValueFactory(new PropertyValueFactory<product, String>("description"));
        PCOL5.setCellValueFactory(new PropertyValueFactory<product, String>("supplierName"));

        productTable.getColumns().addAll(PCOL1, PCOL2, PCOL3, PCOL4, PCOL5);
        PCOL1.prefWidthProperty().bind(productTable.widthProperty().multiply(0.2));
        productTable.setMinWidth(700);
        productPane.add(productTable, 3, 0, 7, 8);
        productTable.setOnMouseClicked(e -> {
            // finds the index of the selected item in the tables
            int indexSelection = productTable.getSelectionModel().getSelectedIndex();
            product productToDelete = productTable.getItems().get(indexSelection);

            try {
                String sqlQuery = "select * from javauser.product where productid =\'" + productToDelete.getProductID() + "\'";
                sendDBCommand(sqlQuery);

                dbResults.next();
                txtproductName.setText(dbResults.getString(2));
                txtproductDesc.setText(dbResults.getString(3));
                txtproductPrice.setText(dbResults.getString(4));
            } catch (Exception f) {
                System.out.println("Populate product method error" + f.toString());
            }
            deleteProduct.setOnAction(d -> {

                product.productList.remove(productToDelete);
                String sqlQuery = "delete from javauser.product where productid=\'" + productToDelete.getProductID() + "\'";
                sendDBCommand(sqlQuery);
                productData.removeAll(productData);
                for (product p : product.productList) {
                    productData.add(p);
                }
                productTable.setItems(productData);
                txtproductName.clear();
                txtproductDesc.clear();
                txtproductPrice.clear();
            });

            editProduct.setOnAction(f -> {

                String sqlQuery = "Update javauser.product set productname = '" + txtproductName.getText()
                        + "', description = '" + txtproductDesc.getText() + "',pricepaid = " + txtproductPrice.getText()
                        + " where productid =\'" + productToDelete.getProductID() + "\'";
                sendDBCommand(sqlQuery);
                txtproductName.clear();
                txtproductDesc.clear();
                txtproductPrice.clear();
            });
        });
        // Technician TAB------------------------------------------------------------------------------------------------------------------------
        technicianTab.setContent(technicianPane);
        technicianTab.setClosable(false);

        technicianPane.setVgap(10);
        technicianPane.setHgap(10);

        addTechnician.setOnAction(e -> {
            String ID = UUID.randomUUID().toString().substring(0, 8);
            technician new_tech = new technician(ID, txttechnicianfName.getText(),
                    txttechnicianlName.getText(),
                    txttechnicianNumber.getText());

            technician.technicianList.add(new_tech);

            // Database Integration Insert Statements
            String sqlQuery = "";
            sqlQuery += "insert into javauser.technician (technicianid, firstname, lastname, phoneNumber) values (";
            sqlQuery += "'" + ID + "',";
            sqlQuery += "'" + txttechnicianfName.getText() + "',";
            sqlQuery += "'" + txttechnicianlName.getText() + "',";
            sqlQuery += "'" + txttechnicianNumber.getText() + "')";
            sendDBCommand(sqlQuery);
            technicianData.add(new_tech);
            txttechnicianfName.clear();
            txttechnicianlName.clear();
            txttechnicianNumber.clear();

        });
        for (technician t : technician.technicianList) {
            technicianData.add(t);
        }

        technicianTable.setItems(technicianData);

        TableColumn TCOL1 = new TableColumn("Technician ID");
        TableColumn TCOL2 = new TableColumn("First Name");
        TableColumn TCOL3 = new TableColumn("Last Name");
        TableColumn TCOL4 = new TableColumn("Phone Number");
        TCOL1.setPrefWidth(160);
        TCOL2.setPrefWidth(160);
        TCOL3.setPrefWidth(160);
        TCOL4.setPrefWidth(160);
        TCOL1.setCellValueFactory(new PropertyValueFactory<technician, String>("technicianID"));
        TCOL2.setCellValueFactory(new PropertyValueFactory<technician, String>("firstName"));
        TCOL3.setCellValueFactory(new PropertyValueFactory<technician, String>("lastName"));
        TCOL4.setCellValueFactory(new PropertyValueFactory<technician, String>("phoneNumber"));

        technicianTable.getColumns().addAll(TCOL1, TCOL2, TCOL3, TCOL4);
        technicianTable.setMinWidth(600);
        technicianPane.add(technicianTable, 3, 0, 7, 8);
        technicianTable.setOnMouseClicked(t -> {
            // finds the index of the selected item in the tables
            int indexSelection = technicianTable.getSelectionModel().getSelectedIndex();
            technician technicianToDelete = technicianTable.getItems().get(indexSelection);

            try {
                String sqlQuery = "select * from javauser.technician where technicianid =\'" + technicianToDelete.getTechnicianID() + "\'";
                sendDBCommand(sqlQuery);
                dbResults.next();
                txttechnicianfName.setText(dbResults.getString(2));
                txttechnicianlName.setText(dbResults.getString(3));
                txttechnicianNumber.setText(dbResults.getString(4));

            } catch (Exception p) {
                System.out.println("Populate Technician method error" + p.toString());
            }

            deleteTechnician.setOnAction(p -> {

                technician.technicianList.remove(technicianToDelete);
                String sqlQuery = "delete from javauser.technician where technicianid=\'" + technicianToDelete.getTechnicianID() + "\'";
                sendDBCommand(sqlQuery);
                technicianData.removeAll(technicianData);
                for (technician c : technician.technicianList) {
                    technicianData.add(c);
                }
                technicianTable.setItems(technicianData);
                txttechnicianfName.clear();
                txttechnicianlName.clear();
                txttechnicianNumber.clear();

            });

            editTechnician.setOnAction(q -> {

                String sqlQuery = "Update javauser.technician set firstname = '" + txttechnicianfName.getText()
                        + "', lastname ='" + txttechnicianlName.getText() + "', phonenumber ='" + txttechnicianNumber.getText() + "'"
                        + "where technicianid =\'" + technicianToDelete.getTechnicianID() + "\'";
                sendDBCommand(sqlQuery);
                txttechnicianfName.clear();
                txttechnicianlName.clear();
                txttechnicianNumber.clear();
            });

        });

        
        //setting for store tab----------------------------------------------------------------------------------------------------------------------------------------------                                       
        GridPane storePane = new GridPane();
        StoreTab.setContent(storePane);
       

        storePane.setVgap(10);
        storePane.setHgap(10);
       Label lblstoreName = new Label("Store Name");                                                                
            Label lblzipCode = new Label("Store Zipcode");
            TextField txtstoreName = new TextField();
            TextField txtzipCode = new TextField();

            Button addStore = new Button("Add Store");
            storePane.add(lblstoreName, 0, 0);
            storePane.add(txtstoreName, 1, 0);
            storePane.add(lblzipCode, 0, 1);
            storePane.add(txtzipCode, 1, 1);
            storePane.add(addStore, 0, 2);

        addStore.setOnAction(e -> {
          String ID = UUID.randomUUID().toString().substring(0, 8);
                                                                    String SID = UUID.randomUUID().toString().substring(0, 8);
                                                                    store new_store = new store(ID, txtstoreName.getText(), txtzipCode.getText());
                                                                    storeData.add(new_store);
                                                                    store.storeList.add(new_store);
                                                                            String sqlQuery = "";
            // Database Integration Insert Statements
            sqlQuery += "insert into javauser.store (storeid, storename, zipcode) values (";
                                                                sqlQuery += "'" + ID + "',";
                                                                sqlQuery += "'" + txtstoreName.getText() + "',";
                                                                sqlQuery += "'" + txtzipCode.getText() + "')";
                                                                sendDBCommand(sqlQuery);
                                                                txtstoreName.clear();
                                                                txtzipCode.clear();
    
        });

         for (store o : store.storeList) {
            storeData.add(o);
             }
        storeTable.setItems(storeData);

                                                TableColumn STCOL1 = new TableColumn("Store ID");
      
                                                TableColumn STCOL2 = new TableColumn("Store Name");
                                                TableColumn STCOL3 = new TableColumn("Zipcode");
                                                    STCOL1.setPrefWidth(200);
                                                    STCOL2.setPrefWidth(200);
                                                    STCOL3.setPrefWidth(200);
                                                STCOL1.setCellValueFactory(new PropertyValueFactory<store, String>("storeID"));
                                                STCOL2.setCellValueFactory(new PropertyValueFactory<store, String>("storeName"));
                                                STCOL3.setCellValueFactory(new PropertyValueFactory<store, String>("zipcode"));

        storeTable.getColumns().addAll(STCOL1, STCOL2, STCOL3);
        storeTable.setMinWidth(600);
        storePane.add(storeTable, 3, 0, 7, 8);
            storePane.add(deleteStore, 4, 8);
        storePane.add(editStore, 5, 8);
        StoreTab.setClosable(false);
        storePane.setPadding(new Insets(20, 20, 20, 20));
        storeTable.setOnMouseClicked(t -> {
            // finds the index of the selected item in the tables
            int indexSelection = storeTable.getSelectionModel().getSelectedIndex();
            store storeToDelete = storeTable.getItems().get(indexSelection);

            try {
                String sqlQuery = "select * from javauser.store where storeid =\'" + storeToDelete.getStoreID() + "\'";
                sendDBCommand(sqlQuery);
                dbResults.next();
                txtstoreName.setText(dbResults.getString(2));
                txtzipCode.setText(dbResults.getString(3));

            } catch (Exception p) {
                System.out.println("Populate store method error" + p.toString());
            }

            deleteStore.setOnAction(p -> {

                store.storeList.remove(storeToDelete);
                String sqlQuery = "delete from javauser.store where storeid=\'" + storeToDelete.getStoreID()+ "\'";
                sendDBCommand(sqlQuery);
                storeData.removeAll(storeData);
                for (store st : store.storeList) {
                    storeData.add(st);
                }
                storeTable.setItems(storeData);
                txtstoreName.clear();
                txtzipCode.clear();

            });

            editStore.setOnAction(q -> {

                String sqlQuery = "Update javauser.store set storename = '" + txtstoreName.getText()
                        + "', zipcode ='" + txtzipCode.getText() + "'"
                        + "where technicianid =\'" + storeToDelete.getStoreID()+ "\'";
                sendDBCommand(sqlQuery);
           txtstoreName.clear();
                txtzipCode.clear();
            });

        });

                                                               
                        
    }

    public void returningCustomer() {
        //setting for the window
        Stage loginStage = new Stage();
        FlowPane loginPortal = new FlowPane();
        loginPortal.setAlignment(Pos.CENTER);
        loginPortal.setHgap(10);
        Scene loginScene = new Scene(loginPortal, 400, 100);
        loginStage.setScene(loginScene);
        loginStage.setTitle("Login Portal");
        loginStage.show();
        Label userName = new Label();
        TextField txtUserName = new TextField();
        Button logOn = new Button("Login");
        Label custID = new Label("Customer ID");
        GridPane returningCustomerPane = new GridPane();
        loginPortal.getChildren().addAll(custID, userName, txtUserName, logOn);
        //LOG IN FUNCTIONALITY ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        logOn.setOnAction(log -> {
            loginStage.hide();

            for (customer m : customer.customerList) {
                if (m.getCustomerID().toLowerCase().matches(txtUserName.getText().toLowerCase())) {
                    returningCustomerPane.setAlignment(Pos.CENTER);
                    Stage returningCustomerStage = new Stage();
                    Scene returningCustomerScene = new Scene(returningCustomerPane, 1100, 700);
                    returningCustomerPane.setVgap(10);
                    returningCustomerPane.setHgap(10);
                    Button submitRequest = new Button("Send a Service Request");
                    submitRequest.setOnAction(h -> {
                        customerForm n = new customerForm();
                        n.window();

                        Date dateSub = new Date();
                        service newTransaction = new service(m.getCustomerID(), n.txtIssue.getText(),
                                dateSub, "NO", m.firstName, m.lastName, m.phoneNumber, m.address,
                                m.city, m.state, m.zipCode);
                        service.serviceList.add(newTransaction);
                        serviceData.add(newTransaction);
                        //clearing text inside the textfield 
                        n.txtIssue.clear();
                        n.txtcustomerPhone.clear();
                        n.txtcustomerfName.clear();
                        n.txtcustomerlName.clear();

                    });
                    for (service ser : service.serviceList) {
                        serviceData.add(ser);
                    }
                    serviceTable.setItems(serviceData);

                    TableColumn COL2 = new TableColumn("First Name");
                    TableColumn COL3 = new TableColumn("Last Name");
                    TableColumn COL4 = new TableColumn("Description");
                    TableColumn COL5 = new TableColumn("Service Completed");

                    COL2.setCellValueFactory(new PropertyValueFactory<service, String>("firstName"));
                    COL3.setCellValueFactory(new PropertyValueFactory<service, String>("lastName"));
                    COL4.setCellValueFactory(new PropertyValueFactory<service, String>("description"));
                    COL5.setCellValueFactory(new PropertyValueFactory<service, String>("completed"));

                    serviceTable.getColumns().addAll(COL2, COL3, COL4, COL5);
                    serviceTable.setMinWidth(400);
                    COL2.setMinWidth(100);
                    COL3.setMinWidth(100);
                    COL4.setMinWidth(300);
                    COL5.setMinWidth(150);// end of lamda expression 
                    Label custInfo = new Label(m.toString());
                    returningCustomerStage.setTitle("Welcome Back " + m.firstName + " " + m.lastName);

                    returningCustomerStage.setScene(returningCustomerScene);
                    returningCustomerStage.show();
                    returningCustomerPane.add(submitRequest, 2, 1);
                    returningCustomerPane.add(serviceTable, 2, 0);
//                              returningCustomerPane.add(custInfo, 3, 0);
                }
            }
        });

        //inner join table showing products puchased by this customer----------------------------------------------
//            TableView<sale> salesTable = new TableView<>();
//            ObservableList<sale> saleData = FXCollections.observableArrayList();
//              for(sale g : sale.salelist)
//            {
//                saleData.add(g);
//            }
//              TableColumn PCOL1 = new TableColumn("Product Name");
//                TableColumn PCOL2 = new TableColumn("Product Price");
//                
//                PCOL1.setCellValueFactory(new PropertyValueFactory<sale, String>("productname"));
//                PCOL2.setCellValueFactory(new PropertyValueFactory<sale, String>("pricePaid"));
//            
//            salesTable.getColumns().addAll(PCOL1,PCOL2);
//            salesTable.setMinWidth(200);
//            PCOL1.setMinWidth(200);
//            PCOL2.setMinWidth(200);
//                        returningCustomerPane.add(salesTable, 3, 0);
        //SHOWING PRODUCT TABLE FOR CUSTOMER TO PRUCHASE FROM ---------------------------------------------
        for (product j : product.productList) {
            productData.add(j);
        }
        productTable.setItems(productData);
        Button buy = new Button("Buy item");

        TableColumn ProCOL1 = new TableColumn("Product Name");
        TableColumn ProCOL2 = new TableColumn("Product Description");

        ProCOL1.setCellValueFactory(new PropertyValueFactory<product, String>("productName"));
        ProCOL2.setCellValueFactory(new PropertyValueFactory<product, String>("description"));

        productTable.getColumns().addAll(ProCOL1, ProCOL2);
        productTable.setMinWidth(200);
        ProCOL1.setMinWidth(200);
        ProCOL2.setMinWidth(200);

        returningCustomerPane.add(productTable, 1, 0);
        returningCustomerPane.add(buy, 1, 1);
    }

    public void returningSupplier() {
        GridPane returningCustomerPane = new GridPane();
        Stage loginStage = new Stage();
        FlowPane loginPortal = new FlowPane();
        loginPortal.setAlignment(Pos.CENTER);
        loginPortal.setHgap(10);
        Scene loginScene = new Scene(loginPortal, 400, 100);
        loginStage.setScene(loginScene);
        loginStage.setTitle("Login Portal");
        loginStage.show();
        Label userName = new Label();
        TextField txtUserName = new TextField();
        Button logOn = new Button("Login");
        Label custID = new Label("Supplier ID");
        loginPortal.getChildren().addAll(custID, userName, txtUserName, logOn);
        for (product j : product.productList) {
            productData.add(j);

        }

        productTable.setItems(productData);
        Button buy = new Button("Buy item");

        TableColumn ProCOL1 = new TableColumn("Product Name");
        TableColumn ProCOL2 = new TableColumn("Product Description");

        ProCOL1.setCellValueFactory(new PropertyValueFactory<product, String>("productName"));
        ProCOL2.setCellValueFactory(new PropertyValueFactory<product, String>("description"));

        productTable.getColumns().addAll(ProCOL1, ProCOL2);
        productTable.setMinWidth(200);
        ProCOL1.setMinWidth(200);
        ProCOL2.setMinWidth(200);

        returningCustomerPane.add(productTable, 1, 0);

        logOn.setOnAction(log -> {
            for (supplier m : supplier.supplierList) {
                if (m.getSupplierID().toLowerCase().matches(txtUserName.getText().toLowerCase())) {
                    returningCustomerPane.setAlignment(Pos.CENTER);
                    returningCustomerPane.setHgap(20);
                    Stage returningCustomerStage = new Stage();
                    Scene returningCustomerScene = new Scene(returningCustomerPane, 1100, 700);

                    Button submitRequest = new Button("Send a Request");
                    Label custInfo = new Label(m.toString());

                    for (supplier s : supplier.supplierList) {
                        supplierData.add(s);
                    }

                    returningCustomerStage.setScene(returningCustomerScene);
                    returningCustomerStage.show();
                    returningCustomerStage.setTitle("Welcome Back " + m.supplierName);

                }

            }

        });

    }

    public void supplier() {
        //setting prompt texts inside textfields 
        txtcustomerfName.setPromptText("Company Name");
        txtcustomerfName.setFocusTraversable(false);

        // placing labels
        customerPane.add(supplierName, 0, 0);
        customerPane.add(supplierStreet, 0, 1);
        customerPane.add(supplierCity, 0, 2);
        customerPane.add(supplierState, 0, 3);
        customerPane.add(supplierZip, 0, 4);
        customerPane.add(supplierPhone, 0, 5);
        customerPane.add(register, 0, 6);

        customerPane.add(txtsupplierName, 1, 0);
        customerPane.add(txtsupplierStreet, 1, 1);
        customerPane.add(txtsupplierCity, 1, 2);
        customerPane.add(txtsupplierState, 1, 3);
        customerPane.add(txtsupplierZip, 1, 4);
        customerPane.add(txtSupplierPhone, 1, 5);

        //main scene 
        //window setting
        customerPane.setVgap(10);
        customerPane.setHgap(10);
        customerPane.setPadding(new Insets(20, 20, 20, 20));
        Scene scene = new Scene(customerPane, 500, 300);
        customerPane.setPadding(new Insets(20, 20, 20, 20));
        primaryStage.setTitle("VENT");
        primaryStage.setScene(scene);
        tPane.setMinHeight(scene.getHeight());
        tPane.setMinWidth(scene.getWidth());
        primaryStage.show();
        register.setOnAction(register
                -> {
            String ID = UUID.randomUUID().toString().substring(0, 8);

            supplier newSupplier = new supplier(ID, txtsupplierName.getText(),
                    txtsupplierStreet.getText(), txtsupplierCity.getText(), txtsupplierState.getText(), txtsupplierZip.getText(), txtSupplierPhone.getText());
            supplierData.add(newSupplier);
            supplier.supplierList.add(newSupplier);
            Label update = new Label("Thank You for Registering, your username is " + newSupplier.getSupplierID());
            //clearing text inside the textfield 
            txtcustomerfName.clear();
            txtcustomerlName.clear();
            txtcustomerPhone.clear();
            txtcustomerStreet.clear();
            txtcustomerCity.clear();
            txtcustomerState.clear();
            txtcustomerZip.clear();
            customerPane.add(update, 1, 6, 3, 1);
        });
    }

    public void technician() {

        Stage tLoginStage = new Stage();
        FlowPane tLoginPortal = new FlowPane();
        tLoginPortal.setAlignment(Pos.CENTER);
        tLoginPortal.setHgap(10);
        Scene tLoginScene = new Scene(tLoginPortal, 400, 100);

        tLoginStage.setScene(tLoginScene);
        tLoginStage.setTitle("Login Portal");
        tLoginStage.show();
        TextField tTextUserName = new TextField();

        Button tLogOn = new Button("Login");
        Label tTechnicianId = new Label("Technician ID");
        tLoginPortal.getChildren().addAll(tTechnicianId, tTextUserName, tLogOn);

        GridPane mainTechnicianPane = new GridPane();

        Stage tStage = new Stage();

        tLogOn.setOnAction(log -> {
            for (technician m : technician.technicianList) {
                if (m.getTechnicianID().toLowerCase().matches(tTextUserName.getText().toLowerCase())) {

                    Scene tTechnicianPortal = new Scene(mainTechnicianPane, 1100, 700);

                    tStage.setScene(tTechnicianPortal);
                    tStage.show();
                    tStage.setTitle("Welcome Back " + m.firstName + " " + m.lastName);

                }

            }

        });

        for (service s : service.serviceList) {
            serviceData.add(s);
        }

        TableColumn COL1 = new TableColumn("Service ID");
        TableColumn COL2 = new TableColumn("Customer First Name");
        TableColumn COL3 = new TableColumn("Customer Last Name");
        TableColumn COL4 = new TableColumn("Address");
        TableColumn COL5 = new TableColumn("city");
        TableColumn COL6 = new TableColumn("state");
        TableColumn COL7 = new TableColumn("zip");
        TableColumn COL8 = new TableColumn("Customer Phone Number");
        TableColumn COL9 = new TableColumn("Problem Description");

        COL1.setCellValueFactory(new PropertyValueFactory<service, String>("serviceID"));
        COL2.setCellValueFactory(new PropertyValueFactory<customer, String>("firstName"));
        COL3.setCellValueFactory(new PropertyValueFactory<customer, String>("lastName"));
        COL4.setCellValueFactory(new PropertyValueFactory<customer, String>("address"));
        COL5.setCellValueFactory(new PropertyValueFactory<customer, String>("city"));
        COL6.setCellValueFactory(new PropertyValueFactory<customer, String>("state"));
        COL7.setCellValueFactory(new PropertyValueFactory<customer, String>("zipCode"));
        COL8.setCellValueFactory(new PropertyValueFactory<customer, String>("phoneNumber"));
        COL9.setCellValueFactory(new PropertyValueFactory<service, String>("description"));

        serviceTable.getColumns().addAll(COL1, COL2, COL3, COL4, COL5, COL6, COL7, COL8, COL9);
        serviceTable.setMinWidth(700);
        serviceTable.setItems(serviceData);
        mainTechnicianPane.add(serviceTable, 0, 0);
    }
    Connection dbConn;
    java.sql.Statement commStmt;
    ResultSet dbResults;

    public void sendDBCommand(String sqlQuery) {
        // Set up your connection strings
        // IF YOU ARE IN CIS330 NOW: use YOUR Oracle Username/Password
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String userID = "javauser"; // Change to YOUR Oracle username
        String userPASS = "javapass"; // Change to YOUR Oracle password
        OracleDataSource ds;

        // Clear Box Testing - Print each query to check SQL syntax
        //  sent to this method.
        // You can comment this line out when your program is finished
        System.out.println(sqlQuery);

        // Lets try to connect
        try {
            // instantiate a new data source object
            ds = new OracleDataSource();
            // Where is the database located? Web? Local?
            ds.setURL(URL);
            // Send the user/pass and get an open connection.
            dbConn = ds.getConnection(userID, userPASS);
            // When we get results
            //  -TYPE_SCROLL_SENSITIVE means if the database data changes we
            //   will see our resultset update in real time.
            //  -CONCUR_READ_ONLY means that we cannot accidentally change the
            //   data in our database by using the .update____() methods of
            //   the ResultSet class - TableView controls are impacted by
            //   this setting as well.
            commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // We send the query to the DB. A ResultSet object is instantiated
            //  and we are returned a reference to it, that we point to from
            // dbResults.
            // Because we declared dbResults at the datafield level
            // we can see the results from anywhere in our Class.
            dbResults = commStmt.executeQuery(sqlQuery); // Sends the Query to the DB
            // The results are stored in a ResultSet structure object
            // pointed to by the reference variable dbResults
            // Because we declared this variable globally above, we can use
            // the results in any method in the class.
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
