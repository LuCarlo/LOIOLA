<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tag"%>


<link href="css/jquery.css" rel="stylesheet" />
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>

<title>HoteisUNIP.com</title>
</head>
<body>
	<form method="post" action="selecionaHotel">
		<div style="text-align: center">
			<h2>Busca de Hotel</h2>
		</div>

		<div>
			<!-- 	<input type="hidden" name="valorDiaria"  />
		<input type="hidden" name="qtdDias" value="6"/>
	 -->
			<table border="1">
				<tr>
					<td>Data de Entrada: <tag:campoData id="dataEntrada" /> <br />
					</td>
					<td>Data de Saída: <tag:campoData id="dataSaida" /><br />
					</td>
				</tr>
			</table>
			<br />Tipo de quarto: <select name="tipoQuarto">
				<option value="1">Quarto Individual</option>
				<option value="2">Quarto Duplo</option>
				<option value="3">Quarto Família</option>
				<option value="4">Quarto Múltiplo</option>

			</select> <br /> <br />
		</div>

		<input type="submit" value="Reservar" />

	</form>

	<h3>Dados da Reserva!!</h3>

	<table border="1">
		<tr>
			<td><b>Data Entrada:</b> <fmt:formatDate
					value="${hotel.dataEntrada.time}" pattern="dd/MM/yyyy" /></td>
			<td><b>Data Saida:</b> <fmt:formatDate
					value="${hotel.dataSaida.time }" pattern="dd/MM/yyyy" /></td>
		</tr>

		<tr>
			<td><b>Quantidade de Diárias:</b> ${hotel.qtdDias}</td>
			<td><b>Tipo do Quarto:</b> <c:if test="${hotel.tipoQuarto == 1}">      
      Quarto Individual
   </c:if> <c:if test="${hotel.tipoQuarto == 2}">      
      Quarto Duplo
   </c:if> <c:if test="${hotel.tipoQuarto == 3}">      
      Quarto Família
   </c:if> <c:if test="${hotel.tipoQuarto == 4}">      
      Quarto Múltiplo
   </c:if></td>
			<td><b>Valor da Diária:</b> ${hotel.valorDiaria}</td>
			<td><b>Valor Total:</b> ${hotel.valorTotal}</td>
		</tr>
	</table>
	<font color="red">*Obs: O valor de diária é fixo. O valor total
		pode variar de acordo com o tipo de quarto selecionado.</font>






	<form method="post" action="listaHotel">

		<div
			style="width: 1300px; height: 86px; margin-top: 35px; margin-left: 45px;">

			<table class="striped">
				<tr>
					<th></th>
					<th>ID</th>
					<th>FORNECEDOR</th>
					<th>CNPJ</th>
					<th>ENDEREÇO</th>
					<th>CELULAR</th>
					<th>TELEFONE</th>
					<th>TELEFONE COMERCIAL</th>
					<th>EXCLUIR</th>
				</tr>
				<c:forEach items="${hoteis}" var="hotel">
					<tr>
						<td>${hoteis.nome}</td>
						<td><b>Tipo do Quarto:</b> <c:if
								test="${hoteis.tipoQuarto == 1}">      
      Quarto Individual
   </c:if> <c:if test="${hoteis.tipoQuarto == 2}">      
      Quarto Duplo
   </c:if> <c:if test="${hoteis.tipoQuarto == 3}">      
      Quarto Família
   </c:if> <c:if test="${hoteis.tipoQuarto == 4}">      
      Quarto Múltiplo
   </c:if></td>
						<td>${hoteis.valorDiaria}</td>
						<td><b>Data Entrada:</b> <fmt:formatDate
								value="${hoteis.dataEntrada.time}" pattern="dd/MM/yyyy" /></td>
						<td><b>Data Saida:</b> <fmt:formatDate
								value="${hoteis.dataSaida.time }" pattern="dd/MM/yyyy" /></td>
					</tr>
					<td>${hoteis.valorTotal}</td>
					<td>${hoteis.qtdDias}</td>


				</c:forEach>
			</table>
		</div>
		<input type="submit" value="Listar Reservas" />
	</form>




</body>
</html>