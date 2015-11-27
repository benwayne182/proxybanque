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
		System.out.println("Client M." +client.getNom()+ " supprim�.");
	}

	public void listerClient(){
		Object[] obj = listeClient.toArray();
		for(Object o : obj){
			System.out.println(o);
		}
	}

	/**
	 * Pour un client donn�, on calcule la somme des soldes de tous ses comptes.
	 * Si elle est superieure � 500 000, elle est autoris�e, dans le cas contraire, elle est refus�e.
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
			System.out.println("Gestion de patrimoine autoris�e pour M."+client.getNom());
		}
		else {
			System.out.println("Gestion de patrimoine refus�e pour M."+client.getNom());
		}

	}


	/**
	 * Pour ajouter un compte � un client, il faut d'abord v�rifier que celui-ci n'en poss�de pas d�j� un de type similaire (courant ou �pargne).
	 * On d�marre une boucle sur les comptes du client et on incremente un compteur � chaque fois qu'un compte de m�me type est d�tect�.
	 * Si la valeur du compteur est non nulle en fin de boucle, le nouveau compte n'est pas ajout�.
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
			System.out.println("M."+ client.getNom() + " poss�de d�j� ce type de compte.");
		}
	}

	/**
	 * Cette m�thode permet de supprimer un compte d'un client donn�.
	 * @param client Client
	 * @param compte Compte supprim�
	 */
	public void supprimerCompte(Client client, Compte compte){
		HashSet<Compte> listeCompte=client.getListeCompte();
		listeCompte.remove(compte);
		System.out.println("Compte "+compte.getNumCompte()+" supprim�");
	}

	/**
	 * Cette m�thode permet de cr�diter un compte d'un montant donn�.
	 * @param montant Montant cr�dit�
	 * @param compte Compte cr�dit�
	 */
	public void crediterCompte(double montant, Compte compte){
		compte.setSolde(compte.getSolde()+montant);
		System.out.println("Compte "+compte.getNumCompte()+" cr�dit� de "+montant+" �");
	}

	/**
	 * La methode retire au solde du compte d�bit� la valeur du montant, seulement s'il a les fonds suffisants.
	 * Elle ajoute au solde du compte cr�dit� le montant pr�lev�.
	 * Cette m�thode s'applique aux comptes �pargnes d�bit�s.
	 * @param montant Montant du virement
	 * @param compteD Compte d�bit�
	 * @param compteC Compte cr�dit�
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
			System.out.println("Le solde du compte d�biteur est insuffisant.");
		}
	}
	
	/**
	 * La methode retire au solde du compte d�bit� la valeur du montant, seulement s'il a les fonds ou un d�bit suffisant.
	 * Elle ajoute au solde du compte cr�dit� le montant pr�lev�.
	 * Cette m�thode s'applique aux comptes courants d�bit�s.
	 * Il s'agit d'une surcharge de la m�thode pr�cedente.
	 * @param montant Montant du virement
	 * @param compteD Compte d�bit�
	 * @param compteC Compte cr�dit�
	 */
	public void virement(double montant, CompteCourant compteD, Compte compteC){
		if (montant <=(compteD.getSolde() + compteD.getDecouvert())) {
			double soldeTmp = compteD.getSolde()-montant;
			compteD.setSolde(soldeTmp);
			double soldeTmp2 = compteC.getSolde() + montant;
			compteC.setSolde(soldeTmp2);
			System.out.println("Virement du compte "+compteD.getNumCompte()+
					" vers le compte "+compteC.getNumCompte()+" de "+montant+" �");
		}
		else {
			System.out.println("Le solde du compte d�biteur est insuffisant.");
		}
	}

	/**
	 * La m�thode permet d'effectuer une simulation de cr�dit.
	 * En fonction du solde du compte, on peut obtenir une, deux ou aucune autorisation de pr�t.
	 * @param compte Compte utilis� pour la simulation de cr�dit.
	 */
	public void simulationCredit(Compte compte) {
		if (compte.getSolde()<=1000){
			System.out.println("Cr�dits consommation et immobilier refus�s pour le compte "+compte.getNumCompte());
		}
		else if (compte.getSolde()>30000){
			System.out.println("Cr�dits consommation et immobilier accept�s pour le compte "+compte.getNumCompte());
		}
		else{
			System.out.println("Cr�dit consommation accept� et immobilier refus� pour le compte "+compte.getNumCompte());
		}


	}

}
