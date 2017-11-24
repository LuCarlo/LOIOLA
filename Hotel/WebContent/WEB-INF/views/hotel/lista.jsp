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

	<div>
		<a href="novaBusca">Reservar novamente</a>
	</div>
	<h3>Lista de reservas</h3>

	<div
		style="width: 1300px; height: 86px; margin-top: 35px; margin-left: 45px;">

		<table border="5">
			<tr>
				<th>Nº da Reserva</th>
				<th>Hotel</th>
				<th>Tipo do Quarto</th>
				<th>Valor Diaria</th>
				<th>Data Entrada</th>
				<th>Data Saida</th>
				<th>Valor Total</th>
				<th>Quantidade de Dias</th>
				<th>EXCLUIR</th>
			</tr>
			<c:forEach items="${hoteis}" var="hotel">
				<tr>
					<td>${hotel.id_reserva}</td>
					<td>${hotel.nome}</td>
					<td><c:if test="${hotel.tipoQuarto == 1}">       
     						 Quarto Individual 
 							</c:if> <c:if test="${hotel.tipoQuarto == 2}">      
      						Quarto Duplo 
  							</c:if> <c:if test="${hotel.tipoQuarto == 3}">      
     						Quarto Família 
   							</c:if> <c:if test="${hotel.tipoQuarto == 4}">      
      						Quarto Múltiplo 
   							</c:if></td>
					<td>${hotel.valorDiaria}</td>
					<td><fmt:formatDate value="${hotel.dataEntrada.time}"
							pattern="dd/MM/yyyy" /></td>
					<td><fmt:formatDate value="${hotel.dataSaida.time}"
							pattern="dd/MM/yyyy" /></td>
					<td>${hotel.valorTotal}</td>
					<td>${hotel.qtdDias}</td>
					<td><a
						href="removeHotel?id_reserva=${hotel.id_reserva}&id_hotel=${hotel.id_hotel}">Remover</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>





</body>
</html>