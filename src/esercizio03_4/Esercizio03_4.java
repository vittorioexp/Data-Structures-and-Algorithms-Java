import java.util.Scanner;
public class Esercizio03_4 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserire la prima stringa: ");
		String s1 = sc.nextLine();
		System.out.print("Inserire la seconda stringa: ");
		String s2 = sc.nextLine();
		int x = 0;
		int y = s2.length();
		boolean found = false;
		while (!found && y<s1.length()) {
			if (comparaStringhe(s1,s2,x,y)) {
				found = true;
			}
			x++;
			y++;
		}
		System.out.println(found);
		
		/*
		x = 0;
		y = s2.length();
		found = false;
		while (!found && y<s1.length()) {
			if (s1.substring(x,y).equals(s2)) {
				found = true;
			}
			x++;
			y++;
		}
		System.out.println(found);
		*/
		
	}
	
	public static boolean comparaStringhe(String contenente, String contenuto, int pos_iniziale, int pos_finale) {
		boolean uguali = true;
		int i=0;
		while (uguali && i<contenuto.length()) {
			if (contenente.charAt(pos_iniziale+i) != contenuto.charAt(i) )  {
				uguali = false;
			}
			i++;
		}
		return uguali;
	}
}