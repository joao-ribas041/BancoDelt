package com.bancodelt.java.program.controllers;

import com.bancodelt.java.models.ContaCorrente;
import com.bancodelt.java.models.ContaPoupanca;
import com.bancodelt.java.models.EstiloAcc;
import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.program.Main;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javax.xml.bind.DatatypeConverter;

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
    @FXML
    private ComboBox<EstiloAcc> cbGenero;
    private List<EstiloAcc> generosAcc = new ArrayList<>();
    private ObservableList<EstiloAcc> obsGenerosAcc;
    
    private int numeroAgencia, numeroConta;
    private String CPF, email, ddd, numeroCelular, nomeTitular, generoTitular, senhaTitular, dataNascimento, dataCriacaoAcc;
    private double saldo;
    private byte tipo;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDateTime dataAtual = LocalDateTime.now();
    
    Main m = new Main();
    ViewOpenAppController voac = new ViewOpenAppController();
    AlertWarningPrototype alertaAviso;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtFCPF.setText(voac.getCPFinput());
        txtFCPF.setEditable(false);
        numeroAgencia = 0001;
        numeroConta = 000000000;
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
    @FXML
    private void cbGeneroEnter(KeyEvent e) throws Exception {
        if(e.getCode() == KeyCode.ENTER) {
            CheckVariaveis();
        }
    }
    
    private void CheckVariaveis() throws Exception {
        CPF = txtFCPF.getText();
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
                        ddd = txtFddd.getText();
                        numeroCelular = txtFnumeroTelefone.getText();
                        if(txtFNome.getText().isEmpty()) {
                            alertaAviso = new AlertWarningPrototype("Alerta", "Informe o seu nome", "O campo nome está vazio, por favor informe-o.");
                        } else {
                            if(txtFNome.getText().length() < 3 || txtFNome.getText().length() >= 50) {
                                alertaAviso = new AlertWarningPrototype("Alerta", "Nome invalido", "O nome informado é invalido, por favor informe um nome legitmo.");
                            } else {
                                nomeTitular = txtFNome.getText();
                                if(dpNascimento.getValue() != null) {
                                    // logica para verificar se é maior que 18 anos
                                    dataNascimento = dpNascimento.getValue().format(dtf);
                                    dataCriacaoAcc = dtf.format(dataAtual);
                                    
                                    if(cbGenero.getValue() != null) {
                                        generoTitular = cbGenero.getValue().getEstilo();
                                        if(txtFSenha.getText().isEmpty() || txtFConfirmSenha.getText().isEmpty()) {
                                            alertaAviso = new AlertWarningPrototype("Alerta", "Informe a senha", "O campo senha está vazio, por favor informe-o.");
                                        } else {
                                            if(txtFSenha.getText().equals(txtFConfirmSenha.getText())) {
                                                senhaTitular = txtFSenha.getText();
                                                if(cbEstiloDaConta.getValue() != null) {
                                                    saldo = 0;
                                                    if(cbEstiloDaConta.getValue().getEstilo().equals("Conta Corrente")) {
                                                        tipo = (byte)cbEstiloDaConta.getValue().getId();
                                                        numeroConta += 1;
                                                        System.out.println("");
                                                        System.out.println("Conta corrente");
                                                        System.out.println("");
                                                        System.out.println("Numero agencia: " + numeroAgencia);
                                                        System.out.println("Numero conta: " + numeroConta);
                                                        System.out.println("CPF: " + CPF);
                                                        System.out.println("E-mail: " + email);
                                                        System.out.println("ddd: " + ddd);
                                                        System.out.println("Numero Celular: " + numeroCelular);
                                                        System.out.println("Nome Titular: " + nomeTitular);
                                                        System.out.println("Genero: " + generoTitular);
                                                        System.out.println("Senha Titular: " + senhaTitular);
                                                        System.out.println("Data nascimento: " + dataNascimento);
                                                        System.out.println("Data Criacão: " + dataCriacaoAcc);
                                                        System.out.println("Saldo: " + saldo);
                                                        System.out.println("Tipo: " + tipo);
                                                        ContaCorrente cc = new ContaCorrente(numeroAgencia, numeroConta, CPF, email, ddd, numeroCelular, nomeTitular, generoTitular, senhaTitular, dataNascimento, dataCriacaoAcc, saldo);
                                                        //Main.getProgram().close();
                                                        //m.rodarTela(new Stage(), "ViewPrincipalApp.fxml");
                                                    }
                                                    if(cbEstiloDaConta.getValue().getEstilo().equals("Conta Poupança")) {
                                                        System.out.println("");
                                                        System.out.println("Conta poupança");
                                                        System.out.println("");
                                                        numeroConta += 1;
                                                        System.out.println("Numero agencia: " + numeroAgencia);
                                                        System.out.println("Numero conta: " + numeroConta);
                                                        System.out.println("CPF: " + CPF);
                                                        System.out.println("E-mail: " + email);
                                                        System.out.println("ddd: " + ddd);
                                                        System.out.println("Numero Celular: " + numeroCelular);
                                                        System.out.println("Nome Titular: " + nomeTitular);
                                                        System.out.println("Genero: " + generoTitular);
                                                        System.out.println("Senha Titular: " + senhaTitular);
                                                        System.out.println("Data nascimento: " + dataNascimento);
                                                        System.out.println("Data Criacão: " + dataCriacaoAcc);
                                                        System.out.println("Saldo: " + saldo);
                                                        System.out.println("Tipo: " + tipo);
                                                        ContaPoupanca cp = new ContaPoupanca(numeroAgencia, numeroConta, CPF, email, ddd, numeroCelular, nomeTitular, generoTitular, senhaTitular, dataNascimento, dataCriacaoAcc, saldo);
                                                        //Main.getProgram().close();
                                                        //m.rodarTela(new Stage(), "ViewPrincipalApp.fxml");
                                                    }
                                                } else {
                                                    alertaAviso = new AlertWarningPrototype("Alerta", "Informe o estilo da conta", "Você não escolheu o estilo da conta, por favor informe-o.");
                                                }
                                            } else {
                                                alertaAviso = new AlertWarningPrototype("Alerta", "Senhas diferentes", "As senhas informadas são diferentes, por favor confirme sua senha.");
                                            }
                                        }
                                    } else {
                                        alertaAviso = new AlertWarningPrototype("Alerta", "Informe o genero", "Você não escolheu o genero, por favor informe-o.");
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
