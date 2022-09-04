package com.bancodelt.java.program.controllers;

import com.bancodelt.java.program.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewLoginAppController implements Initializable {

    @FXML
    private ImageView btnVoltar;
    @FXML
    private TextField txtFCPF;
    @FXML
    private TextField txtFSenha;
    @FXML
    private Button btnEntrar;
    
    Main m = new Main();
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private HBox hboxlogin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   

    @FXML
    private void AcaoBtnEntrar(ActionEvent event) {
    }
    
    
    private void MouseBarEvents() {
        btnVoltar.setOnMouseEntered((event) -> {
            btnVoltar.setFitWidth(30);
            btnVoltar.setFitHeight(30);
        });
        btnVoltar.setOnMouseExited((event) -> {
            btnVoltar.setFitWidth(20);
            btnVoltar.setFitHeight(20);
        });
        btnVoltar.setOnMouseClicked((event) -> {
            Main.getProgram().close();
        });
        
    }
}
