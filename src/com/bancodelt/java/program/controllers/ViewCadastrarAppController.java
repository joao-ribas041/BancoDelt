package com.bancodelt.java.program.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author João Ribas
 */
public class ViewCadastrarAppController implements Initializable {

    @FXML
    private AnchorPane TelaCriarAccApp;
    @FXML
    private Button btnEntrar;
    @FXML
    private TextField txtFCPF;
    @FXML
    private TextField txtFNome;
    @FXML
    private TextField txtFNascimento;
    @FXML
    private ComboBox<?> cbEstiloDaConta;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AcaoBtnEntrar(ActionEvent event) {
    }
    
}
