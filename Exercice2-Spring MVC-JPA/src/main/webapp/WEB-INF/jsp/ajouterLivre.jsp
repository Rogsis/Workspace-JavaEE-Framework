<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des livres</title>
</head>
<body>

	<div class="container">
		<h1>Gestion des livres</h1>
		<h2>Nouveau Livre :</h2>
		<br> <br>
		<div>
			<form action="ajouter" method="POST" class="form-horizontal">
				<div class="form-group">
					<div class="col-xs-3">
						<input name="isbn" placeholder="isbn du livre ..."
							class="form-control" />
					</div>
					<div class="col-xs-3">
						<input name="auteur" placeholder="Auteur du livre ..."
							class="form-control" />
					</div>
					<div class="col-xs-3">
						<input name="titre" placeholder="Titre du livre ..."
							class="form-control" />
					</div>
					<div class="col-xs-2">
						<input type="number" name="nbPages" value=0 class="form-control" />
					</div>
					<div class="col-xs-1">
						<button type="submit" class="btn btn-primary pull-right">Envoyer</button>
					</div>
				</div>

			</form>
		</div>
		<br> <br>
		<li><a href="${pageContext.request.contextPath}/app/accueil">Accueil</a></li>
		<li><a href="${pageContext.request.contextPath}/app/lister">Liste des livres</a></li>
	</div>

</body>
</html>