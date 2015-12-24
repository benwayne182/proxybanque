package fr.gtm.proxibanque.metier;
/**
 * Classe abstraite d�finissant un compte, caract�ris� par: num�ro de compte, solde, date d'ouverture, nom de la classe r�tourn� par la m�thode getSimpleName(). 
 * @author Adminl
 *
 */
public abstract class Compte {

	//proprietes
	protected String numcompte;
	protected String solde;
	protected String dateOuverture;
	protected String className = this.getClass().getSimpleName();
	
	//constructeur
	/**
	 * Constructeur, sp�cifiant solde et date d'ouverture
	 * @param solde
	 * @param dateOuverture
	 */
	public Compte(String solde, String dateOuverture) {
		super();
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}
	
	/**
	 * Constructeur sans arguments
	 */
	//constructeur(vide)
	public Compte() {
		
	}

	//get set
/**
 * Retourne le solde du compte, en string
 * @return string solde
 */
	public String getSolde() {
		return solde;
	}

	/**
	 * D�finit le solde du compte
	 * @param solde
	 */
	public void setSolde(String solde) {
		this.solde = solde;
	}

	/**
	 * Retourne la date d'ouverture
	 * @return stringe de la date
	 */
	public String getDateOuverture() {
		return dateOuverture;
	}
/**
 * D�finit la date d'ouverture
 * @param dateOuverture strign de la date
 */
	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	/**
	 * Prendre le num�ro du compte
	 * @return string sp�cifinat le num�ro de compte
	 */
	public String getNumcompte() {
		return numcompte;
	}
/**
 * D�finit le num�ro du compte
 * @param numcompte
 */
	public void setNumcompte(String numcompte) {
		this.numcompte = numcompte;
	}

	/**
	 * Red�finition de la m�thode toString() {@link java.lang.Object}
	 */
	@Override
	public String toString() {
		return className +" [solde=" + solde
				+ ", dateOuverture=" + dateOuverture + "]";
	}
	
	//toString
	
	
	
}
