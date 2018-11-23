<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des livres</title>
</head>
<body>
	<div class="container">
		<h1>Gestion des livres</h1>
		<br> <br>
		<table class="table table-hover table-striped">
			<tr>
				<th>Isbn</th>
				<th>Auteur</th>
				<th>Titre</th>
				<th>Nb pages</th>
				<th>Suppression</th>
			</tr>
			<c:forEach items="${listeL}" var="l" varStatus="bStatus">
				<tr>
					<td><input type="text" name="isbn" value="${l.isbn}" /></td>
					<td><input type="text" name="auteur" value="${l.auteur}" /></td>
					<td><input type="text" name="titre" value="${l.titre}" /></td>
					<td><input type="number" name="nbPages" value="${l.nbPages}" /></td>
					<td class="centre"><a href="supprimerLivre?isbn=${l.isbn}">X
					</a></td>
				</tr>
			</c:forEach>
		</table>
		<br> <br>
		<li><a href="${pageContext.request.contextPath}/app/accueil">Accueil</a></li>
		<li><a href="${pageContext.request.contextPath}/app/ajouter">Ajouter
				un livre</a></li>

	</div>

</body>
</html>