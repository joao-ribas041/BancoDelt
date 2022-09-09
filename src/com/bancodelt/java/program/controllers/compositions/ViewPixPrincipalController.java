package com.bancodelt.java.program.controllers.compositions;

import com.bancodelt.java.program.Main;
import com.bancodelt.java.program.controllers.ViewPrincipalAppController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class ViewPixPrincipalController implements Initializable {

    @FXML
    private FlowPane fpCadastrarPix;
    @FXML
    private ImageView imgCadPIX;
    @FXML
    private FlowPane fpPagarPix;
    @FXML
    private ImageView imgPagarPIX;
    @FXML
    private FlowPane fpReceberPix;
    @FXML
    private ImageView imgReceberPIX;
    @FXML
    private BorderPane menuCenter;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mouseMenuHomeAction();
    }
    
    private void mouseMenuHomeAction(){
        fpCadastrarPix.setOnMouseEntered((event) -> {
            imgCadPIX.setFitWidth(150);
            imgCadPIX.setFitHeight(150);
            fpCadastrarPix.setPrefWidth(165);
            fpCadastrarPix.setPrefHeight(165);
        });
        fpCadastrarPix.setOnMouseExited((event) -> {
            imgCadPIX.setFitWidth(130);
            imgCadPIX.setFitHeight(130);
            fpCadastrarPix.setPrefWidth(145);
            fpCadastrarPix.setPrefHeight(145);
        });
        fpPagarPix.setOnMouseEntered((event) -> {
            imgPagarPIX.setFitWidth(150);
            imgPagarPIX.setFitHeight(150);
            fpPagarPix.setPrefWidth(165);
            fpPagarPix.setPrefHeight(165);
        });
        fpPagarPix.setOnMouseExited((event) -> {
            imgPagarPIX.setFitWidth(130);
            imgPagarPIX.setFitHeight(130);
            fpPagarPix.setPrefWidth(145);
            fpPagarPix.setPrefHeight(145);
        });
        fpReceberPix.setOnMouseEntered((event) -> {
            imgReceberPIX.setFitWidth(150);
            imgReceberPIX.setFitHeight(150);
            fpReceberPix.setPrefWidth(165);
            fpReceberPix.setPrefHeight(165);
        });
        fpReceberPix.setOnMouseExited((event) -> {
            imgReceberPIX.setFitWidth(130);
            imgReceberPIX.setFitHeight(130);
            fpReceberPix.setPrefWidth(145);
            fpReceberPix.setPrefHeight(145);
        });
        fpCadastrarPix.setOnMouseClicked((event) -> {
            carregarSubTelas("ViewPixCadastrar.fxml");
        });
        fpPagarPix.setOnMouseClicked((event) -> {
            carregarSubTelas("ViewPixPagar.fxml");
        });
        fpReceberPix.setOnMouseClicked((event) -> {
            carregarSubTelas("ViewPixReceber.fxml");
        });
    }
    
    private void carregarSubTelas(String tela){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(Main.getDirectoryJavaInterfacesCompositions() + tela));
        } catch (IOException ex) {
            Logger.getLogger(ViewPrincipalAppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        menuCenter.setCenter(root);
    }
}
