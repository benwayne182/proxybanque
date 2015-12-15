package fr.gtm.proxibanque.metier;

/**
 * Classe abstraite permettant de définir les parametres d'un compte  courant
 * @author BS, ML
 * @version 2.0
 * 
 */
public abstract class CompteCourant extends Compte {

	//proprietes

	protected String decouvert;
	protected String statut;

	//constructeur
	public CompteCourant(String solde, String dateOuverture, String decouvert, String statut) {
		super(solde, dateOuverture);
		this.decouvert = decouvert;
		this.statut= statut;
	}


	//get set
	public String getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(String decouvert) {
		this.decouvert = decouvert;
	}
	
	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	@Override
	public String toString() {
		return className + " decouvert=" + decouvert + ", solde=" + solde + ", dateOuverture="
				+ dateOuverture + "\n";
	}


}
