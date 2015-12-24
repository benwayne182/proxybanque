package fr.gtm.proxibanque.service;

import java.util.ArrayList;

import fr.gtm.proxibanque.metier.Client;

/**
 * Interface des m�thodes des service des objets Client
 * @author Adminl
 *
 */
public interface IServiceClient {
/**
 * Instancie un nouveau client � partir des propri�t�s, d�finies dans la classe {@link fr.gtm.proxibanque.metier.Client}
 * @param nom
 * @param pre
 * @param adresse
 * @param codep
 * @param ville
 * @param tel
 * @param mail
 * @param idcons
 */
	public void creerClient(String nom,	String pre,	String adresse,	String codep, String ville, String tel, String mail, String idcons);
	/**
	 * Retourne la liste des clients associ�s � un conseiller
	 * @param idconseiller
	 * @return liste des objets Client
	 */
	public ArrayList<Client> lireClients(int idconseiller);
	/**
	 * Retourne un objet Client � partir du num�ro d'id�ntification y associ�
	 * @param idclient
	 * @return objet Client
	 */
	public Client lireClient(String idclient);
	
	/**
	 * Modifier les propri�tes d'un client
	 * @param idclient
	 * @param nom
	 * @param pre
	 * @param adresse
	 * @param codep
	 * @param ville
	 * @param mail
	 * @param idcons
	 */
	public void modifClient(String idclient, String nom, String pre, String adresse, String codep, String ville, String mail, String idcons);
	/**
	 * Supprimer un client
	 * @param idclient
	 */
	public void supprClient(String idclient);
}
