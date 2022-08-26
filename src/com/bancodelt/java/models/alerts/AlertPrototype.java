package com.bancodelt.java.models.alerts;

import javafx.scene.control.Alert;

public abstract class AlertPrototype {
    
    protected Alert a1 = new Alert(Alert.AlertType.WARNING);
    protected Alert a2 = new Alert(Alert.AlertType.ERROR);
    
    protected String titulo, msgPrincipal, subMsg;
    
    public abstract void exibirAlert();
    public abstract AlertPrototype clonar();

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMsgPrincipal() {
        return msgPrincipal;
    }
    public void setMsgPrincipal(String msgPrincipal) {
        this.msgPrincipal = msgPrincipal;
    }

    public String getSubMsg() {
        return subMsg;
    }
    public void setSubMsg(String subMsg) {
        this.subMsg = subMsg;
    }
}
