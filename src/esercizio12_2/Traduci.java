import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.*;
public class Traduci {
	public static void main(String[] args) {
		if (args.length!=2) {
			System.out.println("Argomenti invalidi");
			System.exit(1);
		}
		Dictionary diz = new Dictionary();
		FileReader fr = null;
		Scanner sc = null;
		try {
			fr = new FileReader(args[1]);
			sc = new Scanner(fr);
			while (sc.hasNextLine()) {
				String ita, eng;
				ita = sc.next();
				eng = sc.next();
				diz.insert(ita, eng);
			}
			sc.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("File invalidi");
			System.exit(1);
		}
		
		if (args[0].equals("-e")) {
			diz = diz.invert();
		}
		Scanner kb = new Scanner(System.in);
		Scanner tk;
		while (kb.hasNextLine()) {
			String line = kb.nextLine();
			tk = new Scanner(line);
			while (tk.hasNext()) {
				String word = tk.next();
				try {
					System.out.print(diz.find(word)+" ");
				} catch (NoSuchElementException e) {
					System.out.print("*"+word+"* ");
				}
			}
			System.out.println();
		}
	}
}
class Dictionary {
	private class Pair {
		private String parola;
		private String traduzione;
		public Pair() {
			parola = traduzione = null;
		}
		public Pair(String parola, String traduzione) {
			this.parola=parola;
			this.traduzione=traduzione;
		}
		public void setParola(String parola) {
			this.parola=parola;
		}
		public void setTraduzione(String traduzione) {
			this.traduzione=traduzione;
		}
		public String getParola() {
			return parola;
		}
		public String getTraduzione() {
			return traduzione;
		}
	}
	private Pair[] v;
	private int vSize;
	public Dictionary() {
		v = new Pair[1];
		makeEmpty();
	}
	public void makeEmpty() {
		vSize=0;
	}
	public boolean isEmpty() {
		return vSize==0;
	}
	public void insert(String parola, String traduzione) {
		try { remove(parola); }
		catch (NoSuchElementException e){}
		if (vSize==v.length) {
			v = resize(v, vSize*2);
		}
		int j;
		for (j=vSize; j>0 && parola.compareTo(v[j-1].getParola())<0; j--) {
			v[j]=v[j-1];
		}
		v[j]=new Pair(parola, traduzione);
		vSize++;
	}
	public String find(String parola) {
		return binarySearch(v, 0, vSize, parola);
	}
	public void remove(String parola) {
		int i=0;
		for (i=0; i<vSize; i++) {
			if (v[i].getParola().equals(parola)) {
				break;
			}
		}
		if (i==vSize) {
			throw new NoSuchElementException();
		}
		for (int j=i+1; j<vSize; j++) {
			v[j-1]=v[j];
		}
		vSize--;
	}
	public Dictionary invert() {
		Dictionary newDiz = new Dictionary();
		for (int i=0; i<vSize; i++) {
			newDiz.insert(v[i].getTraduzione(), v[i].getParola());
		}
		return newDiz;
	}
	private static Pair[] resize(Pair[] src, int length) {
		Pair[] dst = new Pair[length];
		for (int i=0; i<src.length && i<dst.length; i++) {
			dst[i]=src[i];
		}
		return dst;
	}
	private static String binarySearch(Pair[] a, int from, int to, String key) {
		if (a==null) {
			throw new IllegalArgumentException();
		}
		if (from>to) {
			throw new NoSuchElementException();
		}
		int mid = (from+to)/2;
		if (key.compareTo(a[mid].getParola())==0) {
			return a[mid].getTraduzione();
		} 
		if (key.compareTo(a[mid].getParola())<0) {
			return binarySearch(a, from, mid-1, key);
		}
		return binarySearch(a, mid+1, to, key);
	}
}