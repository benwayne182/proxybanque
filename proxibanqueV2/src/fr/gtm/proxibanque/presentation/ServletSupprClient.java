package fr.gtm.proxibanque.presentation;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.proxibanque.service.IServiceClient;

/**
 * Servlet implementation class ServletSupprClient
 */
@WebServlet("/ServletSupprClient")
public class ServletSupprClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	IServiceClient sclient;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSupprClient() {
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
		sclient.supprClient(idclient);
		
		//Reponse a l'utilisateur
		RequestDispatcher dispatcher=request.getRequestDispatcher("resultSupprClient.jsp");;
		
		dispatcher.forward(request, response);
	}

}
