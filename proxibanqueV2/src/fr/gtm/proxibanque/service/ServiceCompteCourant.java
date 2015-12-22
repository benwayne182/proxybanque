package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.dao.CompteCourantDao;
import fr.gtm.proxibanque.metier.CompteCourant;

public class ServiceCompteCourant implements IServiceCompteCourant{

	CompteCourantDao ccdao = new CompteCourantDao();


	public void creerCompte(String idclient, String dateOuverture, String solde, String decouvert, String statut) {
		ccdao.creerCompte(idclient, dateOuverture, solde, decouvert, statut);

	}
	
	public CompteCourant lireCompte(String idclient) {
		return ccdao.lireCompte(idclient);
		
	}

	public CompteCourant findCompte(int numcompte) {
		return ccdao.findCompte(numcompte);
	}


	public void modifCompteC(int numcompte, String solde) {
		ccdao.modifCompteC(numcompte, solde);
		
	}
	
	
}
