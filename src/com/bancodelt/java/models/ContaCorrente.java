package com.bancodelt.java.models;

import com.bancodelt.java.models.dao.ContaDAO;
import com.bancodelt.java.models.dao.ExtratoDAO;

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
    
    public static void receberPix(String conta, double valor, double saldoAnterior) {
        ContaDAO cDAO = new ContaDAO();
        ExtratoDAO eDAO = new ExtratoDAO();
        
        cDAO.atualizarSaldoPessoal(conta, saldoAnterior + valor);
        eDAO.RegistrarExtrato("Pix in", valor, saldoAnterior + valor, ContaDAO.getIdConta());
    }
}
