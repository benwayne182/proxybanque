package metier;


public class CompteEpargne extends Compte {

	//Proprietes
	protected double tauxRemuneration;
	
	//Constructeur
	public CompteEpargne(int numCompte, float solde, String dateOuverture, double tauxRemuneration) {
		super(numCompte, solde, dateOuverture);
		// TODO Auto-generated constructor stub
		this.tauxRemuneration = tauxRemuneration;
	}

	public CompteEpargne(int numCompte, float solde, String dateOuverture) {
		super(numCompte, solde, dateOuverture);
		// TODO Auto-generated constructor stub
		this.tauxRemuneration = 3.0;
	}

}
