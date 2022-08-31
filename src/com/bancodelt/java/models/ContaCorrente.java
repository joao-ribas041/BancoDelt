package com.bancodelt.java.models;

import java.util.Date;

public class ContaCorrente extends Conta {

    ContaCorrente() {
    }
    
    ContaCorrente(int numeroAgencia, String numeroConta, String CPF, String email, int ddd, String numeroCelular,String nomeTitular, String senhaTitular, Date dataNascimento, Date dataCriacaoAcc, double saldo) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.CPF = CPF;
        this.email = email;
        this.ddd = ddd;
        this.numeroCelular = numeroCelular;
        this.nomeTitular = nomeTitular;
        this.senhaTitular = senhaTitular;
        this.dataNascimento = dataNascimento;
        this.dataCriacaoAcc = dataCriacaoAcc;
        this.saldo = saldo;
        this.tipo = 1;
    }
    
    void pix() {    }
}
