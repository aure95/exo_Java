

import fr.TestDB02;
import fr.banque.Client;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Client client = new Client();
		TestDB02 testDB02 = new TestDB02();

		System.out.println("debut ok");

		testDB02.recupererAllClients();

	}

}
