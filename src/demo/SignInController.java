/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ShengLAN
 */
public class SignInController implements Initializable{
    
    
  
    private Main application;
    
    @FXML
    private Label Lable_UserID_Log;
    @FXML
    public TextField Textfield_UserID_Log;
    @FXML
    private Label Lable_Password_Log;
    @FXML
    private TextField Textfield_Password_Log;
    @FXML
    private Button Button_SignUp_Log;
    @FXML
    private Button Button_SignIn_Log;
    
    @FXML
    private Label Label_Welcome_LoginIn;
    @FXML
    private Label Label_Error_Message;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void setApp(Main application) {
        this.application = application;
    }
    
    

    @FXML
    private void sighUpAction(ActionEvent event) {
        System.out.println("clicked sigh up button");
//        if (application == null){
//            return;
//        }
        application.gotoSignUp();
        //myController.setStage(MainApp.signUpID, MainApp.signInID);
    }

    @FXML
    private void signInAction(ActionEvent event) {
        System.out.println("clicked sign in button");
        if (application == null){
            System.out.println("No Application");
            return;
        }
        application.gotoProfessorMainFunction();
//        if (application == null){
//            // We are running in isolated FXML, possibly in Scene Builder.
//            // NO-OP.
//            Label_Error_Message.setText("Hello " + Textfield_UserID_Log.getText());
//        } else {
//            if (!application.userLogging(Textfield_UserID_Log.getText(), Textfield_Password_Log.getText())){
//                Label_Error_Message.setText("Username/Password is incorrect");
//            }
//        }
        //this.init(main);
        //main.initialize();
        
        //main.getSignInUserID();
        //myController.setStage(MainApp.professorMainFunctionID, MainApp.signInID);
    }
    
    public void processLogin(ActionEvent event) {
        if (application == null){
            // We are running in isolated FXML, possibly in Scene Builder.
            // NO-OP.
            Label_Error_Message.setText("Hello " + Textfield_UserID_Log.getText());
        } else {
            if (!application.userLogging(Textfield_UserID_Log.getText(), Textfield_Password_Log.getText())){
                Label_Error_Message.setText("Username/Password is incorrect");
            }
        }
    }



   
    
}
