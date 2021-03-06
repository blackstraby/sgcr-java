<%-- 
    Document   : manterAdministrador
    Created on : 17/10/2017, 09:29:26
    Author     : RAJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <%@ include file = "layout/head.jsp" %>
        <title>${operacao} Administrador</title>
    </head>
    <body>
        <%@ include file = "layout/menu.jsp" %>

        <div class="container-fluid corpo corpo-adm">
            <ul class="breadcrumb">
                <li><a href="dashboard.jsp">Dashboard</a></li>
                <li>Manter Administrador</li>
            </ul>            
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">${operacao} Administrador</div>
                        <div class="panel-body">
                            <form action="ManterAdministradorController?acao=confirmar${operacao}" method="post" name="frmManterAdministrador"> 
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <input type="hidden" class="form-control" id="codigo" name="hiddenIdAdministrador" value="${administrador.id}" readonly />
                                        <div class="form-group">
                                            <label for="nomeAdmin">Nome Completo:</label>
                                            <input type="text" required class="form-control" id="nomeAdmin" name="txtNomeAdministrador" value="${administrador.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                            </div>
                                            <div class="form-group">
                                                <label for="emailAdmin">Email: </label>
                                                <input type="text" required class="form-control" id="emailAdmin" name="txtEmailAdministrador" value="${administrador.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                            </div>
                                            <div class="form-group">
                                                <label for="senhaAdmin">Senha:</label>
                                                <input type="password" required class="form-control" id="senhaAdmin" name="txtSenhaAdministrador" value="${administrador.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                            </div>

                                            <div class="form-group">
                                                <a href="PesquisaAdministradorController" style="text-decoration: none" ><button type="button" class="btn btn-danger">Cancelar</button> </a>
                                                <input type="submit" name="btnConfirmar" value="Confirmar" class="btn btn-success" >
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            <%@ include file = "layout/rodape.jsp" %>   

    </body>
</html>
