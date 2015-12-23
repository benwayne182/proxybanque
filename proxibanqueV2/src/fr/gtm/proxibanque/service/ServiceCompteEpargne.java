package fr.gtm.proxibanque.service;

import javax.inject.Inject;

import fr.gtm.proxibanque.dao.CompteEpargneDao;
import fr.gtm.proxibanque.metier.CompteEpargne;

public class ServiceCompteEpargne implements IServiceCompteEpargne{

	@Inject
	CompteEpargneDao cedao;

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
