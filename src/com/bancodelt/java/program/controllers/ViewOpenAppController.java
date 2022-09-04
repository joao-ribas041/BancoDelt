package com.bancodelt.java.program.controllers;

import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.program.Main;
import java.io.IOException;
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
    } 
       
    @FXML
    private void AcaoBtnSeguir(ActionEvent event) throws IOException {
        if(CheckCPF() == 1) {
            Main.getProgram().close();
            m.switchTelas(new Stage(), "ViewLoginApp.fxml");
        }
        if(CheckCPF() == 2) {
            Main.getProgram().close();
            m.switchTelas(new Stage(), "ViewRegisterApp.fxml");
        }
    }
    
    private int CheckCPF(){
        if(txtFCPF.getText().isEmpty()){
            alertaAviso = new AlertWarningPrototype("Alerta", "Informe o CPF!", "O campo CPF esta vazio. Por favor informe o CPF");
            return 0;
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
    }
    
    public static void setCPFinput(String CPFinput) {
        ViewOpenAppController.CPFinput = CPFinput;
    }
    public static String getCPFinput() {
        return CPFinput;
    }
}
