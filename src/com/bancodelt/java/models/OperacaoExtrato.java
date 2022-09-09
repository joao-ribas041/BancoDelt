package com.bancodelt.java.models;

public class OperacaoExtrato {
    
    protected static String dataTransacao,
            tipoTransacao;
    
    protected static double valorTransacao,
            saldoAnterior,
            saldoPosterior;

    public static String getDataTransacao() {
        return dataTransacao;
    }

    public static void setDataTransacao(String dataTransacao) {
        OperacaoExtrato.dataTransacao = dataTransacao;
    }

    public static String getTipoTransacao() {
        return tipoTransacao;
    }

    public static void setTipoTransacao(String tipoTransacao) {
        OperacaoExtrato.tipoTransacao = tipoTransacao;
    }

    public static double getValorTransacao() {
        return valorTransacao;
    }

    public static void setValorTransacao(double valorTransacao) {
        OperacaoExtrato.valorTransacao = valorTransacao;
    }

    public static double getSaldoAnterior() {
        return saldoAnterior;
    }

    public static void setSaldoAnterior(double saldoAnterior) {
        OperacaoExtrato.saldoAnterior = saldoAnterior;
    }

    public static double getSaldoPosterior() {
        return saldoPosterior;
    }

    public static void setSaldoPosterior(double saldoPosterior) {
        OperacaoExtrato.saldoPosterior = saldoPosterior;
    }
}
