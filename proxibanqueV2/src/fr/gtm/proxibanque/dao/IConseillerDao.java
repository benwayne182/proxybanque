package fr.gtm.proxibanque.dao;

import fr.gtm.proxibanque.metier.Conseiller;

public interface IConseillerDao {
	public void creerConseiller(String nom,	String prenom,	String identifiant,	String pwd);
	public Conseiller lireConseiller(String id, String pwd);
	public void virement(int numcompteD, int numcompteC, float montant);
	
	

}
