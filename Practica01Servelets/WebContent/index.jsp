
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Pagina Principal</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/uikit@3.2.2/dist/css/uikit.min.css" />
<link rel="stylesheet" href="public/css/icofont.min.css">
<link rel="stylesheet" href="public/css/styles.css" />
<script type="text/javascript" src="js/main.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<body>
	<c:set var="userId" value="${sessionScope['userID']}" />

	<div class="ui container">
		<div class="ui secondary  menu">
			<div class="item logo">
				<a href="/Practica01Servelets"><h2>CrazyKiller019</h2></a>
			</div>

			<div class="right menu">
				<div class="item">
					<form action="busqueda">
						<div class="ui left icon action input">
						 <input type="text"
								placeholder="Buscar..." name="usuario"> <input
								type="submit" class="ui red submit button" value="Buscar">
						</div>
					</form>
				</div>
				<c:choose>
					<c:when test="${userId == null}">
						<div class="item">
							<a href="registro" class="ui primary button">Registrarse</a>
						</div>
						<div class="item">
							<a href="login" class="ui button">Iniciar Sesion</a>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>

	<div class="layout-header">
		<div class="column-description">
			<h1>
				<span>Recuperar Contactos</span>
			</h1>
			<div>
				<p>Te gusta guardar tus contactos aqui lo puedes realizar</p>
			</div>
			<c:choose>
				<c:when test="${userId == null}">
					<a href="registro" class="ui primary button btn-index-register">Registro</a>
				</c:when>
				<c:otherwise>
					<a href="my-agenda" class="ui primary button btn-index-register">Ver
						mi agenda</a>

				</c:otherwise>
			</c:choose>
		</div>
		<div class="column-bg"></div>
	</div>
	<footer>
		<div class="icon_footer">
			<i class="fas fa-chevron-up"></i>
		</div>
		<div class="social_foote">
			<a href="https://www.facebook.com/marco.orellana.796" target="_BLANK"><i
				class="fab fa-facebook-square"></i></a> <a
				href="https://github.com/MarkOrellana/Pr-ctica-de-laboratorio-01-Servlets-JSP-y-JDBC"
				target="_BLANK"><i class="fab fa-github-square"></i></a>
		</div>
		<p>&COPY; 2020 Todos los derechos reservados | Realizado por Mark
			Orellana</p>
	</footer>
</body>
</html>
