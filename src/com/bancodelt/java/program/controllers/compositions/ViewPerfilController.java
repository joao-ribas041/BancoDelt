package com.bancodelt.java.program.controllers.compositions;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class ViewPerfilController implements Initializable {

    @FXML
    private FlowPane FPConta;
    @FXML
    private VBox VBoxAgencia;
    @FXML
    private Label lblAgencia;
    @FXML
    private TextField txtFAgencia;
    @FXML
    private VBox VBoxConta;
    @FXML
    private Label lblConta;
    @FXML
    private TextField txtFConta;
    @FXML
    private VBox VBoxCPF;
    @FXML
    private Label lblCPF;
    @FXML
    private TextField txtFCPF;
    @FXML
    private VBox VBoxNome;
    @FXML
    private Label lblNomeTitular;
    @FXML
    private TextField txtFNomeTitular;
    @FXML
    private VBox VBoxEmail;
    @FXML
    private Label lblEmail;
    @FXML
    private TextField txtFEmail;
    @FXML
    private VBox VBoxDDD;
    @FXML
    private Label lblDDD;
    @FXML
    private TextField txtFDDD;
    @FXML
    private VBox VBoxNumero;
    @FXML
    private Label lblNumero;
    @FXML
    private TextField txtFNumero;
    @FXML
    private VBox VBoxGenero;
    @FXML
    private Label lblGenero;
    @FXML
    private ComboBox<?> cbGenero;
    @FXML
    private Label lblNascimento;
    @FXML
    private TextField txtFNascimento;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
