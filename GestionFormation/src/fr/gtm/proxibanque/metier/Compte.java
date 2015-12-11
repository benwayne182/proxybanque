package fr.gtm.proxibanque.metier;

public abstract class Compte {

	//proprietes
	protected int numCompte;
	protected double solde;
	protected String dateOuverture;
	protected String className = this.getClass().getSimpleName();
	
	//constructeur
	public Compte(int numCompte, double solde, String dateOuverture) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}

	//get set
	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	@Override
	public String toString() {
		return className +" [numCompte=" + numCompte + ", solde=" + solde
				+ ", dateOuverture=" + dateOuverture + "]";
	}
	
	//toString
	
	
	
}
