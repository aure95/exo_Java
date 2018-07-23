package fr.banque;

public class Operation {

	private String libelle;
	private Double montant;
	private String date;

	//////////////////////////////////////

	public Operation() {

	}

	public Operation(String libelle, Double montant, String date) {

		this.setLibelle(libelle);
		this.setMontant(montant);
		this.setDate(date);
	}

	////////////////////////////////////////

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/////////////////////////////////////

}
