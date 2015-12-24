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

import fr.gtm.proxibanque.metier.Client;
import fr.gtm.proxibanque.service.IServiceClient;
import fr.gtm.proxibanque.service.ServiceClient;

/**
 * Servlet implementation class ModifClient
 */
@WebServlet("/ServletLireClient")
public class ServletLireClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject IServiceClient sclient;
	//ServiceClient sclient = new ServiceClient();

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

	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation des parametres de la requete
		String idclient=request.getParameter("idclient");



		//Soumettre les parametres de la requete a la couche service
		//ServiceClient sclient = new ServiceClient();
		Client client_modif = sclient.lireClient(idclient);
		HttpSession maSession = request.getSession();
		maSession.setAttribute("client_modif", client_modif);

		//Reponse a l'utilisateur
		RequestDispatcher dispatcher=request.getRequestDispatcher("resultModifClient.jsp");

		dispatcher.forward(request, response);
	}

}
