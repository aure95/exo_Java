import fr.banque.Client;
import fr.banque.Compte;

public class Run {

	public static void main(String[] args) {

		Client c1 = new Client();
		Compte compte1 = new Compte(123, 92.3D);

		////////////////////////////////////////

		System.out.println(compte1.toString());
		compte1.setSolde(36.45D);
		System.out.println(compte1.toString());
		compte1.ajouter(65D);
		System.out.println(compte1.toString());
		compte1.retirer(45.3D);
		System.out.println(compte1.toString());


		System.out.println("\n" + "//////////////////////////" + "\n");

		//////////////////////////////////////////

		System.out.println(c1.toString());
		c1.setAge(10);
		System.out.println(c1.toString());
		c1.setNom("yolo");
		System.out.println(c1.toString());
		c1.setNumero(123);
		System.out.println(c1.toString());
		c1.setPrenom("toto");
		System.out.println(c1.toString());
		c1.ajouterCompte(new Compte());
		System.out.println(c1.toString());





	}

}
