package metier;


public class CarteVisaPremier implements ICarte {

	//propriete
	protected int numeroCarte;

	//constructeur
	public CarteVisaPremier(int numeroCarte) {
		super();
		this.numeroCarte = numeroCarte;
	}

	//get set
	public int getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(int numeroCarte) {
		this.numeroCarte = numeroCarte;
	}
	
}
