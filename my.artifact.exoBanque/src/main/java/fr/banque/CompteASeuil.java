package fr.banque;

public class CompteASeuil extends Compte implements ICompteASeuil {

	private double seuil;

	public CompteASeuil() {
		this(0, 0);

	}

	public CompteASeuil(int numero, double solde) {
		super(numero, solde);
		this.setSeuil(0.0D);

	}

	/////////////////////////////////////

	@Override
	public double getSeuil() {
		return seuil;
	}

	@Override
	public void setSeuil(double seuil) {
		this.seuil = seuil;
	}

	///////////////////////////////////

	@Override
	public void retirer(double unMontant) {

		if(this.getSolde()-unMontant>this.seuil)
		{
			super.retirer(unMontant);
		}
		else
		{
			System.out.println(
					"IMPOSSIBLE le montant " + unMontant + " car le seuil supérieur " + this.getSeuil()
					+ " au solde actuel de  "
					+ this.getSolde());
		}

	}

	@Override
	public String toString() {
		String res = super.toString().substring(0, super.toString().length() - 1);
		res += ", seuil=" + this.getSeuil() + "]";

		return res;

	}


}
