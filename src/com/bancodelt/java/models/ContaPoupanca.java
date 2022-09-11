package com.bancodelt.java.models;

import com.bancodelt.java.models.dao.ContaDAO;
import com.bancodelt.java.models.dao.ExtratoDAO;

public class ContaPoupanca extends Conta2{

    public ContaPoupanca(int numAgencia, int numConta, String CPF, String email, String numeroCelular, String nomeTitular, String generoTitular, String senhaTitular, String dataNascimento, String dataCriacaoAcc, double saldo) {
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.CPF = CPF;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.nomeTitular = nomeTitular;
        this.generoTitular = generoTitular;
        this.senhaTitular = senhaTitular;
        this.dataNascimento = dataNascimento;
        this.saldo = saldo;
        this.dataCriacaoAcc = dataCriacaoAcc;
        this.tipo = 1;
    }
    
    public static double remuneracao(Double taxa, double saldo) {
        ContaDAO cDAO = new ContaDAO();
        ExtratoDAO eDAO = new ExtratoDAO();
        
        Double correcao = (saldo * taxa / 100);
        Double saldoCorrecao = saldo + correcao;
        
        
        cDAO.atualizarSaldoPessoal(getConta(), saldoCorrecao);
        eDAO.RegistrarExtrato("Correção", correcao, saldoCorrecao, getNumConta());
        
        return saldoCorrecao;
    }
}
