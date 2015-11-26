package metier;

import java.util.HashSet;

public class Gerant extends Personne{

	//proprietes
	public static HashSet<Conseiller> listeConseiller = new HashSet<Conseiller>();

	
	//constructeur
	public Gerant(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

}
