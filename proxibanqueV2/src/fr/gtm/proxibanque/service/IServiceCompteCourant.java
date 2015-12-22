package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.metier.CompteCourant;

public interface IServiceCompteCourant {

	public void creerCompte(String idclient, String dateOuverture, String solde, String decouvert, String statut);

	public CompteCourant lireCompte(String idclient);

	public CompteCourant findCompte(int numcompte);
	
	public void modifCompteC(int numcompte, String solde);
}
