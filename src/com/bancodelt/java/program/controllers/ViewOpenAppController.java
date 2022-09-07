package com.bancodelt.java.program.controllers;

import com.bancodelt.java.config.MascaraTextField;
import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.models.dao.ContaDAO;
import com.bancodelt.java.program.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class ViewOpenAppController implements Initializable {

    @FXML
    private ImageView btnVoltar;
    @FXML
    private TextField txtFCPF;
    @FXML
    private Button btnSeguir;

    public static String CPFinput;

    AlertWarningPrototype alertaAviso;
    Main m = new Main();
    
    ContaDAO cDAO = new ContaDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        MascaraTextField.mascaraCPF(txtFCPF);

        // validar cpf antes de executar os metodos
        txtFCPF.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                seguir();
            }
        });
    }

    @FXML
    private void AcaoBtnSeguir(ActionEvent event) {
        seguir();
    }

    private int CheckCPF() {
        if (txtFCPF.getText().isEmpty() || txtFCPF.getText().length() < 14) {
            alertaAviso = new AlertWarningPrototype("Alerta", "CPF INCOMPLETO", "O campo CPF esta incompleto. Por favor informe o CPF");
            return 0;
        } else {
            if(cDAO.jaTemConta(txtFCPF.getText()) == true) {
                setCPFinput(txtFCPF.getText());
                return 1;
            } else {
                setCPFinput(txtFCPF.getText());
                return 2;
            }
        }
    }

    private void seguir() {
        try {
            if (CheckCPF() == 1) {
                Main.getProgram().close();
                m.switchTelas(new Stage(), "ViewLoginApp.fxml");
            } else if (CheckCPF() == 2) {
                Main.getProgram().close();
                m.switchTelas(new Stage(), "ViewRegisterApp.fxml");
            }
        } catch (IOException e) {
            Logger.getLogger(ViewOpenAppController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void setCPFinput(String CPFinput) {
        ViewOpenAppController.CPFinput = CPFinput;
    }

    public static String getCPFinput() {
        return CPFinput;
    }
}
