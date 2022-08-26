package com.bancodelt.java.models.alerts;

/**
 *
 * @author João Ribas
 */
public class AlertWarningPrototype  extends AlertPrototype{
    
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
