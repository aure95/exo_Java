package fr.exemple;

public class Personne {
	
	// Attributs
	// visibilité / typage / nom
	
	private String nom;
	private String prenom;
	private int age;
	private double taille;
		
	// Méthodes
	// visibilité / code retour / nom / parametres
	
	
	public Personne(){	
	}
	
	
	public Personne(String pNom,String pPrenom,int age,double taille){
		
		this.nom=pNom;
		this.prenom=pPrenom;
		this.age=age;
		this.taille=taille;
		
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

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}
	
	public void parler(String message) {
		
		System.out.println(message);
	}
	
	public int marcher() {

		return 1;
		
	}

	
	
	
	
	

}
