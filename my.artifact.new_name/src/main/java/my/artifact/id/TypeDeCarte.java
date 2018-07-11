package my.artifact.id;

public enum TypeDeCarte {


	P, C, T, CA;
	// PIQUE(1), COEUR(2), TREFLE(3), CARREAUX(4);

	public int a;

	TypeDeCarte() {

	}

	TypeDeCarte(int a) {

		this.a = a;

	}

	@Override
	public String toString() {

		return String.valueOf(this.a);
	}

}
