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
 * Servlet implementation class ServletCreaClient
 */
@WebServlet("/ServletCreaClient")
public class ServletCreaClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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

		

		//Soumettre les parametres de la requete a la couche service
		ClientDao cdao = new ClientDao();
		cdao.creerClient(nom, prenom, adresse, codepostal, ville, telephone, email);
		HttpSession maSession = request.getSession();
		maSession.setAttribute("cdao", cdao);
		
		//Reponse a l'utilisateur
		RequestDispatcher dispatcher=request.getRequestDispatcher("resultCreaClient.jsp");;
		
		dispatcher.forward(request, response);
	}

}
