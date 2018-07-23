package fr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.banque.Client;
import fr.banque.Compte;

public class TestDB03 extends TestDB02 {

	private Statement request = null;
	private ResultSet resultat = null;

	public TestDB03() {
		super();
		// TODO Auto-generated constructor stub

	}

	public List<Compte> getCompteClient(Client client) {

		List<Compte> Comptes = new ArrayList<>();

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
		} catch (SQLException e) {
			//
			// e.printStackTrace();
		}

		System.out.println(resultat);



		return Comptes;


	}






}
