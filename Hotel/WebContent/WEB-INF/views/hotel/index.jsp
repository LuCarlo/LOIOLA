<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tag"%>

<link href="css/jquery.css" rel="stylesheet" />
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>

<title>HoteisUNIP.com</title>
</head>
<body>
	<form method="get" action="selecionaHotel">
		<div style="text-align: center">
			<h2>Busca de Hotel</h2>
		</div>

		<div>
		<input type="hidden" name="valorDiaria" value="150" />
		<input type="hidden" name="qtdDias" value="6"/>
			<table border="1">
				<tr>
					<td>Data de Entrada: <tag:campoData id="dataEntrada" /> <br />
					</td>
					<td>Data de Saída: <tag:campoData id="dataSaida" /><br />
					</td>
				</tr>
			</table>
			<br />Tipo de quarto: <select name="tipoQuarto">
				<option value="Quarto Individual">Quarto Individual</option>
				<option value="Quarto Duplo">Quarto Duplo</option>
				<option value="Quarto Familia">Quarto Familia</option>
				<option value="Quarto Múltiplo">Quarto Múltiplo</option>

			</select> <br /> <br /> 
		</div>
		
		<input type="submit" value="Pesquisar" />
	</form>

</body>
</html>