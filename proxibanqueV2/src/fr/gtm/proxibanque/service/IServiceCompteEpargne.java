package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.metier.CompteEpargne;

/**
 * Interface des m�thodes service du CompteEpargne
 * @author Adminl
 *
 */
public interface IServiceCompteEpargne {

	/**
	 * Creer un compte epargne associ� � un client
	 * @param idclient num�ro client
	 * @param dateOuverture date d'ouverture
	 * @param solde solde
	 * @param tauxRemuneration taux de remuneration
	 */
	public void creerCompte(String idclient, String dateOuverture, String solde, String tauxRemuneration);
	/**
	 * Lire le compte associ� au client
	 * @param idclient num�ro client
	 * @return objet CompteEpargne
	 */
	public CompteEpargne lireCompte(String idclient);
	
	/**
	 * Trouver le compte epargne � partir de son id�ntifiant
	 * @param numcompte
	 * @return objet Compteepargne
	 */
	public CompteEpargne findCompte(int numcompte);
	
	/**
	 * Modifier le solde du compte epargne num�ro numcompte
	 * @param numcompte
	 * @param solde
	 */
	public void modifCompteE(int numcompte, String solde);
}
