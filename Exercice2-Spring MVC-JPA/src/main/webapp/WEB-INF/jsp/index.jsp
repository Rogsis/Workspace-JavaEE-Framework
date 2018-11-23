<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des Livres</title>
</head>
<body>
	<div class="container">
		<h1>Gestion des livres</h1>
		<ul>
			<li class="active"><a href="#">Accueil</a></li>
			<li><a href="${pageContext.request.contextPath}/app/lister">Liste
					des livres</a></li>
			<li><a
				href="${pageContext.request.contextPath}/app/ajouter">Ajouter
					un livre</a></li>
		</ul>
	</div>
</body>
</html>