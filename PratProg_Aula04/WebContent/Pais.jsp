<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ page import = "aula04.Pais"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pais</title>
</head>
<body>
	<% Pais pais = (Pais)  request.getAttribute("pais"); %>
<p>
	Id = <%= pais.getId() %> <br>
	Nome = <%= pais.getNome() %> <br>
	População = <%= pais.getPopulacao() %> <br>
	Area = <%= pais.getArea() %> <br>
</body>
</html>