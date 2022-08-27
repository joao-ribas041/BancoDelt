package com.bancodelt.java.program.interfaces;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author João Ribas
 */
public class ViewOpenAppController implements Initializable {

    @FXML
    private Button btnEntrar;
    @FXML
    private TextField txtFCPF;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void AcaoBtnEntrar(ActionEvent event) {
        CheckACC();
    }
    
    private void CheckACC() {
        Alert a1 = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
        if (txtFCPF.getText().isEmpty()) {
            a1.setTitle("Alerta");
            a1.setHeaderText("Informe o CPF!");
        }
    }
}
