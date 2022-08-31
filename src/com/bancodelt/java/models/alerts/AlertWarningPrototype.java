package com.bancodelt.java.models.alerts;

public class AlertWarningPrototype  extends AlertPrototype{
    
    public AlertWarningPrototype(String titulo, String msgPrincipal, String subMsg) {
        a1.setTitle(titulo);
        a1.setHeaderText(msgPrincipal);
        a1.setContentText(subMsg);
        System.out.println("Alerta " + msgPrincipal);
        a1.showAndWait();
    }
    
    protected AlertWarningPrototype(AlertWarningPrototype alertWarningPrototype) {
        this.titulo = alertWarningPrototype.getTitulo();
        this.msgPrincipal = alertWarningPrototype.getMsgPrincipal();
        this.subMsg = alertWarningPrototype.getSubMsg();
    }
    
    public AlertWarningPrototype() {
        titulo = null;
        msgPrincipal = null;
        subMsg = null;
    }
    
    @Override
    public void exibirAlert() {
        a1.setTitle(getTitulo());
        a1.setHeaderText(getMsgPrincipal());
        a1.setContentText(getSubMsg());
        a1.showAndWait();
    }
    
    @Override
    public AlertPrototype clonar() {
        return new AlertWarningPrototype(this);
    }
}
