package fr.gtm.proxibanque.metier;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.gtm.proxibanque.service.ServiceConseiller;

@ManagedBean
@SessionScoped
public class ConseillerManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject ServiceConseiller scons;
	
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
		if("test".equalsIgnoreCase(getId()) && "test".equals(getPwd()))
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
