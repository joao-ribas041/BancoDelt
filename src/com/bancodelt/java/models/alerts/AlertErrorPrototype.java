package com.bancodelt.java.models.alerts;

/**
 *
 * @author João Ribas
 */
public class AlertErrorPrototype extends AlertPrototype {
    
    protected AlertErrorPrototype(AlertErrorPrototype alertErrorPrototype) {
        this.titulo = alertErrorPrototype.getTitulo();
        this.msgPrincipal = alertErrorPrototype.getMsgPrincipal();
        this.subMsg = alertErrorPrototype.getSubMsg();
    }
    
    public AlertErrorPrototype() {
        titulo = null;
        msgPrincipal = null;
        subMsg = null;
    }
    
    @Override
    public void exibirAlert() {
        a2.setTitle(getTitulo());
        a2.setHeaderText(getMsgPrincipal());
        a2.setContentText(getSubMsg());
        a2.showAndWait();
    }
    
    @Override
    public AlertPrototype clonar() {
        return new AlertErrorPrototype(this);
    }
}
