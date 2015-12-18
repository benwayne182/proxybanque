package fr.gtm.proxibanque.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.proxibanque.dao.ClientDao;

/**
 * Servlet implementation class ModifClient
 */
@WebServlet("/ServletLireClient")
public class ServletLireClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLireClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}


	/**
	 * M�thode permettant la lecture des donn�es d'un client � partir de la base 
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation des parametres de la requete
		String idclient=request.getParameter("idclient");



		//Soumettre les parametres de la requete a la couche service
		ClientDao cdao = new ClientDao(null, null, null, null, null, null);
		ClientDao client_modif = cdao.lireClient(idclient);
		HttpSession maSession = request.getSession();
		maSession.setAttribute("client_modif", client_modif);

		//Reponse a l'utilisateur
		RequestDispatcher dispatcher=request.getRequestDispatcher("resultModifClient.jsp");

		dispatcher.forward(request, response);
	}

}
