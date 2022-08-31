package com.bancodelt.java.program.controllers;

import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.program.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewOpenAppController implements Initializable {
    
    @FXML
    private AnchorPane TelaPrincipalApp;
    @FXML
    private Button btnEntrar;
    @FXML
    private TextField txtFCPF;
    
    public String CPFinput;
    
    Main m = new Main();
    AlertWarningPrototype alertaAviso = new AlertWarningPrototype();
    Parent telaCadastro;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void AcaoBtnEntrar(ActionEvent event) throws Exception {
        CheckACC();
    }
    
    @FXML
    private void acaoBtnEnter(KeyEvent e) throws Exception {
        if(e.getCode() == KeyCode.ENTER){
            CheckACC();
        }
    }

    @FXML
    private void acaoTXTFEnter(KeyEvent e) throws Exception {
        if(e.getCode() == KeyCode.ENTER){
            CheckACC();
        }
    }
    
        private void CheckACC() throws Exception {            
        if (txtFCPF.getText().isEmpty()) {
            alertaAviso.setTitulo("Alerta");
            alertaAviso.setMsgPrincipal("Informe o CPF!");
            alertaAviso.setSubMsg("O campo CPF esta vazio. Por favor informe o CPF");
            alertaAviso.exibirAlert();
        } else {
            CPFinput = txtFCPF.getText();
            
            // se conta existe, entrar direto, caso contrario ir para criar conta
            if(CPFinput.equalsIgnoreCase("138")) {
                System.out.println("CPF VALIDO, entrando...");
                // criar txtF para senha e mostrar txtF caso conta ja exista
                // ou fazer menu personalizado para login de conta existente
            } else {
                System.out.println("CPF INVALIDO, criar conta");
                Main.getProgram().close();
                m.rodarTela(new Stage(), "ViewCadastrarApp.fxml");
            }
        }
    }
}
