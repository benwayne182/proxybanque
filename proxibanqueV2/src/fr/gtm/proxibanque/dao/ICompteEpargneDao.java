package fr.gtm.proxibanque.dao;

import fr.gtm.proxibanque.metier.CompteEpargne;

/**
 * Interface des méthodes CRUD pour les objets de type {@link fr.gtm.proxibanque.metier.CompteEpargne}
 * @author Adminl
 *
 */
public interface ICompteEpargneDao {
	/**
	 * Creation d'un compte epargne, à partir de ses proprietes (voir {@link fr.gtm.proxibanque.metier.CompteEpargne})
	 * @param idclient 
	 * @param dateOuverture
	 * @param solde
	 * @param tauxRemuneration
	 */
	public void creerCompte(String idclient, String dateOuverture, String solde, String tauxRemuneration);
	/**
	 * Trouver (lire) un compte epargne associé à un client
	 * @param idclient numéro identification client
	 * @return objet de type CompteEpargne
	 */
	public CompteEpargne lireCompte(String idclient);
	/**
	 * Trouver un compte epargne à partir de son ID
	 * @param numcompteD numéro compte
	 * @return objet CompteEpargne
	 */
	public CompteEpargne findCompte(int numcompteD);
	/**
	 * Modifier le compte epargne numéro numcompteC
	 * @param numcompteC numéro de compte
	 * @param solde solde
	 */
	public void modifCompteE(int numcompteC, String solde);

}
