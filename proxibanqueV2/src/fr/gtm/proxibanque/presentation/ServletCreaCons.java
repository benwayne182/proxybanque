package fr.gtm.proxibanque.presentation;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.proxibanque.service.IServiceConseiller;


/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/ServletCreaCons")
public class ServletCreaCons extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject IServiceConseiller scons;
	/**
	 * Default constructor. 
	 */
	public ServletCreaCons() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation des parametres de la requete
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String login=request.getParameter("login");
		String pwd=request.getParameter("password");



		//Soumettre les parametres de la requete a la couche service
		scons.creerConseiller(nom, prenom, login, pwd);
		HttpSession maSession = request.getSession();
		maSession.setAttribute("cdao", scons);

		//Reponse a l'utilisateur
		RequestDispatcher dispatcher=request.getRequestDispatcher("resultCrea.jsp");;

		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}*/

}
