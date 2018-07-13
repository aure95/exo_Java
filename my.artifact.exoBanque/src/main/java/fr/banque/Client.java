package fr.banque;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;


public class Client {


	private String nom;
	private String prenom;
	private int age;
	private int numero;
	// private List<Compte> compte = new ArrayList<>(5);
	private Map<Integer, Compte> compte = new Hashtable<>();

	public Client() {


	}

	// TODO finir exo10 partie 2 Map

	public Client(String nom, String prenom, int age, int numero, Compte[] compte) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.numero = numero;
		// this.remplirList(compte);
		this.remplirMap(compte);

	}

	/*
	 * private void remplirList(Compte[] compte) {
	 *
	 * for (Compte a : compte) { this.compte.add(a); }
	 *
	 * }
	 */

	private void remplirMap(Compte[] compte) {

		for (Compte a : compte) {

			this.compte.put(a.getNumero(), a);
		}

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Compte[] getCompte()
	{

		Compte[] res = new Compte[this.compte.size()];
		//this.compte.toArray(res);
		if (!compte.isEmpty()) {
			this.compte.values().toArray(res);
		}

		return res;
	}

	public Compte getCompte(int numeroCompte) {


		//solution pour List
		/*
		 * Compte res = null; boolean OK=false; Compte[] compteCopie = new
		 * Compte[this.compte.size()]; this.compte.toArray(compteCopie);
		 *
		 *
		 * for (Compte co : compteCopie) { System.out.println(co.toString());
		 *
		 * if (co.getNumero() != 0) { if (co.getNumero() == numeroCompte) { res = co; OK
		 * = true;
		 *
		 * } }
		 *
		 * }
		 *
		 * if (!OK) { System.out.println( "le compte avec numero de compte " +
		 * numeroCompte + " ne peut etre trouvé ou n'éxiste pas "); }
		 *
		 * return res; // return new Compte();
		 */

		Compte res = null;

		if (!compte.isEmpty()) {
			compte.get(numeroCompte);
		}

		return res;
	}


	public void ajouterCompte(Compte Acompte) throws BanqueException {

		if (this.compte.size() < 5) {
			// this.compte.add(Acompte);
			this.compte.put(Acompte.getNumero(), Acompte);
		}
		else
		{
			throw new BanqueException("Le compte ne peut etre ajouté pas de place");
		}

		/*
		 * boolean vide=true;
		 *
		 *
		 * for (int i = 0; i < this.compte.size(); i++) { if (this.compte.get(i) ==
		 * null) { this.compte.add(Acompte); vide=false; break; }
		 *
		 * } if (vide) { throw new
		 * BanqueException("Le compte ne peut etre ajouté pas de place"); }
		 */


	}

	public void verserInterets() {

		int cpt = 0;
		Compte[] compte_copie = new Compte[this.compte.size()];

		this.compte.values().toArray(compte_copie);

		for (Compte co : compte_copie)
		{
			if(co == null)
			{
				break;
			}
			// System.out.println(co.getClass().toString());
			if (co.getClass().toString().equals("class fr.banque.CompteRemunere")) {
				// System.out.println("class cLient ");
				((CompteRemunere) co).verserInterets();
				this.compte.replace(cpt, co);



			}
			if(co instanceof ICompteRemunere) {
				// System.out.println("co instanceof ICompteRemunere debut");
				// System.out.println("replace1 =" + this.compte.values().toString());
				((ICompteRemunere) co).verserInterets();

				this.compte.replace(cpt, co);
				// System.out.println("replace2 =" + this.compte.values().toString());
				// System.out.println("co instanceof ICompteRemunere fin");
			}
			cpt++;

		}
	}

	@Override
	public String toString() {
		/*	return "Client [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", numero=" + numero + ", compte="
				+ Arrays.toString(this.compte.toArray()) + "]";
		 */
		return "Client [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", numero=" + numero + ", compte="
		+ Arrays.toString(this.compte.values().toArray()) + "]";
	}
}
