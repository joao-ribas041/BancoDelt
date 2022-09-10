package com.bancodelt.java.program.controllers.compositions;

import com.bancodelt.java.config.MascaraTextField;
import com.bancodelt.java.models.Conta2;
import com.bancodelt.java.models.alerts.AlertErrorPrototype;
import com.bancodelt.java.models.alerts.AlertInformationPrototype;
import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.models.dao.ContaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class ViewDepositarController implements Initializable {

    @FXML
    private FlowPane Titulo;
    @FXML
    private TextField txtFValor;
    @FXML
    private TextField txtFConta;
    @FXML
    private Button btnDepositar;

    AlertWarningPrototype alertaAviso;
    AlertErrorPrototype alertaErro;
    AlertInformationPrototype alertaInforma;
    private double valorADepositar = 0;
    private double saldoAnterior = 0;

    ContaDAO cDAO = new ContaDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MascaraTextField.mascaraConta(txtFConta);
        MascaraTextField.mascaraReal(txtFValor);
    }

    @FXML
    private void btnDepositarAction(ActionEvent event) {
        depositar();
    }

    private void depositar() {
        if (txtFConta.getText().isEmpty() || txtFValor.getText().isEmpty()) {
            alertaAviso = new AlertWarningPrototype("Alerta", "Campo vazio", "Você não solicitou nenhum valor para deposito.");
        } else {
            if (txtFConta.getText().length() < 10 || txtFValor.getText().length() < 1) {
                alertaAviso = new AlertWarningPrototype("Alerta", "Campo incompleto", "Você não informou todos os dados para conta de deposito.");
            } else {
                valorADepositar = new Double(txtFValor.getText());
                if (valorADepositar == 0) {
                    alertaErro = new AlertErrorPrototype("Erro", "Valor nulo", "Você não informou um valor para a transação.");
                } else {
                    if (Conta2.getConta().equals(txtFConta.getText())) {
                        alertaAviso = new AlertWarningPrototype("Alerta", "Deposito pessoal.", "Você irá fazer um deposito em sua própria conta.");
                        saldoAnterior = cDAO.contaExiste(txtFConta.getText());
                        if (ContaDAO.isContaExiste() == true) {
                            Conta2.depositar(txtFConta.getText(), valorADepositar, saldoAnterior);
                            alertaInforma = new AlertInformationPrototype("Alerta", "Deposito efetuado", "Deposito efetuado com sucesso. ");
                            cDAO.setTipo(Conta2.getTipo());
                            cDAO.resgatarSaldoTitular(Conta2.getCPF());
                        } else {
                            alertaAviso = new AlertWarningPrototype("Alerta", "Conta não existe", "Você informou uma conta inexistente.");
                        }
                    } else {
                        if (valorADepositar > Conta2.getSaldo()) {
                            alertaErro = new AlertErrorPrototype("Erro", "Saldo Insuficiente", "Você não tem saldo suficiente para a transação.");
                        } else {
                            saldoAnterior = cDAO.contaExiste(txtFConta.getText());
                            if (ContaDAO.isContaExiste() == true) {
                                Conta2.depositar(txtFConta.getText(), valorADepositar, saldoAnterior);
                                alertaInforma = new AlertInformationPrototype("Alerta", "Deposito efetuado", "Deposito efetuado com sucesso.");
                                cDAO.setTipo(Conta2.getTipo());
                                cDAO.resgatarSaldoTitular(Conta2.getCPF());
                            } else {
                                alertaAviso = new AlertWarningPrototype("Alerta", "Conta não existe", "Você informou uma conta inexistente.");
                            }
                        }
                    }
                }
            }
        }
    }
}
