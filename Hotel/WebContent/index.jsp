<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="resources/css/estilo.css" rel="stylesheet" />

<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>

</head>
<body>
<!-- 	Trocar por datepicker porque não ta funcionando dessa forma -->

	Data check-in: <input type="text" id="datepicker" name="checkin"> <br>
	
	Data check-out: <input type="text" id="datepicker" name="checkout"> <br>
</body>
</html>