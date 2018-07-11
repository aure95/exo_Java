package my.artifact.id;

public class Maclass {

	Maclass() {

	}

	public static int faire(int... p1) {
		int res = 0;

		for (int a : p1) {
			res += a;
		}
		return res;

	}

	public static void main(String[] args) {

		System.out.println("hola mundo");

		TypeDeCarte tdc = TypeDeCarte.C;
		tdc = TypeDeCarte.C;

		System.out.println(tdc.toString());

		System.out.println(Maclass.faire(1, 2, 3, 4, 5, 6, 7, 8, 9));
		System.out.println(Maclass.faire(1, 2));


	}



}
