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

import fr.gtm.proxibanque.dao.ClientDao;
import fr.gtm.proxibanque.dao.ConseillerDao;
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


	/**
	 * Méthode permettant l'interrogation de la base de données lors de l'identification du conseiller.
	 * Commparaison des données entrées en formulaire avec les données présentes en base. 
	 * Lorsque les données correspondent, redirection vers la page d'accueil du conseiller.
	 * Lorsque les données ne correspondent pas, redirection vers une page invitant à re-saisir les informations demandées 
	 * Redirection vers la page de confirmation de modification du client
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */	
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation des parametres de la requete
		String login=request.getParameter("id");
		String pwd=request.getParameter("password");


		//Soumettre les parametres de la requete a la couche service
		UserService log = new UserService(login,pwd);
		HttpSession maSession = request.getSession();


		//Reponse a l'utilisateur
		ConseillerDao consdao = new ConseillerDao(null,null,null,null);
		consdao=consdao.lireConseiller(log.getId(), log.getPassword());
		maSession.setAttribute("consdao", consdao);
		RequestDispatcher dispatcher;

		if((login.equalsIgnoreCase(consdao.getIdentifiant()))&&(pwd.equalsIgnoreCase(consdao.getPwd()))){
			ClientDao cl = new ClientDao(null, null, null, null, null, null);
			ArrayList<ClientDao> listeclient = cl.lireClients(consdao.getIdConseiller());
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
