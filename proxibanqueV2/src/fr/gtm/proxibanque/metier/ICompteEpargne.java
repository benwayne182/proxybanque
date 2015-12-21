package fr.gtm.proxibanque.metier;

public interface ICompteEpargne {

	public void creerCompte(String idclient, String dateOuverture, String solde, String tauxRemuneration);
	
	public CompteEpargne lireCompte(String idclient);
}
