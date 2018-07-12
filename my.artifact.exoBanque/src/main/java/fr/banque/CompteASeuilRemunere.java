package fr.banque;

public class CompteASeuilRemunere extends CompteRemunere implements ICompteASeuil {


	private double seuil;

	///////////////////////////////////////////////////

	public CompteASeuilRemunere() {
		this(0, 0.0D, 0.0D, 0.0D);

	}

	public CompteASeuilRemunere(int numero, double solde, double taux) {
		this(numero, solde, taux, 0.0D);

	}

	public CompteASeuilRemunere(int numero, double solde, double taux, double seuil) {
		super(numero, solde, taux);
		this.setSeuil(seuil);
	}


	//////////////////////////////////////////////////

	@Override
	public void retirer(double unMontant) throws BanqueException {

		if (this.getSolde() - unMontant > this.seuil) {
			super.retirer(unMontant);
		} else {
			throw new BanqueException("IMPOSSIBLE le montant " + unMontant + " car le seuil supérieur "
					+ this.getSeuil()
			+ " au solde actuel de  " + this.getSolde());
		}
	}

	@Override
	public double getSeuil() {

		return this.seuil;

	}

	@Override
	public void setSeuil(double unSeuil) {

		this.seuil = unSeuil;

	}

	@Override
	public String toString() {

		String res = super.toString().substring(0, super.toString().length() - 1) + ", seuil= " + this.getSeuil() + "]";

		return res;
	}

}
