package fr.gtm.proxibanque.dao;

import fr.gtm.proxibanque.metier.CompteEpargne;

/**
 * Interface des m�thodes CRUD pour les objets de type {@link fr.gtm.proxibanque.metier.CompteEpargne}
 * @author Adminl
 *
 */
public interface ICompteEpargneDao {
	/**
	 * Creation d'un compte epargne, � partir de ses proprietes (voir {@link fr.gtm.proxibanque.metier.CompteEpargne})
	 * @param idclient 
	 * @param dateOuverture
	 * @param solde
	 * @param tauxRemuneration
	 */
	public void creerCompte(String idclient, String dateOuverture, String solde, String tauxRemuneration);
	/**
	 * Trouver (lire) un compte epargne associ� � un client
	 * @param idclient num�ro identification client
	 * @return objet de type CompteEpargne
	 */
	public CompteEpargne lireCompte(String idclient);
	/**
	 * Trouver un compte epargne � partir de son ID
	 * @param numcompteD num�ro compte
	 * @return objet CompteEpargne
	 */
	public CompteEpargne findCompte(int numcompteD);
	/**
	 * Modifier le compte epargne num�ro numcompteC
	 * @param numcompteC num�ro de compte
	 * @param solde solde
	 */
	public void modifCompteE(int numcompteC, String solde);

}
