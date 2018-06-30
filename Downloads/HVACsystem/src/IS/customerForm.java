/*
Authors: Moe yaziji, Grey Steinberg
DATE: 5/21/2018
PURPOSE: This class calls a window class form and allows user to submit a form for the 
service request
*/
package IS;

import java.awt.Color;
import javafx.scene.image.Image ;
import java.util.*; 

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class customerForm {

    
    Stage pStage = new Stage ();
    Label introMessage = new Label();
    GridPane customerPane = new GridPane();
    Scene s= new Scene (customerPane, 580,140);
    
        Label customerName = new Label("Name");    
    Label customerPhone = new Label("Phone Number");
    Label issue = new Label("Issue");
    
    TextField txtcustomerfName = new TextField();
    TextField txtcustomerlName = new TextField();
    TextField txtcustomerPhone = new TextField();
    TextField txtIssue = new TextField();

    public void window()
    {
//       customerPane.setStyle("-fx-background: #FFFFFF");
          s.getStylesheets().add("file:/Users/moeyaziji/Desktop/HVACsystem/src/IS/CascadeStyleSheet.css");
            ImageView logo= new ImageView (new Image("file:images/logo.png"));
            logo.setFitWidth(300);
            logo.setFitHeight(70);
//            customerPane.getChildren().add(logo);
                      customerPane.add(logo, 3, 0,3,3);

        
               
         
        Label message = new Label("Please complete the fields below");
        message.setId("message");
        
        customerPane.setPadding(new Insets(30,30,30,30));
        customerPane.setVgap(10);
        customerPane.setHgap(10);
           //customer tab nodes


    
    txtcustomerfName.setPromptText("FirstName");
    
    txtcustomerfName.setFocusTraversable(false);
    txtcustomerlName.setPromptText("Last Name");
    txtcustomerlName.setFocusTraversable(false);
    txtcustomerPhone.setPromptText("212-746-8268");
    txtcustomerPhone.setFocusTraversable(false);
    txtIssue.setPromptText("Ex: Air conditioning");
    txtIssue.setFocusTraversable(false);
    Button sendRequest = new Button("Submit Issue");
         // placing labels
            //customer
        
   
            customerPane.add(customerPhone, 0, 0);
            customerPane.add(issue, 0, 1);

            customerPane.add(sendRequest, 0, 2);
            
                
            //technician
            
            
        //placing textfields
            //customer
        
            customerPane.add(txtcustomerPhone, 1, 0);
            customerPane.add(txtIssue, 1, 1);
            
            
        pStage.setScene(s);
        pStage.setTitle("VENT");
        sendRequest.setOnAction(e-> { 
         
        });
        pStage.show();
    
        
    }
    
}
