package metier;

import java.util.HashSet;

public abstract class Conseiller extends Personne{

	//proprietes
	protected HashSet<Client> listeClient= new HashSet<Client>(1);

	//getters setters
	public HashSet<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(HashSet<Client> listeClient) {
		this.listeClient = listeClient;
	}


	//constructeur
	public Conseiller(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}





}
