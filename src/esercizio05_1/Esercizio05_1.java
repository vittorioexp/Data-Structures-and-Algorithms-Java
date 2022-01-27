import java.util.Scanner;

public class Esercizio05_1 {
	public static void main(String[] args) {
		//Fase di input
		Scanner sc = new Scanner(System.in);
		String one = null;
		String two = null;
		if (args.length > 2) {
			System.out.println("Sono stati inseriti piu' di due parametri da terminale!");
			System.exit(1);
		} else if (args.length == 1) {
			one = args[0];
			System.out.println("Inserire la stringa mancante da tastiera: ");
			two = sc.nextLine();
		} else if (args.length == 0) {
			System.out.println("Inserire la prima stringa da tastiera: ");
			one = sc.nextLine();
			System.out.println("Inserire la seconda stringa da tastiera: ");
			two = sc.nextLine();
		} else {
			one = args[0];
			two = args[1];
		}
		char a[] = toArray(one);
		char b[] = toArray(two);
		if (reverseEquals(a,b)) {
			System.out.println("Le stringhe " + one + " e " + two + " sono una l'inversa dell'altra");
		} else {
			System.out.println("Le stringhe " + one + " e " + two + " non sono una l'inversa dell'altra");
		}
	}
	public static char[] toArray(String s) {
		if (s == null) {
			return null;
		}
		char[] v = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			v[i] = s.charAt(i);
		}
		return v;
	}
	public static boolean reverseEquals(char[] a, char[] b) {
		if (a == null || b == null) {
			return false;
		}
		if (a.length == 0 && b.length == 0) {
			return true;
		}
		if (a.length == b.length) {
			int i = 0;
			int j = a.length - 1;
			while (i < a.length) {
				if (a[i] != b[j]) {
					return false;
				}
				i++;
				j--;
			}
			return true;
		}
		return false;
	}
}