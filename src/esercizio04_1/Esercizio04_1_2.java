public class Esercizio04_1_2 {
	public static void main (String []args) {
		int sum = 0;
		long product = 1;
		int i = 1;
		while (i<=20) {
			if (i%2==0) {
				sum += i;
				product *= i;
			}
			i++;
		}
		System.out.println("Sum: " + sum);
		System.out.println("Product: " + product);
	}
}