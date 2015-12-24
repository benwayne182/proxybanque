package fr.gtm.proxibanque.service;

import javax.inject.Inject;

import fr.gtm.proxibanque.dao.CompteEpargneDao;
import fr.gtm.proxibanque.metier.CompteEpargne;
/**
 * Classe d'implementation des méthodes de l'interface {@link fr.gtm.proxibanque.service.IServiceCompteEpargne}
 * @author Adminl
 *
 */
public class ServiceCompteEpargne implements IServiceCompteEpargne{

	@Inject
	CompteEpargneDao cedao;

	//constructeur
	public ServiceCompteEpargne() {
		
	}
	
	
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
