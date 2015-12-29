package fr.gtm.proxibanque.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Sous-classe de la classe abstraite personne {@link fr.gtm.proxibanque.metier.Personne},
 * dont h�rite les propri�t�s nom et pr�nom et ajoute un entier du num�ro d'id�ntification du conseiller,
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
	 * D�finit l'identifiant
	 * @param identifiant
	 */
	public void setLogin(String identifiant) {
		this.login = identifiant;
	}

	/**
	 * Recup�re le mot de passe du conseiller 
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
 * Retourne le num�ro d'identification du conseiller
 * @return entier idConseiller
 */
	public int getIdConseiller() {
		return idConseiller;
	}

	/**
	 * D�finit le num�ro d'identification du conseiller
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
