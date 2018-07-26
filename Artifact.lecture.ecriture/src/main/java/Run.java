import java.io.IOException;

import fr.io.NomPrenomReader;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");

		NomPrenomReader.setChemin(
				"C:\\Users\\aure\\Desktop\\ressources_cours_java\\Formation Java\\Enonces-FormationJava\\Enonces-FormationJava\\Exo12-IO\\");

		try {
			NomPrenomReader.readNom();

			System.out.println("//////////////");
			NomPrenomReader.readPrenom();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}



	}

}
