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
        String sql = "select * from usuario where cpf=?;";
        String sql2 = "select * from banco where id_agencia=1;";
        if (getTipo() == 1) {
            System.out.println("Poupança");
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, CPF);
                rs = pst.executeQuery();
                if (rs.next()) {
                    ContaPoupanca.setNumeroConta(rs.getInt(1));
                    ContaPoupanca.setNumeroAgencia(rs.getInt(2));
                    ContaPoupanca.setTipo(rs.getInt(3));
                    ContaPoupanca.setNumConta(rs.getString(4));
                    ContaPoupanca.setCPF(rs.getString(5));
                    ContaPoupanca.setEmail(rs.getString(6));
                    ContaPoupanca.setNumeroCelular(rs.getString(7));
                    ContaPoupanca.setNomeTitular(rs.getString(8));
                    ContaPoupanca.setGeneroTitular(rs.getString(9));
                    ContaPoupanca.setDataNascimento(rs.getString(11));
                    ContaPoupanca.setDataCriacaoAcc(rs.getString(12));
                    ContaPoupanca.setSaldo(rs.getDouble(13));
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
                    ContaCorrente.setNumeroConta(rs.getInt(1));
                    ContaCorrente.setNumeroAgencia(rs.getInt(2));
                    ContaCorrente.setTipo(rs.getInt(3));
                    ContaCorrente.setNumConta(rs.getString(4));
                    ContaCorrente.setCPF(rs.getString(5));
                    ContaCorrente.setEmail(rs.getString(6));
                    ContaCorrente.setNumeroCelular(rs.getString(7));
                    ContaCorrente.setNomeTitular(rs.getString(8));
                    ContaCorrente.setGeneroTitular(rs.getString(9));
                    ContaCorrente.setDataNascimento(rs.getString(11));
                    ContaCorrente.setDataCriacaoAcc(rs.getString(12));
                    ContaCorrente.setSaldo(rs.getDouble(13));
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
