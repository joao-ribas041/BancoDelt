package com.bancodelt.java.models.dao;

import com.bancodelt.java.config.DBAcess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExtratoDAO {

    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDateTime dataAtual;
    private String datatransacao = "";

    public void RegistrarExtrato(String tipoTransacao, double valorTransacao, double saldoPos, int conta) {
        dataAtual = LocalDateTime.now();
        setDatatransacao(dtf.format(dataAtual));
        conexao = DBAcess.getConexao();
        String sql = "insert into extrato (data_transacao, tipo_transacao, valor_transacao, saldo_posterior, fk_usuario) values(?, ?, ?, ?, ?);";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, getDatatransacao());
            pst.setString(2, tipoTransacao);
            pst.setDouble(3, valorTransacao);
            pst.setDouble(4, saldoPos);
            pst.setInt(5, conta);

            int add = pst.executeUpdate();
            if (add > 0) {
                System.out.println("Extrato registrado com sucesso");
            } else {
                System.out.println("Erro ao registrar extrato");
            }
            DBAcess.closeConexao(conexao, pst);
        } catch (SQLException e) {
            Logger.getLogger(ExtratoDAO.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Erro SQL Exception GESTOR");
            DBAcess.closeConexao(conexao, pst);
        }
    }

    public String getDatatransacao() {
        return datatransacao;
    }

    public void setDatatransacao(String datatransacao) {
        this.datatransacao = datatransacao;
    }
}
