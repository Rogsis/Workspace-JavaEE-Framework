package fr.eni.jpa.servlet.film;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.bean.Film;
import fr.eni.jpa.bean.Style;
import fr.eni.jpa.service.GestionFilm;
import fr.eni.jpa.service.GestionStyle;

/**
 * Servlet implementation class ListerServlet
 */
@WebServlet("/lister")
public class ListerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupérer la liste des films
		GestionFilm gf = new GestionFilm();
		List<Film> films = gf.getListe();
		
		//Ajouter les styles en tant qu'attribut de requête
		request.setAttribute("listeF", films);
		
		//Pousser la requête vers la page listeStyles.jsp
		RequestDispatcher rd = request.getRequestDispatcher("listeFilms.jsp");
		rd.forward(request, response);
		
	}
	
	

}
