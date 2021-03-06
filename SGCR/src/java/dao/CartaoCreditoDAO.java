/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.CartaoCredito;
import modelo.Corrida;
import modelo.Inscricao;

/**
 *
 * @author RAJ
 */
public class CartaoCreditoDAO {

    public static List<CartaoCredito> obterCartoesCredito() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<CartaoCredito> cartoes = new ArrayList<CartaoCredito>();

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from cartao_credito");
            while (rs.next()) {
                CartaoCredito cartao = new CartaoCredito(
                        rs.getInt("id"),
                        rs.getString("numero"),
                        rs.getString("codigo_seguranca"),
                        rs.getString("validade"),
                        rs.getString("nome_titular"),
                        null,
                        null);
                cartao.setInscricaoId(rs.getInt("inscricao_id"));
                cartao.setInscricao(Inscricao.obterInscricao(cartao.getInscricaoId()));
                cartao.setInscricaoCorridaId(rs.getInt("inscricao_corrida_id"));
                cartao.setInscricaoCorrida(Corrida.obterCorrida(cartao.getInscricaoCorridaId()));
                cartoes.add(cartao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return cartoes;
    }

    public static void gravar(CartaoCredito cartaoCredito) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO cartao_credito (numero, codigo_seguranca, validade, nome_titular, inscricao_id, inscricao_corrida_id) VALUES (?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, cartaoCredito.getNumero());
            comando.setString(2, cartaoCredito.getCodigoSeguranca());
            comando.setString(3, cartaoCredito.getValidade());
            comando.setString(4, cartaoCredito.getNomeTitular());
            comando.setInt(5, cartaoCredito.getInscricao().getId());
            comando.setInt(6, cartaoCredito.getInscricaoCorrida().getId());

            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(CartaoCredito cartaoCredito) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE cartao_credito SET numero = ?, codigo_seguranca = ?, validade = ?, nome_titular = ?, inscricao_id = ?, inscricao_corrida_id = ? WHERE id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, cartaoCredito.getNumero());
            comando.setString(2, cartaoCredito.getCodigoSeguranca());
            comando.setString(3, cartaoCredito.getValidade());
            comando.setString(4, cartaoCredito.getNomeTitular());
            comando.setInt(5, cartaoCredito.getInscricao().getId());
            comando.setInt(6, cartaoCredito.getInscricaoCorrida().getId());
            comando.setInt(7, cartaoCredito.getId());

            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(CartaoCredito cartaoCredito) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "DELETE FROM cartao_credito WHERE id = " + cartaoCredito.getId();
            comando.execute(stringSQL);

        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static CartaoCredito obterCartaoCredito(int id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        CartaoCredito cartaoCredito = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM cartao_credito WHERE id = " + id);
            rs.first();
            cartaoCredito = new CartaoCredito(
                    rs.getInt("id"),
                    rs.getString("numero"),
                    rs.getString("codigo_seguranca"),
                    rs.getString("vencimento"),
                    rs.getString("nome_titular"),
                    null,
                    null);
            cartaoCredito.setInscricaoId(rs.getInt("inscricao_id"));
            cartaoCredito.setInscricaoCorridaId(rs.getInt("inscricao_corrida_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return cartaoCredito;
    }

    public static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }

            if (comando != null) {
                conexao.close();
            }

        } catch (SQLException e) {

        }
    }
}
