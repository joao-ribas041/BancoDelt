package com.bancodelt.java.program.controllers;

import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.program.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class ViewOpenAppController implements Initializable {

    @FXML
    private ImageView btnVoltar;
    @FXML
    private TextField txtFCPF;
    @FXML
    private Button btnSeguir;
    
    public static String CPFinput;
    
    AlertWarningPrototype alertaAviso;
    Main m = new Main();
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        txtFCPF.setOnKeyPressed((event) -> {
            if(event.getCode() == KeyCode.ENTER){
                try {
                    seguir();
                } catch (IOException ex) {
                    Logger.getLogger(ViewOpenAppController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    } 
       
    @FXML
    private void AcaoBtnSeguir(ActionEvent event) throws IOException {
        seguir();
    }
    
    private int CheckCPF(){
        if(txtFCPF.getText().isEmpty()){
            alertaAviso = new AlertWarningPrototype("Alerta", "Informe o CPF!", "O campo CPF esta vazio. Por favor informe o CPF");
        } else {
            CPFinput = txtFCPF.getText();
            if(txtFCPF.getText().equals("1234")) {
                setCPFinput(txtFCPF.getText());
                return 1;
            } else {
                setCPFinput(txtFCPF.getText());
                return 2;
            }
        }
        return 0;
    }
    
    private void seguir() throws IOException{
        if(CheckCPF() == 1) {
            Main.getProgram().close();
            m.switchTelas(new Stage(), "ViewLoginApp.fxml");
        } else if(CheckCPF() == 2) {
            Main.getProgram().close();
            m.switchTelas(new Stage(), "ViewRegisterApp.fxml");
        }
    } 

    public static void setCPFinput(String CPFinput) {
        ViewOpenAppController.CPFinput = CPFinput;
    }
    public static String getCPFinput() {
        return CPFinput;
    }
}