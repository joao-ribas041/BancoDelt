package com.bancodelt.java.program.controllers.compositions;

import com.bancodelt.java.models.OperacaoExtrato;
import java.net.URL;
import java.text.DecimalFormat;
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
    DecimalFormat df = new DecimalFormat("###,##0.00");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void setDadosExtrato(OperacaoExtrato op) {
        lblDataTransacao.setText(op.getDataTransacao());
        lblTipoTransacao.setText(op.getTipoTransacao());
        lblValorTransacao.setText(df.format(op.getValorTransacao()));
        lblSaldoPosTransacao.setText(df.format(op.getSaldoPosterior()));
        //lblValorTransacao.setText(OperacaoExtrato.getValorTransacao());
        //lblSaldoPosTransacao.setText(OperacaoExtrato.getSaldoPosterior());
    }    
}
