<%-- 
    Document   : login
    Created on : 21/12/2017, 08:23:53
    Author     : RAJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <%@ include file = "layout/head.jsp" %>

        <title>Login</title>

    </head>
    <body>
        <%@ include file = "layout/menu.jsp" %>


        <div class="container corpo">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <c:choose>
                        <c:when test="${mensagemErro!=null}">
                            <div class="alert alert-danger alert-dismissable fade in">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                <strong>Ops!</strong> ${mensagemErro}.
                            </div>
                        </c:when>    
                    </c:choose>
                    
                    <div class="panel panel-primary">
                        <div class="panel-heading">Login</div>
                        <div class="panel-body">
                            <form action="LoginController?acao=logar" method="post" name="frmManterAtleta">
                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input type="email" class="form-control" id="email" name="email" data-dismiss="alert" aria-label="close">
                                </div>
                                <div class="form-group">
                                    <label for="senha">Senha:</label>
                                    <input type="password" class="form-control" id="senha" name="senha">
                                </div>
                                <div class="form-group">
                                    <div class="radio-inline">
                                        <label><input type="radio" name="optUsuario" value="administrador">Administrador</label>
                                    </div>
                                    <div class="radio-inline">
                                        <label><input type="radio" name="optUsuario" value="organizador" >Organizador</label>
                                    </div>
                                    <div class="radio-inline">
                                        <label><input type="radio" name="optUsuario" checked="checked" value="atleta">Atleta</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-8 col-md-offset-2">
                                        <button type="submit" class="btn btn-info btn-block">Entrar</button>

                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap JS and jQuery -->
        <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
        <script type="text/javascript" src="public/bootstrap/js/jquery-3.2.1.js"></script>
        <script type="text/javascript" src="public/bootstrap/js/bootstrap.js"></script>
    </body>
</html>
