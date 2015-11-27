package metier;

public abstract class CompteCourant extends Compte {

	//proprietes

	protected double decouvert;

	//constructeur
	public CompteCourant(int numCompte, double solde, String dateOuverture, double decouvert) {
		super(numCompte, solde, dateOuverture);
		this.decouvert = decouvert;
	}
	public CompteCourant(int numCompte, double solde, String dateOuverture) {
		super(numCompte, solde, dateOuverture);
		this.decouvert = 1000.00;

	}

	//get set
	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	@Override
	public String toString() {
		return className + " decouvert=" + decouvert + ", numCompte="
				+ numCompte + ", solde=" + solde + ", dateOuverture="
				+ dateOuverture + "\n";
	}


}
