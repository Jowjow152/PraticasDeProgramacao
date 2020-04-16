<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Listar Paises</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
     
        <!-- Barra superior com os menus de navegação -->

        <!-- Container Principal -->
        <div id="main" class="container">
            <h3 class="row" >Lista de Paises</h3>
            
            <c:forEach var="pais" items="${lista}">
            <h4 class="page-header">Pais #${pais.id}</h4>
            <div class="row">
                <div class="col-md-12">
                    <p><strong>Nome</strong>
                    </p>
                    <p>
                        ${pais.nome}
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <p><strong>População</strong>
                    </p>
                    <p>
                        ${pais.populacao}
                    </p>
                </div>
                <div class="col-md-12">
                    <p><strong>Área</strong>
                    </p>
                    <p>
                        ${pais.area} Km²
                    </p>
                </div>
            </div>
            </c:forEach>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.jsp" class="btn btn-default">Voltar</a>
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>