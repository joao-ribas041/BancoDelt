package com.bancodelt.java.models;

public abstract class Conta2 {
    
    protected static int numAgencia,
            numConta,
            tipo;

    protected static String Agencia = null,
            Conta = null,
            CPF = null,
            email = null,
            numeroCelular = null,
            nomeTitular = null,
            generoTitular = null,
            senhaTitular = null,
            dataNascimento = null,
            dataCriacaoAcc = null;

    protected static double saldo;

    public static double depositar(double valor){
        return saldo - valor;
    }
    
    public static double sacar(double valor){
        return saldo - valor;
    }

    public static int getNumAgencia() {
        return numAgencia;
    }

    public static void setNumAgencia(int numAgencia) {
        Conta2.numAgencia = numAgencia;
    }

    public static int getNumConta() {
        return numConta;
    }

    public static void setNumConta(int numConta) {
        Conta2.numConta = numConta;
    }

    public static int getTipo() {
        return tipo;
    }

    public static void setTipo(int tipo) {
        Conta2.tipo = tipo;
    }

    public static String getAgencia() {
        return Agencia;
    }

    public static void setAgencia(String Agencia) {
        Conta2.Agencia = Agencia;
    }

    public static String getConta() {
        return Conta;
    }

    public static void setConta(String Conta) {
        Conta2.Conta = Conta;
    }

    public static String getCPF() {
        return CPF;
    }

    public static void setCPF(String CPF) {
        Conta2.CPF = CPF;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Conta2.email = email;
    }

    public static String getNumeroCelular() {
        return numeroCelular;
    }

    public static void setNumeroCelular(String numeroCelular) {
        Conta2.numeroCelular = numeroCelular;
    }

    public static String getNomeTitular() {
        return nomeTitular;
    }

    public static void setNomeTitular(String nomeTitular) {
        Conta2.nomeTitular = nomeTitular;
    }

    public static String getGeneroTitular() {
        return generoTitular;
    }

    public static void setGeneroTitular(String generoTitular) {
        Conta2.generoTitular = generoTitular;
    }

    public static String getSenhaTitular() {
        return senhaTitular;
    }

    public static void setSenhaTitular(String senhaTitular) {
        Conta2.senhaTitular = senhaTitular;
    }

    public static String getDataNascimento() {
        return dataNascimento;
    }

    public static void setDataNascimento(String dataNascimento) {
        Conta2.dataNascimento = dataNascimento;
    }

    public static String getDataCriacaoAcc() {
        return dataCriacaoAcc;
    }

    public static void setDataCriacaoAcc(String dataCriacaoAcc) {
        Conta2.dataCriacaoAcc = dataCriacaoAcc;
    }

    public static double getSaldo() {
        return saldo;
    }

    public static void setSaldo(double saldo) {
        Conta2.saldo = saldo;
    }
    
    
}
