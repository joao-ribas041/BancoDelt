package com.bancodelt.java.models;

import java.util.Date;

public class ContaPoupanca extends Conta {

    ContaPoupanca() {
    }
    
    ContaPoupanca(int numeroAgencia, String numeroConta, String CPF, String email, int ddd, String numeroCelular, String nomeTitular, String senhaTitular, Date dataNascimento, Date dataCriacaoAcc, double saldo) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.CPF = CPF;
        this.email = email;
        this.ddd = ddd;
        this.numeroCelular = numeroCelular;
        this.nomeTitular = nomeTitular;
        this.senhaTitular = senhaTitular;
        this.dataNascimento = dataNascimento;
        this.saldo = saldo;
        this.dataCriacaoAcc = dataCriacaoAcc;
        this.tipo = 0;
    }
    
    void remuneracao() {    }
}
