package com.bancodelt.java.program.controllers;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewLoginAppController implements Initializable {

    @FXML
    private ImageView btnVoltar;
    @FXML
    private TextField txtFCPF;
    @FXML
    private TextField txtFSenha;
    @FXML
    private Button btnEntrar;
    @FXML
    private HBox hboxlogin;
    
    Main m = new Main();
    AlertWarningPrototype alertaAviso;
    
    ContaDAO cDAO = new ContaDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MouseBarEvents();
        txtFCPF.setEditable(false);
        txtFCPF.setText(ViewOpenAppController.getCPFinput());
    }   

    @FXML
    private void AcaoBtnEntrar(ActionEvent event) throws IOException {
        LoginApp();
    }
    
    @FXML
    private void btnVoltarClick(MouseEvent event) throws IOException {
        Main.getProgram().close();
        m.switchTelas(new Stage(), "ViewOpenApp.fxml");
    }
    
    private boolean LoginApp() throws IOException{
        if(cDAO.loginTitular(txtFCPF.getText(), txtFSenha.getText()) == true) {
            cDAO.resgatarDadosTitular(txtFCPF.getText());
            Main.getProgram().close();
            m.switchTelas(new Stage(), "ViewPrincipalApp.fxml");
            return true;
        } else {
            alertaAviso = new AlertWarningPrototype("Alerta", "Usuario invalido!", "Verifique o cpf ou a senha.");
            return false;
        }
    }
    
    private void MouseBarEvents() {
        btnVoltar.setOnMouseEntered((event) -> {
            btnVoltar.setFitWidth(25);
            btnVoltar.setFitHeight(25);
        });
        btnVoltar.setOnMouseExited((event) -> {
            btnVoltar.setFitWidth(20);
            btnVoltar.setFitHeight(20);
        });
        txtFSenha.setOnKeyPressed((event) -> {
            if(event.getCode() == KeyCode.ENTER) {
                try {
                    LoginApp();
                } catch (IOException ex) {
                    Logger.getLogger(ViewLoginAppController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
