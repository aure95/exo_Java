import fr.dessin.Point2D;
import fr.dessin.Point3D;

public class Run {

	public static void main(String[] args) {
		
		Point2D p1=new Point2D();
		Point2D p2=new Point2D(1,2);
		
		p1.afficher();
		p2.afficher();
		
		p1.setX(1);
		p1.setY(2);
		
		p2.setX(4);
		p2.setY(5);
		
		p1.afficher();
		p2.afficher();
		
		p1.translater(2,2);
		p2.translater(0,1);
		
		p1.afficher();
		p2.afficher();
		
		System.out.println("compteur "+Point2D.getCompteur());
		
		Point2D p3 = new Point2D();
		
		System.out.println("compteur "+Point2D.getCompteur());
		
		Point3D p4= new Point3D(1,2,3);
		Point3D p5= new Point3D();
		
		p4.afficher();
		p5.afficher();
		
		System.out.println("compteur "+Point3D.getCompteur());
		
		p4.setZ(10);
		p4.setX(5);
		
		p4.afficher();
		p5.afficher();
		
		//System.out.println(Point2D.getCompteur());
		
		p4.translater(2, 2, 2);
		p5.translater(5, 5, 5);
		
		p4.afficher();
		p5.afficher();
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
