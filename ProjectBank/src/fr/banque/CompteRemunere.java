package fr.banque;


public class CompteRemunere extends Compte {

	private double taux;

	///////////////////////////////////////

	public CompteRemunere() {
		this(0, 0.0D, 0.0D);

	}

	public CompteRemunere(int numero, double solde, double taux) {
		super(numero, solde);
		this.setTaux(taux);
	}

	///////////////////////////////////////

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		if (taux >= 0.0 && taux <= 1.0) {
			this.taux = taux;
		}
		else {

			System.out.println("la valeur du taux doit etre compris entre 0 et 1");
		}
	}

	public double calculerInterets() {
		double res = 0.0D;

		res = this.getSolde() * this.taux;

		return res;
	}

	public void verserInterets() {
		this.ajouter(this.calculerInterets());
	}

	@Override
	public String toString() {
		String res = super.toString().substring(0, super.toString().length() - 1);
		res += ", taux=" + this.getTaux() + "]";

		return res;

	}


}
