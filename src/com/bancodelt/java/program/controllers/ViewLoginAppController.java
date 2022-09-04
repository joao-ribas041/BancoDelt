package com.bancodelt.java.program.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ViewLoginAppController implements Initializable {

    @FXML
    private ImageView btnVoltar;
    @FXML
    private TextField txtFCPF;
    @FXML
    private TextField txtFSenha;
    @FXML
    private Button btnEntrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MouseBarEvents();
    }   

    @FXML
    private void AcaoBtnEntrar(ActionEvent event) {
    }
    
        private void MouseBarEvents(){
        btnVoltar.setOnMouseEntered((event) -> {
            btnVoltar.setFitWidth(30);
            btnVoltar.setFitHeight(30);
        });
        btnVoltar.setOnMouseExited((event) -> {
            btnVoltar.setFitWidth(20);
            btnVoltar.setFitHeight(20);
        });
        btnVoltar.setOnMouseClicked((event) -> {
            
        });
    }
}
