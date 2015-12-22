package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.metier.Conseiller;

public interface IServiceConseiller {
	
	 public void creerConseiller(String nom, String prenom,	String identifiant,	String pwd);
	 
	 public Conseiller lireConseiller(String id, String pwd);
	 
	 public void virement(int numcompteD, int numcompteC, float montant);
	 
	 
}
