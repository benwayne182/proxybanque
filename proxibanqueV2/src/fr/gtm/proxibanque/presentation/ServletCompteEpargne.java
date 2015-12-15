package fr.gtm.proxibanque.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.gtm.proxibanque.dao.CompteEpargneDao;

/**
 * Servlet implementation class ServletCompteEpargne
 */
@WebServlet("/ServletCompteEpargne")
public class ServletCompteEpargne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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

	/**
	 * Methode permettant la creation d'un compte epargne dans la base de donnes à partir des parametres rentres dans le formulaire
	 * Redirection vers la page de confirmation de creation de compte
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation des parametres de la requete
		String idclient=request.getParameter("idclient");
		String solde=request.getParameter("solde");
		String dateouv=request.getParameter("dateouv");
		String tauxrem=request.getParameter("tauxremun");


		//Soumettre les parametres de la requete a la couche service
		CompteEpargneDao cedao = new CompteEpargneDao(solde, dateouv, tauxrem);
		cedao.creerCompte(idclient);


		//Reponse a l'utilisateur
		RequestDispatcher dispatcher=request.getRequestDispatcher("resultCreaCompte.jsp");;

		dispatcher.forward(request, response);
	}

}
