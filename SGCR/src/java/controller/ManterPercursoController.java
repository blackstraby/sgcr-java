/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Corrida;
import modelo.Organizador;
import modelo.Percurso;

/**
 *
 * @author rafael
 */
public class ManterPercursoController extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("corridas", Corrida.obterCorridas());
            RequestDispatcher view = request.getRequestDispatcher("/manterPercurso.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

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
        processRequest(request, response);
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
        processRequest(request, response);
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

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        double numQuilometragem = Double.parseDouble(request.getParameter("numQuilometragemPercurso"));
        String descricao = request.getParameter("descricaoPercurso");
        int corridaId = Integer.parseInt(request.getParameter("hiddenIdCorrida"));
        
        HttpSession session = request.getSession(true);
        Organizador organizador = (Organizador) session.getAttribute("organizador");

        try {
            Percurso percurso = new Percurso(numQuilometragem, descricao, organizador);
            percurso.gravar();
            
            Corrida corrida = Corrida.obterCorrida(corridaId);
            percurso.gravar();
            percurso = Percurso.obterUltimoPercursoOrganizador(organizador.getId());
            percurso.gravarPercursoCorrida(corrida);
            
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCorridaController");
            view.forward(request, response);
        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (ServletException ex) {
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");

            int idPercurso = Integer.parseInt(request.getParameter("id"));
            Percurso percurso = Percurso.obterPercurso(idPercurso);

            request.setAttribute("percurso", percurso);
            RequestDispatcher view = request.getRequestDispatcher("/manterPercurso.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("hiddenIdPercurso"));
//        String descricao = request.getParameter("descricaoPercurso");
//        double numQuilometragem = Double.parseDouble(request.getParameter("numQuilometragemPercurso"));
        
        HttpSession session = request.getSession(true);
        Organizador organizador = (Organizador) session.getAttribute("organizador");
        
        Percurso percurso = new Percurso(id, 0.0, "", organizador);
        try {
            percurso.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCorridaController");
            view.forward(request, response);
        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (ServletException ex) {
        }
    }

    private void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");

            int idPercurso = Integer.parseInt(request.getParameter("id"));
            Percurso percurso = Percurso.obterPercurso(idPercurso);

            request.setAttribute("percurso", percurso);
            RequestDispatcher view = request.getRequestDispatcher("/manterPercurso.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("hiddenIdPercurso"));
        double numQuilometragem = Double.parseDouble(request.getParameter("numQuilometragemPercurso"));
        String descricao = request.getParameter("descricaoPercurso");
        
        HttpSession session = request.getSession(true);
        Organizador organizador = (Organizador) session.getAttribute("organizador");
        
        try {
            Percurso percurso = new Percurso(id, numQuilometragem, descricao, organizador);
            percurso.alterar();

            RequestDispatcher view = request.getRequestDispatcher("PesquisaCorridaController");
            view.forward(request, response);
        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (ServletException ex) {
        }
    }

}
