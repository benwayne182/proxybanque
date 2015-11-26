package service;

import metier.Client;
import metier.Compte;
import metier.Conseiller;

public class ServiceConseiller extends Conseiller {

	//constructeur
	public ServiceConseiller(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

	//methodes
	public void creerClient(Client client){
		listeClient.add(client);
	}
	public void modifierClient(Client client, String nom, String prenom, String adresse, int codePostal, String ville, String telephone) {
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresse(adresse);
		client.setCodePostal(codePostal);
		client.setVille(ville);
		client.setTelephone(telephone);
	}
	public void lireInfosClient(Client client) {
		client.toString();
	}
	public void supprimerClient(Client client) {
		listeClient.remove(client);


	}
	public void virement(double montant, Compte compteD, Compte compteC) {

	}


}
