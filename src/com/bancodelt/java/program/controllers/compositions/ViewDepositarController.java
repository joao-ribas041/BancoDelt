package com.bancodelt.java.program.controllers.compositions;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class ViewDepositarController implements Initializable {

    @FXML
    private FlowPane Titulo;
    @FXML
    private TextField txtFValor;
    @FXML
    private TextField txtFConta;
    @FXML
    private Button btnDepositar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnDepositarAction(ActionEvent event) {
    }
    
}
