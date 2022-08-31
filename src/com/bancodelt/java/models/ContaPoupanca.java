package com.bancodelt.java.models;

public class ContaPoupanca extends Conta {

    ContaPoupanca() {
    }
    
    ContaPoupanca(int numeroAgencia, String numeroConta, String nomeTitular, String senhaTitular, String CPF, double saldo, double dataCriacaoAcc) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.senhaTitular = senhaTitular;
        this.CPF = CPF;
        this.saldo = saldo;
        this.dataCriacaoAcc = dataCriacaoAcc;
        this.tipo = 0;
    }
    
    void remuneracao() {    }
}
