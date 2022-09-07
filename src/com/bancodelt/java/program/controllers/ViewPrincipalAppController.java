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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
    private Button btnDepositar;
    @FXML
    private Button btnDeslogar;
    @FXML
    private ImageView imgLogo;
    @FXML
    private FlowPane PainelCentral;
    @FXML
    private BorderPane TelaPrincipal;
    @FXML
    private FlowPane fpDepositar;
    @FXML
    private FlowPane fpTransferir;
    @FXML
    private FlowPane fpPIX;
    @FXML
    private FlowPane fpPoupanca;
    @FXML
    private Button btnTransferir;
    @FXML
    private Button btnPIX;
    @FXML
    private Button btnPoupanca;
    @FXML
    private Button btnExtrato;
    @FXML
    private FlowPane fpExtrato;
    @FXML
    private ImageView imgDepositar;
    @FXML
    private ImageView imgTransferir;
    @FXML
    private ImageView imgPix;
    @FXML
    private ImageView imgPoupanca;
    @FXML
    private ImageView imgExtrato;
    
    Main m = new Main();
    
    Image imgMostrar = new Image(getClass().getResourceAsStream(Main.getDirectoryJavaIcons() + "MOSTRAR.png"));
    Image imgOculto = new Image(getClass().getResourceAsStream(Main.getDirectoryJavaIcons() + "OCULTAR.png"));
    
    private boolean viewHide = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ViewHide();
        
        mouseMenuHomeAction();
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
    private void btnDepositarAction(ActionEvent event) {
        carregarSubTelas("ViewDepositar.fxml");
    }
    @FXML
    private void btnTransferirAction(ActionEvent event) {
        carregarSubTelas("ViewTransferir.fxml");
    }
    @FXML
    private void btnPIXAction(ActionEvent event) {
        carregarSubTelas("ViewPixPrincipal.fxml");
    }
    @FXML
    private void btnPoupancaAction(ActionEvent event) {
        carregarSubTelas("ViewPoupanca.fxml");
    }
    @FXML
    private void btnExtratoAction(ActionEvent event) {
        carregarSubTelas("ViewExtrato.fxml");
    }
    @FXML
    private void btnDeslogarAction(ActionEvent event) {
        Main.getProgram().close();
        try {
            m.switchTelas(new Stage(), "ViewOpenApp.fxml");
        } catch (IOException ex) {
            Logger.getLogger(ViewPrincipalAppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ViewHide(){
        btnViewHide.setOnMouseEntered((event) -> {
            btnViewHide.setFitWidth(55);
            btnViewHide.setFitHeight(55);
        });
        btnViewHide.setOnMouseExited((event) -> {
            btnViewHide.setFitWidth(45);
            btnViewHide.setFitHeight(45);
        });
        
        btnViewHide.setOnMouseClicked((event) -> {
            if(viewHide == false) {
                lblSaldo.setText("*****");
                btnViewHide.setImage(imgOculto);
                viewHide = true;
            } else {
                lblSaldo.setText("1.000.000,00");
                btnViewHide.setImage(imgMostrar);
                viewHide = false;
            }
        });
    }
    
    private void mouseMenuHomeAction(){
        fpDepositar.setOnMouseEntered((event) -> {
            imgDepositar.setFitWidth(150);
            imgDepositar.setFitHeight(150);
            fpDepositar.setPrefWidth(165);
            fpDepositar.setPrefHeight(165);
        });
        fpDepositar.setOnMouseExited((event) -> {
            imgDepositar.setFitWidth(130);
            imgDepositar.setFitHeight(130);
            fpDepositar.setPrefWidth(145);
            fpDepositar.setPrefHeight(145);
            
        });
        fpTransferir.setOnMouseEntered((event) -> {
            imgTransferir.setFitWidth(150);
            imgTransferir.setFitHeight(150);
            fpTransferir.setPrefWidth(165);
            fpTransferir.setPrefHeight(165);
        });
        fpTransferir.setOnMouseExited((event) -> {
            imgTransferir.setFitWidth(130);
            imgTransferir.setFitHeight(130);
            fpTransferir.setPrefWidth(145);
            fpTransferir.setPrefHeight(145);
        });
        fpPIX.setOnMouseEntered((event) -> {
            imgPix.setFitWidth(150);
            imgPix.setFitHeight(150);
            fpPIX.setPrefWidth(165);
            fpPIX.setPrefHeight(165);
        });
        fpPIX.setOnMouseExited((event) -> {
            imgPix.setFitWidth(130);
            imgPix.setFitHeight(130);
            fpPIX.setPrefWidth(145);
            fpPIX.setPrefHeight(145);
        });
        fpPoupanca.setOnMouseEntered((event) -> {
            imgPoupanca.setFitWidth(150);
            imgPoupanca.setFitHeight(150);
            fpPoupanca.setPrefWidth(165);
            fpPoupanca.setPrefHeight(165);
        });
        fpPoupanca.setOnMouseExited((event) -> {
            imgPoupanca.setFitWidth(130);
            imgPoupanca.setFitHeight(130);
            fpPoupanca.setPrefWidth(145);
            fpPoupanca.setPrefHeight(145);
        });
        fpExtrato.setOnMouseEntered((event) -> {
            imgExtrato.setFitWidth(150);
            imgExtrato.setFitHeight(150);
            fpExtrato.setPrefWidth(165);
            fpExtrato.setPrefHeight(165);
        });
        fpExtrato.setOnMouseExited((event) -> {
            imgExtrato.setFitWidth(130);
            imgExtrato.setFitHeight(130);
            fpExtrato.setPrefWidth(145);
            fpExtrato.setPrefHeight(145);
        });

        fpDepositar.setOnMouseClicked((event) -> {
            carregarSubTelas("ViewDepositar.fxml");
        });
        fpTransferir.setOnMouseClicked((event) -> {
            carregarSubTelas("ViewTransferir.fxml");
        });
        fpPIX.setOnMouseClicked((event) -> {
            carregarSubTelas("ViewPixPrincipal.fxml");
        });
        fpPoupanca.setOnMouseClicked((event) -> {
            carregarSubTelas("ViewPoupanca.fxml");
        });
        fpExtrato.setOnMouseClicked((event) -> {
            carregarSubTelas("ViewExtrato.fxml");
        });
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
