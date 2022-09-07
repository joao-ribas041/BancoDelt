package com.bancodelt.java.models;

public abstract class Conta {
    
    protected static int numeroAgencia,
            numeroConta,
            tipo; 
    
    protected static String numAgencia = null,
            numConta = null,
            CPF = null,
            email = null,
            numeroCelular = null,
            nomeTitular = null,
            generoTitular = null,
            senhaTitular = null,
            dataNascimento = null,
            dataCriacaoAcc = null;
    
    protected static double saldo;
    
    void sacar() {
        
    }
    
    void depositar() {
        
    }

    public static int getNumeroAgencia() {
        return numeroAgencia;
    }

    public static void setNumeroAgencia(int numeroAgencia) {
        Conta.numeroAgencia = numeroAgencia;
    }

    public static int getNumeroConta() {
        return numeroConta;
    }

    public static void setNumeroConta(int numeroConta) {
        Conta.numeroConta = numeroConta;
    }

    public static int getTipo() {
        return tipo;
    }

    public static void setTipo(int tipo) {
        Conta.tipo = tipo;
    }

    public static String getNumAgencia() {
        return numAgencia;
    }

    public static void setNumAgencia(String numAgencia) {
        Conta.numAgencia = numAgencia;
    }

    public static String getNumConta() {
        return numConta;
    }

    public static void setNumConta(String numConta) {
        Conta.numConta = numConta;
    }

    public static String getCPF() {
        return CPF;
    }

    public static void setCPF(String CPF) {
        Conta.CPF = CPF;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Conta.email = email;
    }

    public static String getNumeroCelular() {
        return numeroCelular;
    }

    public static void setNumeroCelular(String numeroCelular) {
        Conta.numeroCelular = numeroCelular;
    }

    public static String getNomeTitular() {
        return nomeTitular;
    }

    public static void setNomeTitular(String nomeTitular) {
        Conta.nomeTitular = nomeTitular;
    }

    public static String getGeneroTitular() {
        return generoTitular;
    }

    public static void setGeneroTitular(String generoTitular) {
        Conta.generoTitular = generoTitular;
    }

    public static String getSenhaTitular() {
        return senhaTitular;
    }

    public static void setSenhaTitular(String senhaTitular) {
        Conta.senhaTitular = senhaTitular;
    }

    public static String getDataNascimento() {
        return dataNascimento;
    }

    public static void setDataNascimento(String dataNascimento) {
        Conta.dataNascimento = dataNascimento;
    }

    public static String getDataCriacaoAcc() {
        return dataCriacaoAcc;
    }

    public static void setDataCriacaoAcc(String dataCriacaoAcc) {
        Conta.dataCriacaoAcc = dataCriacaoAcc;
    }

    public static double getSaldo() {
        return saldo;
    }

    public static void setSaldo(double saldo) {
        Conta.saldo = saldo;
    }
    
    
}
