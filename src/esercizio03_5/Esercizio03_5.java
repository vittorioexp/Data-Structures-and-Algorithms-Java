import java.util.Scanner;
public class Esercizio03_5 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserire l'anno: ");
		int anno = sc.nextInt();
		while (anno<2017) {
			System.out.print(anno + "  ");
		//Utilizzo degli operatori booleani
		if (anno>=1582 && ((anno%100==0 && anno%400==0) || (anno%100!=0 && anno%4==0))) {
			System.out.println("Anno bisestile");
		} else {
			System.out.println("Anno NON bisestile");
		}
		anno++;
		}
	}
}