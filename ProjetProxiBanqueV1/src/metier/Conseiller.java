package metier;

import java.util.HashSet;

public abstract class Conseiller extends Personne{

	//proprietes
	public static HashSet<Client> listeClient= new HashSet<Client>(10);

	//getters setters
	public static HashSet<Client> getListeClient() {
		return listeClient;
	}

	public static void setListeClient(HashSet<Client> listeClient) {
		Conseiller.listeClient = listeClient;
	}


	//constructeur
	public Conseiller(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}





}
