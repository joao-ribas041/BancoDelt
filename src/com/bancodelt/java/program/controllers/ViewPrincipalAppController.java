package com.bancodelt.java.program.controllers;

import com.bancodelt.java.program.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewPrincipalAppController implements Initializable {

    @FXML
    private Label lblSaldo;
    @FXML
    private Label lblRS;
    @FXML
    private ImageView btnViewHide;
    @FXML
    private AnchorPane MenuSlider;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnPerfil;
    @FXML
    private Button btnSacar;
    @FXML
    private Button btnDepositar;
    @FXML
    private Button btnPix;
    @FXML
    private Button btnDeslogar;
    @FXML
    private ImageView imgLogo;
    @FXML
    private AnchorPane PainelCentral;
    
    Main m = new Main();
    @FXML
    private BorderPane TelaPrincipal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void btnHomeAction(ActionEvent event) {
        TelaPrincipal.setCenter(PainelCentral);
    }

    @FXML
    private void btnPerfilAction(ActionEvent event) {
        carregarSubTelas("ViewPerfil.fxml");
    }

    @FXML
    private void btnSacarAction(ActionEvent event) {
        carregarSubTelas("ViewSacar.fxml");
    }

    @FXML
    private void btnDepositarAction(ActionEvent event) {
        carregarSubTelas("ViewDepositar.fxml");
    }

    @FXML
    private void btnPixAction(ActionEvent event) {
        carregarSubTelas("ViewPixPrincipal.fxml");
    }

    @FXML
    private void btnDeslogarAction(ActionEvent event) throws IOException {
        Main.getProgram().close();
        m.switchTelas(new Stage(), "ViewOpenApp.fxml");
    }
    
    private void carregarSubTelas(String tela){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(Main.getDirectoryJavaInterfacesCompositions() + tela));
        } catch (IOException ex) {
            Logger.getLogger(ViewPrincipalAppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        TelaPrincipal.setCenter(root);
    }
}
