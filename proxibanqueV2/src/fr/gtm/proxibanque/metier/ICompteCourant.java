package fr.gtm.proxibanque.metier;

public interface ICompteCourant {

	public void creerCompte(String idclient, String dateOuverture, String solde, String decouvert, String statut);

	public CompteCourant lireCompte(String idclient);

	public CompteCourant findCompte(String numcompte);
}
