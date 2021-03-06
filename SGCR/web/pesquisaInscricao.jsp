<%-- 
    Document   : pesquisaInscricao
    Created on : Oct 15, 2017, 4:54:51 PM
    Author     : RAJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "layout/head.jsp" %>
        <title>Pesquisa Inscrição</title>
    </head>
    <body>
        <%@ include file = "layout/menu.jsp" %>

        <div class="container-fluid corpo corpo-adm">
            <div id="navbar" class="navbar-collapse collapse">
                <h2>Pesquisa Inscrição</h2>
                <form action="PesquisaInscricaoController" method="get" class="navbar-form navbar-right">
                    <div class="form-group">
                        <div class="form-group">
                            <div class="radio-inline">
                                <label><input type="radio" name="optBusca" required value="corridas">Corridas</label>
                            </div>
                            <div class="radio-inline">
                                <label><input type="radio" name="optBusca" required value="atletas" >Atletas</label>
                            </div>                                   
                        </div>
                        <div class="input-group">
                            <div class="input-group-btn">
                                <button class="btn btn-default" type="submit">
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                </button>
                            </div>
                            <input type="text" class="form-control" required name="busca" placeholder=" Busca" size="22">
                        </div>
                    </div>
                </form>
            </div>  
            <table class="table table-hover table-responsive">
                <thead>
                    <tr>
                        <th>Atleta</th>
                        <th>Corrida</th>
                        <th>Número de Peito</th>
                        <th>Data da Compra</th>
                        <th>Percurso</th>
                        <th>Kit</th>

                        <!-- <th colspan="2">Ação</th> -->
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${inscricoes}" var="inscricao">
                        <tr>
                            <td><c:out value="${inscricao.atleta.nome}" /></td>
                            <td><c:out value="${inscricao.corrida.nome}" /></td>
                            <td><c:out value="000${inscricao.id}" /></td>
                            <td><c:out value="${inscricao.dataCompra}" /></td>
                            <td><c:out value="${inscricao.percurso.quilometragem}km" /></td>
                            <td><c:out value="${inscricao.kit.nome}" /></td>

                           <!-- <td><a href="ManterInscricaoController?acao=prepararEditar&id=<c:out value="${inscricao.id}"/>&corridaId=<c:out value="${inscricao.corridaId}"/>">Editar</a> </td>
                            <td><a href="ManterInscricaoController?acao=prepararExcluir&id=<c:out value="${inscricao.id}"/>&corridaId=<c:out value="${inscricao.corridaId}"/>">Excluir</a> </td>
                            -->
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterInscricaoController?acao=escolherCorrida" method="post">
                <!--<button type="submit" class="btn btn-success" name="btnIncluir" value="Incluir"><i class="fa fa-user-plus" aria-hidden="true"></i> Incluir Inscrição</button>-->
            </form>
        </div>
        <%@ include file = "layout/rodape.jsp" %>
    </body>
</html>
