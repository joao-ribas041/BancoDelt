package com.bancodelt.java.program.controllers.compositions;

import com.bancodelt.java.config.MascaraTextField;
import com.bancodelt.java.models.Conta2;
import com.bancodelt.java.models.ContaPoupanca;
import com.bancodelt.java.models.alerts.AlertErrorPrototype;
import com.bancodelt.java.models.alerts.AlertInformationPrototype;
import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.models.dao.ContaDAO;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class ViewPoupancaController implements Initializable {

    @FXML
    private FlowPane Titulo;
    @FXML
    private TextField txtFSaldo;
    @FXML
    private TextField txtFCorrecao;
    @FXML
    private Button btnPoupanca;

    private double taxaCorrecao = 0;

    AlertWarningPrototype alertaAviso;
    AlertErrorPrototype alertaErro;
    AlertInformationPrototype alertaInforma;
    DecimalFormat df = new DecimalFormat("###,##0.00");

    ContaDAO cDAO = new ContaDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtFSaldo.setText(df.format(ContaPoupanca.getSaldo()));
        MascaraTextField.mascaraReal(txtFCorrecao);
        btnPoupanca.setOnAction((event) -> {
            aplicarPoupanca();
        });
    }

    private void aplicarPoupanca() {
        if (txtFCorrecao.getText().isEmpty()) {
            alertaAviso = new AlertWarningPrototype("Alerta", "Campo vazio", "Você não informou a taxa de correção.");
        } else {
            taxaCorrecao = Double.parseDouble(txtFCorrecao.getText());
            if (taxaCorrecao == 0) {
                alertaAviso = new AlertWarningPrototype("Alerta", "Taxa invalida", "Taxa incorreta, por favor informe outra taxa.");
            } else {
                double correcao;
                correcao = ContaPoupanca.remuneracao(taxaCorrecao, ContaPoupanca.getSaldo());
                cDAO.setTipo(Conta2.getTipo());
                cDAO.resgatarSaldoTitular(Conta2.getCPF());
                alertaInforma = new AlertInformationPrototype("Alerta", "Taxa aplicada.", "Taxa de correção aplicada com sucesso.");
            }
        }
    }
}