package fr.gtm.proxibanque.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.gtm.proxibanque.service.ServiceConseiller;

/**
 * Servlet implementation class ServletVirement
 */
@WebServlet("/ServletVirement")
public class ServletVirement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletVirement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation des parametres de la requete
		String numdeb=request.getParameter("numdeb");
		String numcred=request.getParameter("numcred");
		String montant=request.getParameter("montant");



		//Soumettre les parametres de la requete a la couche service
		ServiceConseiller scons = new ServiceConseiller();
		int numdebI = Integer.parseInt(numdeb);
		int numcredI = Integer.parseInt(numcred);
		Float montantF = Float.parseFloat(montant);
		scons.virement(numdebI, numcredI, montantF);

		//Reponse a l'utilisateur
		RequestDispatcher dispatcher=request.getRequestDispatcher("resultVirement.jsp");;

		dispatcher.forward(request, response);
	}

}
