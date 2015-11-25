package metier;

public abstract class CompteCourant extends Compte {

	//proprietes
	
	protected double decouvert;

	//constructeur
	public CompteCourant(int numCompte, float solde, String dateOuverture, double decouvert) {
		super(numCompte, solde, dateOuverture);
		this.decouvert = decouvert;
	}
	public CompteCourant(int numCompte, float solde, String dateOuverture) {
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
	
}
