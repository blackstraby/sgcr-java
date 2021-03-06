<%-- 
    Document   : manterAtleta
    Created on : 17/10/2017, 09:35:09
    Author     : RAJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>

        <%@ include file = "layout/head.jsp" %>
        <title>Manter Atleta - ${operacao}</title>
        <script src="public/js/myscript.js"></script>

    </head>
    <body>
        <%@ include file = "layout/menu.jsp" %>

        <div class="container corpo">
            <ul class="breadcrumb">
                <li><a href="dashboard.jsp">Home</a></li>
                <li class="active"> ${operacao} Atleta</li>
            </ul>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">${operacao} Atleta</div>
                        <div class="panel-body">
                            <form action="ManterAtletaController?acao=confirmar${operacao}" method="post" name="frmManterAtleta">
                                <div class="col-md-4">
                                    <input type="hidden" class="form-control" id="codigo" name="hiddenIdAtleta" value="${atleta.id}" readonly />
                                    <div class="form-group">
                                        <label for="Nome">Nome Completo:</label>
                                        <input type="text" required class="form-control" id="nome" name="txtNomeAtleta" value="${atleta.nome}Joao" <c:if test="${operacao == 'Excluir'}"> readonly</c:if> >
                                        </div>
                                        <div class="form-group">
                                            <label for="cpf">CPF:</label>
                                            <input type="text" required class="form-control" id="cpf" placeholder="xxx.xxx.xxx-xx" onkeydown="javascript: fMasc(this, mCPF);" name="txtCpfAtleta" value="${atleta.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>
                                        <div class="form-group">
                                            <label for="dtNasc">Data Nascimento:</label>
                                            <input type="text" required class="form-control" id="dtNasc" placeholder="__/__/____" onkeypress="mascaraData(this, event)" name="txtDataNascimentoAtleta" value="${atleta.dataNascimento}01/01/1990" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>
                                        <div class="form-group">
                                            <label for="apelido">Apelido:</label>
                                            <input type="text" class="form-control" id="apelido" name="txtApelidoAtleta" value="${atleta.apelido}a" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>
                                        <div class="form-group">
                                            <label for="tamCamisa">Tamanho Camisa:</label>
                                            <select name="optTamanhoCamisa" class="form-control" required <c:if test="${operacao == 'Excluir'}"> disabled </c:if>>
                                            <option value="P" <c:if test="${atleta.tamanhoCamisa == 'P'}"> selected</c:if>>P</option>
                                            <option value="M" <c:if test="${atleta.tamanhoCamisa == 'M'}"> selected</c:if>>M</option>
                                            <option value="G" <c:if test="${atleta.tamanhoCamisa == 'G'}"> selected</c:if>>G</option>
                                            </select>

                                        </div>

                                        <div class="form-group">
                                            <label for="cel">Celular</label>
                                            <input type="tel" required class="form-control" id="cel" placeholder="(xx) x xxxx-xxxx" onkeydown="javascript: fMasc(this, mTel);" name="txtCelularAtleta" value="${atleta.celular}(32)99999-9999" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>
                                        <div class="form-group">
                                            <label for="telefone">Telefone:</label>
                                            <input type="tel" required class="form-control" id="telefone"  placeholder="(xx) x xxxx-xxxx" name="txtTelefoneAtleta" onkeydown="javascript: fMasc(this, mTel);" value="${atleta.telefone}(32)3299-9999" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>

                                        <div class="form-group">
                                            <label for="sexo">Sexo:</label> <br>
                                            <div class="radio-inline">
                                                <label><input type="radio" checked name="txtSexoAtleta" value="M" required <c:if test="${operacao == 'Excluir'}"> readonly</c:if> <c:if test="${atleta.sexo == 'M'}"> checked</c:if>>Masculino</label>
                                            </div>
                                            <div class="radio-inline">
                                                    <label><input type="radio" name="txtSexoAtleta" value="F" required <c:if test="${operacao == 'Excluir'}"> readonly</c:if> <c:if test="${atleta.sexo == 'F'}"> checked</c:if>>Feminino</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="cep">CEP:</label>
                                                <input type="text" class="form-control" id="cep" name="txtCepAtleta" required value="${atleta.cep}36080-400" onblur="pesquisacep(this.value);" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>
                                        <div class="form-group">
                                            <label for="cidade">Cidade:</label>
                                            <input type="text" class="form-control" id="cidade" name="txtCidadeAtleta" required value="${atleta.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>
                                        <div class="form-group">
                                            <label for="rua">Logradouro:</label>
                                            <input type="text" class="form-control" id="logradouro" name="txtLogradouroAtleta" required value="${atleta.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>
                                        <div class="form-group">
                                            <label for="bairro">Bairro:</label>
                                            <input type="text" class="form-control" id="bairro" name="txtBairroAtleta" required value="${atleta.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>
                                        <div class="form-group">
                                            <label for="numero">Número:</label>
                                            <input type="text" class="form-control" id="numero" name="txtNumeroAtleta" required value="${atleta.numero}666" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>
                                        <div class="form-group">
                                            <label for="estado">Estado:</label>
                                            <input type="text" class="form-control" id="estado" name="txtEstadoAtleta" required value="${atleta.estado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>
                                        <div class="form-group">
                                            <label for="complemento">Complemento:</label>
                                            <input type="text" class="form-control" id="complemento" name="txtComplementoAtleta" value="${atleta.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>
                                        <div><input name="ibge" type="hidden" id="ibge" size="8"/><br/></div>

                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="email">E-mail:</label>
                                            <input type="email" class="form-control" id="email" name="txtEmailAtleta" required value="${atleta.email}joao@gmail.com" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>
                                        <div class="form-group">
                                            <label for="senha1">Senha:</label>
                                            <input type="password" class="form-control" id="senha1" name="txtSenhaAtleta" required value="${atleta.senha}123" autocomplete <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>
                                        <div class="form-group">
                                            <label for="senha2">Confirmar Senha:</label>
                                            <input type="password" class="form-control" id="senha2" name="txtSenhaAtleta2" required value="123" oninput="validaSenha(this)" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                        </div>
                                        <div class="checkbox">
                                            <label><input type="checkbox" name="agree" required id="agree"> Aceito e Concordo com os <a href="#">Termos</a></label>
                                        </div>
                                        <div class="form-group">
                                            <a href="PesquisaAtletaController" style="text-decoration: none" ><button type="button" class="btn btn-danger">Cancelar</button> </a>
                                            <input type="submit" name="btnConfirmar" value="Confirmar" class="btn btn-success"  >
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
