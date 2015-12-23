package fr.gtm.proxibanque.dao;

import fr.gtm.proxibanque.metier.CompteEpargne;

public interface ICompteEpargneDao {
	public void creerCompte(String idclient, String dateOuverture, String solde, String tauxRemuneration);
	public CompteEpargne lireCompte(String idclient);
	public CompteEpargne findCompte(int numcompteD);
	public void modifCompteE(int numcompteC, String solde);

}
