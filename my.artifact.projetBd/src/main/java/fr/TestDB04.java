package fr;

import java.sql.PreparedStatement;
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

		String []labels=null;

		PreparedStatement request = null;

		this.init();
		/*
		 * try { this.setRequest(this.getConnection().createStatement());
		 *
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * //e.printStackTrace(); }
		 */

		System.out.println(client.getNom() + " " + client.getPrenom());

		try {

			/*
			 * this.setResultat(this.getRequest().
			 * executeQuery("select c.id from utilisateur u,compte c where u.nom=" +
			 * client.getNom() + " and u.prenom=" + client.getPrenom() +
			 * " and u.id=c.utilisateurId"));
			 */

			System.out.println("coucou1");

			request = this.getConnection()
					.prepareStatement(
							"select c.id from utilisateur u,compte c where u.nom=? and u.prenom=? and u.id=c.utilisateurId ");
			request.setString(1, client.getNom());
			request.setString(2, client.getPrenom());
			this.setResultat(request.executeQuery());

			request.clearParameters();




			/*
			 * this.setResultat(this.getRequest()
			 * .executeQuery("select c.id from utilisateur u,compte c where u.nom=" +
			 * client.getNom() + " and\r\n" + "			u.prenom=" + client.getPrenom() +
			 * " and u.id=c.utilisateurId"));
			 */

			//this.setResultat(this.getRequest().executeQuery("select o*,u.id,c.id from operation o utilisateur u compte c where utilisateur.nom="+ +" and utilisateur.prenom="" and u.id=c.utilisateurId and c.id=o.compteId));
			//this.setResultat(this.getRequest().executeQuery("select o*,u.id,c.id from operation o utilisateur u compte c where utilisateur.nom="+ +" and utilisateur.prenom="" and u.id=c.utilisateurId and c.id=o.compteId));
			// select c.id from utilisateur u,compte c where u.nom="Fargis" and
			// u.prenom="Denis" and u.id=c.utilisateurId
			System.out.println("coucou2");
			System.out.println("///////////////////\n");
			System.out.println("coucou3");
			int columCount=this.getResultat().getMetaData().getColumnCount();
			labels=new String[columCount];
			System.out.println("value columnCount= " + String.valueOf(columCount));



			// System.out.println(labels[i - 1]);
		} catch (Exception e2) {
			e2.printStackTrace();
		}



		System.out.println("////////////////\n");



		ResultSet resultat = this.getResultat();

		try {
			while (resultat.next()) {


				for (String label : labels) {
					try {
						String reponse = resultat.getString("id");
						if (!resultat.wasNull()) {
							System.out.println(reponse);
						}

					} catch (NullPointerException e) {
						e.printStackTrace();
					}
				}

			}
		} catch (SQLException e) { // TODO Auto-generated catch block //
			e.printStackTrace();
		}

		/*
		 * try { for (int i = 1; i < resultat.getMetaData().getColumnCount(); i++) {
		 * System.out.println(resultat.getMetaData().getColumnLabel(i)); } } catch
		 * (SQLException e) { // TODO Auto-generated catch block // e.printStackTrace();
		 * }
		 *
		 * try { while (resultat.next()) {
		 *
		 * // System.out.println(resultat.getString("id"));
		 *
		 * } } catch (SQLException e) { // TODO Auto-generated catch block //
		 * e.printStackTrace(); }
		 */



		this.close();
		return operations;

	}
}










