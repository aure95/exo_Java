package fr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.banque.Client;


public class TestDB02 {


	private final String dbDriver = "com.mysql.jdbc.Driver";
	private final String dbUrl = "jdbc:mysql://localhost/banque";
	private final String dbLogin = "root";
	private final String dbPwd = "";

	private Connection connection = null;
	private Statement request = null;
	private ResultSet resultat = null;


	public Statement getRequest() {
		return request;
	}

	public void setRequest(Statement request) {
		this.request = request;
	}

	public ResultSet getResultat() {
		return resultat;
	}

	public void setResultat(ResultSet resultat) {
		this.resultat = resultat;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	private class CliModel {
		String nom = null;
		String prenom = null;
		String dateDeNaissance = null;
	}

	public TestDB02() {

		this.init();
	}

	public void init(){

		try {
			Class.forName(dbDriver);
		} catch (Exception e) {
			e.printStackTrace();

		}
		try {
			connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
		} catch (SQLException e1) {
			//
			e1.printStackTrace();
		}

	}

	public Connection getConnection() {
		return this.connection;
	}

	public List<Client> recupererAllClients() {
		List<Client> clients = new ArrayList<>();








		//////////////////////////////////////////////////


		try {
			this.request = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		try {
			resultat = request.executeQuery("select * from utilisateur");
		} catch (SQLException e) {
			//
			// e.printStackTrace();
		}


		try {


			String[] fieldNames = new String[resultat.getMetaData().getColumnCount()];
			for (int i = 1; i < resultat.getMetaData().getColumnCount(); i++) {

				fieldNames[i - 1] = resultat.getMetaData().getColumnLabel(i);
				// System.out.println(resultat.getMetaData().getColumnLabel(i));

			}

			System.out.println("///////////" + this.getClass().getSimpleName() + "///////////");



			while (resultat.next()) {

				Client client = new Client();


				// Client client = new Client();
				CliModel cliModel = new CliModel();

				// System.out.println(resultat.getString("nom"));
				cliModel.nom = resultat.getString("nom");

				// System.out.println(resultat.getString("prenom"));
				cliModel.prenom = resultat.getString("prenom");


				// System.out.println(resultat.getString("dateDeNaissance"));
				cliModel.dateDeNaissance = resultat.getString("dateDeNaissance");

				// if (cliModel.nom != null) {
				client.setNom(cliModel.nom);
				// }
				// if (cliModel.prenom != null) {
				client.setPrenom(cliModel.prenom);
				// }
				// if (cliModel.dateDeNaissance != null) {

				// }
				client.setAge(this.calculerAge(cliModel.dateDeNaissance));


				// System.out.println(client.toString());
				clients.add(client);

			}
		} catch (SQLException e) {
			//
			// e.printStackTrace();
		}

		return clients;

	}

	public void close() {

		if (resultat != null) {
			try {
				resultat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (request != null) {
			try {
				request.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}




	private int calculerAge(String dateDeNaissance) {

		int age = 0;
		Date date = new Date();
		int currentYear = date.getYear() + 1900;
		// System.out.println("year " + currentYear);
		// age = Integer.parseInt(dateDeNaissance.split("")[0]);
		// System.out.println("date de naissance " + dateDeNaissance);
		//System.out.println(Arrays.toString(dateDeNaissance.split("-")));

		if(dateDeNaissance!=null)
		{
			String[] data = dateDeNaissance.split("-");
			int yearParsed = Integer.parseInt(data[0]);
			// System.out.println(yearParsed);
			age = currentYear - yearParsed;
			// System.out.println("age calcul= " + age);

			return age;


		}


		// age = Integer.parseInt(dateDeNaissance.split("-")[0]);

		return 0;
	}






}
