package com.bancodelt.java.program.controllers;

import com.bancodelt.java.config.MascaraTextField;
import com.bancodelt.java.config.VerificaCPF;
import com.bancodelt.java.models.alerts.AlertWarningPrototype;
import com.bancodelt.java.models.dao.ContaDAO;
import com.bancodelt.java.program.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        txtFCPF.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    seguir();
                } catch (IOException ex) {
                    Logger.getLogger(ViewOpenAppController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnSeguir.setOnAction((event) -> {
            try {
                seguir();
            } catch (IOException ex) {
                Logger.getLogger(ViewOpenAppController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private int CheckCPF() {
        if (txtFCPF.getText().isEmpty() || txtFCPF.getText().length() < 14) {
            alertaAviso = new AlertWarningPrototype("Alerta", "CPF INCOMPLETO", "O campo CPF esta incompleto. Por favor informe o CPF");
            return 0;
        } else {
            if (cDAO.jaTemConta(txtFCPF.getText()) == true) {
                setCPFinput(txtFCPF.getText());
                return 1;
            } else {
                VerificaCPF vCPF = new VerificaCPF(txtFCPF.getText());
                if (vCPF.isCPF()) {
                    setCPFinput(txtFCPF.getText());
                    return 2;
                } else {
                    alertaAviso = new AlertWarningPrototype("Alerta", "Cpf Invalido!", "O CPF informado é invalido, por favor informe um CPF legitimo para Registrar a conta.");
                    return 0;

                }
            }
        }
    }

    private void seguir() throws IOException {
        int valor = CheckCPF();
        if (valor == 1) {
            valor = 0;
            Main.getProgram().close();
            m.switchTelas(new Stage(), "ViewLoginApp.fxml");
        } else if (valor == 2) {
            valor = 0;
            Main.getProgram().close();
            m.switchTelas(new Stage(), "ViewRegisterApp.fxml");
        }
    }

    public static void setCPFinput(String CPFinput) {
        ViewOpenAppController.CPFinput = CPFinput;
    }

    public static String getCPFinput() {
        return CPFinput;
    }
}
