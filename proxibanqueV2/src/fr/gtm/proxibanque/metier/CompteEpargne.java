package fr.gtm.proxibanque.metier;

/**
 * Classe abstraite permettant de définir les parametres d'un compte epargne
 * @author BS, ML
 * @version 2.0
 * 
 */
public class CompteEpargne extends Compte {



	//Proprietes
	protected String tauxRemuneration;

	//Constructeur

	public CompteEpargne(String solde, String dateOuverture, String tauxRemuneration) {
		super(solde, dateOuverture);
		this.tauxRemuneration=tauxRemuneration;
		// TODO Auto-generated constructor stub
	}

	//toString
	/**
	 * Redefinition du toString de la classe abstraite Compte
	 */	
	@Override
	public String toString() {
		return className + " tauxRemuneration=" + tauxRemuneration
				+ " % , solde=" + solde
				+ ", dateOuverture=" + dateOuverture + "\n";
	}


}
