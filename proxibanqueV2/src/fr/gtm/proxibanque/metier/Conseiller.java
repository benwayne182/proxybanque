package fr.gtm.proxibanque.metier;

public class Conseiller extends Personne{
	//proprietes
	protected int idConseiller;
	protected String identifiant;
	protected String pwd;
	

	//getters setters

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
	
	//constructeur(vide)
	public Conseiller() {
		
	}



}
