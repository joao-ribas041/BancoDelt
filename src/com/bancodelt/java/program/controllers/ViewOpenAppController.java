package com.bancodelt.java.program.controllers;

import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.program.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    
    Main m = new Main();
    AlertWarningPrototype alertaAviso;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MouseBarEvents();
    } 
       
    @FXML
    private void AcaoBtnSeguir(ActionEvent event) throws Exception {
        if(CheckLogin() == 1) {
            Parent root = FXMLLoader.load(getClass().getResource(Main.getDirectoryJavaInterfaces() + "ViewLoginApp.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            btnVoltar.setVisible(true);
            stage.show();
        } else if(CheckLogin() == 2) {
            Parent root = FXMLLoader.load(getClass().getResource(Main.getDirectoryJavaInterfaces() + "ViewRegisterApp.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            btnVoltar.setVisible(true);
            stage.show();
        }
    }
    
    
    private int CheckLogin(){
        if (txtFCPF.getText().isEmpty()) {
            alertaAviso = new AlertWarningPrototype("Alerta", "Informe o CPF!", "O campo CPF esta vazio. Por favor informe o CPF");
            return 0;
        } else {
            CPFinput = txtFCPF.getText();
            // se conta existe, entrar direto, caso contrario ir para criar conta
            if(CPFinput.equalsIgnoreCase("138")) {
                System.out.println("CPF VALIDO, entrando...");
                setCPFinput(txtFCPF.getText());
                return 1;
            } else {
                System.out.println("CPF INVALIDO, criar conta");
                return 2;
            }
        }
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
    }
    
    public static void setCPFinput(String CPFinput) {
        ViewOpenAppController.CPFinput = CPFinput;
    }
    public static String getCPFinput() {
        return CPFinput;
    }
}
