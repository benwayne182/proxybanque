package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.metier.Conseiller;

/**
 * Méthodes de traitement des objets conseiller {@link fr.gtm.proxibanque.metier.Conseiller}
 * @author Adminl
 *
 */
public interface IServiceConseiller {
	
	/**
	 * Creation d'un conseiller
	 * @param nom
	 * @param prenom
	 * @param identifiant
	 * @param pwd
	 */
	 public void creerConseiller(String nom, String prenom,	String identifiant,	String pwd);
	 
	 /**
	  * Trouver le conseiller avec username et mot de passe
	  * @param id username
	  * @param pwd mot de passe
	  * @return
	  */
	 public Conseiller lireConseiller(String id, String pwd);
	 
	 /**
	  * Effectuer un virement
	  * @param numcompteD compte à debiter
	  * @param numcompteC compte à crediter
	  * @param montant montant
	  */
	 public void virement(int numcompteD, int numcompteC, float montant);
	 
	 
}
