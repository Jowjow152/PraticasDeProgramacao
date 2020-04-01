<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "aula04.Pais, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Pais</title>
</head>
<body>
	<% ArrayList<Pais> lista = (ArrayList<Pais>) request.getAttribute("lista"); %>
	<% for(Pais pais: lista){ %>
	
	<p>
	Id = <%= pais.getId() %> <br>
	Nome = <%= pais.getNome() %> <br>
	População = <%= pais.getPopulacao() %> <br>
	Area = <%= pais.getArea() %> <br>
	
	<% } %>
</body>
</html>