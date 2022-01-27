import java.util.Scanner;

public class Esercizio02_1 {
	public static void main (String[] args) {
	
		Scanner in = new Scanner(System.in);
		
		String result = "";
		
		for (int i = 0; i < 5; i++) {
			String tmp = in.next();
			result = tmp + " " + result;
		}
		
		System.out.println(result);
	
	}

}