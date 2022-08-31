package com.bancodelt.java.program.controllers;

import com.bancodelt.java.models.EstiloAcc;
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
import javafx.scene.layout.AnchorPane;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarCategorias();
    }    

    @FXML
    private void AcaoBtnEntrar(ActionEvent event) throws Exception {
        CheckVariaveis();
    }
    
    public void iniciarCategorias() {
        EstiloAcc estilo0 = new EstiloAcc(0, "Conta Poupança");
        EstiloAcc estilo1 = new EstiloAcc(1, "Conta Corrente");
        estilosAcc.add(estilo0);
        estilosAcc.add(estilo1);
        
        obsEstiloAcc = FXCollections.observableArrayList(estilosAcc);
        cbEstiloDaConta.setItems(obsEstiloAcc);
    }
    
    private void CheckVariaveis() throws Exception {
        //Main.getProgram().close();
        //m.rodarTela(new Stage(), "ViewPrincipalApp.fxml");
    }
    
}
