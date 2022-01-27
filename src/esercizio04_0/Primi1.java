import java.util.Scanner;
public class Primi1 { 
	public static void main(String[] args) { 
		int i=2;
		boolean trovato = false;
		Scanner console = new Scanner(System.in);
		int num = console.nextInt();
		while(i<=num/2 && !trovato) {
			if(num%i == 0) {
				trovato = true;
			}
			i++;
		}
		if(!trovato)
		System.out.println(“Il numero “+num+” e’ primo”);
		else
		System.out.println(“Il numero “+num+” non e’primo”);
	}
}