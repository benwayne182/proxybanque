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
import fr.gtm.proxibanque.metier.Client;

/**
 * Servlet implementation class ServletCreaEpargne
 */
@WebServlet("/ServletCreaEpargne")
public class ServletCreaEpargne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCreaEpargne() {
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
		Client client = new ClientDao().lireClient(idclient);
		HttpSession maSession = request.getSession();
		maSession.setAttribute("cdao", client);

		//Reponse a l'utilisateur
		RequestDispatcher dispatcher=request.getRequestDispatcher("resultCompteEpargne.jsp");

		dispatcher.forward(request, response);
	}

}
