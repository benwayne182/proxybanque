package fr.gtm.proxibanque.metier;

import java.util.HashSet;

public class Gerant extends Personne {

	//proprietes
	protected HashSet<Conseiller> listeConseiller = new HashSet<Conseiller>();


	//constructeur
	public Gerant(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

	//getters setters
	public HashSet<Conseiller> getListeConseiller() {
		return listeConseiller;
	}


	public void setListeConseiller(HashSet<Conseiller> listeConseiller) {
		this.listeConseiller = listeConseiller;
	}



}
