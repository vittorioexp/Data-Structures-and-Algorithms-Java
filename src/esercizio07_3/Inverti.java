public class Inverti {
	public static void main(String[] args) {
		if (args.length>=1) {
			System.out.println(inverti(args[0]));
		}
	}
	
	public static String inverti(String str) {
		char c[] = toCharArray(str);
		if (c.length<2) {
			return toString(c);
		}
		char v[] = resize(c, 1, c.length-1);
		return c[c.length-1] + inverti(toString(v)) + c[0];
		
	}
	public static String toString(char c[]) {
		String str = "";
		for (int i=0; i<c.length; i++) {
			str += c[i];
		}
		return str;
	}
	public static char[] toCharArray(String str) {
		char c[] = new char[str.length()];
		for (int i=0; i<c.length; i++) {
			c[i] = str.charAt(i);
		}
		return c;
	}
	public static char[] resize(char a[], int init, int fin) {
		char v[] = new char[fin-init];
		for (int i=init; i<fin; i++) {
			v[i-init] = a[i]; 
		}
		return v;
	}
}