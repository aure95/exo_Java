package fr.banque;

import java.util.Arrays;

public class Client {

	private String nom;
	private String prenom;
	private int age;
	private int numero;
	private Compte[] compte = new Compte[5];






	public Client() {


	}



	public Client(String nom, String prenom, int age, int numero, Compte[] compte) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.numero = numero;
		this.compte = compte;
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
		return this.compte;
	}

	public Compte getCompte(int numeroCompte) {

		Compte res = null;
		boolean OK=false;

		for (Compte co : this.compte) {
			if (co.getNumero() != 0) {
				if (co.getNumero() == numeroCompte) {
					res = co;
					OK=true;

				}
			}
		}
		if (!OK)
		{
			System.out.println(
					"le compte avec numero de compte " + numeroCompte + " ne peut etre trouvé ou n'éxiste pas ");
		}

		return res;
	}

	public void ajouterCompte(Compte Acompte) {

		boolean vide=true;


		for(int i =0;i<this.compte.length;i++)
		{
			if(this.compte[i]==null)
			{
				this.compte[i]=Acompte;
				vide=false;
				break;
			}

		}
		if (vide) {
			System.out.println("Le compte ne peut etre ajouté pas de place");
		}

	}

	public void verserInterets() {

		int cpt = 0;

		for (Compte co : this.compte)
		{
			if(co == null)
			{
				break;
			}
			System.out.println(co.getClass().toString());
			if (co.getClass().toString().equals("class fr.banque.CompteRemunere")) {
				// System.out.println("class cLient ");
				((CompteRemunere) this.compte[cpt]).verserInterets();
			}
			if(co instanceof ICompteRemunere) {
				// System.out.println("co instanceof ICompteRemunere debut");
				((ICompteRemunere) this.compte[cpt]).verserInterets();
				// System.out.println("co instanceof ICompteRemunere fin");
			}
			cpt++;

		}
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", numero=" + numero + ", compte="
				+ Arrays.toString(compte) + "]";
	}
}
