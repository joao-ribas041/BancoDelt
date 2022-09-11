package com.bancodelt.java.program.controllers.compositions;

import com.bancodelt.java.models.ContaCorrente;
import com.bancodelt.java.models.alerts.AlertErrorPrototype;
import com.bancodelt.java.models.alerts.AlertInformationPrototype;
import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.models.dao.PixDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class ViewPixCadastrarController implements Initializable {

    @FXML
    private FlowPane Titulo;
    @FXML
    private VBox VBoxCPF;
    @FXML
    private Label lblCPF;
    @FXML
    private TextField txtFCPF;
    @FXML
    private Button btnCadastrarCPF;
    @FXML
    private VBox VBoxNumero;
    @FXML
    private Label lblNumero;
    @FXML
    private TextField txtFNumeroTel;
    @FXML
    private Button btnCadastrarNumero;
    @FXML
    private VBox VBoxEmail;
    @FXML
    private Label lblEmail;
    @FXML
    private TextField txtFEmail;
    @FXML
    private Button btnCadastrarEmail;

    AlertWarningPrototype alertaAviso;
    AlertErrorPrototype alertaErro;
    AlertInformationPrototype alertaInforma;

    PixDAO pDAO = new PixDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        possuiChaves();
        btnCadastrarChaves();
        txtFCPF.setText(ContaCorrente.getCPF());
        txtFNumeroTel.setText(ContaCorrente.getNumeroCelular());
        txtFEmail.setText(ContaCorrente.getEmail());
    }

    private void possuiChaves() {
        if (pDAO.possuiPix(ContaCorrente.getNumConta())) {
            pDAO.resgatarChavesPix(ContaCorrente.getNumConta());
            if (ContaCorrente.getChavesPix().equals(ContaCorrente.getCPF())) {
                btnCadastrarCPF.setDisable(true);
                btnCadastrarCPF.setVisible(false);
            } else {
                btnCadastrarCPF.setDisable(false);
                btnCadastrarCPF.setVisible(true);
            }
            if (ContaCorrente.getChavesPix().equals(ContaCorrente.getNumeroCelular())) {
                btnCadastrarNumero.setDisable(true);
                btnCadastrarNumero.setVisible(false);
            } else {
                btnCadastrarNumero.setDisable(false);
                btnCadastrarNumero.setVisible(true);
            }
            if (ContaCorrente.getChavesPix().equals(ContaCorrente.getEmail())) {
                btnCadastrarEmail.setDisable(true);
                btnCadastrarEmail.setVisible(false);
            } else {
                btnCadastrarEmail.setDisable(false);
                btnCadastrarEmail.setVisible(true);
            }
        } else {
            System.out.println("\n\n\nEle não possui pix.");
            btnCadastrarCPF.setDisable(false);
            btnCadastrarCPF.setVisible(true);
            btnCadastrarNumero.setDisable(false);
            btnCadastrarNumero.setVisible(true);
            btnCadastrarEmail.setDisable(false);
            btnCadastrarEmail.setVisible(true);
        }
    }

    private void btnCadastrarChaves() {
        if (!btnCadastrarCPF.isDisable()) {
            btnCadastrarCPF.setOnMouseClicked((event) -> {
                if (pDAO.CadastrarPix(txtFCPF.getText(), ContaCorrente.getNumConta())) {
                    alertaInforma = new AlertInformationPrototype("Alerta", "Cadastrado com sucesso", "Chave pix cadastrada com sucesso.");
                    btnCadastrarCPF.setDisable(true);
                    btnCadastrarCPF.setVisible(false);
                } else {
                    alertaErro = new AlertErrorPrototype("Alerta", "Falha ao cadastrar", "Não foi possivel cadastrar chave pix.");
                }
            });
        }

        if (!btnCadastrarNumero.isDisable()) {
            btnCadastrarNumero.setOnMouseClicked((event) -> {
                if (pDAO.CadastrarPix(txtFNumeroTel.getText(), ContaCorrente.getNumConta())) {
                    alertaInforma = new AlertInformationPrototype("Alerta", "Cadastrado com sucesso", "Chave pix cadastrada com sucesso.");
                    btnCadastrarNumero.setDisable(true);
                    btnCadastrarNumero.setVisible(false);
                } else {
                    alertaErro = new AlertErrorPrototype("Alerta", "Falha ao cadastrar", "Não foi possivel cadastrar chave pix.");
                }
            });
        }
        
        if (!btnCadastrarEmail.isDisable()) {
            btnCadastrarEmail.setOnMouseClicked((event) -> {
                if(pDAO.CadastrarPix(txtFEmail.getText(), ContaCorrente.getNumConta())) {
                    alertaInforma = new AlertInformationPrototype("Alerta", "Cadastrado com sucesso", "Chave pix cadastrada com sucesso.");
                    btnCadastrarEmail.setDisable(true);
                    btnCadastrarEmail.setVisible(false);
                } else {
                    alertaErro = new AlertErrorPrototype("Alerta", "Falha ao cadastrar", "Não foi possivel cadastrar chave pix.");
                }
            });
        }
    }
}
