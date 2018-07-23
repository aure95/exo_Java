package fr;

import fr.banque.Compte;
import fr.banque.CompteASeuil;
import fr.banque.CompteASeuilRemunere;
import fr.banque.CompteRemunere;

public class CompteConverter {

	private static Compte[] typeCompte = null;

	public static Compte getTypeCompte(String libelle, String decouvert) {

		CompteConverter.typeCompte = new Compte[4];
		CompteConverter.typeCompte[0] = new Compte();
		CompteConverter.typeCompte[1] = new CompteASeuil();
		CompteConverter.typeCompte[2] = new CompteRemunere();
		CompteConverter.typeCompte[3] = new CompteASeuilRemunere();



		Compte res = null;

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
