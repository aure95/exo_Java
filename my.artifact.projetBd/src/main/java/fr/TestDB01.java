package fr;

import java.util.Arrays;
import java.util.List;

import fr.banque.Client;

public class TestDB01 {



	public TestDB01() {

	}

	public static void main(String[] args) {

		TestDB02 db = new TestDB02();
		Client[] client;


		List<Client> clients = db.recupererAllClients();
		client = new Client[clients.size()];

		clients.toArray(client);
		System.out.println(Arrays.toString(client));

		db.close();

		/*
		 * final String dbDriver = "com.mysql.jdbc.Driver"; final String dbUrl =
		 * "jdbc:mysql://localhost/banque"; final String dbLogin = "root"; final String
		 * dbPwd = "";
		 *
		 * Connection connection = null; Statement request = null; ResultSet resultat =
		 * null;
		 *
		 * try { Class.forName(dbDriver); } catch (Exception e) { e.printStackTrace(); }
		 *
		 * try { connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 *
		 * try { request = connection.createStatement(); } catch (SQLException e) { //
		 * // e.printStackTrace(); }
		 *
		 * try { resultat = request.executeQuery("select * from utilisateur"); } catch
		 * (SQLException e) { // // e.printStackTrace(); }
		 *
		 * try { while (resultat.next()) {
		 * System.out.println(resultat.getString("nom"));
		 * System.out.println(resultat.getString("prenom")); } } catch (SQLException e)
		 * { // // e.printStackTrace(); }
		 *
		 *
		 * finally { if (resultat != null) { try { resultat.close(); } catch
		 * (SQLException e) { e.printStackTrace(); } } if (request != null) { try {
		 * request.close(); } catch (SQLException e) { e.printStackTrace(); } } if
		 * (connection != null) { try { connection.close(); } catch (SQLException e) {
		 * e.printStackTrace(); } } }
		 */



	}

}
