package com.bancodelt.java.models;

import java.util.Date;

public abstract class Conta {
    
    int numeroAgencia;
    String numeroConta;
    String CPF;
    String email;
    String ddd;
    String numeroCelular;
    String nomeTitular;
    String senhaTitular;
    String dataNascimento;
    String dataCriacaoAcc;
    double saldo;
    byte tipo;
    
    void sacar() {
        
    }
    
    void depositar() {
        
    }
}
