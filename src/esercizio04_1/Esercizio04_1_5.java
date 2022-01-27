public class Esercizio04_1_5 {
	public static void main (String []args) {
		System.out.println("x	y	result");
		for (short x = 1; x <= 4 ; x++) {
			for (short y = 1; y <= 5; y++) {
				short result = (short) Math.pow(x, y);
				System.out.println(x + "	" + y + "	" + result);
			}
		}
	}
}