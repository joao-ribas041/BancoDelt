package com.bancodelt.java.models;

public class EstiloAcc {
    
    private int id;
    private String estilo;

    public EstiloAcc(int id, String estilo) {
        this.id = id;
        this.estilo = estilo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return getEstilo();
    }
}
