import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
public class Esposito1162350 {
	public static void main(String[] args) {
		if (args.length!=1) System.exit(1);
		String txt = "";
		try {
			FileReader fr = new FileReader(args[0]);
			Scanner file = new Scanner(fr);
			while (file.hasNextLine()) {
				txt += file.nextLine() + "\n";
			}
			file.close();
			fr.close();
		} catch (IOException e){
			System.exit(1);
		}
		Dictionary diz = new MyDictionary();
		Scanner tk = new Scanner(txt);
		while (tk.hasNext()) {
			String str = tk.next();
			if (isWord(str)) {
				diz.insert(str);
			}
		}
		String tmp = diz.toString();
		System.out.println(reverse(tmp));
	}
	private static boolean isWord(String word) {
		for (int i=0; i<word.length(); i++) {
			if (!Character.isLetter(word.charAt(i)))  {
				return false;
			}
		}
		return true;
	}
	private static String reverse(String tmp) {
		String[] vett = tmp.split("\n");
		String res = "";
		for (int i=0; i<vett.length; i++) {
			res = vett[i] + "\n" + res;
		}
		return res;
	}
}
class MyDictionary implements Dictionary {
	private class Pair {
		private String key;
		private int value;
		public Pair() {
			key=null;
			value=0;
		}
		public Pair(String k, int v)  {
			key=k;
			value=v;
		}
		public String getKey() {
			return key;
		}
		public int getValue() {
			return value;
		}
		public void setKey(String k) {
			key=k;
		}
		public void setValue(int v) {
			value=v;
		}
	}
	private Pair[] v;
	private int vSize;
	public MyDictionary() {
		v = new Pair[1];
		makeEmpty();
	}
	public void makeEmpty() {
		vSize=0;
	}
	public boolean isEmpty() {
		return vSize==0;
	}
	public void insert(String word) {
		if (word==null) throw new IllegalArgumentException ();
		if (vSize==v.length) v=resize(v, vSize*2);
		int value = find(word);
		if (value==0) {
			int j;
			for (j=vSize; j>0 && word.compareTo(v[j-1].getKey())<0; j--) {
				v[j]=v[j-1];
			}
			v[j]=new Pair(word, 1);
			vSize++;
		} else {
			int i = findPos(word);
			v[i].setValue(v[i].getValue()+1);
		}
	} 
    public int find(String word) {
		if (word==null) throw new IllegalArgumentException ();
		int num = binSearch(v,word,0,vSize-1);
		if (num==-1) {
			return 0;
		} else {
			return v[num].getValue();
		}
	}
	public String toString() {
		String str = "";
		for (int i=0; i<vSize; i++) {
			str=v[i].getKey() + " " + v[i].getValue() + "\n" + str;
		}
		return str;
	}
	private int findPos(String word) {
		if (word==null) throw new IllegalArgumentException ();
		return binSearch(v,word,0,vSize-1);
	}
	private static Pair[] resize(Pair[] src, int length) {
		Pair[] dst = new Pair[length];
		for (int i=0; i<src.length && i<dst.length; i++) {
			dst[i]=src[i];
		}
		return dst;
	}
	private static int binSearch(Pair[] a, String key, int from, int to) {
		if (from>to) return -1;
		int mid=(from+to)/2;
		if (key.compareTo(a[mid].getKey())==0) {
			return mid;
		} else if (key.compareTo(a[mid].getKey())>0) {
			return binSearch(a,key,mid+1,to);
		} else {
			return binSearch(a,key,from,mid-1);
		}
	}
}
interface Dictionary { 
      void insert(String word); 
      int find(String word); 
}