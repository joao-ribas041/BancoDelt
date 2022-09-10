package com.bancodelt.java.program.controllers.compositions;

import com.bancodelt.java.config.MascaraTextField;
import com.bancodelt.java.models.Conta2;
import com.bancodelt.java.models.ContaCorrente;
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

public class ViewPixReceberController implements Initializable {

    @FXML
    private FlowPane Titulo;
    @FXML
    private TextField txtFValor;
    @FXML
    private Button btnReceber;

    AlertWarningPrototype alertaAviso;
    AlertErrorPrototype alertaErro;
    AlertInformationPrototype alertaInforma;
    private double valorAReceber = 0;
    private double saldoAnterior = 0;

    ContaDAO cDAO = new ContaDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MascaraTextField.mascaraReal(txtFValor);
    }

    @FXML
    private void btnSacarAction(ActionEvent event) {
        receber();
    }

    private void receber() {
        if (txtFValor.getText().isEmpty()) {
            alertaAviso = new AlertWarningPrototype("Alerta", "Informe o valor", "Você não solicitou o valor que deseja receber.");
        } else {
            if (txtFValor.getText().length() < 1) {
                alertaAviso = new AlertWarningPrototype("Alerta", "Campo incompleto", "Você não solicitou nenhum valor para saque.");
            } else {
                valorAReceber = new Double(txtFValor.getText());
                if (valorAReceber == 0) {
                    alertaErro = new AlertErrorPrototype("Erro", "Valor nulo", "Você não informou um valor para a transação.");
                } else {
                    saldoAnterior = cDAO.contaExiste(Conta2.getConta());
                    if (ContaDAO.isContaExiste() == true) {
                        ContaCorrente.receberPix(Conta2.getConta(), valorAReceber, saldoAnterior);
                        alertaInforma = new AlertInformationPrototype("Alerta", "Pix Recebido", "Pix recebido com sucesso.");
                        cDAO.setTipo(Conta2.getTipo());
                        cDAO.resgatarSaldoTitular(Conta2.getCPF());
                    }
                }
            }
        }
    }

}
