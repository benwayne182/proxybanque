package fr.gtm.proxibanque.metier;


/**
 * Classe abstraite d'un utilisateur (personne), caractérisé par nom et prénom.
 * @author Adminl
 *
 */
public abstract class Personne {
	protected String nom ;
	protected String prenom ;
	
	//getters setters
	/**
	 * Recupère le nom de l'objet personne
	 * @return string du nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Définit le nom de l'objet personne
	 * @param nom nom de la personne
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Recupère le prénom
	 * @return string du prénom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Définit le prénom
	 * @param prenom prénom de la personne
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	//constructeur
	/**
	 * Constructeur avec deux arguments:
	 * @param nom nom de la personne
	 * @param prenom prenom de la personne
	 */
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	//constructeur(vide)
	/**
	 * Costructeur sans arguments
	 */
	public Personne() {
		
	}
	
	

}
