package fr.dessin;

public class Point2D {
	
	private int x;
	private int y;
	private static int compteur;
	
	/////////////////////////////////////////
	
	public Point2D() {
		
		this(0,0);
		
		//this.x = 0;
		//this.y = 0;
		Point2D.compteur++;
	}
	
	public Point2D(int vX, int vY) {
		
		this.x = vX;
		this.y = vY;
		Point2D.compteur++;
	}
	
	/////////////////////////////////////////
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	/////////////////////////////////
	
	
	public static int getCompteur() {
		return Point2D.compteur;
	}
	
	public void afficher() {
		
		System.out.println(this.x+" "+this.y);
	}
	
	public void translater(int dX,int dY) {
		
		this.x+=dX;
		this.y+=dY;
		
	}
	
	

}
