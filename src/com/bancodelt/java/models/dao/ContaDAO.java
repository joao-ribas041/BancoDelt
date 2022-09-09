package com.bancodelt.java.models.dao;

import com.bancodelt.java.config.DBAcess;
import com.bancodelt.java.models.ContaCorrente;
import com.bancodelt.java.models.ContaPoupanca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContaDAO {

    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private Statement st = null;

    private int tipo;

    public boolean jaTemConta(String CPF) {
        conexao = DBAcess.getConexao();
        String sql = "select cpf from usuario where cpf=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, CPF);
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Conta existe, direcionando para pagina login");
                DBAcess.closeConexao(conexao, pst, rs);
                return true;
            } else {
                System.out.println("Conta não existe, direcionando para pagina Registro");
                DBAcess.closeConexao(conexao, pst, rs);
                return false;
            }
        } catch (SQLException e) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, e);
            DBAcess.closeConexao(conexao, pst);
            return false;
        }
    }

    public boolean loginTitular(String CPF, String Senha) {
        conexao = DBAcess.getConexao();
        String sql = "select cpf, senha, fk_tipoacc from usuario where cpf=? and senha=?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, CPF);
            pst.setString(2, Senha);
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Logado com sucesso");
                setTipo(rs.getInt(3));
                DBAcess.closeConexao(conexao, pst, rs);
                return true;
            } else {
                System.out.println("Usuario ou senha invalido.");
                DBAcess.closeConexao(conexao, pst, rs);
                return false;
            }
        } catch (SQLException e) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, e);
            DBAcess.closeConexao(conexao, pst);
            return false;
        }
    }

    public void resgatarDadosTitular(String CPF) {
        conexao = DBAcess.getConexao();
        String sql = "select usuario.*, banco.agencia from usuario, banco where cpf=?;";
        if (getTipo() == 1) {
            System.out.println("Poupança");
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, CPF);
                rs = pst.executeQuery();
                if (rs.next()) {
                    ContaPoupanca.setNumConta(rs.getInt(1));
                    ContaPoupanca.setNumAgencia(rs.getInt(2));
                    ContaPoupanca.setTipo(rs.getInt(3));
                    ContaPoupanca.setConta(rs.getString(4));
                    ContaPoupanca.setCPF(rs.getString(5));
                    ContaPoupanca.setEmail(rs.getString(6));
                    ContaPoupanca.setNumeroCelular(rs.getString(7));
                    ContaPoupanca.setNomeTitular(rs.getString(8));
                    ContaPoupanca.setGeneroTitular(rs.getString(9));
                    ContaPoupanca.setDataNascimento(rs.getString(11));
                    ContaPoupanca.setDataCriacaoAcc(rs.getString(12));
                    ContaPoupanca.setSaldo(rs.getDouble(13));
                    ContaPoupanca.setAgencia(rs.getString(14));
                    System.out.println("Sucesso ao resgatar os dados do usuario");
                    DBAcess.closeConexao(conexao, pst, rs);
                } else {
                    System.out.println("Erro ao resgatar os dados do usuario");
                    DBAcess.closeConexao(conexao, pst, rs);
                }
            } catch (SQLException e) {
                Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, e);
                DBAcess.closeConexao(conexao, pst, rs);
            }
        }
        if (getTipo() == 2) {
            System.out.println("Corrente");
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, CPF);
                rs = pst.executeQuery();
                if (rs.next()) {
                    ContaCorrente.setNumConta(rs.getInt(1));
                    ContaCorrente.setNumAgencia(rs.getInt(2));
                    ContaCorrente.setTipo(rs.getInt(3));
                    ContaCorrente.setConta(rs.getString(4));
                    ContaCorrente.setCPF(rs.getString(5));
                    ContaCorrente.setEmail(rs.getString(6));
                    ContaCorrente.setNumeroCelular(rs.getString(7));
                    ContaCorrente.setNomeTitular(rs.getString(8));
                    ContaCorrente.setGeneroTitular(rs.getString(9));
                    ContaCorrente.setDataNascimento(rs.getString(11));
                    ContaCorrente.setDataCriacaoAcc(rs.getString(12));
                    ContaCorrente.setSaldo(rs.getDouble(13));
                    ContaCorrente.setAgencia(rs.getString(14));
                    System.out.println("Sucesso ao resgatar os dados do usuario");
                    DBAcess.closeConexao(conexao, pst, rs);
                } else {
                    System.out.println("Erro ao resgatar os dados do usuario");
                    DBAcess.closeConexao(conexao, pst, rs);
                }
            } catch (SQLException e) {
                Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, e);
                DBAcess.closeConexao(conexao, pst, rs);
            }
        }
    }

    public void CadastrarTitular(int numAgencia, int tipoAcc, String conta, String CPF, String email, String numeroCelular, String nomeTitular, String generoTitular, String senhaTitular, String dataNascimento, String dataCriacaoAcc, double saldo) {
        conexao = DBAcess.getConexao();
        //call registra_titular (1, 1, '01011123-3', '000.000.000-03', '03@gmail.com','(43)12345-6789','ADMIN procedure call','Masculino','1234','01/01/2022','01/01/2022',135.45);
        String sql = "call registra_titular (?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, numAgencia);
            pst.setInt(2, tipoAcc);
            pst.setString(3, conta);
            pst.setString(4, CPF);
            pst.setString(5, email);
            pst.setString(6, numeroCelular);
            pst.setString(7, nomeTitular);
            pst.setString(8, generoTitular);
            pst.setString(9, senhaTitular);
            pst.setString(10, dataNascimento);
            pst.setString(11, dataCriacaoAcc);
            pst.setDouble(12, saldo);

            int add = pst.executeUpdate();
            if (add > 0) {
                System.out.println("Usuario cadastrado com sucesso");
            } else {
                System.out.println("Erro ao cadastrar usuario");
            }
            DBAcess.closeConexao(conexao, pst);
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro SQL Exception GESTOR");
            DBAcess.closeConexao(conexao, pst);
        }
    }

    public void atualizarSaldoPessoal(String conta, double valor) {
        conexao = DBAcess.getConexao();
        String sql = "update usuario set saldo=? where conta=?";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setDouble(1, valor);
            pst.setString(2, conta);

            int add = pst.executeUpdate();
            if (add > 0) {
                System.out.println("Transação efetuado com sucesso");
            } else {
                System.out.println("Transação não efetuado.");
            }
            DBAcess.closeConexao(conexao, pst);
        } catch (SQLException e) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, e);
            DBAcess.closeConexao(conexao, pst);
        }
    }

    public void atualizarSaldoDepositoExtrangeiro(String contaOrigem, String contaDestino, double saldoOrigem, double valorDestino) {
        conexao = DBAcess.getConexao();
        String sql = "update usuario set saldo=? where conta=?;";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setDouble(1, saldoOrigem);
            pst.setString(2, contaOrigem);

            int add = pst.executeUpdate();
            if (add > 0) {
                System.out.println("Deposito efetuado com sucesso");
            } else {
                System.out.println("Deposito não efetuado.");
            }
            DBAcess.closeConexao(conexao, pst);

            conexao = DBAcess.getConexao();
            sql = "update usuario set saldo=? where conta=?;";

            pst = conexao.prepareStatement(sql);

            pst.setDouble(1, valorDestino);
            pst.setString(2, contaDestino);

            add = pst.executeUpdate();
            if (add > 0) {
                System.out.println("Deposito efetuado com sucesso");
            } else {
                System.out.println("Deposito não efetuado.");
            }
            DBAcess.closeConexao(conexao, pst);

        } catch (SQLException e) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, e);
            DBAcess.closeConexao(conexao, pst);
        }
    }

    public double contaExiste(String Conta) {
        double valorAtual = 0;
        conexao = DBAcess.getConexao();
        String sql = "select saldo from usuario where conta=?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Conta);
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Conta existe");
                valorAtual = rs.getDouble(1);
                DBAcess.closeConexao(conexao, pst, rs);
                return valorAtual;
            } else {
                System.out.println("Conta não existe");
                DBAcess.closeConexao(conexao, pst, rs);
                return valorAtual;
            }
        } catch (SQLException e) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, e);
            DBAcess.closeConexao(conexao, pst);
            return valorAtual;
        }
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
