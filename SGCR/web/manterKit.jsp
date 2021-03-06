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

        <%@ include file = "layout/head.jsp" %>
        <title>Manter Kit</title>

    </head>
    <body>

        <%@ include file = "layout/menu.jsp" %>
        <script type="text/javascript" src="public/js/myscript.js"></script>

        <div class="container-fluid corpo corpo-adm">
            <ul class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li class="active">Manter Kit</li>
            </ul>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Manter Kit - ${operacao}</div>
                        <div class="panel-body">
                            <form action="ManterKitController?acao=confirmar${operacao}" method="post" name="frmManterKit">
                                <div class="col-md-12">
                                    <input type="hidden" class="form-control" id="codigo" name="hiddenIdKit" value="${kit.id}" readonly />
                                    <div  class="col-md-6">    
                                        <div class="form-group">
                                            <label for="nomeKit">Nome:</label>
                                            <input type="text" required class="form-control" id="txtNomeKit" name="txtNomeKit" placeholder="Nome (Ex: VIP, Normal, Único)" value="${kit.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if> />
                                            </div>            
                                        </div>
                                        <div  class="col-md-6">  
                                            <div class="form-group">
                                                <label for="fileImagemKit">Imagem:</label>
                                                <input type="hidden" name="MAX_FILE_SIZE" value="4194304" />
                                                <!-- Nao permir valores maiores que 4194304 (4MB) -->
                                                <input type="text"  class="form-control" name="fileImagemKit" value="${kit.imagem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                            </div>
                                        </div>
                                        <div  class="col-md-6">  
                                            <div class="form-group">
                                                <label for="optTipoChip">Tipo do Chip:</label>
                                                <select name="optTipoChip" required class="form-control" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                                <option value="Descartável" <c:if test="${kit.tipoChip == 'Descartável'}"> selected</c:if>>Descartável</option>
                                                <option value="Retornável" <c:if test="${kit.tipoChip == 'Retornável'}"> selected</c:if>>Retornável</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-6">  
                                            <div class="form-group">
                                                <label for="descricaoKit">Descrição:</label>
                                                <input type="text" class="form-control" id="txtDescricaoKit" name="txtDescricaoKit" placeholder="Descrição (Ex: Camiseta x, boné y...)" value="${kit.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if> />
                                            </div>            
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <a href="PesquisaKitController" class="btn btn-danger btn-block" >Cancelar</a>
                                                </div>
                                                <div class="col-sm-6">
                                                    <button type="submit" name="btnConfirmar" class="btn btn-success btn-block">Confirmar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        <%@ include file = "layout/rodape.jsp" %>                            

    </body>
</html>
