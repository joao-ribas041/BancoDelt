package com.bancodelt.java.program.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ViewPrincipalAppController implements Initializable {

    @FXML
    private AnchorPane TelaPrincipalApp;
    @FXML
    private Label lblSaldo;
    @FXML
    private Label lblPix;
    @FXML
    private Label lblTransferir;
    @FXML
    private Label lblDepositar;
    @FXML
    private Label lblExtrato;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
}
