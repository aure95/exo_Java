package fr.exemple;

public class Run {

	public static void main(String[] args) {
		// fabriquer une instance de personne
		// c est aussi une variable locale de ma méthode main
		
		Personne p1=new Personne("fhsufh","vfbjugh",15,64.8);
		Personne p2=new Personne();
		
	/*	
		p1.setAge(25);
		p1.setNom("ghiojg");
		p1.setPrenom("flgpk");
		p1.setTaille(2.3D);
		
		*/
		
		p2.setAge(41);
		p2.setNom("hkjoh");
		p2.setPrenom("ghdfuhgu");
		p2.setTaille(0.9);
		
	 
		
		System.out.println(p1.getAge());
		System.out.println(p2.getAge());
		
		
		
		
		
		
		
		
		

	}

}
