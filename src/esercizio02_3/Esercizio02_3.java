import java.util.Scanner;

public class Esercizio02_3 {
	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input: ");
		String str = in.nextLine();
		int length = str.length();
		
		String outString = str;
		
		
		for (int i=0; i<length; i++) {
			int posizione = (int) (Math.random() * length);
			outString = outString.charAt(posizione) + outString.substring(0,posizione) + outString.substring(posizione+1, length);
		}
		
		
		System.out.println(outString);
		
	}
	
}