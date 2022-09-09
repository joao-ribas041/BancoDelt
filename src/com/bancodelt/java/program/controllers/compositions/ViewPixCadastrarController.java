package com.bancodelt.java.program.controllers.compositions;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class ViewPixCadastrarController implements Initializable {

    @FXML
    private FlowPane Titulo;
    @FXML
    private VBox VBoxCPF;
    @FXML
    private Label lblCPF;
    @FXML
    private TextField txtFCPF;
    @FXML
    private Button btnCadastrarCPF;
    @FXML
    private VBox VBoxNumero;
    @FXML
    private Label lblNumero;
    @FXML
    private TextField txtFNumeroTel;
    @FXML
    private Button btnCadastrarNumero;
    @FXML
    private VBox VBoxEmail;
    @FXML
    private Label lblEmail;
    @FXML
    private TextField txtFEmail;
    @FXML
    private Button btnCadastrarEmail;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
