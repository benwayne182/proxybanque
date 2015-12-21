package fr.gtm.proxibanque.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.proxibanque.metier.CompteCourant;
import fr.gtm.proxibanque.metier.CompteEpargne;
import fr.gtm.proxibanque.service.ServiceCompteCourant;
import fr.gtm.proxibanque.service.ServiceCompteEpargne;

/**
 * Servlet implementation class ServletListeCompte
 */
@WebServlet("/ServletListeCompte")
public class ServletListeCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListeCompte() {
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
		ServiceCompteCourant ccdao2 = new ServiceCompteCourant();
		ServiceCompteEpargne cedao2 = new ServiceCompteEpargne();
		CompteCourant ccdao = ccdao2.lireCompte(idclient);
		CompteEpargne cedao = cedao2.lireCompte(idclient);
		HttpSession maSession = request.getSession();
		maSession.setAttribute("ccdao", ccdao);
		maSession.setAttribute("cedao", cedao);
		
		//Reponse a l'utilisateur
		RequestDispatcher dispatcher=request.getRequestDispatcher("resultListeCompte.jsp");

		dispatcher.forward(request, response);
	}

}
