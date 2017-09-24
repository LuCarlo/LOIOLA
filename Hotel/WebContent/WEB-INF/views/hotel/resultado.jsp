<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tag"%>

<jsp:useBean id="hotel" class="br.com.unip.hotel.modelo.Hotel" />

<link href="css/jquery.css" rel="stylesheet" />
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<title>Resultado de busca</title>
</head>
<body>


	<form method="get" action="listaHotel">

	<td>
		<tr>Data Entrada: ${param.dataEntrada}
		</tr>
		<tr>Data Saida: ${param.dataSaida }
		</tr>
	</td>

	<td>
		<tr>${param.valorDiaria}
		</tr>
		<tr>
		aaaaaa
		<input type="text" value="${requestScope.qtdDias}" />
		</tr>
	</td>
	</form>
	
</body>
</html>