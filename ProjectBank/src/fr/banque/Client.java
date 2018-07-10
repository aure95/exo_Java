package fr.banque;

import java.util.Arrays;

public class Client {
	
	private String nom;
	private String prenom;
	private int age;
	private int numero;
	private Compte[] compte=new Compte[5];
	
	
	
	
	
	
	public Client() {
		this("","",0,null,)
	}

	public Client(String nom, String prenom, int age, int numero, Compte[] compte) {

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

	public Compte[] getCompte() {
		return compte;
	}

	public void setCompte(Compte[] compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", numero=" + numero + ", compte="
				+ Arrays.toString(compte) + "]";
	}
}
