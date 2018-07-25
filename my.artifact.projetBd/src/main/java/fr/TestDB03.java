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

		this.init();

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

			// String requete = "select *from operation where compteId=(select c.id from
			// utilisateur u,compte c where u.nom=\"Fargis\" and u.prenom=\"Denis\" and
			// u.id=c.utilisateurId)";
			int cpt = 1;

			while (resultat.next()) {





				double solde = resultat.getDouble("solde");
				double decouvert = resultat.getDouble("decouvert");
				double taux = resultat.getDouble("taux");


				/*
				 * System.out.println("///////" + String.valueOf(cpt) + "////////");
				 *
				 * for (String d : data) { System.out.println(d); }
				 */

				// cpt++;



				compte = CompteConverter.getTypeCompte(decouvert, taux);

				// System.out.println(compte.getClass().toString());

				if(compte instanceof Compte) {
					compte.setSolde(solde);
				}

				if(compte instanceof CompteASeuil) {
					((CompteASeuil) compte).setSeuil(decouvert);
				}

				if(compte instanceof CompteRemunere) {
					((CompteRemunere) compte).setTaux(taux);
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
