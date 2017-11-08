/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Kit;
import modelo.ProdutoKit;

/**
 *
 * @author ariel
 */
public class ManterProdutoKitController extends HttpServlet {

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
            throws ServletException, IOException,ClassNotFoundException, SQLException{
        String acao= request.getParameter("acao");
        if(acao.equals("prepararIncluir")){
            prepararIncluir(request, response);
        }else{
            if (acao.equals("confirmarIncluir")) {
                confirmarIncluir(request,response);
            }else {
                if (acao.equals("prepararExcluir")) {
                    prepararExcluir(request, response);
                } else {
                    if (acao.equals("confirmarExcluir")) {
                        confirmarExcluir(request, response);
                    }
                }

            }
        }
    }
    
     public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("kits", Kit.obterKits());
            int codProdutoKit = Integer.parseInt(request.getParameter("id"));

            ProdutoKit produtoKit = ProdutoKit.obterProdutoKit(codProdutoKit);
            request.setAttribute("produto", produtoKit);

            RequestDispatcher view = request.getRequestDispatcher("/manterProdutoKit.jsp");
            view.forward(request, response);

        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("txtIdProduto"));
        String nomeProduto = request.getParameter("txtNomeProduto");
        double valor = Double.parseDouble(request.getParameter("txtProdutoValor"));
        
        ProdutoKit produtoKit = new ProdutoKit(id, nomeProduto, valor, null);
        try {
            produtoKit.excluir();

            RequestDispatcher view = request.getRequestDispatcher("PesquisaProdutoKitController");
            view.forward(request, response);

        } catch (IOException ex) {
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (ServletException ex) {
        }
    }
    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response){
        try{
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("kits",Kit.obterKits());
            RequestDispatcher view = request.getRequestDispatcher("/manterProdutoKit.jsp");
            view.forward(request, response);

        }catch(ServletException ex){
        }catch(IOException ex){
        }catch (ClassNotFoundException ex){
        }
    }
    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response){
       int id = Integer.parseInt(request.getParameter("txtIdProduto"));
       String nome =  request.getParameter("txtNomeProduto");
       double valor = Double.parseDouble(request.getParameter("txtProdutoValor"));
       int kitProduto = Integer.parseInt(request.getParameter("optKit"));
       try {
           Kit kit = null;
           
               kit = Kit.obterKit(kitProduto);
        
           ProdutoKit produtoKit = new ProdutoKit(id,nome,valor,kit); 
       produtoKit.gravar();
       RequestDispatcher view = request.getRequestDispatcher("PesquisaProdutoKitController");
       view.forward(request,response);  
    }catch (IOException ex){
    }catch(SQLException ex){
    }catch(ClassNotFoundException ex){
    }catch (ServletException ex){
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
            Logger.getLogger(ManterProdutoKitController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterProdutoKitController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterProdutoKitController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterProdutoKitController.class.getName()).log(Level.SEVERE, null, ex);
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
