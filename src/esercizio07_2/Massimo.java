import java.util.Scanner;
public class Massimo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v[] = new int[2];
		int index = 0;
		String cmd;
		System.out.println("Immettere n numeri, battere q per terminare l'input");
		while (!(cmd = sc.nextLine()).equals("q")) {
			if (index>=v.length) {
				v = resize(v, index*2);
			}
			v[index] = Integer.parseInt(cmd);
			index++;
		}
		System.out.println("Massimo: " + massimo(v));
	}
	public static int massimo(int[] v) {
		int lastElement = v[v.length-1];
		if (v.length==1) return lastElement;
		v = resize(v, v.length-1);
		return max(massimo(v), lastElement);
	}
	public static int max(int a, int b) {
		if (a>=b) return a;
		else return b;
	}
	public static int min(int a, int b) {
		if (a>=b) return b;
		else return a;
	}
	public static int[] resize(int a[], int length) {
		int v[] = new int[length];
		for (int i=0; i<min(length, a.length); i++) {
			v[i]=a[i];
		}
		return v;
	}
}