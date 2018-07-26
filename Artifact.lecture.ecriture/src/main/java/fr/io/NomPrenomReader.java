package fr.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NomPrenomReader {

	private static List<String> resultat = new ArrayList<String>();
	private static String chemin;

	public static String getChemin() {
		return NomPrenomReader.chemin;
	}

	public static void setChemin(String chemin) {
		NomPrenomReader.chemin = chemin;
	}

	public NomPrenomReader(String chemin) {
		NomPrenomReader.setChemin(chemin);

	}

	private static void readFichier(String unNomDeFichier) throws IOException {

		System.out.println(NomPrenomReader.getChemin() + unNomDeFichier);

		FileReader fileReader = new FileReader(NomPrenomReader.getChemin() + unNomDeFichier);
		BufferedReader reader = new BufferedReader(fileReader);
		String data = null;

		try {
			while ((data = reader.readLine()) != null) {
				NomPrenomReader.resultat.add(data);

				for (String d : NomPrenomReader.resultat) {
					System.out.println(d);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (data != null) {
				try {
					reader.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}





	}

	public static List<String> readNom() throws IOException {

		List<String> res = new ArrayList<String>();


		NomPrenomReader.readFichier("nom.txt");

		return res;
	}

	public static List<String> readPrenom() throws IOException {

		List<String> res = new ArrayList<String>();

		NomPrenomReader.readFichier("prenom.txt");


		return res;

	}

}
