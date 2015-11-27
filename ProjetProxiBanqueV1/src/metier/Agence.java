package metier;

public class Agence {

	//proprietes
	private int id;
	private String dateCreation;
	private Gerant gerant;

	//get set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Gerant getGerant() {
		return gerant;
	}
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}


	//constructeur
	public Agence(int id, String dateCreation) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
	}


}
