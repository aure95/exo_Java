package fr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.banque.Client;
import fr.banque.Operation;

public class TestDB04 extends TestDB03 {

	public TestDB04() {
		super();
	}

	public List<Operation> getAllOperationClient(Client client) {

		ArrayList<Operation> operations = new ArrayList<>();
		try {
			this.setRequest(this.getConnection().createStatement());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		try {
			this.setResultat(this.getRequest().executeQuery("select * from utilisateur"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		ResultSet resultat = this.getResultat();

		try {
			while (resultat.next()) {

				System.out.println(resultat.getString("nom"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		this.close();

		return operations;


	}




}
