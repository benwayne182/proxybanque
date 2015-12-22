package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.dao.ConseillerDao;
import fr.gtm.proxibanque.metier.Conseiller;

public class ServiceConseiller implements IServiceConseiller{


	ConseillerDao consdao = new ConseillerDao();

	//Constructeur
	public ServiceConseiller() {

	}


	//methodes
	public void creerConseiller(String nom, String prenom,	String identifiant,	String pwd) {
		consdao.creerConseiller(nom, prenom, identifiant, pwd);

	}

	public Conseiller lireConseiller(String id, String pwd) {
		return consdao.lireConseiller(id, pwd);
	}
	
	public void virement(int numcompteD, int numcompteC, float montant) {
		consdao.virement(numcompteD, numcompteC, montant);
	}



}
