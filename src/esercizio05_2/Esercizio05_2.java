public class Esercizio05_2 {
	public static void main (String[] args) {
		if (args.length == 0) {
			throw new IllegalArgumentException();
		}
		int num = Integer.parseInt(args[0]);
		if (num < 0) {
			throw new IllegalArgumentException();
		}
		for (int i=num; i>=1; i--) {
			System.out.println(i);
		}
		
	}
}