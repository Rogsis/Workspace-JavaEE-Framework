<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/commun.css">
	
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
		        <a  href="index.jsp" class="navbar-brand active">
		        <span class="glyphicon glyphicon-film"></span> 
		        <span class="glyphicon glyphicon-film"></span> 
		        </a>
		          <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		    </div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<ul class="nav navbar-nav navbar-right">
					<li ><a href="index.jsp">Accueil</a></li>
					<li><a href="lister">Liste des films</a></li>
					<li><a href="ajouter">Ajouter un film</a></li>
					<li><a href="listerStyle">Styles</a></li>
					<li><a href="geo.jsp">Qui sommes-nous</a></li>
				</ul>
			</div>
		</div>
	</nav>	
	
<div class="container">	
	<h1 class="bleu">Edition d'un film</h1>
	<br><br>
		<div>
	<form:form action="editer" method="POST" class="form-horizontal" commandName="film" >
				<form:input type="hidden" path="id"/> 
				<div class="form-group">			
					<form:label path="titre" class="col-xs-2 control-label">Titre :</form:label>
					<div class="col-xs-10">
						<form:input path="titre" placeholder="Titre du film ..."  class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<form:label path="annee" class="col-xs-2 control-label">Année :</form:label>
					<div class="col-xs-10">
						<form:input path="annee"  placeholder="Année de sortie ..."  class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<form:label path="style.id" class="col-xs-2 control-label">Style :</form:label>
					<div class="col-xs-10">
						<form:select path="style.id" class="form-control">
							<form:options items="${listeStyles}" 
											itemValue="id"
											itemLabel="libelle"></form:options>
						</form:select>					
					</div>
				</div>
				<div class="form-group">			
					<form:input path="real.id" type="hidden" /> 
					<form:label path="real.prenom" class="col-xs-2 control-label">Réalisateur :</form:label>
					<div class="col-xs-5">
						<form:input path="real.prenom" placeholder="Prénom ..."  class="form-control" /> 
					</div>
					<div class="col-xs-5">
						<form:input path="real.nom" placeholder="Nom ..."  class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<form:label path="duree" class="col-xs-2 control-label">Durée :</form:label>
					<div class="col-xs-10">
						<form:input path="duree"  placeholder="Durée du film (format h:mm) ..."  class="form-control" /> 
					</div>
				</div>


				<div class="form-group">			
					<form:label path="vu" class="col-xs-2 control-label">Vu :</form:label>
					<div class="col-xs-10">
						<form:select path = "vu" class="form-control">
							<form:option value="true">Oui</form:option>
							<form:option value="false">Non</form:option>
						</form:select>					
					</div>
				</div>

				<c:forEach items="${film.acteurs}" var="acteur" varStatus="status">
					<div class="form-group">			
						<label for="duree" class="col-xs-2 control-label">Acteur ${status.index + 1} :</label>
						<div class="col-xs-5">
							<input name="acteurs[${status.index}].prenom" value="${acteur.prenom}"  placeholder="Prénom ..." class="form-control"/>
						</div>
						<div class="col-xs-5">
							<input name="acteurs[${status.index}].nom" value="${acteur.nom}"  placeholder="Nom ..." class="form-control"/>
						</div>
						<input type="hidden" name="acteurs[${status.index}].id" value="${acteur.id}"/>
					</div>
					<c:set var="nbActeurs" value="${status.count}"/> 
				</c:forEach>
				
				<div class="form-group">			
					<form:label path="synopsis" class="col-xs-2 control-label">Synopsis :</form:label>
					<div class="col-xs-10">
						<form:textarea path="synopsis" rows="5" placeholder="Résumé et commentaires ..."  class="form-control" ></form:textarea> 
					</div>
				</div>

				<div class="form-group" >
					<div class="col-xs-offset-2 col-xs-10">
						<button type="submit" class="btn btn-primary">Envoyer</button>			
					</div>
				</div>	
			
	</form:form>
	</div>
</div>
	<jsp:include page="footer.jsp" />
	
</body>
</html>