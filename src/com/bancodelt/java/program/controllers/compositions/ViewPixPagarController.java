package com.bancodelt.java.program.controllers.compositions;

import com.bancodelt.java.config.MascaraTextField;
import com.bancodelt.java.models.Conta2;
import com.bancodelt.java.models.ContaCorrente;
import com.bancodelt.java.models.EstiloAcc;
import com.bancodelt.java.models.alerts.AlertErrorPrototype;
import com.bancodelt.java.models.alerts.AlertInformationPrototype;
import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.models.dao.ContaDAO;
import com.bancodelt.java.models.dao.PixDAO;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class ViewPixPagarController implements Initializable {

    @FXML
    private FlowPane Titulo;
    @FXML
    private TextField txtFValor;
    @FXML
    private HBox hboxChave;
    @FXML
    private HBox hboxValor;
    @FXML
    private Label lblChave;
    @FXML
    private TextField txtFChave;
    @FXML
    private Button btnPAGARPIX;
    @FXML
    private ComboBox<EstiloAcc> cbEstiloChave;
    private List<EstiloAcc> estilosChavesPix = new ArrayList<>();
    private ObservableList<EstiloAcc> obsEstiloChavesPix;

    AlertWarningPrototype alertaAviso;
    AlertErrorPrototype alertaErro;
    AlertInformationPrototype alertaInforma;
    private double valorPix = 0;
    private double saldoAnterior = 0;

    PixDAO pDAO = new PixDAO();
    ContaDAO cDAO = new ContaDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MascaraTextField.mascaraReal(txtFValor);
        iniciarChavesPix();
        checksCBPix();
        hboxValor.setDisable(true);
        hboxValor.setVisible(false);
        hboxChave.setDisable(true);
        hboxChave.setVisible(false);
        btnPAGARPIX.setDisable(true);
        btnPAGARPIX.setVisible(false);
    }

    @FXML
    private void btnPagarPIXAction(ActionEvent event) {
        pagarPix();
    }

    private void checksCBPix() {
        cbEstiloChave.setOnAction((event) -> {
            if (cbEstiloChave.getValue() != null) {
                if (cbEstiloChave.getValue().getId() == 1) {
                    hboxValor.setDisable(false);
                    hboxValor.setVisible(true);
                    hboxChave.setDisable(false);
                    hboxChave.setVisible(true);
                    btnPAGARPIX.setDisable(false);
                    btnPAGARPIX.setVisible(true);
                    txtFChave.clear();
                    MascaraTextField.mascaraCPF(txtFChave);
                    txtFChave.setPromptText("Digite o CPF");
                    lblChave.setText("CPF: ");
                }
                if (cbEstiloChave.getValue().getId() == 2) {
                    System.out.println("Escolha Celular");
                    hboxValor.setDisable(false);
                    hboxValor.setVisible(true);
                    hboxChave.setDisable(false);
                    hboxChave.setVisible(true);
                    btnPAGARPIX.setDisable(false);
                    btnPAGARPIX.setVisible(true);
                    txtFChave.clear();
                    MascaraTextField.mascaraTelefone(txtFChave);
                    txtFChave.setPromptText("Digite o Celular");
                    lblChave.setText("Celular: ");
                }
                if (cbEstiloChave.getValue().getId() == 3) {
                    System.out.println("Escolha E-mail");
                    hboxValor.setDisable(false);
                    hboxValor.setVisible(true);
                    hboxChave.setDisable(false);
                    hboxChave.setVisible(true);
                    btnPAGARPIX.setDisable(false);
                    btnPAGARPIX.setVisible(true);
                    txtFChave.clear();
                    MascaraTextField.mascaraEmail(txtFChave);
                    txtFChave.setPromptText("Digite o e-mail");
                    lblChave.setText("E-mail: ");
                }
            }
        });
    }

    private void pagarPix() {
        if (pDAO.possuiPix(ContaCorrente.getNumConta())) {
            if (txtFValor.getText().isEmpty() || txtFChave.getText().isEmpty()) {
                alertaAviso = new AlertWarningPrototype("Alerta", "Campo vazio", "Você não solicitou nenhum valor para fazer o pix.");
            } else {
                if (txtFChave.getText().length() < 1 || txtFValor.getText().length() < 1) {
                    alertaAviso = new AlertWarningPrototype("Alerta", "Campo incompleto", "Você não informou todos os dados da chave pix ou valor.");
                } else {
                    setValorPix(new Double(txtFValor.getText()));
                    if (valorPix == 0) {
                        alertaErro = new AlertErrorPrototype("Erro", "Valor nulo", "Você não informou um valor para a transação.");
                    } else {
                        if (valorPix > ContaCorrente.getSaldo()) {
                            alertaErro = new AlertErrorPrototype("Erro", "Saldo Insuficiente", "Você não tem saldo suficiente para a transação.");
                        } else {
                            if (txtFChave.getText().equals(ContaCorrente.getCPF())
                                    || txtFChave.getText().equals(ContaCorrente.getNumeroCelular())
                                    || txtFChave.getText().equals(ContaCorrente.getEmail())) {
                                alertaErro = new AlertErrorPrototype("Erro", "Chave pix", "Você não pode fazer um pix para si mesmo.");
                            } else {
                                if (pDAO.possuiPixOutraConta(txtFChave.getText())) {
                                    saldoAnterior = PixDAO.getValorAnterior();
                                    ContaCorrente.pagarPix(PixDAO.getOutraContaPix(), valorPix, saldoAnterior);
                                    
                                    cDAO.setTipo(Conta2.getTipo());
                                    cDAO.resgatarSaldoTitular(Conta2.getCPF());
                                    alertaInforma = new AlertInformationPrototype("Alerta", "Pix efetuado", "Pix efetuado com sucesso." + valorPix);
                                } else {
                                    alertaAviso = new AlertWarningPrototype("Alerta", "Outra conta nao possui pix", "");
                                }
                            }
                        }
                    }
                }
            }
        } else {
            alertaAviso = new AlertWarningPrototype("Alerta", "Você não possui chave pix.", "Para receber pix você precisa cadastrar uma chave.");
        }
    }

    private void iniciarChavesPix() {
        EstiloAcc tipochave1 = new EstiloAcc(1, "CPF");
        EstiloAcc tipochave2 = new EstiloAcc(2, "Celular");
        EstiloAcc tipochave3 = new EstiloAcc(3, "E-mail");
        estilosChavesPix.add(tipochave1);
        estilosChavesPix.add(tipochave2);
        //estilosChavesPix.add(tipochave3);
        //desabilitado email por bug.
        obsEstiloChavesPix = FXCollections.observableArrayList(estilosChavesPix);
        cbEstiloChave.setItems(obsEstiloChavesPix);
    }

    public double getValorPix() {
        return valorPix;
    }

    public void setValorPix(double valorPix) {
        this.valorPix = valorPix;
    }
}
