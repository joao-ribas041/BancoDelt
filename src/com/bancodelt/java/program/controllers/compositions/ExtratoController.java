package com.bancodelt.java.program.controllers.compositions;

import com.bancodelt.java.models.OperacaoExtrato;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ExtratoController implements Initializable {

    @FXML
    private Label lblTipoTransacao;
    @FXML
    private Label lblValorTransacao;
    @FXML
    private Label lblSaldo;
    @FXML
    private Label lblSaldoPosTransacao;
    @FXML
    private Label lblDataTransacao;
    @FXML
    private VBox caixaExtrato;
    
    OperacaoExtrato oe = new OperacaoExtrato();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void setDadosExtrato() {
        lblDataTransacao.setText(OperacaoExtrato.getDataTransacao());
        lblTipoTransacao.setText(OperacaoExtrato.getTipoTransacao());
        //lblValorTransacao.setText(OperacaoExtrato.getValorTransacao());
        //lblSaldoPosTransacao.setText(OperacaoExtrato.getSaldoPosterior());
    }    
}
