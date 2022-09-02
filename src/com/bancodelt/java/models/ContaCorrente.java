package com.bancodelt.java.models;

import java.util.Date;

public class ContaCorrente extends Conta {

    public ContaCorrente() {
    }
    
    public ContaCorrente(int numeroAgencia, int numeroConta, String CPF, String email, String ddd, String numeroCelular,String nomeTitular, String senhaTitular, String dataNascimento, String dataCriacaoAcc, double saldo) {
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
