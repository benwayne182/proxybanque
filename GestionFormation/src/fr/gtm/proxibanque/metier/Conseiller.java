package fr.gtm.proxibanque.metier;

import java.util.HashSet;

public abstract class Conseiller extends Personne{
	
	protected int idConseiller;
	protected String identifiant;
	protected String pwd;
	//proprietes
	protected HashSet<Client> listeClient= new HashSet<Client>(1);

	//getters setters
	public HashSet<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(HashSet<Client> listeClient) {
		this.listeClient = listeClient;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	//constructeur
	public Conseiller(String nom, String prenom, String login, String password) {
		super(nom, prenom);
		this.identifiant=login;
		this.pwd=password;
	}
	
	public Conseiller(String nom, String prenom) {
		super(nom, prenom);
	}



}
