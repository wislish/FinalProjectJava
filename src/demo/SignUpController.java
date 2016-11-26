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
public class SignUpController implements Initializable{

   
    //private StageController myController;
    private Main application;
    @FXML
    private TextField Textfield_UserID_SignUp;
    @FXML
    private TextField Textfield_Password_SignUp;
    @FXML
    private TextField Textfield_ConfirmPassword;
    @FXML
    public Label Label_ErrorMessage_SignUp;
    @FXML
    private Button Button_Reset_SignUp;
    @FXML
    private Button Button_Submit_SignUp;
    @FXML
    private Button Button_Back_SignUp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void Reset_SignUpAction(ActionEvent event) {
        Textfield_UserID_SignUp.setText("");
   
        Textfield_Password_SignUp.setText("");
    
        Textfield_ConfirmPassword.setText("");
    }

    @FXML
    private void submit_SignUpAction(ActionEvent event) {
        //Textfield_UserID_SignUp.setText(main.getSignInUserID());
    }

   

    @FXML
    private void backAction(ActionEvent event) {
         application.gotoSignIn();
        
    }
    
   

    void setApp(Main application) {
        this.application = application;//To change body of generated methods, choose Tools | Templates.
    }
    
}
