/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.PontuacaoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author RAJ
 */
public class Pontuacao {

    private int id;
    private int pontuacao;
    private Ranking ranking;
    private int rankingId;

    public Pontuacao(int id, int pontuacao, Ranking ranking) {
        this.id = id;
        this.pontuacao = pontuacao;
        this.ranking = ranking;
    }

    public Pontuacao(int pontuacao, Ranking ranking){
        this.pontuacao = pontuacao;
        this.ranking = ranking;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getRankingId() {
        return rankingId;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRankingId(int RankingId) {
        this.rankingId = rankingId;
    }

    public void gravar() throws SQLException,
            ClassNotFoundException {
        PontuacaoDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        PontuacaoDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        PontuacaoDAO.excluir(this);
    }

    public static Pontuacao obterPontuacao(int id) throws ClassNotFoundException {
        return PontuacaoDAO.obterPontuacao(id);
    }

    public static List<Pontuacao> obterPontuacoes() throws ClassNotFoundException {
        return PontuacaoDAO.obterPontuacoes();
    }
}
