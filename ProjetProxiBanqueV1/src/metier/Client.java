package metier;

import java.util.HashSet;

public class Client {

	//proprietes
	protected String nom ;
	protected String prenom ;
	protected String adresse ;
	protected int codePostal ;
	protected String ville ;
	protected int telephone ;
	public HashSet<Compte> listeCompte;
	
	//constructeur
	public Client(String nom, String prenom, String adresse, int codePostal,
			String ville, int telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

	//get set
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public int getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public int getTelephone() {
		return telephone;
	}


	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
		public HashSet<Compte> getListeCompte() {
		return listeCompte;
	}

	public void setListeCompte(HashSet<Compte> listeCompte) {
		this.listeCompte = listeCompte;
	}

			
}
