package com.bancodelt.java.program.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ViewPrincipalAppController implements Initializable {

    @FXML
    private Label lblSaldo;
    @FXML
    private Label lblRS;
    @FXML
    private ImageView btnViewHide;
    @FXML
    private AnchorPane Painel;
    @FXML
    private VBox MenuSlider;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnSacar;
    @FXML
    private Button btnDepositar;
    @FXML
    private Button btnPix;
    @FXML
    private Button btnDeslogar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}
