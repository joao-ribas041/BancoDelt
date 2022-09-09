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

public class ViewSacarController implements Initializable {

    @FXML
    private FlowPane Titulo;
    @FXML
    private TextField txtFValor;
    @FXML
    private Button btnSacar;

    AlertWarningPrototype alertaAviso;
    AlertErrorPrototype alertaErro;
    AlertInformationPrototype alertaInforma;
    private double valorASacar = 0;
    private double saldoAnterior = 0;

    ContaDAO cDAO = new ContaDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MascaraTextField.mascaraReal(txtFValor);
    }

    @FXML
    private void btnSacarAction(ActionEvent event) {
        sacar();
    }

    private void sacar() {
        if (txtFValor.getText().isEmpty()) {
            alertaAviso = new AlertWarningPrototype("Alerta", "Informe o valor", "Você não solicitou nenhum valor para saque.");
        } else {
            if (txtFValor.getText().length() < 1) {
                alertaAviso = new AlertWarningPrototype("Alerta", "Campo incompleto", "Você não informou todos os dados para conta de deposito.");
            } else {
                valorASacar = new Double(txtFValor.getText());
                if (Conta2.getSaldo() < valorASacar) {
                    alertaErro = new AlertErrorPrototype("Erro", "Saldo Insuficiente", "Você não tem saldo suficiente para a transação.");
                } else {
                    saldoAnterior = cDAO.contaExiste(Conta2.getConta());
                    if (saldoAnterior != 0) {
                        Conta2.sacar(Conta2.getConta(), valorASacar, saldoAnterior);
                        alertaInforma = new AlertInformationPrototype("Alerta", "Saque efetuado", "Saque efetuado com sucesso.");
                        cDAO.setTipo(Conta2.getTipo());
                        cDAO.resgatarDadosTitular(Conta2.getCPF());
                    } else {
                        alertaAviso = new AlertWarningPrototype("Alerta", "Conta não existe", "Erro de sistema.");
                    }
                }
            }
        }
    }
}
