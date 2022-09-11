package com.bancodelt.java.models.dao;

import com.bancodelt.java.config.DBAcess;
import com.bancodelt.java.models.ContaCorrente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PixDAO {

    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    private static int outraContaPix = 0;
    private static double valorAnterior = 0;

    private static List<String> listaChaves = new ArrayList<>();

    public boolean possuiPix(int conta) {
        conexao = DBAcess.getConexao();
        String sql = "select possui_pix from pix where fk_usuario=?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, conta);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getBoolean(1)) {
                    System.out.println("\n\nValor pix de tabela:" + rs.getBoolean(1));
                    System.out.println("\nPossui pix.");
                    DBAcess.closeConexao(conexao, pst, rs);
                    return true;
                } else {
                    System.out.println("\n\nValor pix de tabela:" + rs.getBoolean(1));
                    System.out.println("\nNão possui pix.");
                    DBAcess.closeConexao(conexao, pst, rs);
                    return false;
                }
            } else {
                System.out.println("\nNão possui pix.");
                DBAcess.closeConexao(conexao, pst, rs);
                return false;
            }
        } catch (SQLException e) {
            Logger.getLogger(PixDAO.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Erro SQL Exception GESTOR");
            DBAcess.closeConexao(conexao, pst, rs);
            return false;
        }
    }

    public boolean possuiPixOutraConta(String chave) {
        conexao = DBAcess.getConexao();
        String sql = "select possui_pix, fk_usuario from pix where chave_pix=?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, chave);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getBoolean(1)) {
                    setOutraContaPix(rs.getInt(2));
                    System.out.println("\nPossui pix.");
                    DBAcess.closeConexao(conexao, pst, rs);
                    conexao = DBAcess.getConexao();
                    sql = "select saldo from usuario where id_usuario=?;";
                    pst = conexao.prepareStatement(sql);
                    pst.setInt(1, getOutraContaPix());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        setValorAnterior(rs.getDouble(1));
                    }
                    DBAcess.closeConexao(conexao, pst, rs);
                    return true;
                } else {
                    System.out.println("\nNão possui pix.");
                    DBAcess.closeConexao(conexao, pst, rs);
                    return false;
                }
            } else {
                System.out.println("\nNão possui pix.");
                DBAcess.closeConexao(conexao, pst, rs);
                return false;
            }
        } catch (SQLException e) {
            Logger.getLogger(PixDAO.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Erro SQL Exception GESTOR");
            DBAcess.closeConexao(conexao, pst, rs);
            return false;
        }
    }

    public boolean CadastrarPix(String chave, int conta) {
        conexao = DBAcess.getConexao();
        String sql = "insert into pix(possui_pix, chave_pix, fk_usuario) values (?, ?, ?);";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setBoolean(1, true);
            pst.setString(2, chave);
            pst.setInt(3, conta);

            int add = pst.executeUpdate();
            if (add > 0) {
                System.out.println("\nChave pix cadastrada com sucesso.");
                DBAcess.closeConexao(conexao, pst);

                return true;
            } else {
                System.out.println("\nNão foi possivel cadastrar chave pix.");
                DBAcess.closeConexao(conexao, pst);
                return false;
            }
        } catch (SQLException e) {
            Logger.getLogger(PixDAO.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Erro SQL Exception GESTOR");
            DBAcess.closeConexao(conexao, pst);
            return false;
        }
    }

    public boolean resgatarChavesPix(int conta) {
        conexao = DBAcess.getConexao();
        String sql = "select chave_pix from pix where fk_usuario=?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, conta);
            rs = pst.executeQuery();
            while (rs.next()) {
                String chaveRecebida = rs.getString(1);
                listaChaves.add(chaveRecebida);
                System.out.println("\nSucesso ao resgatar chaves pix.");
            }
            ContaCorrente.setChavesPix(getListaChaves());
            DBAcess.closeConexao(conexao, pst, rs);
            return true;
        } catch (SQLException e) {
            Logger.getLogger(PixDAO.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Erro SQL Exception GESTOR");
            DBAcess.closeConexao(conexao, pst, rs);
            return false;
        }
    }

    public boolean fazerPix(String contaOrigem, int contaDestino, double saldoOrigem, double valorDestino) {
        conexao = DBAcess.getConexao();
        String sql = "update usuario set saldo=? where conta=?;";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setDouble(1, saldoOrigem);
            pst.setString(2, contaOrigem);

            int add = pst.executeUpdate();
            if (add > 0) {
                System.out.println("Pix efetuado com sucesso");
            } else {
                System.out.println("Pix não efetuado.");
            }
            DBAcess.closeConexao(conexao, pst);

            conexao = DBAcess.getConexao();
            sql = "update usuario set saldo=? where id_usuario=?;";

            pst = conexao.prepareStatement(sql);

            pst.setDouble(1, valorDestino);
            pst.setInt(2, contaDestino);

            add = pst.executeUpdate();
            if (add > 0) {
                System.out.println("Pix efetuado com sucesso");
                DBAcess.closeConexao(conexao, pst);
                return true;
            } else {
                System.out.println("Pix não efetuado.");
                DBAcess.closeConexao(conexao, pst);
                return false;
            }

        } catch (SQLException e) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, e);
            DBAcess.closeConexao(conexao, pst);
            return false;
        }
    }

    public static int getOutraContaPix() {
        return outraContaPix;
    }

    public static void setOutraContaPix(int outraContaPix) {
        PixDAO.outraContaPix = outraContaPix;
    }

    public static double getValorAnterior() {
        return valorAnterior;
    }

    public static void setValorAnterior(double valorAnterior) {
        PixDAO.valorAnterior = valorAnterior;
    }

    public static List<String> getListaChaves() {
        return listaChaves;
    }
}
