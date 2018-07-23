package fr;

public class CompteConverter {

	private static String[] typeCompte = null;

	public static String getTypeCompte(String libelle, String decouvert) {

		CompteConverter.typeCompte = new String[4];
		CompteConverter.typeCompte[0] = "Compte";
		CompteConverter.typeCompte[1] = "CompteASeuil";
		CompteConverter.typeCompte[2] = "CompteRemunere";
		CompteConverter.typeCompte[3] = "CompteASeuilRemunere";



		String res = null;

		switch (libelle) {
		case "Compte Courant":
			if (decouvert == null) {
				res = CompteConverter.typeCompte[0];

			} else {
				res = CompteConverter.typeCompte[1];
			}

			break;

		case "Livret A":

			res = CompteConverter.typeCompte[2];
			break;

		case "Compte Remunéré":

			if (decouvert == null) {
				res = CompteConverter.typeCompte[2];

			} else {
				res = CompteConverter.typeCompte[3];
			}
			break;

		}


		return res;

	}

}
