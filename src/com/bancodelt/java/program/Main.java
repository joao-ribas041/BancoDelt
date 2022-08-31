package com.bancodelt.java.program;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    private static Stage program;
    private static final String directoryJavaInterfaces = "/com/bancodelt/java/program/interfaces/";
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        rodarTela(stage, "ViewOpenApp.fxml");
        // Testar a tela de cadastro (comentar linha de cima).
        //rodarTela(stage, "ViewCadastrarApp.fxml");
    }
    
    public void rodarTela(Stage stg, String telafxml) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(Main.getDirectoryJavaInterfaces() + telafxml));
        Scene scene = new Scene(root);
        stg.setScene(scene);
        setProgram(stg);
        stg.show();
    }
    
    // Método para acessar as "cenas" do programa
    public static Stage getProgram() {
        return program;
    }
    public static void setProgram(Stage programLogin) {
        Main.program = programLogin;
    }
    
    
    // Método para obter os diretórios
    public static String getDirectoryJavaInterfaces() {
        return directoryJavaInterfaces;
    }
}
