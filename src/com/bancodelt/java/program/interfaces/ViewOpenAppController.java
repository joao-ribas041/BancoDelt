package com.bancodelt.java.program.interfaces;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author João Ribas
 */
public class ViewOpenAppController implements Initializable {

    @FXML
    private Button btnEntrar;
    @FXML
    private TextField txtFCPF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
