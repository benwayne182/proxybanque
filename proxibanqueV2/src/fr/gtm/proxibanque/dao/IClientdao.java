package fr.gtm.proxibanque.dao;

import java.util.ArrayList;

import fr.gtm.proxibanque.metier.Client;

public interface IClientdao {
	public void creerClient(String nom,	String pre,	String adresse,	String codep, String ville, String tel, String mail, String idcons);
	public ArrayList<Client> lireClients(int idconseiller);
	public Client lireClient(String idclient);
	public void modifClient(String idclient, String nom, String pre,	String adresse,	String codep, String ville, String mail, String idcons);
	public void supprClient(String idclient);
}
