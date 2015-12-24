package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.metier.CompteCourant;

/**
 * Interface de déclaration des méthodes de la couche service, pour le traitement des comptes courants
 * @author Adminl
 *
 */
public interface IServiceCompteCourant {

	/**
	 * Création d'un compte courant associé à un client
	 * @param idclient numéro du client
	 * @param dateOuverture date d'ouverture
	 * @param solde solde
	 * @param decouvert decouvert
	 * @param statut particulier ou entreprise
	 */
	public void creerCompte(String idclient, String dateOuverture, String solde, String decouvert, String statut);

	/**
	 * Trouver le compte courant associé au client 
	 * @param idclient numéro du client
	 * @return objet CompteCourant
	 */
	public CompteCourant lireCompte(String idclient);

	/**
	 * Trouver un compte à partir de son numéro
	 * @param numcompte
	 * @return objet CompteCourant
	 */
	public CompteCourant findCompte(int numcompte);
	
	/**
	 * Modifier le solde d'un compte courant numéro numcompte
	 * @param numcompte numéro de compte
	 * @param solde solde
	 */
	
	public void modifCompteC(int numcompte, String solde);
}
