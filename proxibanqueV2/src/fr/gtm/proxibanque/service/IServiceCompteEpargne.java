package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.metier.CompteEpargne;

public interface IServiceCompteEpargne {

	public void creerCompte(String idclient, String dateOuverture, String solde, String tauxRemuneration);
	
	public CompteEpargne lireCompte(String idclient);
	
	public CompteEpargne findCompte(int numcompte);
	
	public void modifCompteE(int numcompte, String solde);
}
