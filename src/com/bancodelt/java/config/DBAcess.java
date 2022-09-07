package com.bancodelt.java.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAcess {
    
    private static final String url = "jdbc:mysql://localhost:3306/db_bancodelt";
    private static final String user = "root";
    private static final String password = "root";
    
   private static Connection conexao = null;
    
    public static Connection getConexao() {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("Sucess");
            return conexao;
        } catch (SQLException e) {
            System.err.println("Falha: Falha ao encerrar conexao com o Bando de Dados.");
            System.err.println("Erro: " + e.getMessage());
            return null;
        }
    }
    
    public static void closeConexao(Connection conexao) {
        try {
            if(conexao != null) {
                conexao.close();
                System.out.println("Sucess: Conexao com o Banco de Dados encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Falha: \n Falha ao encerrar conexao com o Bando de Dados.");
            System.err.println("Erro: " + e.getMessage());
        }
    }
    
    public static void closeConexao(Connection conexao, PreparedStatement pst) {
        closeConexao(conexao);
        try {
            if(pst != null) {
                pst.close();
                System.out.println("Sucess: Conexao PreparedStatement encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Falha: \n Falha ao encerrar conexao PreparedStatement.");
            System.err.println("Erro: " + e.getMessage());
        }
    }
    
    public static void closeConexao(Connection conexao, ResultSet rs, Statement st) {
        try {
            if(conexao != null) {
                conexao.close();
                System.out.println("Sucess: Conexao com o Banco de Dados encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Falha: \n Falha ao encerrar conexao com o Bando de Dados.");
            System.err.println("Erro: " + e.getMessage());
        }
        
        try {
            if(rs != null) {
                rs.close();
                System.out.println("Sucess: Conexao ResultSet encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Falha: \n Falha ao encerrar conexao PreparedStatement.");
            System.err.println("Erro: " + e.getMessage());
        }
        
        try {
            if(st != null) {
                st.close();
                System.out.println("Sucess: Conexao Statement encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Falha: \n Falha ao encerrar conexao Statement.");
            System.err.println("Erro: " + e.getMessage());
        }
    }
    
    public static void closeConexao(Connection conexao, PreparedStatement pst, ResultSet rs) {
        try {
            if(conexao != null) {
                conexao.close();
                System.out.println("Sucess: Conexao com o Banco de Dados encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Falha: \n Falha ao encerrar conexao com o Bando de Dados.");
            System.err.println("Erro: " + e.getMessage());
        }
        
        try {
            if(pst != null) {
                pst.close();
                System.out.println("Sucess: Conexao PreparedStatement encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Falha: \n Falha ao encerrar conexao PreparedStatement.");
            System.err.println("Erro: " + e.getMessage());
        }
        
        try {
            if(rs != null) {
                rs.close();
                System.out.println("Sucess: Conexao ResultSet encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Falha: \n Falha ao encerrar conexao PreparedStatement.");
            System.err.println("Erro: " + e.getMessage());
        }
    }
    
    
    
    public static void closeConexao(Connection conexao, PreparedStatement pst, ResultSet rs, Statement st) {
        try {
            if(conexao != null) {
                conexao.close();
                System.out.println("Sucess: Conexao com o Banco de Dados encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Falha: \n Falha ao encerrar conexao com o Bando de Dados.");
            System.err.println("Erro: " + e.getMessage());
        }
        
        try {
            if(pst != null) {
                pst.close();
                System.out.println("Sucess: Conexao PreparedStatement encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Falha: \n Falha ao encerrar conexao PreparedStatement.");
            System.err.println("Erro: " + e.getMessage());
        }
        
        try {
            if(rs != null) {
                rs.close();
                System.out.println("Sucess: Conexao ResultSet encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Falha: \n Falha ao encerrar conexao PreparedStatement.");
            System.err.println("Erro: " + e.getMessage());
        }
        
        try {
            if(st != null) {
                st.close();
                System.out.println("Sucess: Conexao Statement encerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Falha: \n Falha ao encerrar conexao Statement.");
            System.err.println("Erro: " + e.getMessage());
        }
    }
}