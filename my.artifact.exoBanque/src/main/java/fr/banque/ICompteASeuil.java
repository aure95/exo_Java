package fr.banque;

public interface ICompteASeuil {

	public double seuil = 0.0D;

	public void retirer(double uneValeur);
	public double getSeuil();
	public void setSeuil(double unSeuil);

}
