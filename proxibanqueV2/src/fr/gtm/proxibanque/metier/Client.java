package fr.gtm.proxibanque.metier;

/**
 * Classe qui définit un client, sous classe de la classe abstraite Personne.
 * @author Adminl
 *
 */
public class Client extends Personne{

	//proprietes
	/**
	 * Propriétés (toutes de type String): numéro identifiant, adresse, code postale, telephone, email, numéro idéntifiant du conseiller associé 
	 */
	private String id; 
	private String adresse;
	private String codePostal ;
	private String ville ;
	private String telephone ;
	private String email;
	private String idconseiller;


	//constructeur
	/**
	 * Constructeur d'une instance Client
	 * @param nom nom du client
	 * @param prenom prenom du client
	 * @param adresse adresse
	 * @param codePostal code postal
	 * @param ville ville
	 * @param telephone telephone
	 */
	public Client(String nom, String prenom, String adresse, String codePostal,
			String ville, String telephone) {
		super(nom, prenom);
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}
	
	//constructeur(vide)
	/**
	 * Constructeur sans arguments
	 */
	public Client() {
		
	}

	//getters setters
	/**
	 * Prends l'adresse de l'objet Client
	 * @return string de l'adresse (numéro et rue)
	 */
	public String getAdresse() {
		return adresse;
	}

/**
 * Définit l'adresse du client
 * @param adresse numéro et rue
 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

/**
 * Retourne le string du code postal
 * @return string code postal
 */
	public String getCodePostal() {
		return codePostal;
	}

/**
 * Définit, en string, le code postal
 * @param codePostal
 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

/**
 * Retourne la ville
 * @return string ville
 */
	public String getVille() {
		return ville;
	}

/**
 * Definit la ville du client
 * @param ville string
 */
	public void setVille(String ville) {
		this.ville = ville;
	}

/**
 * Prends le numéro de téléphone
 * @return string du numéro
 */
	public String getTelephone() {
		return telephone;
	}

/**
 * Définit le numéro de téléphone
 * @param telephone
 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Retourne le numéro d'idéntification (en String)
	 * @return string de l'Id
	 */
	public String getId() {
		return id;
	}
/**
 * Définit le numéro d'idéntification du client
 * @param id
 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Prends l'adresse email
	 * @return strign de l'adresse
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Définit l'adresse email
	 * @param email string de l'email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Prends le numéro d'idéntification du conseiller associé au client
	 * @return string du numéro
	 */
	public String getIdconseiller() {
		return idconseiller;
	}
/**
 * Définit le numéro d'idéntification du conseiller associé au client
 * @param idconseiller
 */
	public void setIdconseiller(String idconseiller) {
		this.idconseiller = idconseiller;
	}

	//toString
	
	@Override
	/**
	 * Redéfinition de la méthodes toString()
	 */
	public String toString() {
		return "Client nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", telephone=" + telephone  + " \n"
				+ "\n";
	}



}
