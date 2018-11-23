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

import fr.eni.spring.bean.Mediatheque;

/**
 * Servlet implementation class AfficherMediaTheque
 */
@WebServlet("/AfficherMediaTheque")
public class AfficherMediaTheque extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private Mediatheque mediatheque;
    
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mediatheque", mediatheque);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/afficherMediatheque.jsp");
		rd.forward(request, response);
	}

}















