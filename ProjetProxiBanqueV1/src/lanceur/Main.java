package lanceur;

import metier.Client;

import metier.Conseiller;
import service.ServiceConseiller;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ServiceConseiller serviceConseiller = new ServiceConseiller("legrand", "gerard");
		
		Client client1 = new Client("pierre", "jacques", "2 rue de la poire", 75001, "paris", "0124537845");
		Client client2 = new Client("laurent", "jacques", "2 rue de la poire", 75001, "paris", "0124537845");

		serviceConseiller.creerClient(client1);
		serviceConseiller.creerClient(client1);
		serviceConseiller.creerClient(client2);


		
		System.out.println(Conseiller.listeClient);
	}

}
