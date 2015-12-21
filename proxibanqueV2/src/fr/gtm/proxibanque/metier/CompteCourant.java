package fr.gtm.proxibanque.metier;

public class CompteCourant extends Compte {

	//proprietes

	protected String decouvert;
	protected String statut;

	//constructeur
	public CompteCourant(String solde, String dateOuverture, String decouvert, String statut) {
		super(solde, dateOuverture);
		this.decouvert = decouvert;
		this.statut= statut;
	}
	
	//constructeur(vide)
	public CompteCourant() {

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
