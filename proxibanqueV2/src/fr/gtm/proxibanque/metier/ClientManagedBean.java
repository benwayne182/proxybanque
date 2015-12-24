package fr.gtm.proxibanque.metier;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.gtm.proxibanque.service.IServiceClient;

@ManagedBean
@ViewScoped
public class ClientManagedBean {
	
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal ;
	private String ville ;
	private String telephone ;
	private String email;
	private String idcons;
	
	
	@Inject IServiceClient sclient;
	
	public ClientManagedBean() {
		
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String creerClient() {
		sclient.creerClient(nom, prenom, adresse, codePostal, ville, telephone, email, idcons);
		return "";
	}
	
	
}
