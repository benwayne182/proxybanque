package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.dao.CompteCourantDao;
import fr.gtm.proxibanque.metier.CompteCourant;
import fr.gtm.proxibanque.metier.ICompteCourant;

public class ServiceCompteCourant implements ICompteCourant{

	CompteCourantDao ccdao = new CompteCourantDao();


	public void creerCompte(String idclient, String dateOuverture, String solde, String decouvert, String statut) {
		ccdao.creerCompte(idclient, dateOuverture, solde, decouvert, statut);

	}
	
	public CompteCourant lireCompte(String idclient) {
		return ccdao.lireCompte(idclient);
		
	}
}
