package com.bancodelt.java.models;

import java.util.Date;

public abstract class Conta {
    
    int numeroAgencia;
    int numeroConta;
    String CPF;
    String email;
    String ddd;
    String numeroCelular;
    String nomeTitular;
    String generoTitular;
    String senhaTitular;
    String dataNascimento;
    String dataCriacaoAcc;
    double saldo;
    byte tipo;
    
    void sacar() {
        
    }
    
    void depositar() {
        
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEmail() {
        return email;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public String getGeneroTitular() {
        return generoTitular;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getDataCriacaoAcc() {
        return dataCriacaoAcc;
    }

    public double getSaldo() {
        return saldo;
    }

    public byte getTipo() {
        return tipo;
    }
    
    
}
