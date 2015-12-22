package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.dao.CompteEpargneDao;
import fr.gtm.proxibanque.metier.CompteEpargne;

public class ServiceCompteEpargne implements IServiceCompteEpargne{

	
	CompteEpargneDao cedao = new CompteEpargneDao();

	public void creerCompte(String idclient, String dateOuverture, String solde, String tauxRemuneration) {
		cedao.creerCompte(idclient, dateOuverture, solde, tauxRemuneration);
	}

	public CompteEpargne lireCompte(String idclient) {
		return cedao.lireCompte(idclient);
		
	}

	public CompteEpargne findCompte(int numcompte) {
		return cedao.findCompte(numcompte);
	}

	public void modifCompteE(int numcompte, String solde) {
		cedao.modifCompteE(numcompte, solde);
		
	}
	
	

}
