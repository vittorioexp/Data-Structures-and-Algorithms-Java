import java.util.Scanner;
public class Esercizio06_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("m: ");
		int m = sc.nextInt();
		System.out.print("n: ");
		int n = sc.nextInt();
		if (m<n || m<0 || n<0) throw new IllegalArgumentException();
		int resto;
		int res = 0;
		do {
			resto = m%n;
			System.out.println(resto);
			if (resto==0) {
				res = n;
			}
			m = n;
			n = resto;
		} while (resto!=0);
		System.out.println("MCD: "+res);
	}
}