import java.util.Scanner;
public class Fibonacci {
	public static void main (String[] args) throws IllegalArgumentException {
		Scanner sc = new Scanner(System.in);
		Cronometro c1 = new Cronometro();
		Cronometro c2 = new Cronometro();
		System.out.print("Inserire il numero desiderato: ");
		int n = sc.nextInt();
		c1.start();
		System.out.println(recursiveFib(n));
		c1.stop();
		System.out.println("Elapsed: " + (double) c1.tempotrascorso()/1000 + " seconds\n");
		
		c2.start();
		System.out.println(iterativeFib(n));
		c2.stop();
		System.out.println("Elapsed: " + (double) c2.tempotrascorso()/1000 + " seconds\n");
	}
	public static long recursiveFib(int n) {
		if (n<0) throw new IllegalArgumentException();
		if (n==0) return 0;
		if (n==1) return 1;
		return recursiveFib(n-2)+recursiveFib(n-1);
	}
	public static long iterativeFib(int n) {
		if (n<0) throw new IllegalArgumentException();
		long a=0;
		long b=1;
		long res=0;
		for (int i=1; i<n; i++) {
			res=a+b;
			a=b;
			b=res;
		}
		return res;
	}
}