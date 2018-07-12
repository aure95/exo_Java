package fr.banque;

public class CompteASeuilRemunere extends CompteRemunere implements ICompteASeuil {



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
	public void retirer(double unMontant) {

		if (this.getSolde() - unMontant > this.seuil) {
			super.retirer(unMontant);
		} else {
			System.out.println("IMPOSSIBLE le montant " + unMontant + " car le seuil supérieur " + this.getSeuil()
			+ " au solde actuel de  " + this.getSolde());
		}
	}

	@Override
	public double getSeuil() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSeuil(double unSeuil) {
		// TODO Auto-generated method stub

	}

}
