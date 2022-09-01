package com.bancodelt.java.program.controllers;

import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.program.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    
    public static String CPFinput;
    
    Main m = new Main();
    AlertWarningPrototype alertaAviso;

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
            alertaAviso = new AlertWarningPrototype("Alerta", "Informe o CPF!", "O campo CPF esta vazio. Por favor informe o CPF");
        } else {
            CPFinput = txtFCPF.getText();
            
            // se conta existe, entrar direto, caso contrario ir para criar conta
            if(CPFinput.equalsIgnoreCase("138")) {
                System.out.println("CPF VALIDO, entrando...");
                setCPFinput(txtFCPF.getText());
                Main.getProgram().close();
                m.rodarTela(new Stage(), "ViewPrincipalApp.fxml");
                // criar txtF para senha e mostrar txtF caso conta ja exista
                // ou fazer menu personalizado para login de conta existente
            } else {
                System.out.println("CPF INVALIDO, criar conta");
                Main.getProgram().close();
                m.rodarTela(new Stage(), "ViewCadastrarApp.fxml");
            }
        }
    }

    public static void setCPFinput(String CPFinput) {
        ViewOpenAppController.CPFinput = CPFinput;
    }

    public static String getCPFinput() {
        return CPFinput;
    }    
}
