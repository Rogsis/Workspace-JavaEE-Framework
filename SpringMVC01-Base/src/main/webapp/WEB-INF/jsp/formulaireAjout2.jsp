<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajout d'une personne</title>
</head>
<body>
	<form:form action="personnes2" method="post" commandName="personne">
		<form:input path="nom" placeholder="Votre nom"/>
		<form:input path="prenom" placeholder="Votre prénom"/>
		<form:input path="adresse.ville" placeholder="Votre ville"/>
		<form:button>Enregistrer</form:button>
	</form:form>

</body>
</html>