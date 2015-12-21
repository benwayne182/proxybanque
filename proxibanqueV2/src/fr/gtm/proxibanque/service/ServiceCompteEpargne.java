package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.dao.CompteEpargneDao;
import fr.gtm.proxibanque.metier.CompteEpargne;
import fr.gtm.proxibanque.metier.ICompteEpargne;

public class ServiceCompteEpargne implements ICompteEpargne{

	
	CompteEpargneDao cedao = new CompteEpargneDao();

	public void creerCompte(String idclient, String dateOuverture, String solde, String tauxRemuneration) {
		cedao.creerCompte(idclient, dateOuverture, solde, tauxRemuneration);
	}

	public CompteEpargne lireCompte(String idclient) {
		return cedao.lireCompte(idclient);
		
	}
	
	

}
