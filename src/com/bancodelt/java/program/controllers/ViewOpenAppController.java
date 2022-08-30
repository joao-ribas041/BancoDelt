package com.bancodelt.java.program.controllers;

import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class ViewOpenAppController implements Initializable {

    @FXML
    private Button btnEntrar;
    @FXML
    private TextField txtFCPF;
    
    AlertWarningPrototype alertaAviso = new AlertWarningPrototype();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void AcaoBtnEntrar(ActionEvent event) {
        CheckACC();
    }
    
    private void CheckACC() {            
        if (txtFCPF.getText().isEmpty()) {
            alertaAviso.setTitulo("Alerta");
            alertaAviso.setMsgPrincipal("Informe o CPF!");
            alertaAviso.setSubMsg("O campo CPF esta vazio. Por favor informe o CPF");
            alertaAviso.exibirAlert();
        }
    }
}
