<%-- 
    Document   : pesquisaPagamento
    Created on : 04/12/2017, 15:57:42
    Author     : RAJ
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <%@ include file = "layout/head.jsp" %>
        <title>Gerenciar Pagamento</title>
    </head>
    <body>
        <%@ include file = "layout/menu.jsp" %>

        <div class="container-fluid corpo corpo-adm">
            <ul class="breadcrumb">
                <li><a href="dashboard.jsp">Dashboard</a></li>
                <li class="active" >Manter Resultado</li>
            </ul>    
            <center><h1>Manter Resultado Corrida</h1></center><br>
            <div class="row">
                <c:forEach items="${corridas}" var="corrida">
                    <div class="col-md-4">                      
                        <div class="panel panel-info">
                            <div class="panel-heading">${corrida.nome}</div>
                            <div class="panel-body corrida-info">
                                <div class="corrida-info-conteudo">
                                    <p><i class="fa fa-calendar" aria-hidden="true"></i> <span>${corrida.data}</span></p>
                                    <p>${corrida.descricao}</p>
                                </div>
                                <p><b>...</b></p>
                            </div>
                            <div class="panel-footer">
                                <a style="text-decoration: none" href="ManterResultadoCorridaController?acao=prepararIncluir&corridaId=<c:out value="${corrida.id}"/>">
                                    <button class="btn btn-block btn-success">  Gerenciar Corrida  </button> 
                                </a>   
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>

        <%@ include file = "layout/rodape.jsp" %>

    </body>
</html>
