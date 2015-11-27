package service;

import java.util.HashSet;
import java.util.Iterator;

import metier.Agence;
import metier.Client;
import metier.Compte;
import metier.CompteEntreprise;
import metier.CompteParticulier;
import metier.Conseiller;
import metier.Gerant;

public class ServiceGerant extends Gerant {

	public ServiceGerant(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

	//methodes
	public void creerConseiller(Conseiller conseiller){
		listeConseiller.add(conseiller);
	}
	public void modifierConseiller(Conseiller conseiller, String nom, String prenom) {
		conseiller.setNom(nom);
		conseiller.setPrenom(prenom);
	}
	public void supprimerConseiller(Conseiller conseiller) {
		listeConseiller.remove(conseiller); 
		System.out.println("Conseiller " +conseiller+ " supprimé.");
	}
	public void lireInfosConseiller(Conseiller conseiller) {
		System.out.println(conseiller.toString());
	}

	/**
	 * Cette methode recupere tous les comptes de tous les conseillers de l'agence.
	 * Quand le solde de ces comptes est inferieur à 50 000 pour un compte entreprise et 5 000 pour un particulier, on incremente un compteur.
	 * La méthode retourne le nombre de comptes débiteurs, ainsi que leur type.
	 * @param agence Agence auditée
	 */
	public void audit(Agence agence){
		int nbCompteDebiteursP=0;
		int nbCompteDebiteursE=0;
		Gerant gerant= agence.getGerant();
		HashSet<Conseiller> listeConseiller = gerant.getListeConseiller();
		for (Iterator<Conseiller> it = listeConseiller.iterator(); it.hasNext(); ) {
			Conseiller conseiller = it.next();
			HashSet<Client> listeClient=conseiller.getListeClient();

			for (Iterator<Client> it2 = listeClient.iterator(); it2.hasNext(); ) {
				Client client = it2.next();
				HashSet<Compte> listeCompte=client.getListeCompte();

				for (Iterator<Compte> it3 = listeCompte.iterator(); it3.hasNext(); ) {
					Compte compte = it3.next();

					if (compte instanceof CompteParticulier){
						if (compte.getSolde()<5000){
							nbCompteDebiteursP+=1;
						}
					}
					else if (compte instanceof CompteEntreprise){

						if (compte.getSolde()<50000){
							nbCompteDebiteursE+=1;
						}
					}
				}
			}
		}
		int nbCompteDebiteurs=nbCompteDebiteursE+nbCompteDebiteursP;
		System.out.println("Il y a "+nbCompteDebiteurs+" comptes débiteurs, dont "+nbCompteDebiteursE+" comptes courants entreprise et "+nbCompteDebiteursP+" comptes courants particulier.");
	}


}
