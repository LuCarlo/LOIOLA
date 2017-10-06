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

	<form method="post" action="listaHotel">

		<div
			style="width: 1300px; height: 86px; margin-top: 35px; margin-left: 45px;">

			<table class="striped">
<!-- 				<tr> -->
<!-- 					<th></th> -->
<!-- 					<th>ID</th> -->
<!-- 					<th>FORNECEDOR</th> -->
<!-- 					<th>CNPJ</th> -->
<!-- 					<th>ENDEREÇO</th> -->
<!-- 					<th>CELULAR</th> -->
<!-- 					<th>TELEFONE</th> -->
<!-- 					<th>TELEFONE COMERCIAL</th> -->
<!-- 					<th>EXCLUIR</th> -->
<!-- 				</tr> -->
				<c:forEach items="${hoteis}" var="hotel">
					<tr>
						<td>Nome: ${hotel.nome}</td>
						<td><b>Tipo do Quarto:</b> <c:if
								test="${hotel.tipoQuarto == 1}">       
     						 Quarto Individual 
 							</c:if> <c:if test="${hotel.tipoQuarto == 2}">      
      						Quarto Duplo 
  							</c:if> <c:if test="${hotel.tipoQuarto == 3}">      
     						Quarto Família 
   							</c:if> <c:if test="${hotel.tipoQuarto == 4}">      
      						Quarto Múltiplo 
   							</c:if></td>
						<td>Valor Diaria: ${hotel.valorDiaria}</td>
						<td><b>Data Entrada:</b> <fmt:formatDate
								value="${hotel.dataEntrada.time}" pattern="dd/MM/yyyy" /></td>
						<td><b>Data Saida:</b> <fmt:formatDate
								value="${hotel.dataSaida.time }" pattern="dd/MM/yyyy" /></td>
					</tr> 
					<td>Valor Total: ${hotel.valorTotal}</td>
					<td>Valor QTD: ${hotel.qtdDias}</td>


				</c:forEach>
			</table>
		</div>
		<input type="submit" value="Listar Reservas" />
	</form>



</body>
</html>