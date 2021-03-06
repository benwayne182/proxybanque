package fr.gtm.proxibanque.presentation;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.proxibanque.service.IServiceCompteEpargne;

/**
 * Servlet implementation class ServletCompteEpargne
 */
@WebServlet("/ServletCompteEpargne")
public class ServletCompteEpargne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	IServiceCompteEpargne sce;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCompteEpargne() {
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
		String solde=request.getParameter("solde");
		String dateouv=request.getParameter("dateouv");
		String tauxrem=request.getParameter("tauxremun");


		//Soumettre les parametres de la requete a la couche service
		sce.creerCompte(idclient, dateouv, solde, tauxrem);


		//Reponse a l'utilisateur
		RequestDispatcher dispatcher=request.getRequestDispatcher("resultCreaCompte.jsp");;

		dispatcher.forward(request, response);
	}

}
