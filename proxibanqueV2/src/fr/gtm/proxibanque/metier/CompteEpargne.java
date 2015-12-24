package fr.gtm.proxibanque.metier;

/**
 * Sous-classe de la classe abstraite Compte {@link fr.gtm.proxibanque.metier.Compte}, qui définit un compte épargne avec un taux de rémuneration tauxRemuneration.
 * @author Adminl
 *
 */
public class CompteEpargne extends Compte {



	//Proprietes
	protected String tauxRemuneration;

	//Constructeur
/**
 * Constructeru de la classe Comtpe epargne
 * @param solde solde
 * @param dateOuverture date d'ouverture
 * @param tauxRemuneration taux de remunération
 */
	public CompteEpargne(String solde, String dateOuverture, String tauxRemuneration) {
		super(solde, dateOuverture);
		this.tauxRemuneration=tauxRemuneration;
		// TODO Auto-generated constructor stub
	}
	
	//constructeur(vide)
	/**
	 * Constructeur sans arguments
	 */
	public CompteEpargne() {
		
	}

	
	//setters getters
	/**
	 * Retourne le taux de remuneration
	 * @return string tauxRemuneration
	 */
	public String getTauxRemuneration() {
		return tauxRemuneration;
	}
/**
 * Définit le taux de remuneration du compte epargne
 * @param tauxRemuneration
 */
	public void setTauxRemuneration(String tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	
	//toString
	/**
	 * Redefinition du toString 
	 */	
	@Override
	public String toString() {
		return className + " tauxRemuneration=" + tauxRemuneration
				+ " % , solde=" + solde
				+ ", dateOuverture=" + dateOuverture + "\n";
	}




}
