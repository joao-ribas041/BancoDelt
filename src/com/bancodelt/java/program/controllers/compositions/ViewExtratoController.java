package com.bancodelt.java.program.controllers.compositions;

import com.bancodelt.java.config.DBAcess;
import com.bancodelt.java.models.Conta2;
import com.bancodelt.java.models.OperacaoExtrato;
import com.bancodelt.java.models.dao.ExtratoDAO;
import com.bancodelt.java.program.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class ViewExtratoController implements Initializable {

    @FXML
    private FlowPane Titulo;
    @FXML
    private VBox extratoPainel;

    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    private List<OperacaoExtrato> extratosAdicionados;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        extratosAdicionados = new ArrayList<>(extratosAdicionados());
        try {
            for (int i = 0; i < extratosAdicionados.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(Main.getDirectoryJavaInterfacesCompositions() + "Extrato.fxml"));
                VBox ebox = fxmlLoader.load();
                ExtratoController extratoController = fxmlLoader.getController();
                extratoController.setDadosExtrato(extratosAdicionados.get(i));
                extratoPainel.getChildren().add(ebox);

            }
        } catch (IOException ex) {
            Logger.getLogger(ViewExtratoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<OperacaoExtrato> extratosAdicionados() {
        List<OperacaoExtrato> ls = new ArrayList<>();
        OperacaoExtrato oe;
        conexao = DBAcess.getConexao();
        String sql = "select data_transacao, tipo_transacao, valor_transacao, saldo_posterior from extrato where fk_usuario=?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Conta2.getNumConta());
            rs = pst.executeQuery();
            while (rs.next()) {                
                oe = new OperacaoExtrato(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4));
                ls.add(oe);
            }
            DBAcess.closeConexao(conexao, pst, rs);
        } catch (SQLException e) {
            Logger.getLogger(ExtratoDAO.class.getName()).log(Level.SEVERE, null, e);
            DBAcess.closeConexao(conexao, pst, rs);
        }
        return ls;
    }
}
