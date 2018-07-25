package fr;

import fr.banque.Compte;
import fr.banque.CompteASeuil;
import fr.banque.CompteASeuilRemunere;
import fr.banque.CompteRemunere;

public class CompteConverter {

	private static Compte[] typeCompte = null;

	public static Compte getTypeCompte(double decouvert, double taux) {

		CompteConverter.typeCompte = new Compte[4];
		CompteConverter.typeCompte[0] = new Compte();
		CompteConverter.typeCompte[1] = new CompteASeuil();
		CompteConverter.typeCompte[2] = new CompteRemunere();
		CompteConverter.typeCompte[3] = new CompteASeuilRemunere();


		Compte res = null;


		if (decouvert == 0.0) {
			if (taux == 0.0) {
				// Compte
				res = CompteConverter.typeCompte[0];
			} else {
				// CompteRemunere
				res = CompteConverter.typeCompte[2];
			}

		}
		else {
			if (taux == 0.0) {
				// CompteASeuil
				res = CompteConverter.typeCompte[1];
			}
			else
			{
				// CompteASeuilRemeunere
				res = CompteConverter.typeCompte[3];

			}
		}

		return res;

	}

}
