package fr.gtm.proxibanque.service;

import java.util.ArrayList;

import javax.inject.Inject;

import fr.gtm.proxibanque.dao.ClientDao;
import fr.gtm.proxibanque.dao.IClientdao;
import fr.gtm.proxibanque.metier.Client;

/**
 * Implementation des méthodes de l'interface {@link fr.gtm.proxibanque.service.IServiceClient}
 * @author Adminl
 *
 */

public class ServiceClient implements IServiceClient {

	@Inject IClientdao clientdao; 

	//ClientDao clientdao = new ClientDao();
	
	//constructeur
	public ServiceClient() {

	}

	public void creerClient(String nom,	String pre,	String adresse,	String codep, String ville, String tel, String mail, String idcons) {
		clientdao.creerClient(nom, pre, adresse, codep, ville, tel, mail, idcons);
	}

	public ArrayList<Client> lireClients(int idconseiller){

		return clientdao.lireClients(idconseiller);

	}
	
	public Client lireClient(String idclient) {
		return clientdao.lireClient(idclient);

	}
	
	public void modifClient(String idclient, String nom, String pre, String adresse, String codep, String ville, String mail, String idcons) {
		clientdao.modifClient(idclient, nom, pre, adresse, codep, ville, mail, idcons);
	}
	
	public void supprClient(String idclient) {
		clientdao.supprClient(idclient);
	}
}
