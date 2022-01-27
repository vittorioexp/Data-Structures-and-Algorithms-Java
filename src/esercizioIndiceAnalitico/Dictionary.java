public class Dictionary {
	private class Pair {
		private Comparable key;
		private LinkedList value;
		public Pair() {
			key=null;
			value=new LinkedList();
		}
		public Pair(Comparable k, LinkedList list) {
			key=k;
			value=list;
		}
		public Comparable getKey() {
			return key;
		}
		public LinkedList getValue() {
			return value;
		}
		public void setKey(Comparable k) {
			key=k;
		}
		public void setValue(LinkedList list) {
			value=list;
		}
	}
	private Pair[] v;
	private int vSize;
	public Dictionary() {
		v = new Pair[1];
		makeEmpty();
	}
	public Dictionary(int size) {
		v = new Pair[size];
		makeEmpty();
	}
	public void makeEmpty() {
		vSize=0;
	}
	public boolean isEmpty() {
		return vSize==0;
	}
	//find
	//Ritorna la posizione della chiave
	public int find(Comparable key) {
		for (int i=0; i<vSize; i++) {
			if (v[i].getKey().equals(key)) {
				return i;
			}
		}
		return -1;
	}
	//remove
	public boolean remove(Comparable key) {
		for (int i=0; i<vSize; i++) {
			if (v[i].getKey().equals(key)) {
				for (int j=i+1; j<vSize; j++) {
					v[j-1]=v[j];
				}
				vSize--;
				v[vSize]=new Pair();
				return true;
			}
		}
		return false;
	}
	//insert
	public void insert(Comparable key, int value) {
		int index = find(key);
		if (vSize==v.length) {
			v=resize(v, vSize*2);
		}
		if (index==(-1)) {
			//Chiave non presente
			//Inserire chiave ordinatamente
			int j;
			for (j=vSize; j>0 && key.compareTo(v[j-1].getKey())<0; j--) {
				v[j]=v[j-1];
			}
			LinkedList list = new LinkedList();
			list.addLast(value);
			//System.out.println(key + "  " + list.getLast());
			v[j]=new Pair(key, list);
			vSize++;
		} else {
			//Chiave presente
			v[index].getValue().addLast(value);
			
		}
		
	}
	
	public String toString() {
		String str="";
		for (int i=0; i<vSize; i++) {
			str += v[i].getKey() + "[" + v[i].getValue().toStringLinkedList() + "]" + "\n";
		}
		return str;
	}
	
	public static Pair[] resize(Pair[] src, int newLength) {
		Pair[] dst = new Pair[newLength];
		for (int i=0; i<src.length && i<dst.length; i++) {
			dst[i]=src[i];
		}
		return dst;
	}
}