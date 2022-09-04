package com.bancodelt.java.models;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class MascaraFx extends TextField{
    
    public static void mascaraNumerosInteiros(TextField textField){
        textField.textProperty().addListener((ObservableValue<? extends String> observable, String valorAntigo, String valorNovo) -> {
            if(!valorNovo.matches("\\d*")) {
                textField.setText(valorNovo.replaceAll("[^\\d]", ""));
            }
        });
    }
    
}
