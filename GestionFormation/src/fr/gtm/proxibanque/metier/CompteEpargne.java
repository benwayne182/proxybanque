package fr.gtm.proxibanque.metier;


public class CompteEpargne extends Compte {

	//Proprietes
	protected double tauxRemuneration;

	//Constructeur
	/**
	 * 
	 * @param numCompte numero de compte
	 * @param solde solde du compte
	 * @param dateOuverture date d'ouverture du compte
	 * @param tauxRemuneration taux de rémuneration
	 */
	public CompteEpargne(int numCompte, double solde, String dateOuverture, double tauxRemuneration) {
		super(numCompte, solde, dateOuverture);
		// TODO Auto-generated constructor stub
		this.tauxRemuneration = tauxRemuneration;
	}

	/**
	 * Surcharge du constructeur pour le taux de remuneration par defaut
	 * @param numCompte numero de compte
	 * @param solde solde du compte
	 * @param dateOuverture date d'ouverture du compte
	 */
	public CompteEpargne(int numCompte, double solde, String dateOuverture) {
		super(numCompte, solde, dateOuverture);
		// TODO Auto-generated constructor stub
		this.tauxRemuneration = 3.0;
	}

	//toString
	/**
	 * Redefinition du toString de la classe abstraite Compte
	 */	
	@Override
	public String toString() {
		return className + " tauxRemuneration=" + tauxRemuneration
				+ " % , numCompte=" + numCompte + ", solde=" + solde
				+ ", dateOuverture=" + dateOuverture + "\n";
	}


}
