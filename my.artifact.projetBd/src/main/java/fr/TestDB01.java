package fr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class TestDB01 {



	public TestDB01() {

	}

	public static void main(String[] args) {

		final String dbDriver = "com.mysql.jdbc.Driver";
		final String dbUrl = "http://localhost/phpmyadmin/db_structure.php?server=1&db=banque";
		final String dbLogin = "root";
		final String dbPwd = "root";

		Connection connection = null;
		Statement request = null;
		ResultSet resultat = null;

		try {
			Class.forName(dbDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
