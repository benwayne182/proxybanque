package fr.gtm.proxibanque.dao;

import fr.gtm.proxibanque.metier.CompteCourant;

/**
 * Interface des m�thodes CRUD pour les objets CompteCourant
 * @author Adminl
 *
 */
public interface ICompteCourantDao {

	/**
	 * Cree un compte courant � partir de num�ro client, date d'ouverture, solde, decouvert et statut (particulier ou entreprise)
	 * @param idclient
	 * @param dateOuverture
	 * @param solde
	 * @param decouvert
	 * @param statut
	 */
	public void creerCompte(String idclient, String dateOuverture, String solde, String decouvert, String statut);
	
	/**
	 * Lire un compte courant d'un client, � partir du num�ro client
	 * @param idclient
	 * @return objet instance de la classe {@link fr.gtm.proxibanque.metier.CompteCourant}
	 */
	public CompteCourant lireCompte(String idclient);
	
	/**
	 * trouver un compte courant � partir de son num�ro id�ntifiant
	 * @param numcompte
	 * @return objet instance de la classe {@link fr.gtm.proxibanque.metier.CompteCourant}
	 */
	public CompteCourant findCompte(int numcompte);
	
	/**
	 * Modifier le solde d'un compte courant, identifi� par son num�ro
	 * @param numcompte
	 * @param solde
	 */
	public void modifCompteC(int numcompte, String solde);
}
