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
		String []labels=null;
		try {
			this.setRequest(this.getConnection().createStatement());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		System.out.println(client.getNom() + " " + client.getPrenom());

		try {

			/*
			 * this.setResultat(this.getRequest().
			 * executeQuery("select c.id from utilisateur u,compte c where u.nom=" +
			 * client.getNom() + " and u.prenom=" + client.getPrenom() +
			 * " and u.id=c.utilisateurId"));
			 */

			this.setResultat(this.getRequest().executeQuery("select * from utilisateur"));

			//this.setResultat(this.getRequest().executeQuery("select o*,u.id,c.id from operation o utilisateur u compte c where utilisateur.nom="+ +" and utilisateur.prenom="" and u.id=c.utilisateurId and c.id=o.compteId));
			//this.setResultat(this.getRequest().executeQuery("select o*,u.id,c.id from operation o utilisateur u compte c where utilisateur.nom="+ +" and utilisateur.prenom="" and u.id=c.utilisateurId and c.id=o.compteId));
			// select c.id from utilisateur u,compte c where u.nom="Fargis" and
			// u.prenom="Denis" and u.id=c.utilisateurId
			System.out.println("///////////////////\n");
			int columCount=this.getResultat().getMetaData().getColumnCount();
			labels=new String[columCount];
			System.out.println("value columnCount= " + String.valueOf(columCount));

			for(int i=1;i<columCount;i++) {
				labels[i - 1] = this.getResultat().getMetaData().getColumnLabel(i);
				System.out.println(labels[i - 1]);

			}
			System.out.println("////////////////\n");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		ResultSet resultat = this.getResultat();

		try {
			while (resultat.next()) {


				for (String label : labels) {
					try {
						String reponse = resultat.getString(label);
						if (reponse != null) {
							System.out.println(reponse);
						}
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
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
