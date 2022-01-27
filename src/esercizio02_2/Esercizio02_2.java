import java.util.Scanner;

public class Esercizio02_2 {
	public static void main (String[] args) {
	
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input: ");
		int number = in.nextInt();
		
		System.out.println("\nSoluzione aritmetica");
		
		int divisore = 10000;
		while (divisore >= 1) {
			System.out.print(" " + (int) (number/divisore) % 10 );
			divisore = divisore / 10;
		}
		
		System.out.println("\nSoluzione della classe String");
		
		String str = "" + number;
		
		while (str.length()<5) {
			str = "0" + str;
		}
		
		for (int i=0; i<5; i++) {
			System.out.print(" " + str.substring(i,i+1));
		}

	}

}