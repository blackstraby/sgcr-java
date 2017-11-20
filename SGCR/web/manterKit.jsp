<%-- 
    Document   : manterKit
    Created on : Oct 17, 2017, 9:30:45 AM
    Author     : RAJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Kit</title>
    </head>
    <body>
        <h1>Manter Kit - ${operacao}</h1>
        
        <form action="ManterKitController?acao=confirmar${operacao}" method="post" name="frmManterKit">
            <table>
                <tr>
                    <td>Código:</td> 
                    <td><input type="text" name="txtIdKit" value="${kit.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Nome:</td> 
                    <td><input type="text" name="txtNomeKit" value="${kit.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Quantidade:</td> 
                    <td><input type="number" name="numQuantidadeKit" value="${kit.quantidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Imagem:</td>  
                    <td><input type="text" name="fileImagemKit" value="${kit.imagem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr> 
                    <td>Tipo do Chip:</td> 
                    <td>
                        <select name="optTipoChip" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="Descartável" <c:if test="${kit.tipoChip == 'Descartável'}"> selected</c:if>>Descartável</option>
                            <option value="Retornável" <c:if test="${kit.tipoChip == 'Retornável'}"> selected</c:if>>Retornável</option>
                        </select>
                    </td>
                </tr>              
                <tr>
                    <td>
                        <input type="submit" name="btnConfirmar" value="Confirmar"/>
                    </td>
                </tr>
                <br>
                <tr>
                    <td><a href="index.jsp">Menu</a></td>
                </tr>
                <tr>
                    <td><a href="PesquisaKitController">Voltar para pesquisa</a></td>
                </tr>
            </table>
        </form>
    </body>
</html>
