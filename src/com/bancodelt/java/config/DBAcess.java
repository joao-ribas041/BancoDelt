package com.bancodelt.java.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBAcess {
    
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static final String password = "root";
    
   private static Connection conexao = null;
    
    public static Connection getConexao() {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("Sucess");
            return conexao;
        } catch (SQLException e) {
            System.err.println("Falha: \n Falha ao encerrar conexao com o Bando de Dados.");
            System.err.println("Erro: " + e.getMessage());
            return null;
        }
    }
    
    public static void closeConexao(Connection conexao) {
        try {
            if(conexao != null) {
                conexao.close();
                System.out.println("Sucess: \n Conexao com o Banco de Dados encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Falha: \n Falha ao encerrar conexao com o Bando de Dados.");
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
