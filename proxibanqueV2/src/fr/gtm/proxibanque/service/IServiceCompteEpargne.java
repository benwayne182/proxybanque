package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.metier.CompteEpargne;

/**
 * Interface des méthodes service du CompteEpargne
 * @author Adminl
 *
 */
public interface IServiceCompteEpargne {

	/**
	 * Creer un compte epargne associé à un client
	 * @param idclient numéro client
	 * @param dateOuverture date d'ouverture
	 * @param solde solde
	 * @param tauxRemuneration taux de remuneration
	 */
	public void creerCompte(String idclient, String dateOuverture, String solde, String tauxRemuneration);
	/**
	 * Lire le compte associé au client
	 * @param idclient numéro client
	 * @return objet CompteEpargne
	 */
	public CompteEpargne lireCompte(String idclient);
	
	/**
	 * Trouver le compte epargne à partir de son idéntifiant
	 * @param numcompte
	 * @return objet Compteepargne
	 */
	public CompteEpargne findCompte(int numcompte);
	
	/**
	 * Modifier le solde du compte epargne numéro numcompte
	 * @param numcompte
	 * @param solde
	 */
	public void modifCompteE(int numcompte, String solde);
}
