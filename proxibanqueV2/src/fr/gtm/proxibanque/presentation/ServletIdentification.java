package fr.gtm.proxibanque.presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.proxibanque.metier.Client;
import fr.gtm.proxibanque.metier.Conseiller;
import fr.gtm.proxibanque.service.ServiceClient;
import fr.gtm.proxibanque.service.ServiceConseiller;
import fr.gtm.proxibanque.service.UserService;


/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/ServletIdentification")
public class ServletIdentification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public ServletIdentification() {
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
		String login=request.getParameter("id");
		String pwd=request.getParameter("password");


		//Soumettre les parametres de la requete a la couche service
		UserService log = new UserService(login,pwd);
		HttpSession maSession = request.getSession();


		//Reponse a l'utilisateur
		ServiceConseiller scons = new ServiceConseiller();
		Conseiller cons=scons.lireConseiller(log.getId(), log.getPassword());
		maSession.setAttribute("consdao", cons);
		RequestDispatcher dispatcher;

		if((login.equalsIgnoreCase(cons.getIdentifiant()))&&(pwd.equalsIgnoreCase(cons.getPwd()))){
			ServiceClient sclient = new ServiceClient();
			ArrayList<Client> listeclient = sclient.lireClients(cons.getIdConseiller());
			maSession.setAttribute("listeclient", listeclient);
			dispatcher=request.getRequestDispatcher("resultId.jsp");
		}else{
			dispatcher=request.getRequestDispatcher("login_red.html");
		}

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}*/

}
