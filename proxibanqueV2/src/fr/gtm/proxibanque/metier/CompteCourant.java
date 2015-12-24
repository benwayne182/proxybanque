package fr.gtm.proxibanque.metier;

/**
 * Sous-classe de la classe abtraite Compte {@link fr.gtm.proxibanque.metier.Compte}, définit un compte courant,
 * avec l'ajout de propriétes  decouvert et statut du compte (particulier ou entreprise).
 * @author Adminl
 *  
 *
 */
public class CompteCourant extends Compte {

	//proprietes
	private String decouvert;
	private String statut;

	//constructeur
	/**
	 * Constructeur de la classe
	 * @param solde string du solde du compte courant
	 * @param dateOuverture string de la date d'ouverture
	 * @param decouvert decouvert du compte courant
	 * @param statut statut (particulier ou entreprise)
	 */
	public CompteCourant(String solde, String dateOuverture, String decouvert, String statut) {
		super(solde, dateOuverture);
		this.decouvert = decouvert;
		this.statut= statut;
	}
	
	//constructeur(vide)
	/**
	 * Constructeur sans arguments
	 */
	public CompteCourant() {

	}


	//get set
	/**
	 * Prendre le decouvert du compte courant
	 * @return string decouvert
	 */
	public String getDecouvert() {
		return decouvert;
	}
/**
 * Définir le découvert pour le compte courant
 * @param decouvert
 */
	public void setDecouvert(String decouvert) {
		this.decouvert = decouvert;
	}

	/**
	 * Retourne si le compte et particulier ou entreprise
	 * @return string statut
	 */
	public String getStatut() {
		return statut;
	}

/**
 * Définit le statut du compte, particulier ou entreprise
 * @param statut
 */
	public void setStatut(String statut) {
		this.statut = statut;
	}


	/**
	 * Redéfinition de la méthode toString() {@link java.lang.Object} 
	 */
	@Override
		public String toString() {
		return className + " decouvert=" + decouvert + ", solde=" + solde + ", dateOuverture="
				+ dateOuverture + "\n";
	}


}
