package fr.gtm.proxibanque.metier;


/**
 * Classe abstraite d'un utilisateur (personne), caract�ris� par nom et pr�nom.
 * @author Adminl
 *
 */
public abstract class Personne {
	protected String nom ;
	protected String prenom ;
	
	//getters setters
	/**
	 * Recup�re le nom de l'objet personne
	 * @return string du nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * D�finit le nom de l'objet personne
	 * @param nom nom de la personne
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Recup�re le pr�nom
	 * @return string du pr�nom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * D�finit le pr�nom
	 * @param prenom pr�nom de la personne
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
