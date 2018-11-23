<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajout d'une personne</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/app/personnes" method="post">
		<input type="text" name="nom" placeholder="Votre nom">
		<input type="text" name="prenom" placeholder="Votre prénom">
		<input type="text" name="adresse.ville" placeholder="Votre ville">
		<input type="submit" value="Ajouter"/>
	</form>

</body>
</html>