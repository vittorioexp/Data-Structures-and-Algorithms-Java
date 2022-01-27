public class Esercizio04_1_1 {
	public static void main (String []args) {
		int sum = 0;
		int product = 1;
		for (int i=1; i<=10; i++) {
			sum += i;
			product *= i;
		}
		System.out.println("Sum: " + sum);
		System.out.println("Product: " + product);
	}
}