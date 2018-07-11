import java.util.Arrays;

import fr.banque.Client;
import fr.banque.Compte;

public class Run {

	public static void main(String[] args) {

		Client c1 = new Client();
		Compte compte1 = new Compte(123, 92.3D);

		////////////////////////////////////////

		System.out.println(compte1.toString());
		compte1.setSolde(36.45D);
		System.out.println(compte1.toString());
		compte1.ajouter(65D);
		System.out.println(compte1.toString());
		compte1.retirer(45.3D);
		System.out.println(compte1.toString());


		System.out.println("\n" + "//////////////////////////" + "\n");

		//////////////////////////////////////////

		System.out.println(c1.toString());
		c1.setAge(10);
		System.out.println(c1.toString());
		c1.setNom("yolo");
		System.out.println(c1.toString());
		c1.setNumero(123);
		System.out.println(c1.toString());
		c1.setPrenom("toto");
		System.out.println(c1.toString());
		c1.ajouterCompte(compte1);
		System.out.println(c1.toString());

		Compte compte2 = new Compte(456, 45D);
		Compte compte3 = new Compte(544578, 65.3D);
		Compte compte4 = new Compte(4584584, 102.8D);
		Compte compte5 = new Compte(455, 458.7D);

		c1.ajouterCompte(compte1);
		System.out.println(c1.toString());
		c1.ajouterCompte(compte2);
		System.out.println(c1.toString());
		c1.ajouterCompte(compte3);
		System.out.println(c1.toString());
		c1.ajouterCompte(compte4);
		System.out.println(c1.toString());
		c1.ajouterCompte(compte5);
		System.out.println(c1.toString());
		c1.ajouterCompte(compte2);
		System.out.println(c1.toString());

		System.out.println(c1.getCompte(123).toString());
		System.out.println(c1.getCompte(456).toString());
		System.out.println(c1.getCompte(789));

		System.out.println(Arrays.toString(c1.getCompte()));







	}

}
