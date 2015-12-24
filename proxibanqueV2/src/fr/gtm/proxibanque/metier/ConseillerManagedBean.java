package fr.gtm.proxibanque.metier;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.gtm.proxibanque.service.IServiceConseiller;
import fr.gtm.proxibanque.service.ServiceConseiller;

@ManagedBean
@SessionScoped
public class ConseillerManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@Inject IServiceConseiller scons;
	ServiceConseiller scons =new ServiceConseiller();
	
	private String id;
	private String pwd;
	
	
	//setters & getters
	public String getId() {
		return id;
	}



	public void setId(String login) {
		this.id = login;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String login()
	{
		if(getId().equalsIgnoreCase(scons.lireConseiller(id, pwd).getIdentifiant()) && getPwd().equals(scons.lireConseiller(id, pwd).getPwd()))
		{
			return "login2";
		}
		else
		{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("login", new FacesMessage("Combinaison login/mot de passe invalide"));
			return "login";
		}
	}

}
