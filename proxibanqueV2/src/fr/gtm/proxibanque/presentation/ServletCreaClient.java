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
 * Servlet implementation class ServletCreaClient
 */
@WebServlet("/ServletCreaClient")
public class ServletCreaClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject IServiceClient sclient;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCreaClient() {
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
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String adresse=request.getParameter("adresse");
		String codepostal=request.getParameter("codepostal");
		String ville=request.getParameter("ville");
		String telephone=request.getParameter("telephone");
		String email=request.getParameter("email");
		String idcons=request.getParameter("idconseiller");



		//Soumettre les parametres de la requete a la couche service
		//ServiceClient sclient = new ServiceClient();
		sclient.creerClient(nom, prenom, adresse, codepostal, ville, telephone, email, idcons);
		HttpSession maSession = request.getSession();
		Client client=new Client(nom, prenom, adresse, codepostal, ville, telephone);
		client.setEmail(email);
		client.setIdconseiller(idcons);
		maSession.setAttribute("cdao", client);

		//Reponse a l'utilisateur
		RequestDispatcher dispatcher=request.getRequestDispatcher("resultCreaClient.jsp");;

		dispatcher.forward(request, response);
	}

}
