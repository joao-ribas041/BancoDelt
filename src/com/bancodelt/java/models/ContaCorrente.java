package com.bancodelt.java.models;

public class ContaCorrente extends Conta2{

    public ContaCorrente(int numAgencia, int numConta, String CPF, String email, String numeroCelular,String nomeTitular, String generoTitular, String senhaTitular, String dataNascimento, String dataCriacaoAcc, double saldo) {
        this.numAgencia = numAgencia;
        this.numConta = numConta;
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
