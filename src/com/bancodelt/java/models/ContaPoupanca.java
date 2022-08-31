package com.bancodelt.java.models;

public class ContaPoupanca extends Conta {

    ContaPoupanca() {
    }
    
    ContaPoupanca(int numeroAgencia, String numeroConta, String CPF, String nomeTitular, String senhaTitular, String dataNascimento, String dataCriacaoAcc, double saldo) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.CPF = CPF;
        this.nomeTitular = nomeTitular;
        this.senhaTitular = senhaTitular;
        this.dataNascimento = dataNascimento;
        this.saldo = saldo;
        this.dataCriacaoAcc = dataCriacaoAcc;
        this.tipo = 0;
    }
    
    void remuneracao() {    }
}
