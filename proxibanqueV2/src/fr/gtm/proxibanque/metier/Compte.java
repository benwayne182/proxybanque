package fr.gtm.proxibanque.metier;

public abstract class Compte {

	//proprietes
	protected String numcompte;
	protected String solde;
	protected String dateOuverture;
	protected String className = this.getClass().getSimpleName();
	
	//constructeur
	public Compte(String solde, String dateOuverture) {
		super();
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}

	//get set

	public String getSolde() {
		return solde;
	}

	public void setSolde(String solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public String getNumcompte() {
		return numcompte;
	}

	public void setNumcompte(String numcompte) {
		this.numcompte = numcompte;
	}

	@Override
	public String toString() {
		return className +" [solde=" + solde
				+ ", dateOuverture=" + dateOuverture + "]";
	}
	
	//toString
	
	
	
}
