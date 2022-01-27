public class Esposito1162350 { 
                                
 public static void main(String[] args) {
  MultiSet s = new MyMultiSet();
  String s1 = "ok";    String s2 = "no";
  s.add("ok");   s.add("ok");   s.add("ok");
  s.add("no");    s.add("no");
  s.remove("ok");   s.remove("no");
  System.out.print(s.molt(s1) + s.molt(s2));  // deve visualizzare 3
 }
}
interface Container { // comportamento definito a lezione
  void makeEmpty();  boolean isEmpty();
}
interface MultiSet extends Container {
//aggiunge x in una posizione qualunque di this; richiede x!= null;
  void add(Object x);
//viene eliminata una qualunque (e una sola) occorrenza di x; richiede x!= null;
  void remove(Object x) throws IllegalStateException;
//restituisce la molteplicità di x, cioe' il numero di elementi E di this per i //quali x.equals(E) vale true; richiede x!= null;
  int molt(Object x);
}

interface Set extends Container{ // comportamento definito a lezione
  void add(Object x);   boolean contains(Object x);   Object[] toArray();
}

class MySet implements Set {
	public MySet(){
		v = new Object[1];
		makeEmpty();
	}
	public void add(Object x) {
		if (contains(x)) return;
		if (vSize==v.length) {
			v=resize(v, vSize*2);
		}
		v[vSize++]=x;
	}
	public void remove(Object x) {
		for (int i=0; i<vSize; i++) {
			if (x.equals(v[i])) {
				for (int j=i; j<vSize-1; j++) {
					v[j]=v[j+1];
				}
				vSize--;
			}
		}
	}
	public boolean contains(Object x) {
		for (int i=0; i<vSize; i++) {
			if (x.equals(v[i])) {
				return true;
			}
		}
		return false;
	}
	public Object[] toArray() {
		Object[] obj = new Object[vSize];
		System.arraycopy(v,0,obj,0,vSize);
		return obj;
	}
	public void makeEmpty() {
		vSize=0;
	}
	public boolean isEmpty() {
		return vSize==0;
	}
	private static Object[] resize(Object[] src, int length) {
		Object[] dst = new Object[length];
		for (int i=0; i<src.length && i<dst.length; i++) {
			dst[i]=src[i];
		}
		return dst;
	}
	private Object[] v;
	private int vSize;
}
class MyMultiSet implements MultiSet { 

	public MyMultiSet() {
		s = new MySet();
	}
	//aggiunge x in una posizione qualunque di this; richiede x!= null;
	public void add(Object x) {
		if (x==null) return;
		int m = molt(x);
		s.remove((Object) new Coppia(x,m));
		s.add((Object) new Coppia(x,m+1));
	}
	//viene eliminata una qualunque (e una sola) occorrenza di x; richiede x!= null;
	public void remove(Object x) throws IllegalStateException {
		if (x==null) return;
		if (s.isEmpty()) {
			throw new IllegalStateException();
		}
		int m = molt(x);
		s.remove((Object) new Coppia(x,m));
		s.add((Object) new Coppia(x,m-1));
	}
	//restituisce la molteplicità di x, cioe' il numero di elementi E di this per i //quali x.equals(E) vale true; richiede x!= null;
	public int molt(Object x) {
		if (x==null) return 0;
		if (isEmpty()) return 0;
		int count=0;
		Object[] v = s.toArray();
		for (int i=0; i<v.length; i++) {
			if ((((Coppia)v[i]).obj).equals(x)) {
				count=((Coppia)v[i]).i;
			}
		}
		return count;
	}
	public void makeEmpty() {
		s.makeEmpty();
	}
	public boolean isEmpty() {
		return s.isEmpty();
	}
	public boolean equals(Coppia c1, Coppia c2) {
		return c1.equals(c2);
	}
	
  // questa classe non può avere variabili statiche;
  private class Coppia { //classe interna a MyMultiSet
    //rappresenta una coppia (Object,int)
    Object obj;     int i;   Coppia(Object o, int m) {obj=o; i= m;}
    public boolean equals(Object z){
		if(!(z instanceof Coppia))
           return false;
        Coppia pair = (Coppia)z;
        if(pair.obj.equals(this.obj) && pair.i == this.i)
           return true;
        return false;
	} //e' necessario sovrascrivere equals
   }
  private MySet s; // non ci possono essere altre variabili di esemplare
} 