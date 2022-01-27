import java.util.Scanner;
public class Esercizio04_3 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserire un numero: ");
		int number;
		number = sc.nextInt();
		while (number<=0) {
			System.out.print("Inserire un numero: ");
			number = sc.nextInt();
		}
		for (int i=1; i<=number; i++) {
			if (isPrimeNumber(i)) {
				System.out.println(i);
			}
		}
	}
	private static boolean isPrimeNumber(int num) {
		boolean prime = true;
		int i = 2;
		if (num == 1) {
			prime = true;
		} else {
			while (i<=num/2 && prime) {
				if (num%i==0) {
					//Divisibile per i
					prime = false;
				}
				i++;
			}
		}
		return prime;
	}
}