import java.util.Scanner;
public class Algoritmi {
	static int rs=0, is=0, ss=0, ms=0;
	
	public static void main(String[] args) {
		//Compilare con   java Algoritmi <input.txt 9
		//Cambiare riga 13 con l'algoritmo desiderato
		//Comparable[] o = new Comparable[Integer.parseInt(args[0])];
		int[] vett = new int[18];
		Scanner sc = new Scanner(System.in);
		int i=0;
		while (sc.hasNextLine())  {
			vett[i]=Integer.parseInt(sc.nextLine());
			//o[i]=sc.nextLine();
			i++;
		}
		vett = radixInsertionSort(vett);
		for (int j=0; j<vett.length; j++) {
			System.out.println("#" + vett[j]);
		}
		System.out.println("RS: " + rs + "  IS: "+ is);
		//insertionSort(o);
		//System.out.println(toString(o));
		//System.out.println(binarySearch(o, "AD"));
	}
	public static int[] radixInsertionSort(int v[]) {
		rs=0;
		is=0;
		v = radixSort(v, 3);
		v = insertionSort(v);
		return v;
	}
	public static int[] radixSort(int[] v, int digit) {
		if (digit<0) return v;
		for (int i=0; i<v.length-1; i++) {
			rs++;
			if ((v[i]/((int) Math.pow(10, digit))%10)>(v[i+1]/((int) Math.pow(10, digit))%10)) {
				int tmp = v[i];
				v[i]=v[i+1];
				v[i+1]=tmp;
				rs+=3;
			}
		}
		return radixSort(v, --digit);
	}
	private static int[] insertionSort(int[] v) {
		if (v==null) throw new IllegalArgumentException();
		for (int i=1; i<v.length; i++) {
			int tmp = v[i];	is++;
			int j;
			for (j=i; j>0 && tmp<v[j-1]; j--, is++) {
				v[j]=v[j-1];	is++;
			}
			v[j]=tmp;	is++;
		}
		return v;
	}
	private static void selectionSort(Comparable[] v) {
		if (v==null) throw new IllegalArgumentException();
		for(int i=0; i<v.length-1; i++) {
			int pos=i;
			for (int j=pos+1; j<v.length;j++) {
				if (v[j].compareTo(v[pos])<0) {
					pos=j;
				}
			}
			if (pos!=i) {
				Comparable tmp = v[pos];
				v[pos] = v[i];
				v[i] = v[pos];
			}
		}
	}
	private static void mergeSort(Comparable[] v) {
		if (v==null) throw new IllegalArgumentException();
		if (v.length<2) return;
		int mid = (1+v.length)/2;
		Comparable[] left = new Comparable[mid];
		Comparable[] right = new Comparable[v.length-mid];
		System.arraycopy(v,0,left,0,mid);
		System.arraycopy(v,mid,right,0,v.length-mid);
		mergeSort(left);
		mergeSort(right);
		merge(v,left,right);
	}
	private static void merge(Comparable[] a, Comparable[] b, Comparable[] c){
		int i=0, j=0, k=0;
		while (j<b.length && k<c.length) {
			if (b[j].compareTo(c[k])<0) {
				a[i++]=b[j++];
			} else if (b[j].compareTo(c[k])>0) {
				a[i++]=c[k++];
			} else {
				a[i++]=b[j++];
				k++;
			}
		}
		while (j<b.length) {
			a[i++]=b[j++];
		}
		while (k<c.length) {
			a[i++]=c[k++];
		}
	}
	private static void insertionSort(Comparable[] v) {
		if (v==null) throw new IllegalArgumentException();
		for (int i=1; i<v.length; i++) {
			Comparable tmp = v[i];
			int j;
			for (j=i; j>0 && tmp.compareTo(v[j-1])<0; j--) {
				v[j]=v[j-1];
			}
			v[j]=tmp;
		}
	}
	private static int binarySearch(Comparable[] v, Comparable element) {
		if (v==null) throw new IllegalArgumentException();
		return binSearch(v,element,0,v.length-1);
	}
	private static int binSearch(Comparable[] v, Comparable e, int from, int to) {
		if (from>to) return -1;
		int midPos = (from+to)/2;
		if (e.compareTo(v[midPos])==0) {
			return midPos;
		} 
		else if (e.compareTo(v[midPos])<0) {
			return binSearch(v, e, from, midPos-1);
		}
		return binSearch(v,e,midPos+1,to);
	}
	private static String toString(Comparable[] v) {
		if (v==null) throw new IllegalArgumentException();
		String str = "";
		for (int i=0; i<v.length; i++) {
			str += v[i] + "\n";
		}
		return str;
	}
}