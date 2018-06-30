/*
Authors: Moe yaziji, Grey Steinberg
DATE: 5/21/2018
PURPOSE: this is the main program, it calls other windows and functions and uses database integration to reload data from database
*/
package IS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
//import oracle.jdbc.pool.OracleDataSource;

public class HVAC_IS extends Application {

    @Override
    public void start(Stage primaryStage) {
        FlowPane top = new FlowPane();
        Stage pStage = new Stage();
        Label introMessage = new Label();
        FlowPane pane = new FlowPane();
        Scene s = new Scene(pane, 800, 500);

        Button returningCustomer = new Button("Returning Customer");
        Button newCustomer = new Button("New Customer");

        Button admin = new Button("Admin");
        Button technicianButton = new Button("Technician");
        Button returningsupplier = new Button("Returning Supplier");
        returningsupplier.setId("returningsupplier");
        Button newSupplier = new Button("New Supplier");

        s.getStylesheets().add("file:../HVACsystem/src/IS/CascadeStyleSheet.css");
        ImageView logo = new ImageView(new Image("file:images/logo.png"));
        logo.setFitWidth(300);
        logo.setFitHeight(70);

        pane.setVgap(20);
        pane.setHgap(20);
//        pStage.getIcons().add(new Image("file:images/logo.png")); 
        String brandName = "VENT";
        pStage.setTitle(brandName);
        pane.getChildren().addAll(returningCustomer, newCustomer, admin, technicianButton, newSupplier, returningsupplier);

        returningCustomer.setId("returningCustomer");
        newCustomer.setId("newCustomer");
        admin.setId("admin");
        technicianButton.setId("TechnicianButton");
        newSupplier.setId("newSupplier");

        returningCustomer.setMinHeight(200);
        newCustomer.setMinHeight(200);
        admin.setMinHeight(200);
        technicianButton.setMinHeight(200);
        returningsupplier.setMinHeight(200);
        newSupplier.setMinHeight(200);

        returningCustomer.setMinWidth(250);
        newCustomer.setMinWidth(250);
        admin.setMinWidth(250);
        technicianButton.setMinWidth(250);
        returningsupplier.setMinWidth(250);
        newSupplier.setMinWidth(250);

        top.setMinHeight(40);
        top.setMinWidth(50);

        pane.setAlignment(Pos.CENTER);
        top.setAlignment(Pos.CENTER);
        top.getChildren().add(logo);

        pStage.setScene(s);
        pStage.show();

        returningCustomer.setOnAction(t -> {
            window r = new window();
            r.returningCustomer();

        });

        admin.setOnAction(t -> {
            window adminWindow = new window();
            adminWindow.admin();

        });

        newCustomer.setOnAction(h -> {
            window customerWindow = new window();
            customerWindow.customer();
        });

        technicianButton.setOnAction(j -> {
            window tech = new window();
            tech.technician();
        });

        newSupplier.setOnAction(n -> {
            window supplierWindow = new window();
            supplierWindow.supplier();

        });
        returningsupplier.setOnAction(u -> {

            window returning = new window();
            returning.returningSupplier();
        });

//        db();
    }

    public static void main(String[] args) {
        launch(args);
    }

//    public void db() {
//   try {
//            String sqlQuery = "SELECT * FROM javauser.product";
//            sendDBCommand(sqlQuery);
//            try {
//                while (dbResults.next()) {
//
//                    product newProduct = new product(dbResults.getString(1),dbResults.getString(4), dbResults.getString(3),
//                            dbResults.getString(2), dbResults.getString(5));
//                    product.productList.add(newProduct);
//
//                }
//            } catch (SQLException sqle) {
//                System.out.print(sqle.toString());
//            }
//
//        } catch (Exception m) {
//            System.out.print(m.toString());
//        }
//        // recreating customer instance objects    
//        try {
//            String sqlQuery = "SELECT * FROM javauser.customer";
//            sendDBCommand(sqlQuery);
//            try {
//                while (dbResults.next()) {
//
//                    customer newcustomer = new customer(dbResults.getString(1),dbResults.getString(2), dbResults.getString(3),
//                            dbResults.getString(4),
//                            dbResults.getString(5), dbResults.getString(6),
//                            dbResults.getString(7), dbResults.getString(8));
//                    customer.customerList.add(newcustomer);
//
//                }
//            } catch (SQLException sqle) {
//                System.out.print(sqle.toString());
//            }
//
//        } catch (Exception m) {
//            System.out.print(m.toString());
//        }
//        // recreating supplier instance objects    
//
//        try {
//            String sqlQuery = "SELECT * FROM javauser.supplier";
//            sendDBCommand(sqlQuery);
//            try {
//                while (dbResults.next()) {
//
//                    supplier newSupplier = new supplier(dbResults.getString(1), dbResults.getString(2), dbResults.getString(3),
//                            dbResults.getString(4),
//                            dbResults.getString(5), dbResults.getString(6),
//                            dbResults.getString(7));
//                    
//                    supplier.supplierList.add(newSupplier);
//
//                }
//            } catch (SQLException sqle) {
//                System.out.print(sqle.toString());
//            }
//
//        } catch (Exception m) {
//            System.out.print(m.toString());
//        }
//        // recreating technician instance objects    
//        try {
//            String sqlQuery = "SELECT * FROM javauser.technician";
//            sendDBCommand(sqlQuery);
//            try {
//                while (dbResults.next()) {
//
//                    technician newTechnician = new technician(dbResults.getString(1),dbResults.getString(2), dbResults.getString(3),
//                            dbResults.getString(4));
//                    technician.technicianList.add(newTechnician);
//
//                }
//            } catch (SQLException sqle) {
//                System.out.print(sqle.toString());
//            }
//
//        } catch (Exception m) {
//            System.out.print(m.toString());
//        }
//        
//         try {
//            String sqlQuery = "SELECT * FROM javauser.store";
//            sendDBCommand(sqlQuery);
//            try {
//                while (dbResults.next()) {
//
//                    store newStore = new store(dbResults.getString(1),dbResults.getString(2), dbResults.getString(3));
//          
//                    store.storeList.add(newStore);
//
//                }
//            } catch (SQLException sqle) {
//                System.out.print(sqle.toString());
//            }
//
//        } catch (Exception m) {
//            System.out.print(m.toString());
//        }
//    }
////    Connection dbConn;
////    Statement commStmt;
////    ResultSet dbResults;
////
////    public void sendDBCommand(String sqlQuery) {
//        // Set up your connection strings
//        // IF YOU ARE IN CIS330 NOW: use YOUR Oracle Username/Password
//        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
//        String userID = "javauser"; // Change to YOUR Oracle username
//        String userPASS = "javapass"; // Change to YOUR Oracle password
//        OracleDataSource ds;
//
//        // Clear Box Testing - Print each query to check SQL syntax
//        //  sent to this method.
//        // You can comment this line out when your program is finished
//        System.out.println(sqlQuery);
//
//        // Lets try to connect
//        try {
//            // instantiate a new data source object
//            ds = new OracleDataSource();
//            // Where is the database located? Web? Local?
//            ds.setURL(URL);
//            // Send the user/pass and get an open connection.
//            dbConn = ds.getConnection(userID, userPASS);
//            // When we get results
//            //  -TYPE_SCROLL_SENSITIVE means if the database data changes we
//            //   will see our resultset update in real time.
//            //  -CONCUR_READ_ONLY means that we cannot accidentally change the
//            //   data in our database by using the .update____() methods of
//            //   the ResultSet class - TableView controls are impacted by
//            //   this setting as well.
//            commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            // We send the query to the DB. A ResultSet object is instantiated
//            //  and we are returned a reference to it, that we point to from
//            // dbResults.
//            // Because we declared dbResults at the datafield level
//            // we can see the results from anywhere in our Class.
//            dbResults = commStmt.executeQuery(sqlQuery); // Sends the Query to the DB
//            // The results are stored in a ResultSet structure object
//            // pointed to by the reference variable dbResults
//            // Because we declared this variable globally above, we can use
//            // the results in any method in the class.
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        }
//    }

}
