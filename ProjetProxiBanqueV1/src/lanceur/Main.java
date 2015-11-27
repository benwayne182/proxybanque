package lanceur;

import metier.Agence;
import metier.Client;
import metier.CompteEntreprise;
import metier.CompteEpargne;
import metier.CompteParticulier;
import service.ServiceConseiller;
import service.ServiceGerant;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Instanciation
		ServiceConseiller conseiller1 = new ServiceConseiller("Premier", "François");
		ServiceConseiller conseiller2 = new ServiceConseiller("Wayne", "Bruce");


		CompteEpargne cepargne1 = new CompteEpargne(1234, 1000, "26 novembre 2015");
		CompteEpargne cepargne2 = new CompteEpargne(1235, 1001, "27 novembre 2015");
		CompteEpargne cepargne3 = new CompteEpargne(45366, 785.52, "25/12/1996", 3.5);

		CompteParticulier cparticulier1 = new CompteParticulier(1236, 50000000, "28 novembre 2015");
		CompteParticulier cparticulier2 = new CompteParticulier(1245, 652, "09/05/1998");
		CompteParticulier cparticulier3 = new CompteParticulier(4563, -100000, "21/05/2003");

		CompteEntreprise centreprise1 = new CompteEntreprise(1945, 1520, "24/11/2012");
		CompteEntreprise centreprise2 = new CompteEntreprise(1478, -6000000, "78/112/7520");
		CompteEntreprise centreprise3 = new CompteEntreprise(1545, -500000, "25/11/1999");

		Client client1 = new Client("Pierre", "Jacques", "2 rue de la poire", 75001, "paris", "0124537845");
		Client client2 = new Client("Laurent", "Jacques", "1 rue de la poire", 75001, "paris", "0124537845");
		Client client3 = new Client("Smith", "John", "3 rue de la prune", 75000, "Paris", "0321568479");
		Client client4 = new Client("Carter", "John", "6 rue de la pêche", 75000, "Paris", "0523154695");
		Client client5 = new Client("Boule", "Bill", "78 rue de la pomme", 75000, "Paris", "0328958479");
		Client client6 = new Client("Durand", "Homer", "23 rue de la banane", 75000, "Paris", "0328914479");

		Agence agence = new Agence(007, "11/09/2001");

		ServiceGerant gerant = new ServiceGerant("Georges", "Gerard");
		

		//Creation des acteurs
		gerant.creerConseiller(conseiller1);
		gerant.creerConseiller(conseiller2);

		conseiller1.creerClient(client1);
		conseiller1.creerClient(client1);//on teste que le conseiller ne puisse pas creer deux fois le meme client
		conseiller1.creerClient(client2);
		conseiller1.creerClient(client3);

		conseiller2.creerClient(client4);
		conseiller2.creerClient(client5);
		conseiller2.creerClient(client6);

		//creation des comptes pour les clients du conseiller1		
		conseiller1.creerCompte(client1, cepargne1);
		conseiller1.creerCompte(client1, centreprise2);
		conseiller1.creerCompte(client2, cepargne2);
		conseiller1.creerCompte(client2, cepargne1); //on teste que le client ne puisse pas avoir deux comptes epargnes
		conseiller1.creerCompte(client2, cparticulier1);
		conseiller1.creerCompte(client3, centreprise1);
		conseiller1.creerCompte(client3, cepargne3);

		//creation des comptes pour les clients du conseiller2
		conseiller2.creerCompte(client4, cparticulier2);
		conseiller2.creerCompte(client4, centreprise3); //on teste que le client ne puisse pas avoir deux comptes courants
		conseiller2.creerCompte(client5, cparticulier3);
		conseiller2.creerCompte(client6, centreprise3);
		
		//creation gerant agence
		agence.setGerant(gerant);


		//tests
		System.out.println("------Liste client conseillers------------");
		System.out.println("----------conseiller1-----");
		conseiller1.listerClient();
		System.out.println("--------conseiller2-------");
		conseiller2.listerClient();

		System.out.println("----Suppression compte---");
		conseiller1.supprimerCompte(client2, cepargne2);
		System.out.println("----Crediter compte");
		conseiller2.crediterCompte(50, centreprise3);


		System.out.println("---------Virement-------------");
		conseiller1.virement(500, cparticulier1, cepargne2);		
		System.out.println("---------Gestion patrimoine-------------");
		conseiller1.gestionPatrimoine(client2);
		conseiller2.gestionPatrimoine(client1);
		System.out.println("-------Simulations crédit");
		conseiller1.simulationCredit(centreprise1);
		conseiller1.simulationCredit(centreprise2);
		conseiller2.simulationCredit(cparticulier1);

		System.out.println("-----Audit------");
		gerant.audit(agence);
		
		System.out.println("---------Suppression client--------------");
		conseiller2.supprimerClient(client5);

	}

}
