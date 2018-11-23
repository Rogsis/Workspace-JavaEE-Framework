package fr.eni.jpa.servlet.style;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.bean.Style;
import fr.eni.jpa.service.GestionStyle;

/**
 * Servlet implementation class AjouterServlet
 */
@WebServlet("/ajouterStyle")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupérer le style à ajouter
		//Style styleAAjouter = new Style(request.getParameter("libelle"));
		String libelle = request.getParameter("libelle");
		
		//Ajouter le style
		GestionStyle gs = new GestionStyle();
		gs.ajouter(libelle);
		
		//Rafraichir la liste à afficher
		response.sendRedirect(request.getContextPath()+"/listerStyle");
	}

}
