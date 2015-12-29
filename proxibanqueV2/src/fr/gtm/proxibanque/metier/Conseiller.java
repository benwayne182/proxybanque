package fr.gtm.proxibanque.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Sous-classe de la classe abstraite personne {@link fr.gtm.proxibanque.metier.Personne},
 * dont hérite les propriétés nom et prénom et ajoute un entier du numéro d'idéntification du conseiller,
 * un string du nom d'utilisateur et le mot de passe
 * 
 * @author Adminl
 *
 */
@Entity
public class Conseiller extends Personne{
	//proprietes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idConseiller;
	private String login;
	private String password;
	

	//getters setters
/**
 * Prends le username (identifiant)
 * @return string identifiant
 */
	public String getLogin() {
		return login;
	}

	/**
	 * Définit l'identifiant
	 * @param identifiant
	 */
	public void setLogin(String identifiant) {
		this.login = identifiant;
	}

	/**
	 * Recupère le mot de passe du conseiller 
	 * @return string pwd
	 */
	public String getPwd() {
		return password;
	}

	/**
	 * Definit le mot de passe
	 * @param pwd
	 */
	public void setPwd(String pwd) {
		this.password = pwd;
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
		this.login=identifiant;
		this.password=password;
	}
	
	//constructeur(vide)
	/**
	 * Cosntructeur sans arguments
	 */
	public Conseiller() {
		
	}



}
