package com.bancodelt.java.program.controllers.compositions;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class ViewPixPagarController implements Initializable {

    @FXML
    private FlowPane Titulo;
    @FXML
    private TextField txtFValor;
    @FXML
    private HBox hboxChave;
    @FXML
    private Label lblChave;
    @FXML
    private TextField txtFChave;
    @FXML
    private Button btnPAGARPIX;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void btnPagarPIXAction(ActionEvent event) {
    }
    
}
