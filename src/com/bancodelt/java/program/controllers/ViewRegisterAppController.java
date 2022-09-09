package com.bancodelt.java.program.controllers;

import com.bancodelt.java.config.DBAcess;
import com.bancodelt.java.models.ContaCorrente;
import com.bancodelt.java.models.ContaPoupanca;
import com.bancodelt.java.models.EstiloAcc;
import com.bancodelt.java.config.MascaraTextField;
import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.models.dao.ContaDAO;
import com.bancodelt.java.program.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewRegisterAppController implements Initializable {

    @FXML
    private TextField txtFNome;
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

    private int numAgencia, numConta;
    private String Conta, CPF, email, numeroCelular, nomeTitular, generoTitular, senhaTitular, dataNascimento, dataCriacaoAcc;
    private double saldo;
    private byte tipo;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDateTime dataAtual = LocalDateTime.now();

    Main m = new Main();
    ViewOpenAppController voac = new ViewOpenAppController();
    AlertWarningPrototype alertaAviso;
    
    ContaDAO cDAO = new ContaDAO();

    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private Statement st = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MouseBarEvents();
        txtFCPF.setEditable(false);
        txtFCPF.setText(ViewOpenAppController.getCPFinput());
        numAgencia = 1;
        iniciarCategorias();

        MascaraTextField.mascaraEmail(txtFEmail);
        MascaraTextField.mascaraTelefone(txtFnumeroTelefone);
        MascaraTextField.mascaraNome(txtFNome);
        MascaraTextField.mascaraData(dpNascimento);
    }

    @FXML
    private void AcaoBtnRegistrar(ActionEvent event) throws IOException {
        CheckVariaveis();
    }

    @FXML
    private void btnVoltarClick(MouseEvent event) throws IOException {
        Main.getProgram().close();
        m.switchTelas(new Stage(), "ViewOpenApp.fxml");
    }

    private void CheckVariaveis() throws IOException {
        CPF = txtFCPF.getText();
        if (txtFEmail.getText().isEmpty()) {
            alertaAviso = new AlertWarningPrototype("Alerta", "Informe o E-mail!", "O campo E-mail está vazio, por favor informe-o.");
        } else {
            if (txtFEmail.getText().contains("@") && txtFEmail.getText().contains(".com")) {
                email = txtFEmail.getText();
                if (txtFnumeroTelefone.getText().isEmpty()) {
                    alertaAviso = new AlertWarningPrototype("Alerta", "Informe o seu numero", "O campo numero de telefone está vazio, por favor informe-o.");
                } else {
                    numeroCelular = txtFnumeroTelefone.getText();
                    if (txtFNome.getText().isEmpty()) {
                        alertaAviso = new AlertWarningPrototype("Alerta", "Informe o seu nome", "O campo nome está vazio, por favor informe-o.");
                    } else {
                        if (txtFNome.getText().length() < 3 || txtFNome.getText().length() >= 50) {
                            alertaAviso = new AlertWarningPrototype("Alerta", "Nome invalido", "O nome informado é invalido, por favor informe um nome legitmo.");
                        } else {
                            nomeTitular = txtFNome.getText();
                            if (dpNascimento.getValue() != null) {
                                // logica para verificar se é maior que 18 anos
                                dataNascimento = dpNascimento.getValue().format(dtf);
                                dataCriacaoAcc = dtf.format(dataAtual);

                                if (cbGenero.getValue() != null) {
                                    generoTitular = cbGenero.getValue().getEstilo();
                                    if (txtFSenha.getText().isEmpty() || txtFConfirmSenha.getText().isEmpty()) {
                                        alertaAviso = new AlertWarningPrototype("Alerta", "Informe a senha", "O campo senha está vazio, por favor informe-o.");
                                    } else {
                                        if (txtFSenha.getText().equals(txtFConfirmSenha.getText())) {
                                            senhaTitular = txtFSenha.getText();
                                            if (cbEstiloDaConta.getValue() != null) {
                                                saldo = 0;
                                                if (cbEstiloDaConta.getValue().getEstilo().equals("Conta Corrente")) {
                                                    tipo = (byte) cbEstiloDaConta.getValue().getId();
                                                    Conta = "01000000-0";
                                                    System.out.println("");
                                                    System.out.println("Conta corrente");
                                                    System.out.println("");
                                                    System.out.println("Numero agencia: " + numAgencia);
                                                    System.out.println("Numero conta: " + Conta);
                                                    System.out.println("CPF: " + CPF);
                                                    System.out.println("E-mail: " + email);
                                                    System.out.println("Numero Celular: " + numeroCelular);
                                                    System.out.println("Nome Titular: " + nomeTitular);
                                                    System.out.println("Genero: " + generoTitular);
                                                    System.out.println("Senha Titular: " + senhaTitular);
                                                    System.out.println("Data nascimento: " + dataNascimento);
                                                    System.out.println("Data Criacão: " + dataCriacaoAcc);
                                                    System.out.println("Saldo: " + saldo);
                                                    System.out.println("Tipo: " + tipo);
                                                    cDAO.CadastrarTitular(numAgencia, tipo, Conta, CPF, email, numeroCelular, nomeTitular, generoTitular, senhaTitular, dataNascimento, dataCriacaoAcc, saldo);
                                                    Main.getProgram().close();
                                                    m.switchTelas(new Stage(), "ViewPrincipalApp.fxml");
                                                }
                                                if (cbEstiloDaConta.getValue().getEstilo().equals("Conta Poupança")) {
                                                    System.out.println("");
                                                    System.out.println("Conta poupança");
                                                    System.out.println("");
                                                    Conta = "01000000-0";
                                                    System.out.println("Numero agencia: " + numAgencia);
                                                    System.out.println("Numero conta: " + numConta);
                                                    System.out.println("CPF: " + CPF);
                                                    System.out.println("E-mail: " + email);
                                                    System.out.println("Numero Celular: " + numeroCelular);
                                                    System.out.println("Nome Titular: " + nomeTitular);
                                                    System.out.println("Genero: " + generoTitular);
                                                    System.out.println("Senha Titular: " + senhaTitular);
                                                    System.out.println("Data nascimento: " + dataNascimento);
                                                    System.out.println("Data Criacão: " + dataCriacaoAcc);
                                                    System.out.println("Saldo: " + saldo);
                                                    System.out.println("Tipo: " + tipo);
                                                    cDAO.CadastrarTitular(numAgencia, tipo, Conta, CPF, email, numeroCelular, nomeTitular, generoTitular, senhaTitular, dataNascimento, dataCriacaoAcc, saldo);
                                                    Main.getProgram().close();
                                                    m.switchTelas(new Stage(), "ViewPrincipalApp.fxml");
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
            } else {
                alertaAviso = new AlertWarningPrototype("Alerta", "E-mail invalido.", "O campo E-mail é invalido, por favor informe um E-mail legitmo.");
            }
        }
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

        txtFEmail.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    CheckVariaveis();
                } catch (IOException ex) {
                    Logger.getLogger(ViewRegisterAppController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        txtFnumeroTelefone.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    CheckVariaveis();
                } catch (IOException ex) {
                    Logger.getLogger(ViewRegisterAppController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        txtFNome.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    CheckVariaveis();
                } catch (IOException ex) {
                    Logger.getLogger(ViewRegisterAppController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        dpNascimento.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    CheckVariaveis();
                } catch (IOException ex) {
                    Logger.getLogger(ViewRegisterAppController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        cbGenero.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    CheckVariaveis();
                } catch (IOException ex) {
                    Logger.getLogger(ViewRegisterAppController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        txtFSenha.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    CheckVariaveis();
                } catch (IOException ex) {
                    Logger.getLogger(ViewRegisterAppController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        txtFConfirmSenha.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    CheckVariaveis();
                } catch (IOException ex) {
                    Logger.getLogger(ViewRegisterAppController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        cbEstiloDaConta.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    CheckVariaveis();
                } catch (IOException ex) {
                    Logger.getLogger(ViewRegisterAppController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void iniciarCategorias() {
        conexao = DBAcess.getConexao();
        String sql = "SELECT id_estilo, estilo_acc from estilo_conta;";
        try {
            st = conexao.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int id_estilo = rs.getInt("id_estilo");
                String estilo = rs.getString("estilo_acc");
                estilosAcc.add(new EstiloAcc(id_estilo, estilo));
            }
            DBAcess.closeConexao(conexao, rs, st);
        } catch (SQLException e) {
            Logger.getLogger(ViewRegisterAppController.class.getName()).log(Level.SEVERE, null, e);
            DBAcess.closeConexao(conexao, rs, st);
        }
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
