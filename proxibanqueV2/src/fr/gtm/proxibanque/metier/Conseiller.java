package fr.gtm.proxibanque.metier;

/**
 * Sous-classe de la classe abstraite personne {@link fr.gtm.proxibanque.metier.Personne},
 * dont hérite les propriétés nom et prénom et ajoute un entier du numéro d'idéntification du conseiller,
 * un string du nom d'utilisateur et le mot de passe
 * 
 * @author Adminl
 *
 */
public class Conseiller extends Personne{
	//proprietes
	private int idConseiller;
	private String identifiant;
	private String pwd;
	

	//getters setters
/**
 * Prends le username (identifiant)
 * @return string identifiant
 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * Définit l'idéntifiant
	 * @param identifiant
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * Recupère le mot de passe du conseiller 
	 * @return string pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Definit le mot de passe
	 * @param pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
/**
 * Retourne le numéro d'identification du conseiller
 * @return entier idConseiller
 */
	public int getIdConseiller() {
		return idConseiller;
	}

	/**
	 * Définit le numéro d'identification du conseiller
	 * @param idConseiller
	 */
	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	//constructeur
	/**
	 * Constructeur de la classe
	 * @param nom nom du conseiller
	 * @param prenom prenom
	 * @param identifiant username
	 * @param password mot de passe
	 */
	public Conseiller(String nom, String prenom, String identifiant, String password) {
		super(nom, prenom);
		this.identifiant=identifiant;
		this.pwd=password;
	}
	
	//constructeur(vide)
	/**
	 * Cosntructeur sans arguments
	 */
	public Conseiller() {
		
	}



}
