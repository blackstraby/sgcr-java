/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Administrador;
import modelo.Pontuacao;
import modelo.Ranking;

/**
 *
 * @author RAJ
 */
public class ManterPontuacaoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else {
            if (acao.equals("confirmarIncluir")) {
                confirmarIncluir(request, response);
            } else {
                if (acao.equals("prepararExcluir")) {
                    prepararExcluir(request, response);
                } else {
                    if (acao.equals("confirmarExcluir")) {
                        confirmarExcluir(request, response);
                    } else {
                        if (acao.equals("prepararEditar")) {
                            prepararEditar(request, response);
                        } else {
                            if (acao.equals("confirmarEditar")) {
                                confirmarEditar(request, response);
                            }
                        }
                    }
                }
            }
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("rankings", Ranking.obterRankings());
            int codPontuacao = Integer.parseInt(request.getParameter("id"));

            Pontuacao pontuacao = Pontuacao.obterPontuacao(codPontuacao);
            request.setAttribute("pontuacao", pontuacao);

            RequestDispatcher view = request.getRequestDispatcher("/manterPontuacao.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("rankings", Ranking.obterRankings());
            int codPontuacao = Integer.parseInt(request.getParameter("id"));

            Pontuacao pontuacao = Pontuacao.obterPontuacao(codPontuacao);
            request.setAttribute("pontuacao", pontuacao);

            RequestDispatcher view = request.getRequestDispatcher("/manterPontuacao.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("txtIdPontuacao"));
        int valorPontuacao = Integer.parseInt(request.getParameter("txtPontuacao"));

        int idRanking = Integer.parseInt(request.getParameter("optRanking"));
        Ranking ranking = Ranking.obterRanking(idRanking);

        Pontuacao pontuacao = new Pontuacao(id, valorPontuacao, ranking);
        try {
            pontuacao.excluir();

            RequestDispatcher view = request.getRequestDispatcher("PesquisaPontuacaoController");
            view.forward(request, response);

        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (ServletException ex) {
        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("txtIdPontuacao"));
        int valorPontuacao = Integer.parseInt(request.getParameter("txtPontuacao"));

        int idRanking = Integer.parseInt(request.getParameter("optRanking"));
        Ranking ranking = Ranking.obterRanking(idRanking);

        Pontuacao pontuacao = new Pontuacao(id, valorPontuacao, ranking);
        try {
            pontuacao.alterar();

            RequestDispatcher view = request.getRequestDispatcher("PesquisaPontuacaoController");
            view.forward(request, response);

        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (ServletException ex) {
        }
    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("rankings", Ranking.obterRankings());
            RequestDispatcher view = request.getRequestDispatcher("/manterPontuacao.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int valorPontuacao = Integer.parseInt(request.getParameter("txtPontuacao"));
        int rankingId = Integer.parseInt(request.getParameter("optRanking"));
        HttpSession session = request.getSession(true);
        Administrador administrador = (Administrador) session.getAttribute("administrador");

        try {
            Ranking ranking = null;

            ranking = Ranking.obterRanking(rankingId);

            Pontuacao pontuacao = new Pontuacao(valorPontuacao, ranking);
            pontuacao.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPontuacaoController");
            view.forward(request, response);
        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (ServletException ex) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPontuacaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPontuacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPontuacaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPontuacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
