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
	
	private String login;
	private String pwd;
	
	
	//setters & getters
	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String login()
	{
		if("test".equalsIgnoreCase(getLogin()) && "test".equals(getPwd()))
		{
			return "resultId";
		}
		else
		{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("login", new FacesMessage("Combinaison login/mot de passe invalide"));
			return "login";
		}
	}

}
