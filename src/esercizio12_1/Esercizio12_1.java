import java.util.Scanner;
import java.util.NoSuchElementException;
public class Esercizio12_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayString arr = new ArrayString();
		while (sc.hasNextLine()) {
			int words = 0;
			String txt = sc.nextLine();
			Scanner tk = new Scanner(txt);
			while (tk.hasNext()) {
				tk.next();
				words++;
			}
			arr.add(txt, words);
		}
		System.out.println(arr.toString());

	}
	
}
class ArrayString {
	private class Coppia {
		public int size;
		public int words;
		public String text;
		public Coppia() {
			size=0;
			words=0;
			text=null;
		}
		public Coppia(int s, int w, String t) {
			size=s;
			words=w;
			text=t;
		}
	}
	private Coppia[] v;
	private int vSize;
	public ArrayString() {
		v = new Coppia[1];
		makeEmpty();
	}
	public void makeEmpty() {
		vSize=0;
	}
	public boolean isEmpty() {
		return vSize==0;
	}
	public void find(String str) throws NoSuchElementException {
		for (int i=0; i<vSize; i++) {
			if (str.equals(v[i].text)) {
				return;
			}
		}
		throw new NoSuchElementException();
	} 
	public void add(String str, int words) {
		try { find(str); }
		catch (NoSuchElementException e) {
			if (vSize==v.length) {
			v = resize(v, vSize*2);
			}
			//Ciclo interno insertion sort
			int j=vSize;
			int length = str.length();
			Coppia c1 = new Coppia(length, words, str);
			for (j=vSize; j>0 && compara(c1, v[j-1])<0; j--) {
				v[j]=v[j-1];
			}
			
			v[j]=c1;
			vSize++;
			}
		
	}
	public static int compara(Coppia c1, Coppia c2) {
		if (c1.words>c2.words) {
			return 1;
		}
		else if (c1.words<c2.words) {
			return -1;
		}
		else {
			if (c1.size>c2.size) return 1;
			else if (c1.size<c2.size) return -1;
			else {
				return c1.text.compareTo(c2.text);
			} 
		}
		
		
	}
	public static Coppia[] resize(Coppia[] src, int newLength) {
		Coppia[] dst = new Coppia[newLength];
		for (int i=0; i<src.length && i<dst.length; i++) {
			dst[i]=src[i];
		}
		return dst;
	}
	public String toString() {
		String str = "";
		for (int i=0; i<vSize; i++) {
			str+=v[i].text + '\n';
		}
		return str;
	}
}
