package com.bancodelt.java.program.controllers;

import com.bancodelt.java.program.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewRegisterAppController implements Initializable {

    @FXML
    private ImageView btnVoltar;
    @FXML
    private TextField txtFCPF;
    @FXML
    private TextField txtFSenha;
    @FXML
    private Button btnRegistrar;
    
    Main m = new Main();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MouseBarEvents();
    }

    @FXML
    private void AcaoBtnRegistrar(ActionEvent event) {
    }
    
    private void MouseBarEvents() {
        btnVoltar.setOnMouseEntered((event) -> {
            btnVoltar.setFitWidth(30);
            btnVoltar.setFitHeight(30);
        });
        btnVoltar.setOnMouseExited((event) -> {
            btnVoltar.setFitWidth(20);
            btnVoltar.setFitHeight(20);
        });
    }

    @FXML
    private void btnVoltarClick(MouseEvent event) throws IOException {
        Main.getProgram().close();
        m.switchTelas(new Stage(), "ViewOpenApp.fxml");
    }
}
