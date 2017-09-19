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
	<form method="post" action="selecionaHotel">
		<table border="1">

			<marquee><h2>Busque seu Hotel!</h2></marquee>

			<tr>
				<select name="cidade">
					<option value="bsb">Brasilia</option>
					<option value="sp">São Paulo</option>
					<option value="rj">Rio de Janeiro</option>
					<option value="bh">Belo Horizonte</option>
				</select>

				<select name="tipoQuarto">
					<option value="1">Quarto Individual</option>
					<option value="2">Quarto Duplo</option>
					<option value="3">Quarto Familia</option>
					<option value="4">Quarto Múltiplo</option>
				</select>
			</tr>
			<tr>
				<div>
				<td>Data de Entrada: <tag:campoData id="dataEn" /> <br />
				</td>
				</div>
				<div>
				<td>Data de Saída: <tag:campoData id="dataSai" /><br />
				</td>
				</div>
				<br />
			</tr>

		</table>
		<tr>
			<input type="submit" value="Pesquisar" />
		</tr>
	</form>

</body>
</html>