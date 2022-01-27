public class Esercizio04_1_4 {
	public static void main (String []args) {
		System.out.print("The 7bit ASCII Table\n"); //tabella ASCII standard
		char c = 0x0000;
		while (c <= 255) {
			System.out.println(c);
			c++;
		}
	}
}