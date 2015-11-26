package metier;


public class CarteVisaPremier implements ICarte {

	//proprietes
	protected int numeroCarte;

	//constructeur
	public CarteVisaPremier(int numeroCarte) {
		super();
		this.numeroCarte = numeroCarte;
	}

	//getters setters
	public int getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(int numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

}
