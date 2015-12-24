package fr.gtm.proxibanque.metier;

/**
 * Classe qui d�finit un client, sous classe de la classe abstraite Personne.
 * @author Adminl
 *
 */
public class Client extends Personne{

	//proprietes
	/**
	 * Propri�t�s (toutes de type String): num�ro identifiant, adresse, code postale, telephone, email, num�ro id�ntifiant du conseiller associ� 
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
	 * @return string de l'adresse (num�ro et rue)
	 */
	public String getAdresse() {
		return adresse;
	}

/**
 * D�finit l'adresse du client
 * @param adresse num�ro et rue
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
 * D�finit, en string, le code postal
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
 * Prends le num�ro de t�l�phone
 * @return string du num�ro
 */
	public String getTelephone() {
		return telephone;
	}

/**
 * D�finit le num�ro de t�l�phone
 * @param telephone
 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Retourne le num�ro d'id�ntification (en String)
	 * @return string de l'Id
	 */
	public String getId() {
		return id;
	}
/**
 * D�finit le num�ro d'id�ntification du client
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
	 * D�finit l'adresse email
	 * @param email string de l'email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Prends le num�ro d'id�ntification du conseiller associ� au client
	 * @return string du num�ro
	 */
	public String getIdconseiller() {
		return idconseiller;
	}
/**
 * D�finit le num�ro d'id�ntification du conseiller associ� au client
 * @param idconseiller
 */
	public void setIdconseiller(String idconseiller) {
		this.idconseiller = idconseiller;
	}

	//toString
	
	@Override
	/**
	 * Red�finition de la m�thodes toString()
	 */
	public String toString() {
		return "Client nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", telephone=" + telephone  + " \n"
				+ "\n";
	}



}
