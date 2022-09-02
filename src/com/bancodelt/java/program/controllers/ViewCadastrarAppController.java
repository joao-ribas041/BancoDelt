package com.bancodelt.java.program.controllers;

import com.bancodelt.java.models.ContaCorrente;
import com.bancodelt.java.models.EstiloAcc;
import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.program.Main;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.input.KeyCode;
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
    private TextField txtFddd;
    @FXML
    private TextField txtFnumeroTelefone;
    @FXML
    private ComboBox<EstiloAcc> cbEstiloDaConta;
    private List<EstiloAcc> estilosAcc = new ArrayList<>();
    private ObservableList<EstiloAcc> obsEstiloAcc;
    
    private int numeroAgencia, ddd;
    private String numeroConta, CPF, email, numeroCelular, nomeTitular;
    private Date dataNascimento, dataCriacaoAcc;
    private double saldo;
    private byte tipo;
    
    Main m = new Main();
    ViewOpenAppController voac = new ViewOpenAppController();
    AlertWarningPrototype alertaAviso;
    
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
    private void txtFnomeEnter(KeyEvent e) throws Exception {
        if(e.getCode() == KeyCode.ENTER) {
            CheckVariaveis();
        }
    }
    @FXML
    private void txtFsenhaEnter(KeyEvent e) throws Exception {
        if(e.getCode() == KeyCode.ENTER) {
            CheckVariaveis();
        }
    }
    @FXML
    private void txtFconfirmarSenhaEnter(KeyEvent e) throws Exception {
        if(e.getCode() == KeyCode.ENTER) {
            CheckVariaveis();
        }
    }
    @FXML
    private void txtFEmailEnter(KeyEvent e) throws Exception {
        if(e.getCode() == KeyCode.ENTER) {
            CheckVariaveis();
        }
    }
    @FXML
    private void txtFdddEnter(KeyEvent e) throws Exception {
        if(e.getCode() == KeyCode.ENTER) {
            CheckVariaveis();
        }
    }
    @FXML
    private void txtFnumeroEnter(KeyEvent e) throws Exception {
        if(e.getCode() == KeyCode.ENTER) {
            CheckVariaveis();
        }
    }
    @FXML
    private void cbEstiloEnter(KeyEvent e) throws Exception {
        if(e.getCode() == KeyCode.ENTER) {
            CheckVariaveis();
        }
    }
    @FXML
    private void dpDataEnter(KeyEvent e) throws Exception {
        if(e.getCode() == KeyCode.ENTER) {
            CheckVariaveis();
        }
    }
    
    private void CheckVariaveis() throws Exception {
        if(txtFEmail.getText().isEmpty()){
            alertaAviso = new AlertWarningPrototype("Alerta", "Informe o E-mail!", "O campo E-mail está vazio, por favor informe-o.");
        } else {
            if(txtFEmail.getText().contains("@") && txtFEmail.getText().contains(".com")) {
                email = txtFEmail.getText();
                
                
                if(txtFddd.getText().isEmpty()) {
                    alertaAviso = new AlertWarningPrototype("Alerta", "Informe o seu DDD", "O campo DDD está vazio, por favor informe-o.");
                } else {
                    
                    if(txtFnumeroTelefone.getText().isEmpty()) {
                        alertaAviso = new AlertWarningPrototype("Alerta", "Informe o seu numero", "O campo numero de telefone está vazio, por favor informe-o.");
                    } else {
                        
                        
                        if(txtFNome.getText().isEmpty()) {
                            alertaAviso = new AlertWarningPrototype("Alerta", "Informe o seu nome", "O campo nome está vazio, por favor informe-o.");
                        } else {
                            
                            if(txtFNome.getText().length() < 3 || txtFNome.getText().length() >= 50) {
                                System.out.println("");
                                System.out.println("Menor que 3 e maior que 50");
                                alertaAviso = new AlertWarningPrototype("Alerta", "Nome invalido", "O nome informado é invalido, por favor informe um nome legitmo.");
                            } else {
                                
                                if(dpNascimento.getValue() != null) {
                                    
                                    if(txtFSenha.getText().isEmpty() || txtFConfirmSenha.getText().isEmpty()) {
                                        alertaAviso = new AlertWarningPrototype("Alerta", "Informe a senha", "O campo senha está vazio, por favor informe-o.");
                                    } else {
                                        if(txtFSenha.getText().equals(txtFConfirmSenha.getText())) {
                                            System.out.println("Senhas iguais");
                                            
                                            if(cbEstiloDaConta.getValue() != null) {
                                                
                                                
                                                if(cbEstiloDaConta.getValue().getEstilo().equals("Conta Corrente")) {
                                                    System.out.println("");
                                                    System.out.println("Conta corrente");
                                                    System.out.println("");
                                                    ContaCorrente cc;
                                                    cc = new ContaCorrente();
                                                    
                                                }
                                                if(cbEstiloDaConta.getValue().getEstilo().equals("Conta Poupança")) {
                                                    System.out.println("");
                                                    System.out.println("Conta poupança");
                                                    System.out.println("");
                                                }
                                                
                                            } else {
                                                alertaAviso = new AlertWarningPrototype("Alerta", "Informe o estilo da conta", "Você não escolheu o estilo da conta, por favor informe-o.");
                                            }
                                            
                                            
                                        } else {
                                            System.out.println("senhas diferentes");
                                        }
                                    }
                                    
                                } else {
                                    alertaAviso = new AlertWarningPrototype("Alerta", "Data invalida", "A data informada é invalido, por favor informe uma data legitma.");
                                    
                                }
                                
                                
                                
                            }
                            
                            
                        }
                        
                        
                    }
                    
                }
                
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
