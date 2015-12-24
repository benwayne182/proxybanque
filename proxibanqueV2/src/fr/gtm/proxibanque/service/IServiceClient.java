package fr.gtm.proxibanque.service;

import java.util.ArrayList;

import fr.gtm.proxibanque.metier.Client;

/**
 * Interface des méthodes des service des objets Client
 * @author Adminl
 *
 */
public interface IServiceClient {
/**
 * Instancie un nouveau client à partir des propriétés, définies dans la classe {@link fr.gtm.proxibanque.metier.Client}
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
	 * Retourne la liste des clients associés à un conseiller
	 * @param idconseiller
	 * @return liste des objets Client
	 */
	public ArrayList<Client> lireClients(int idconseiller);
	/**
	 * Retourne un objet Client à partir du numéro d'idéntification y associé
	 * @param idclient
	 * @return objet Client
	 */
	public Client lireClient(String idclient);
	
	/**
	 * Modifier les propriétes d'un client
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
