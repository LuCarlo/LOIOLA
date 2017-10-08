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
	<font color="red"><h3>${hotel.msg}</h3></font>
	<form method="post" action="selecionaHotel">
		<div style="text-align: center">
			<h2>Reserva de Hotel</h2>
		</div>

		<div>
			<!-- 	<input type="hidden" name="valorDiaria"  />
		<input type="hidden" name="qtdDias" value="6"/>
	 -->
			<table border="1">
				<tr>
					<td>Data de Entrada: <tag:campoData id="dataEntrada" /> <br />
					</td>
					<td>Data de Sa�da: <tag:campoData id="dataSaida" /><br />
					</td>
				</tr>
			</table>
			<br />Tipo de quarto: <select name="tipoQuarto">
				<option value="1">Quarto Individual</option>
				<option value="2">Quarto Duplo</option>
				<option value="3">Quarto Fam�lia</option>
				<option value="4">Quarto M�ltiplo</option>

			</select> <br /> <br />
		</div>
		<input type="submit" value="Reservar" />

	</form>
	
	<br /> 	
	<form method="post" action="listaHotel">
		<input type="submit" value="Listar Reservas" />
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
			<td><b>Quantidade de Di�rias:</b> ${hotel.qtdDias}</td>
			<td><b>Tipo do Quarto:</b> <c:if test="${hotel.tipoQuarto == 1}">      
      Quarto Individual
   </c:if> <c:if test="${hotel.tipoQuarto == 2}">      
      Quarto Duplo
   </c:if> <c:if test="${hotel.tipoQuarto == 3}">      
      Quarto Fam�lia
   </c:if> <c:if test="${hotel.tipoQuarto == 4}">      
      Quarto M�ltiplo
   </c:if></td>
			<td><b>Valor da Di�ria:</b> ${hotel.valorDiaria}</td>
			<td><b>Valor Total:</b> ${hotel.valorTotal}</td>
		</tr>
	</table>
	<font color="red">*Obs: O valor de di�ria � fixo. O valor total
		pode variar de acordo com o tipo de quarto selecionado.
		<p>- Somente ser� possivel agendar um quarto por tipo.</p>
		</font>


</body>
</html>