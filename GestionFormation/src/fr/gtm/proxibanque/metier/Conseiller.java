package fr.gtm.proxibanque.metier;

import java.util.HashSet;

public abstract class Conseiller extends Personne{
	protected String login;
	protected String password;
	//proprietes
	protected HashSet<Client> listeClient= new HashSet<Client>(1);

	//getters setters
	public HashSet<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(HashSet<Client> listeClient) {
		this.listeClient = listeClient;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//constructeur
	public Conseiller(String nom, String prenom, String login, String password) {
		super(nom, prenom);
		this.login=login;
		this.password=password;
	}
	
	public Conseiller(String nom, String prenom) {
		super(nom, prenom);
	}



}
