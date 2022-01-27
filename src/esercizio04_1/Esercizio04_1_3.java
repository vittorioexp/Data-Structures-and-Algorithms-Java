import java.util.Scanner;
public class Esercizio04_1_3 {
	public static void main (String []args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (num>=10) {
			System.out.println("Output: ");
			for (int i=10; i<=num; i++) {
				System.out.println(i);
			}
		}
	}
}