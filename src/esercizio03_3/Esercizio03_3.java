import java.util.Scanner;
public class Esercizio03_3 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserire il primo orario: ");
		int timeOne = sc.nextInt();
		System.out.print("Inserire il secondo orario: ");
		int timeTwo = sc.nextInt();
		int minuti = (timeOne % 100) - (timeTwo % 100);
		int ore = (timeOne/100) - (timeTwo/100);
		if (minuti<0) minuti = minuti *(-1);
		if (ore<0) ore = ore *(-1);
		System.out.println("Tempo trascorso: " + ore + " ore e " + minuti + " minuti");
	}
}