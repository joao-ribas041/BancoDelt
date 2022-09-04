package com.bancodelt.java.program;

import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    
    private static Stage program;
    private static final String directoryJavaInterfaces = "/com/bancodelt/java/program/interfaces/";
    
    private static final String directoryJavaResources = "/com/bancodelt/resources/";
    private static final String directoryJavaCss = "/com/bancodelt/resources/css/";
    private static final String directoryJavaIcons = "/com/bancodelt/resources/icons/";
    private static final String directoryJavaImages = "/com/bancodelt/resources/images/";
    private final Image logoApp = new Image(getClass().getResourceAsStream(Main.getDirectoryJavaResources() + "Logo.png"));
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        rodarTela(stage, "ViewOpenApp.fxml");
    }
    
    public void rodarTela(Stage stg, String telafxml) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(Main.getDirectoryJavaInterfaces() + telafxml));
        Scene scene = new Scene(root);
        //stg.initStyle(StageStyle.UNDECORATED);
        stg.setTitle("Banco Delt");
        stg.getIcons().add(getLogoApp());
        stg.centerOnScreen();
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
    public static String getDirectoryJavaResources() {
        return directoryJavaResources;
    }
    public static String getDirectoryJavaCss() {
        return directoryJavaCss;
    }
    public static String getDirectoryJavaIcons() {
        return directoryJavaIcons;
    }
    public static String getDirectoryJavaImages() {
        return directoryJavaImages;
    }
    public Image getLogoApp() {
        return logoApp;
    }
}
