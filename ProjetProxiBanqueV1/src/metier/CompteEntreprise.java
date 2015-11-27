package metier;


public class CompteEntreprise extends CompteCourant {
	
	//constructeur
		public CompteEntreprise(int numCompte, double solde, String dateOuverture, double decouvert) {
			super(numCompte, solde, dateOuverture);
			this.decouvert = decouvert;
		}
		public CompteEntreprise(int numCompte, double solde, String dateOuverture) {
			super(numCompte, solde, dateOuverture);
			this.decouvert = 1000.00;
			
		}
		
		
		
}
