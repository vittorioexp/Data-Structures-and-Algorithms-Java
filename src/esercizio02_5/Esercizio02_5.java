import java.util.Scanner;

public class Esercizio02_5 {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		
		if (num%2!=0) {
			
			int numAsterischi = num;
			
			for (int i=0; i<=(num-1)/2; i++) {
				printChar(' ', i);
				printChar('*', numAsterischi);
				printChar(' ', i);
				System.out.println ();
				numAsterischi -= 2;
			}
		}
		else {
			System.out.println("Inserire un numero DISPARI");
		}
	}
	
	public static void printChar(char c, int n) {
		for (int i=0; i<n; i++) {
			System.out.print(c);
		}
	}

}