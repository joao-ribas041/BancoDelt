package com.bancodelt.java.models;

public class ContaCorrente extends Conta {

    ContaCorrente() {
    }
    
    ContaCorrente(int numeroAgencia, String numeroConta, String CPF, String nomeTitular, String senhaTitular, String dataNascimento, String dataCriacaoAcc, double saldo) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.CPF = CPF;
        this.nomeTitular = nomeTitular;
        this.senhaTitular = senhaTitular;
        this.dataNascimento = dataNascimento;
        this.dataCriacaoAcc = dataCriacaoAcc;
        this.saldo = saldo;
        this.tipo = 1;
    }
    
    void pix() {    }
}
