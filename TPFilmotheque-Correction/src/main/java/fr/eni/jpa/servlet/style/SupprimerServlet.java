package fr.eni.jpa.servlet.style;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jpa.service.GestionStyle;

/**
 * Servlet implementation class SupprimerServlet
 */
@WebServlet("/supprimerStyle")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupérer le style à supprimer
		int idStyleASupprimer = Integer.valueOf(request.getParameter("index"));
		
		//Demande à GestionStyle la suppression
		GestionStyle gs = new GestionStyle();
		gs.supprimer(idStyleASupprimer);
		
		//Renvoyer l'utilisateur sur la page des styles.
		response.sendRedirect(request.getContextPath()+"/listerStyle");
	}


}
