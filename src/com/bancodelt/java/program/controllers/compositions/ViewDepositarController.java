package com.bancodelt.java.program.controllers.compositions;

import com.bancodelt.java.config.MascaraTextField;
import com.bancodelt.java.models.Conta2;
import com.bancodelt.java.models.alerts.AlertWarningPrototype;
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
    private double valorADepositar = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MascaraTextField.mascaraReal(txtFValor);
    }    

    @FXML
    private void btnDepositarAction(ActionEvent event) {
        depositar();
    }
    
    private void depositar() {
        if (txtFValor.getText().isEmpty()) {
            alertaAviso = new AlertWarningPrototype("Alerta", "Informe o valor", "Você não solicitou nenhum valor para deposito.");
        } else {
            valorADepositar = new Double(txtFValor.getText());
            
            System.out.println(valorADepositar);
        }
    }
}
