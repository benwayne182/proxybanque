package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.metier.CompteCourant;

/**
 * Interface de d�claration des m�thodes de la couche service, pour le traitement des comptes courants
 * @author Adminl
 *
 */
public interface IServiceCompteCourant {

	/**
	 * Cr�ation d'un compte courant associ� � un client
	 * @param idclient num�ro du client
	 * @param dateOuverture date d'ouverture
	 * @param solde solde
	 * @param decouvert decouvert
	 * @param statut particulier ou entreprise
	 */
	public void creerCompte(String idclient, String dateOuverture, String solde, String decouvert, String statut);

	/**
	 * Trouver le compte courant associ� au client 
	 * @param idclient num�ro du client
	 * @return objet CompteCourant
	 */
	public CompteCourant lireCompte(String idclient);

	/**
	 * Trouver un compte � partir de son num�ro
	 * @param numcompte
	 * @return objet CompteCourant
	 */
	public CompteCourant findCompte(int numcompte);
	
	/**
	 * Modifier le solde d'un compte courant num�ro numcompte
	 * @param numcompte num�ro de compte
	 * @param solde solde
	 */
	
	public void modifCompteC(int numcompte, String solde);
}
