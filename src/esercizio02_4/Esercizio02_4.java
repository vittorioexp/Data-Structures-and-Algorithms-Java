import java.util.Scanner;

public class Esercizio02_4 {
	
	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input: ");
		int n = in.nextInt();
		
		int a = 1;
		int b = 1;
		int c = 1;
		
		for (int i=2; i<n; i++) {
			a = b;
			b = c;
			c = b + a;
		}
		
		System.out.println(c);
		
	}
}