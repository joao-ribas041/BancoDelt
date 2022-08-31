package com.bancodelt.java.program.controllers;

import com.bancodelt.java.program.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewCadastrarAppController implements Initializable {

    @FXML
    private AnchorPane TelaCriarAccApp;
    @FXML
    private TextField txtFCPF;
    @FXML
    private TextField txtFNome;
    @FXML
    private TextField txtFNascimento;
    @FXML
    private ComboBox<?> cbEstiloDaConta;
    @FXML
    private Button btnCriarAcc;
    @FXML
    private DatePicker dpNascimento;
    @FXML
    private TextField txtFSenha;
    @FXML
    private TextField txtFConfirmSenha;
    @FXML
    private Label txtFSenha1;
    @FXML
    private TextField txtFEmail;
    
    Main m = new Main();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AcaoBtnEntrar(ActionEvent event) throws Exception {
        CheckVariaveis();
    }
    
    private void CheckVariaveis() throws Exception {
        
        
        //Main.getProgram().close();
        //m.rodarTela(new Stage(), "ViewPrincipalApp.fxml");
    }
    
}
