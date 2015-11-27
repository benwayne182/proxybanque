package metier;

import java.util.HashSet;

public class Client extends Personne{

	//proprietes
	protected String adresse;
	protected int codePostal ;
	protected String ville ;
	protected String telephone ;
	protected HashSet<Compte> listeCompte = new HashSet<Compte>(1);


	//constructeur
	public Client(String nom, String prenom, String adresse, int codePostal,
			String ville, String telephone) {
		super(nom, prenom);
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

	//getters setters
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


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public HashSet<Compte> getListeCompte() {
		return listeCompte;
	}

	public void setListeCompte(HashSet<Compte> listeCompte) {
		this.listeCompte = listeCompte;
	}

	//toString
	@Override
	public String toString() {
		return "Client nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", telephone=" + telephone  + " \n"
				+ "listeCompte=" + listeCompte + "\n";
	}



}
