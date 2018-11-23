$(function(){
	
	$(".supp").on("click", function(){
		var att = $(this).attr("id");
		var rep = confirm("Voulez-vous supprimer l'élément ?");
		if (rep)
			window.location="supprimer?id=" + att;
	});
	
	$(".modif").on("click", function(){
		var att = $(this).attr("id");
		window.location="editer?id=" + att;
	});
	
});