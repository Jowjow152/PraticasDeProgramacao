<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>


<body>


	<div class="container-login100">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
			<form action="LoginController.do" method="post">
				<span class="login100-form-title p-b-33"> Login </span>

				<div class="wrap-input100 validate-input">
					<input class="input100" type="text" name="login"
						placeholder="Usuário"> <span class="focus-input100-1"></span>
					<span class="focus-input100-2"></span>
				</div>

				<div class="wrap-input100 rs1 validate-input">
					<input class="input100" type="password" name="senha"
						placeholder="Senha"> <span class="focus-input100-1"></span>
					<span class="focus-input100-2"></span>
				</div>

				<div class="container-login100-form-btn m-t-20">
					<input class="login100-form-btn" type="submit" name="acao" value="Login">
				</div>



				<div class="text-center">
					<a href="Cadastro.jsp" class="txt2 hov1"> Cadastre-se </a>
				</div>
			</form>
		</div>
	</div>

	<script src="js/main.js"></script>
</body>

</html>