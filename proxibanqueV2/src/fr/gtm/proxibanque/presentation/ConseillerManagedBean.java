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

@ManagedBean
@SessionScoped
public class ConseillerManagedBean implements Serializable{

	/**
	 * 
	 */
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
	public String getId() {
		return id;
	}



	public void setId(String login) {
		this.id = login;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public ArrayList<Client> getListeclient() {
		return listeclient;
	}



	public void setListeclient(ArrayList<Client> listeclient) {
		this.listeclient = listeclient;
	}



	public String creaConseiller() {
		scons.creerConseiller(nom, prenom, id, pwd);
		return "login";
		
	}

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
