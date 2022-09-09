package com.bancodelt.java.models.alerts;

public class AlertInformationPrototype extends AlertPrototype {
    
    public AlertInformationPrototype(String titulo, String msgPrincipal, String subMsg) {
        a3.setTitle(titulo);
        a3.setHeaderText(msgPrincipal);
        a3.setContentText(subMsg);
        System.out.println("Alerta " + msgPrincipal);
        a3.showAndWait();
    }
    
    protected AlertInformationPrototype(AlertInformationPrototype alertErrorPrototype) {
        this.titulo = alertErrorPrototype.getTitulo();
        this.msgPrincipal = alertErrorPrototype.getMsgPrincipal();
        this.subMsg = alertErrorPrototype.getSubMsg();
    }
    
    public AlertInformationPrototype() {
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
        return new AlertInformationPrototype(this);
    }
}
