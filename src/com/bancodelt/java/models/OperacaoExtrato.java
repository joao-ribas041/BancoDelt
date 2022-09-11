package com.bancodelt.java.models;

public class OperacaoExtrato {
    
    private String dataTransacao,
            tipoTransacao;
    
    private double valorTransacao,
            saldoPosterior;

    public OperacaoExtrato() {
    }

    public OperacaoExtrato(String dataTransacao, String tipoTransacao, double valorTransacao, double saldoPosterior) {
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
        this.saldoPosterior = saldoPosterior;
    }

    
    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public double getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(double valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public double getSaldoPosterior() {
        return saldoPosterior;
    }

    public void setSaldoPosterior(double saldoPosterior) {
        this.saldoPosterior = saldoPosterior;
    }

    
}
