package com.bancodelt.java.models;

public class ContaCorrente extends Conta {
    
    public ContaCorrente(int numeroAgencia, int numeroConta, String CPF, String email, String numeroCelular,String nomeTitular, String generoTitular, String senhaTitular, String dataNascimento, String dataCriacaoAcc, double saldo) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.CPF = CPF;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.nomeTitular = nomeTitular;
        this.generoTitular = generoTitular;
        this.senhaTitular = senhaTitular;
        this.dataNascimento = dataNascimento;
        this.dataCriacaoAcc = dataCriacaoAcc;
        this.saldo = saldo;
        this.tipo = 2;
    }
    
    void pix() {    }
}
