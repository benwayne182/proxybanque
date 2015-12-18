package fr.gtm.proxibanque.service;
/**
 * Classe appelée pour stocker les informations d'indentification du conseiller au début de sa session de travail
 * @author BS, ML
 * @version 2.0
 *
 */
public class UserService {
	
	//parametres
	protected String id;
	protected String password;
	
	//getters setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//constructeur
	public UserService(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	
}
