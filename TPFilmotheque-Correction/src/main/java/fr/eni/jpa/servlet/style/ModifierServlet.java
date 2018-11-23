package fr.eni.jpa.servlet.style;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.service.GestionStyle;

/**
 * Servlet implementation class ModifierServlet
 */
@WebServlet("/modifStyle")
public class ModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupérer les datas de mise à jour
		int idStyleAModifier = Integer.valueOf(request.getParameter("id"));
		String nouveauLibelle = request.getParameter("libelle");
		
		//Demander à gestionStyle de faire les modifications
		GestionStyle gs = new GestionStyle();
		gs.modifier(idStyleAModifier,nouveauLibelle);
		
		//Renvoyer vers la page des styles
		response.sendRedirect(request.getContextPath()+"/listerStyle");
	}

}
