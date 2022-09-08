package com.bancodelt.java.program.controllers.compositions;

import com.bancodelt.java.config.MascaraTextField;
import com.bancodelt.java.models.Conta2;
import com.bancodelt.java.models.alerts.AlertErrorPrototype;
import com.bancodelt.java.models.alerts.AlertInformationPrototype;
import com.bancodelt.java.models.alerts.AlertWarningPrototype;
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
            valorASacar = new Double(txtFValor.getText());
            if(valorASacar > Conta2.getSaldo()) {
                alertaErro = new AlertErrorPrototype("Erro", "Saldo Insuficiente", "Você não tem saldo suficiente para a transação.");
            } else {
                alertaInforma = new AlertInformationPrototype("Saque", "Saque efetuado", "Você sacou " + valorASacar);
            }
            
            
        }
    }
}
