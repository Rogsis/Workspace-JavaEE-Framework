package fr.eni.jpa.servlet.film;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.bean.Film;
import fr.eni.jpa.service.GestionFilm;
import fr.eni.jpa.service.GestionStyle;

/**
 * Servlet implementation class AfficherServlet
 */
@WebServlet("/afficher")
public class AfficherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupérer le film à afficher
		int idFilmAAfficher = Integer.valueOf(request.getParameter("index"));
		
		//Demande à GestionFilm le film
		GestionFilm gf = new GestionFilm();
		Film film = gf.getFilm(idFilmAAfficher);
		
		//Placer le film en attribut de requête
		request.setAttribute("film", film);
		
		//Renvoyer l'utilisateur vers la page du film.
		RequestDispatcher rd = request.getRequestDispatcher("afficherFilm.jsp");
		rd.forward(request, response);

	}

	

}
