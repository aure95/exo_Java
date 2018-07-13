package fr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

	public void init(){

		try {
			Class.forName(dbDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void recupererAllClients() {
		List<Client> clients = new ArrayList<>();

		//////////////////////////////////////////////////
		try
		{
			connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
		}catch(
				SQLException e)
		{
			//
			e.printStackTrace();
		}

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
			for (int i = 0; i < resultat.getMetaData(); i++) {
				System.out.println(resultat.getMetaData().getTableName(i));
			}
			while (resultat.next()) {
				System.out.println(resultat.getString("nom"));
				System.out.println(resultat.getString("prenom"));
			}
		} catch (SQLException e) {
			//
			// e.printStackTrace();
		}

		finally {
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

		// return clients;

	}





}
