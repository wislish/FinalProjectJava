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

/**
 * FXML Controller class
 *
 * @author ShengLAN
 */
public class ProfessorMainFunctionController implements Initializable {
    private Main application;
    @FXML
    private Button Button_ImportCSV;
    @FXML
    private Button Button_GetStudPer;
    @FXML
    private Button Button_Back_ProfessorMainFun;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void importCSVAction(ActionEvent event) {
    }

    @FXML
    private void getStudPerAction(ActionEvent event) {
        application.gotoStudPerFunction();
    
    }

   

    @FXML
    private void backAction(ActionEvent event) {
        application.gotoSignIn();
    }

    void setApp(Main application) {
        this.application = application;
    
    }
    
    
    
}
