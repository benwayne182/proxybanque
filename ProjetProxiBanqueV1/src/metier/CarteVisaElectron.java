package metier;


public class CarteVisaElectron implements ICarte {

	//proprietes
	protected int numeroCarte;

	//constructeur
	public CarteVisaElectron(int numeroCarte) {
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
