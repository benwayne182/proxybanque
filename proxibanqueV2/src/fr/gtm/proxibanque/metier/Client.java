package fr.gtm.proxibanque.metier;

/**
 * Classe abstraite permettant de définir les parametres d'un client
 * @author BS, ML
 * @version 2.0
 * 
 */
public abstract class Client extends Personne{

	//proprietes
	protected String id;
	protected String adresse;
	protected String codePostal ;
	protected String ville ;
	protected String telephone ;
	protected String email;
	protected int idconseiller;


	//constructeur
	public Client(String nom, String prenom, String adresse, String codePostal,
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


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdconseiller() {
		return idconseiller;
	}

	public void setIdconseiller(int idconseiller) {
		this.idconseiller = idconseiller;
	}

	//toString
	@Override
	public String toString() {
		return "Client nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", telephone=" + telephone  + " \n"
				+ "\n";
	}



}
