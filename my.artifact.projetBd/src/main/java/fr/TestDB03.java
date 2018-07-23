package fr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.banque.Client;
import fr.banque.Compte;
import fr.banque.CompteASeuil;
import fr.banque.CompteRemunere;

public class TestDB03 extends TestDB02 {

	private Statement request = null;
	private ResultSet resultat = null;



	public TestDB03() {
		super();
		// TODO Auto-generated constructor stub

	}

	public List<Compte> getCompteClient(Client client) {

		List<Compte> comptes = new ArrayList<>();


		Compte compte = null;



		Connection connection = this.getConnection();
		try {
			this.request = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		try {
			resultat = request
					.executeQuery("select * from compte where utilisateurId=(select id from utilisateur where nom='"
							+ client.getNom() + "' and prenom='" + client.getPrenom() + "' )");

			int cpt = 1;

			while (resultat.next()) {

				String[] data = new String[4];



				data[0] = resultat.getString("libelle");
				data[1] = resultat.getString("solde");
				data[2] = resultat.getString("decouvert");
				data[3] = resultat.getString("taux");

				/*
				 * System.out.println("///////" + String.valueOf(cpt) + "////////");
				 *
				 * for (String d : data) { System.out.println(d); }
				 */

				cpt++;



				compte = CompteConverter.getTypeCompte(data[0], data[2]);

				// System.out.println(compte.getClass().toString());

				if(compte instanceof Compte) {
					compte.setSolde(Double.parseDouble(data[1]));
				}

				if(compte instanceof CompteASeuil) {
					((CompteASeuil) compte).setSeuil(Double.parseDouble(data[2]));
				}

				if(compte instanceof CompteRemunere) {
					((CompteRemunere) compte).setTaux(Double.parseDouble(data[3]));
				}



				comptes.add(compte);

			}

		} catch (SQLException e) {


			//
			// e.printStackTrace();
		}





		this.close();

		return comptes;



	}






}
