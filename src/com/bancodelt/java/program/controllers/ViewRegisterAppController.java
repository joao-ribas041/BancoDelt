package com.bancodelt.java.program.controllers;

import com.bancodelt.java.models.EstiloAcc;
import com.bancodelt.java.models.MascaraFx;
import com.bancodelt.java.program.Main;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewRegisterAppController implements Initializable {

    @FXML
    private ImageView btnVoltar;
    @FXML
    private TextField txtFCPF;
    @FXML
    private TextField txtFSenha;
    @FXML
    private Button btnRegistrar;
    @FXML
    private TextField txtFEmail;
    @FXML
    private TextField txtFddd;
    @FXML
    private TextField txtFnumeroTelefone;
    @FXML
    private DatePicker dpNascimento;
    @FXML
    private PasswordField txtFConfirmSenha;
    @FXML
    private ComboBox<EstiloAcc> cbGenero;
    private List<EstiloAcc> generosAcc = new ArrayList<>();
    private ObservableList<EstiloAcc> obsGenerosAcc;
    @FXML
    private ComboBox<EstiloAcc> cbEstiloDaConta;
    private List<EstiloAcc> estilosAcc = new ArrayList<>();
    private ObservableList<EstiloAcc> obsEstiloAcc;
    
    private int numeroAgencia, numeroConta;
    private String CPF, email, ddd, numeroCelular, nomeTitular, generoTitular, senhaTitular, dataNascimento, dataCriacaoAcc;
    private double saldo;
    private byte tipo;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDateTime dataAtual = LocalDateTime.now();
    
    Main m = new Main();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MouseBarEvents();
        txtFCPF.setEditable(false);
        txtFCPF.setText(ViewOpenAppController.getCPFinput());
        numeroAgencia = 0001;
        numeroConta = 000000000;
        iniciarCategorias();
        
        MascaraFx.mascaraNumerosInteiros(txtFddd);
        MascaraFx.mascaraNumerosInteiros(txtFnumeroTelefone);
    }

    @FXML
    private void AcaoBtnRegistrar(ActionEvent event) {
    }
    
    @FXML
    private void btnVoltarClick(MouseEvent event) throws IOException {
        Main.getProgram().close();
        m.switchTelas(new Stage(), "ViewOpenApp.fxml");
    }
    
    private void MouseBarEvents() {
        btnVoltar.setOnMouseEntered((event) -> {
            btnVoltar.setFitWidth(25);
            btnVoltar.setFitHeight(25);
        });
        btnVoltar.setOnMouseExited((event) -> {
            btnVoltar.setFitWidth(20);
            btnVoltar.setFitHeight(20);
        });
    }
    
    public void iniciarCategorias() {
        EstiloAcc estilo0 = new EstiloAcc(0, "Conta Poupança");
        EstiloAcc estilo1 = new EstiloAcc(1, "Conta Corrente");
        estilosAcc.add(estilo0);
        estilosAcc.add(estilo1);
        
        obsEstiloAcc = FXCollections.observableArrayList(estilosAcc);
        cbEstiloDaConta.setItems(obsEstiloAcc);
        
        EstiloAcc genero0 = new EstiloAcc(0, "Prefiro não dizer");
        EstiloAcc genero1 = new EstiloAcc(1, "Masculino");
        EstiloAcc genero2 = new EstiloAcc(2, "Feminino");
        generosAcc.add(genero0);
        generosAcc.add(genero1);
        generosAcc.add(genero2);
        
        obsGenerosAcc = FXCollections.observableArrayList(generosAcc);
        cbGenero.setItems(obsGenerosAcc);
    }
}
