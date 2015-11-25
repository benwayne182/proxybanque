package metier;


public class CarteVisaElectron implements ICarte {

	//propriete
	protected int numeroCarte;

	//constructeur
	public CarteVisaElectron(int numeroCarte) {
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
