package fr.gtm.proxibanque.metier;


public class CompteParticulier extends CompteCourant {

	//constructeur
	public CompteParticulier(int numCompte, float solde, String dateOuverture, double decouvert) {
		super(numCompte, solde, dateOuverture);
		this.decouvert = decouvert;
	}
	public CompteParticulier(int numCompte, float solde, String dateOuverture) {
		super(numCompte, solde, dateOuverture);
		this.decouvert = 1000.00;
		
	}
	
}
