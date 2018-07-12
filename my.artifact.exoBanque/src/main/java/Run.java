import java.util.Arrays;

import fr.banque.BanqueException;
import fr.banque.Client;
import fr.banque.Compte;
import fr.banque.CompteASeuil;
import fr.banque.CompteASeuilRemunere;
import fr.banque.CompteRemunere;
import fr.banque.ICompteASeuil;
import fr.banque.ICompteRemunere;


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

		try {
			compte1.retirer(45.3D);
		} catch (BanqueException e) {

			e.printStackTrace();
		}

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
		try {
			c1.ajouterCompte(compte1);
		} catch (BanqueException e7) {

			e7.printStackTrace();
		}
		System.out.println(c1.toString());

		Compte compte2 = new Compte(456, 45D);
		Compte compte3 = new Compte(544578, 65.3D);
		Compte compte4 = new Compte(4584584, 102.8D);
		Compte compte5 = new Compte(455, 458.7D);

		try {
			c1.ajouterCompte(compte1);
		} catch (BanqueException e6) {

			e6.printStackTrace();
		}
		System.out.println(c1.toString());
		try {
			c1.ajouterCompte(compte2);
		} catch (BanqueException e5) {

			e5.printStackTrace();
		}
		System.out.println(c1.toString());
		try {
			c1.ajouterCompte(compte3);
		} catch (BanqueException e4) {
			//
			e4.printStackTrace();
		}
		System.out.println(c1.toString());
		try {
			c1.ajouterCompte(compte4);
		} catch (BanqueException e3) {
			//
			e3.printStackTrace();
		}
		System.out.println(c1.toString());
		try {
			c1.ajouterCompte(compte5);
		} catch (BanqueException e2) {
			//
			e2.printStackTrace();
		}
		System.out.println(c1.toString());
		try {
			c1.ajouterCompte(compte2);
		} catch (BanqueException e1) {
			//
			e1.printStackTrace();
		}
		System.out.println(c1.toString());

		System.out.println(c1.getCompte(123).toString());
		System.out.println(c1.getCompte(456).toString());
		System.out.println(c1.getCompte(789));

		System.out.println(Arrays.toString(c1.getCompte()));

		CompteRemunere compte6 = new CompteRemunere();

		System.out.println("\n" + "/////////////" + compte6.getClass() +
				"/////////////" + "\n");


		compte6.setSolde(50.0D); compte6.setTaux(0.25);
		System.out.println(compte6.toString());
		System.out.println(compte6.calculerInterets()); compte6.verserInterets();
		System.out.println(compte6.toString());

		CompteASeuil compte7 = new CompteASeuil();

		System.out.println("\n" + "/////////////" + compte7.getClass() +
				"/////////////" + "\n");

		System.out.println(compte7.toString()); compte7.ajouter(20.0D);
		System.out.println(compte7.toString()); compte7.setSeuil(15.0D);
		System.out.println(compte7.toString());


		try { compte7.retirer(2.0D); }
		catch (BanqueException e) {
			e.printStackTrace();
		}



		System.out.println(compte7.toString());
		try {
			compte7.retirer(10.0D);
		} catch
		(BanqueException e1) {
			//
			e1.printStackTrace();
		}
		System.out.println(compte7.toString());
		try {
			compte7.retirer(2.0D);
		}
		catch (BanqueException e1) { //
			e1.printStackTrace(); }

		System.out.println(compte7.toString());

		Client client2 = new Client(); System.out.println(client2.toString());
		client2.setNom("toto"); client2.setPrenom("dupont"); client2.setNumero(452);

		Compte compte8[] = null; compte8 = new Compte[5];

		compte8[0] = new Compte(123, 48.0D);
		compte8[1] = new Compte(456, 78.4D);
		compte8[2] = new CompteRemunere(789, 12.8D, 0.7);
		compte8[3] = new Compte(753, 5164.7D);
		compte8[4] = new CompteRemunere(159, 15479.78D, 0.25);

		for (Compte c : compte8) {
			try {
				client2.ajouterCompte(c);
			} catch (BanqueException e1) {
				//
				e1.printStackTrace();
			}
		}

		System.out.println(client2.toString());

		client2.verserInterets();

		System.out.println(client2.toString());


		System.out.println("\n////////////////essai class CompteASeuilRemunere////////////\n");

		CompteASeuilRemunere compte9 = new CompteASeuilRemunere();


		System.out.println("compte9 instanceof ICompteASeuil " + String.valueOf(compte9
				instanceof ICompteASeuil));
		System.out.println("compte9 instanceof ICompteRemunere " + String.valueOf(
				compte9 instanceof ICompteRemunere));
		System.out.println("compte9 instanceof CompteASeuilRemunere " + String.valueOf(compte9
				instanceof CompteASeuilRemunere));

		System.out.println(compte9.toString());
		compte9.setSolde(90.0D);
		compte9.setSeuil(50.0D);
		compte9.setTaux(0.1D);
		System.out.println(compte9.toString());
		try {
			compte9.retirer(10.0D);
		} catch (BanqueException e1) { //
			e1.printStackTrace();
		}
		System.out.println(compte9.toString());
		try {
			compte9.retirer(40.0D);
		} catch (BanqueException e1) { //
			e1.printStackTrace();
		}
		System.out.println(compte9.toString());



		Client client3 = new Client();
		client3.setNom("titi");
		client3.setPrenom("roland"); client3.setNumero(48);

		System.out.println(client3.toString()); try { client3.ajouterCompte(new
				Compte());
		} catch (BanqueException e1) { //
			e1.printStackTrace(); } System.out.println(client3.toString());

			try {
				client3.ajouterCompte(compte9);
			} catch (BanqueException e1) {
			} try {
				client3.ajouterCompte(new Compte());
			} catch (BanqueException e1) {
			} try {
				client3.ajouterCompte(new CompteRemunere());
			} catch (BanqueException e1) {
			}


			System.out.println(client3.toString()); client3.verserInterets();
			System.out.println(client3.toString());





	}

}


