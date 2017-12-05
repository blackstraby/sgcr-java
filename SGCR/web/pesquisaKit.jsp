<%-- 
    Document   : pesquisaKit
    Created on : 14/10/2017, 17:10:36
    Author     : RAJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "layout/head.jsp" %>
        <title>Pesquisa Kit</title>
    </head>
    <body>
        <%@ include file = "layout/menuOrganizador.jsp" %>
        
        <div class="container">
          <h2>Pesquisa Kit</h2>
          
          <table class="table">
            <thead>
              <tr>
                <th>Código</th>
                <th>Corrida</th>
                <th>Nome</th>
                <th>Data da retirada</th>
                <th>Imagem</th>
                <th>Tipo Chip</th>
                <!-- <th colspan="2" style="text-align: center">Ação</th> -->
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${kits}" var="kit">
                <tr>
                    <td><c:out value="${kit.id}" /></td>
                    <td><c:out value="${kit.corrida.nome}" /></td>
                    <td><c:out value="${kit.nome}" /></td>
                    <td><c:out value="${kit.dataRetirada}" /></td>
                    <td><c:out value="${kit.imagem}" /></td>
                    <td><c:out value="${kit.tipoChip}" /></td>
                    <td><a href="ManterKitController?acao=prepararEditar&id=<c:out value="${kit.id}"/>&corridaId=<c:out value="${kit.corridaId}"/>">Editar</a> </td>
                    <td><a href="ManterKitController?acao=prepararExcluir&id=<c:out value="${kit.id}"/>&corridaId=<c:out value="${kit.corridaId}"/>">Excluir</a> </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
          <form action="ManterKitController?acao=prepararIncluir" method="post">
            <button type="submit" class="btn btn-success" name="btnIncluir" value="Incluir">Incluir</button>
            <a href="index.jsp" class="btn btn-primary">Menu</a>
          </form>
        </div>

        <%@ include file = "layout/rodape.jsp" %>
    </body>
</html>
