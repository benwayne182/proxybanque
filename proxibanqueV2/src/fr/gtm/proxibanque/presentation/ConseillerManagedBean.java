package fr.gtm.proxibanque.presentation;

import java.io.Serializable;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import fr.gtm.proxibanque.metier.Client;
import fr.gtm.proxibanque.service.IServiceClient;
import fr.gtm.proxibanque.service.ServiceConseiller;

/**
 * Managed bean du conseiller
 */
@ManagedBean
@SessionScoped
public class ConseillerManagedBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	//@Inject IServiceConseiller scons;
	@Inject IServiceClient sclient;
	ServiceConseiller scons =new ServiceConseiller();
	//ServiceClient sclient = new ServiceClient();
	
	private String id;
	private String pwd;
	private String nom;
	private String prenom;
	private ArrayList<Client> listeclient;
	
	
	//setters & getters
	/**
	 * Prendre le username
	 * @return string du nom utilisateur
	 */
	public String getId() {
		return id;
	}


/**
 * Definition username
 * @param login
 */
	public void setId(String login) {
		this.id = login;
	}


/**
 * Prendre le mot de passe
 * @return string mot de passe
 */
	public String getPwd() {
		return pwd;
	}


/**
 * Definir le mot de passe
 * @param pwd
 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * Prendre le nom
	 * @return string nom
	 */
	public String getNom() {
		return nom;
	}


/**
 * Definir le nom
 * @param nom
 */
	public void setNom(String nom) {
		this.nom = nom;
	}


/**
 * Prender le prenom
 * @return string prenom
 */
	public String getPrenom() {
		return prenom;
	}


/**
 * definir prenom
 * @param prenom
 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

/**
 * Prendre la liste de clients
 * @return liste des objets client
 */
	public ArrayList<Client> getListeclient() {
		return listeclient;
	}

/**
 * Definir la liste des clients
 * @param listeclient
 */

	public void setListeclient(ArrayList<Client> listeclient) {
		this.listeclient = listeclient;
	}


/**
 * Creation d'un conseiller
 * @return
 */
	public String creaConseiller() {
		scons.creerConseiller(nom, prenom, id, pwd);
		return "login";
		
	}
	
	/**
	 * Methode d'autentification: rédirige à la page resultId si login et mot de passe sont verifiés, sinon retour à la page login
	 * @return string de la page suivante
	 */

	public String login()
	{
		if(getId().equalsIgnoreCase(scons.lireConseiller(id, pwd).getIdentifiant()) && getPwd().equals(scons.lireConseiller(id, pwd).getPwd()))
		{
			setListeclient(sclient.lireClients(scons.lireConseiller(id, pwd).getIdConseiller()));
			return "resultId";
		}
		else
		{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("login", new FacesMessage("Combinaison login/mot de passe invalide"));
			return "login";
		}
	}

}
