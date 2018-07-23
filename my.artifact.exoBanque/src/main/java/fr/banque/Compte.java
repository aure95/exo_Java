package fr.banque;

public class Compte {

	private int numero;
	private double solde;

	//////////////////////////////

	public Compte() {

		this(0,0.0D);

	}

	public Compte(int numero, double solde) {

		this.numero = numero;
		this.solde = solde;
	}

	////////////////////////////

	public int getNumero() {
		return numero;
	}


	public double getSolde() {
		return solde;
	}

	public void setSolde(double unSolde) {
		this.solde = unSolde;
	}

	//////////////////////////////////

	public void ajouter(double unMontant) {
		this.solde+=unMontant;
	}

	public void retirer(double unMontant) throws BanqueException {
		//		if (unMontant > this.solde) {
		//			throw new BanqueException("le solde n'est pas suffisant");
		//		}
		this.solde-=unMontant;
	}

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", solde=" + solde + "]";
	}







}
