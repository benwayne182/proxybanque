package fr.gtm.proxibanque.metier;

public interface ICompteEpargne {

	public void creerCompte(String idclient, String dateOuverture, String solde, String tauxRemuneration);
	
	public CompteEpargne lireCompte(String idclient);
	
	public CompteEpargne findCompte(int numcompte);
	
	public void modifCompteE(int numcompte, String solde);
}
