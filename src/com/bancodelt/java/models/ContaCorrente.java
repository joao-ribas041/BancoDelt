package com.bancodelt.java.models;

import com.bancodelt.java.models.dao.ContaDAO;
import com.bancodelt.java.models.dao.ExtratoDAO;
import com.bancodelt.java.models.dao.PixDAO;
import java.util.ArrayList;
import java.util.List;

public class ContaCorrente extends Conta2 {

    //protected static String chavesPix;
    private static List<String> chavesPix = new ArrayList<>();

    public ContaCorrente(int numAgencia, int numConta, String CPF, String email, String numeroCelular, String nomeTitular, String generoTitular, String senhaTitular, String dataNascimento, String dataCriacaoAcc, double saldo) {
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

    public static void pagarPix(int conta, double valor, double saldoAnterior) {
        PixDAO pDAO = new PixDAO();
        ExtratoDAO eDAO = new ExtratoDAO();
        
        pDAO.fazerPix(getConta(), PixDAO.getOutraContaPix(), Conta2.getSaldo() - valor, saldoAnterior + valor);
        eDAO.RegistrarExtrato("Pix out", valor, getSaldo() - valor, getNumConta());
        eDAO.RegistrarExtrato("Pix in", valor, saldoAnterior + valor, conta);
    }

    public static void setChavesPix(List<String> chavesPix) {
        ContaCorrente.chavesPix = chavesPix;
    }

    public static List<String> getChavesPix() {
        return chavesPix;
    }
}
