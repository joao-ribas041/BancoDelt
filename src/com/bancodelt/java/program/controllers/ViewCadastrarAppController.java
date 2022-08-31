package com.bancodelt.java.program.controllers;

import com.bancodelt.java.models.EstiloAcc;
import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.program.Main;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
    private Button btnCriarAcc;
    @FXML
    private DatePicker dpNascimento;
    @FXML
    private TextField txtFSenha;
    @FXML
    private TextField txtFConfirmSenha;
    @FXML
    private TextField txtFEmail;
    @FXML
    private ComboBox<EstiloAcc> cbEstiloDaConta;
    private List<EstiloAcc> estilosAcc = new ArrayList<>();
    private ObservableList<EstiloAcc> obsEstiloAcc;
    
    Main m = new Main();
    ViewOpenAppController voac = new ViewOpenAppController();
    AlertWarningPrototype alertaAviso;
    @FXML
    private TextField txtFddd;
    @FXML
    private TextField txtFnumeroTelefone;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtFCPF.setText(voac.getCPFinput());
        iniciarCategorias();
    }    

    @FXML
    private void AcaoBtnEntrar(ActionEvent event) throws Exception {
        CheckVariaveis();
    }
    // CODIGO REPETIDO, CRIAR IF COM OPERADOR OU PARA TODAS AS TECLAS MAIS TARDE.
    @FXML
    private void txtFnomeEnter(KeyEvent event) throws Exception {
        CheckVariaveis();
    }
    @FXML
    private void txtFsenhaEnter(KeyEvent event) throws Exception {
        CheckVariaveis();
    }
    @FXML
    private void txtFconfirmarSenhaEnter(KeyEvent event) throws Exception {
        CheckVariaveis();
    }
    @FXML
    private void txtFEmailEnter(KeyEvent event) throws Exception {
        CheckVariaveis();
    }
    @FXML
    private void txtFdddEnter(KeyEvent event) throws Exception {
        CheckVariaveis();
    }
    @FXML
    private void txtFnumeroEnter(KeyEvent event) throws Exception {
        CheckVariaveis();
    }
    
    
    
    private void CheckVariaveis() throws Exception {
        if(txtFEmail.getText().isEmpty()){
            alertaAviso = new AlertWarningPrototype("Alerta", "Informe o E-mail!", "O campo E-mail está vazio, por favor informe-o.");
        } else {
            if(txtFEmail.getText().contains("@") && txtFEmail.getText().contains(".com")) {
                
            } else {
                alertaAviso = new AlertWarningPrototype("Alerta", "E-mail invalido.", "O campo E-mail é invalido, por favor informe um E-mail legitmo.");
            }
        }
        //Main.getProgram().close();
        //m.rodarTela(new Stage(), "ViewPrincipalApp.fxml");
    }
    
    public void iniciarCategorias() {
        EstiloAcc estilo0 = new EstiloAcc(0, "Conta Poupança");
        EstiloAcc estilo1 = new EstiloAcc(1, "Conta Corrente");
        estilosAcc.add(estilo0);
        estilosAcc.add(estilo1);
        
        obsEstiloAcc = FXCollections.observableArrayList(estilosAcc);
        cbEstiloDaConta.setItems(obsEstiloAcc);
    }
}
