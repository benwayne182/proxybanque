package service;

import java.util.HashSet;
import java.util.Iterator;

import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;

public class ServiceConseiller extends Conseiller {

	//constructeur
	public ServiceConseiller(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

	//methodes
	public void creerClient(Client client){
		if (listeClient.size()<=10){
			listeClient.add(client);
		}
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
		System.out.println(client.toString());
	}
	public void supprimerClient(Client client) {
		listeClient.remove(client); 
		System.out.println("Client M." +client.getNom()+ " supprimé.");
	}

	public void listerClient(){
		Object[] obj = listeClient.toArray();
		for(Object o : obj){
			System.out.println(o);
		}
	}

	/**
	 * Pour un client donné, on calcule la somme des soldes de tous ses comptes.
	 * Si elle est superieure à 500 000, elle est autorisée, dans le cas contraire, elle est refusée.
	 * @param client Client
	 * 
	 */
	public void gestionPatrimoine(Client client){
		double patrimoine = 0;
		HashSet<Compte> listeCompte=client.getListeCompte();
		for (Iterator<Compte> it = listeCompte.iterator(); it.hasNext(); ) {
			Compte c = it.next();
			patrimoine = patrimoine+c.getSolde();
		}
		if (patrimoine >= 500000) {
			System.out.println("Gestion de patrimoine autorisée pour M."+client.getNom());
		}
		else {
			System.out.println("Gestion de patrimoine refusée pour M."+client.getNom());
		}

	}


	/**
	 * Pour ajouter un compte à un client, il faut d'abord vérifier que celui-ci n'en possède pas déjà un de type similaire (courant ou épargne).
	 * On démarre une boucle sur les comptes du client et on incremente un compteur à chaque fois qu'un compte de même type est détecté.
	 * Si la valeur du compteur est non nulle en fin de boucle, le nouveau compte n'est pas ajouté.
	 * @param client Client
	 * @param compte Compte
	 */
	public void creerCompte(Client client, Compte compte){
		int count =0;
		HashSet<Compte> listeCompte=client.getListeCompte();
		if (compte instanceof CompteCourant){
			for (Iterator<Compte> it = listeCompte.iterator(); it.hasNext(); ){
				Compte c = it.next();
				if (c instanceof CompteCourant){
					count+=1;
				}
			}
		}
		else if (compte instanceof CompteEpargne){
			for (Iterator<Compte> it = listeCompte.iterator(); it.hasNext(); ){
				Compte c = it.next();
				if (c instanceof CompteEpargne){
					count+=1;
				}

			}

		}
		if (count==0){
			listeCompte.add(compte);
		}
		else {
			System.out.println("M."+ client.getNom() + " possède déjà ce type de compte.");
		}
	}

	/**
	 * Cette méthode permet de supprimer un compte d'un client donné.
	 * @param client Client
	 * @param compte Compte supprimé
	 */
	public void supprimerCompte(Client client, Compte compte){
		HashSet<Compte> listeCompte=client.getListeCompte();
		listeCompte.remove(compte);
		System.out.println("Compte "+compte.getNumCompte()+" supprimé");
	}

	/**
	 * Cette méthode permet de créditer un compte d'un montant donné.
	 * @param montant Montant crédité
	 * @param compte Compte crédité
	 */
	public void crediterCompte(double montant, Compte compte){
		compte.setSolde(compte.getSolde()+montant);
		System.out.println("Compte "+compte.getNumCompte()+" crédité de "+montant+" €");
	}

	/**
	 * La methode retire au solde du compte débité la valeur du montant, seulement s'il a les fonds suffisants.
	 * Elle ajoute au solde du compte crédité le montant prélevé.
	 * Cette méthode s'applique aux comptes épargnes débités.
	 * @param montant Montant du virement
	 * @param compteD Compte débité
	 * @param compteC Compte crédité
	 */
	public void virement(double montant, CompteEpargne compteD, Compte compteC) {

		if (montant <=compteD.getSolde()) {
			double soldeTmp = compteD.getSolde()-montant;
			compteD.setSolde(soldeTmp);
			double soldeTmp2 = compteC.getSolde() + montant;
			compteC.setSolde(soldeTmp2);
			System.out.println("Virement du compte "+compteD.getNumCompte()+" vers le compte "+compteC);
		}
		else {
			System.out.println("Le solde du compte débiteur est insuffisant.");
		}
	}
	
	/**
	 * La methode retire au solde du compte débité la valeur du montant, seulement s'il a les fonds ou un débit suffisant.
	 * Elle ajoute au solde du compte crédité le montant prélevé.
	 * Cette méthode s'applique aux comptes courants débités.
	 * Il s'agit d'une surcharge de la méthode précedente.
	 * @param montant Montant du virement
	 * @param compteD Compte débité
	 * @param compteC Compte crédité
	 */
	public void virement(double montant, CompteCourant compteD, Compte compteC){
		if (montant <=(compteD.getSolde() + compteD.getDecouvert())) {
			double soldeTmp = compteD.getSolde()-montant;
			compteD.setSolde(soldeTmp);
			double soldeTmp2 = compteC.getSolde() + montant;
			compteC.setSolde(soldeTmp2);
			System.out.println("Virement du compte "+compteD.getNumCompte()+
					" vers le compte "+compteC.getNumCompte()+" de "+montant+" €");
		}
		else {
			System.out.println("Le solde du compte débiteur est insuffisant.");
		}
	}

	/**
	 * La méthode permet d'effectuer une simulation de crédit.
	 * En fonction du solde du compte, on peut obtenir une, deux ou aucune autorisation de prêt.
	 * @param compte Compte utilisé pour la simulation de crédit.
	 */
	public void simulationCredit(Compte compte) {
		if (compte.getSolde()<=1000){
			System.out.println("Crédits consommation et immobilier refusés pour le compte "+compte.getNumCompte());
		}
		else if (compte.getSolde()>30000){
			System.out.println("Crédits consommation et immobilier acceptés pour le compte "+compte.getNumCompte());
		}
		else{
			System.out.println("Crédit consommation accepté et immobilier refusé pour le compte "+compte.getNumCompte());
		}


	}

}
