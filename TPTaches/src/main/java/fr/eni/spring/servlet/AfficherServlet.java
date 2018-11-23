package fr.eni.spring.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.eni.spring.dao.TacheDAO;
import fr.eni.spring.service.TacheService;

/**
 * Servlet implementation class AfficherServlet
 */
@WebServlet("/AfficherServlet")
public class AfficherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	@Autowired
//    private TacheDAO tacheDAO;
	
	@Autowired
	private TacheService tacheService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init(config);
	}
	
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
		//request.setAttribute("taches", this.tacheDAO.getTaches());
		request.setAttribute("taches", this.tacheService.getToutesLesTaches());
		RequestDispatcher rd = request.getRequestDispatcher("listeTaches.jsp");
		rd.forward(request, response);
		
	}
	
	

}
