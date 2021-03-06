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
import modelo.Administrador;
import modelo.Atleta;
import modelo.Organizador;

/**
 *
 * @author jjti
 */
public class LoginController extends HttpServlet {

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
        String acao = request.getParameter("acao");
        if (acao.equals("logar")) {
            logar(request, response);
        } else if(acao.equals("logout")) {
            logout(request, response);
        }
    }

    public void logar(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String optUsuario = request.getParameter("optUsuario");

        try {
            if (optUsuario.equals("administrador")) {
                try {
                    Administrador administrador = Administrador.logar(email, senha);
                    if (administrador != null) {
                        HttpSession session = request.getSession(true);
                        session.setAttribute("administrador", administrador);
                        session.setAttribute("usuario", "administrador");
                        RequestDispatcher view = request.getRequestDispatcher("/PesquisaAdministradorController");
                        view.forward(request, response);
                    } else {
                        request.setAttribute("mensagemErro", "Usuário não encontrado");
                        RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
                        view.forward(request, response);
                    }

                } catch (IOException | ClassNotFoundException | ServletException ex) {
                }
            } else if (optUsuario.equals("organizador")) {
                try {
                    Organizador organizador = Organizador.logar(email, senha);
                    if (organizador != null) {
                        HttpSession session = request.getSession(true);
                        session.setAttribute("organizador", organizador);
                        session.setAttribute("usuario", "organizador");
                        RequestDispatcher view = request.getRequestDispatcher("/PesquisaCorridaController");
                        view.forward(request, response);
                    } else {
                        request.setAttribute("mensagemErro", "Usuário não encontrado");
                        RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
                        view.forward(request, response);
                    }

                } catch (IOException | ClassNotFoundException | ServletException ex) {
                }
            } else if (optUsuario.equals("atleta")) {
                try {
                    Atleta atleta = Atleta.logar(email, senha);
                    if (atleta != null) {
                        HttpSession session = request.getSession(true);
                        session.setAttribute("atleta", atleta);
                        session.setAttribute("usuario", "atleta");
                        RequestDispatcher view = request.getRequestDispatcher("PesquisaHomeController");
                        view.forward(request, response);
                    } else {
                        request.setAttribute("mensagemErro", "Usuário não encontrado");
                        RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
                        view.forward(request, response);
                    }

                } catch (SQLException | IOException | ClassNotFoundException | ServletException ex) {
                }
            }
        } catch (NullPointerException ex) {
            try {
                response.sendRedirect("login.jsp");
            } catch (IOException ex1) {
            }
        }
    }
    
    public void logout(HttpServletRequest request, HttpServletResponse response) {;
        try {
            HttpSession session = request.getSession(true);
            session.invalidate();
            response.sendRedirect("/SGCR/");

        } catch (IOException ex) {
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

}
