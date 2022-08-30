package com.bancodelt.java.program.controllers;

import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.program.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class ViewOpenAppController implements Initializable {

    @FXML
    private Button btnEntrar;
    @FXML
    private TextField txtFCPF;
    @FXML
    private AnchorPane TelaPrincipalApp;
    
    AlertWarningPrototype alertaAviso = new AlertWarningPrototype();
    Parent telaCadastro;
    @FXML
    private StackPane stckViews;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void AcaoBtnEntrar(ActionEvent event) throws IOException {
        CheckACC();
    }
    
    private void CheckACC() throws IOException {            
        if (txtFCPF.getText().isEmpty()) {
            alertaAviso.setTitulo("Alerta");
            alertaAviso.setMsgPrincipal("Informe o CPF!");
            alertaAviso.setSubMsg("O campo CPF esta vazio. Por favor informe o CPF");
            alertaAviso.exibirAlert();
        } else {
            telaCadastro = FXMLLoader.load(getClass().getResource(Main.getDirectoryJavaInterfaces() + "ViewCadastrarApp.fxml"));
            stckViews.getChildren().add(telaCadastro);
        }
    }
}
