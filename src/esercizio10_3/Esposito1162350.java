interface Container { // comportamento definito a lezione

void makeEmpty(); boolean isEmpty();

}

interface Stack extends Container { // comportamento definito a lezione

Object top(); // lancia EmptyStackException se la pila è vuota

Object pop(); // lancia EmptyStackException se la pila è vuota

void push(Object obj);

}

class EmptyStackException extends RuntimeException {}

interface Dictionary extends Container{ // comportamento definito a lezione

void insert(Comparable key, // lancia IllegalArgumentException se key vale null

Object value);

void remove(Comparable key); // lancia DictionaryItemNotFound se key non esiste

Object find(Comparable key); // lancia DictionaryItemNotFound se key non esiste

}

class DictionaryItemNotFound extends RuntimeException {}

class MyStack implements Stack {

 // ...
 // i metodi devono avere prestazioni O(1) in media, si possono usare array
	
	private Object[] v;
	private int vSize;
	
	public MyStack() {
		v = new Object[1];
		makeEmpty();
	}
	public void makeEmpty() {
		vSize=0;
	}
	public boolean isEmpty() {
		return vSize==0;
	}
	public Object top() {
		// lancia EmptyStackException se la pila è vuota
		if (vSize==0) {
			throw new EmptyStackException();
		}
		return v[vSize-1];
	}

	public Object pop() {
		// lancia EmptyStackException se la pila è vuota
		Object tmp = top();
		vSize--;
		return tmp;
	}

	public void push(Object obj) {
		if (vSize==v.length) {
			v = resize(v, vSize*2);
		}
		v[vSize++] = obj;
	}
	private static Object[] resize(Object[] src, int newLength) {
		Object[] dst = new Object[newLength];
		for (int i=0; i<src.length && i<dst.length; i++) {
			dst[i] = src[i];
		}
		return dst;
	}

}

class MyDictionary implements Dictionary {
	
	public MyDictionary() {
		s = new MyStack();
	}
	
	public boolean isEmpty() {
		return s.isEmpty();
	}
	
	public void makeEmpty() {
		s.makeEmpty();
	}

	public void insert(Comparable key, Object value) { // lancia IllegalArgumentException se key vale null
		if (key==null) {
			throw new IllegalArgumentException();
		}
		try {
			remove(key);
		} catch (DictionaryItemNotFound e) {}
		Pair p = new Pair();
		p.key = key;
		p.value = value;
		s.push(p);
	}


	public void remove(Comparable key) { // lancia DictionaryItemNotFound se key non esiste
		Stack tmp = new MyStack();
		Pair p = null;
		boolean found = false;
		while (!s.isEmpty() && !found) {
			p = (Pair) s.pop();
			if (!p.key.equals(key)) {
				tmp.push(p);
			} else {
				found = true;
			}
		}
		//Reverse stack
		while (!tmp.isEmpty()) {
			s.push(tmp.pop());
		}
		//Exception
		if (!found) {
			throw new DictionaryItemNotFound();
		}
		
	}	

	public Object find(Comparable key) { // lancia DictionaryItemNotFound se key non esiste
		Stack tmp = new MyStack();
		Pair p = null;
		Pair res = null;
		boolean found = false;
		while (!s.isEmpty() && !found) {
			p = (Pair) s.pop();
			if (p.key.equals(key)) {
				res = p;
				found = true;
				tmp.push(p);
			}
		}
		//Reverse stack
		while (!tmp.isEmpty()) {
			s.push(tmp.pop());
		}
		//Exception
		if (!found) {
			throw new DictionaryItemNotFound();
		}
		return res.value;
	}	

	// questa classe non può avere variabili statiche, non si possono usare array

	// non ci sono vincoli di prestazioni per i metodi

	private Stack s; // non ci possono essere altre variabili di esemplare

	private class Pair { // non modificare questa classe

	private Comparable key; private Object value;
	
	}

}

public class Esposito1162350 { // MODIFICARE CognomeMatricola, ma NON il contenuto

public static void main(String[] args) {

Dictionary dict = new MyDictionary();

dict.insert("123", "pippo"); dict.insert("234", "pluto");

dict.insert("456", "paperino"); dict.insert("123", "topolino");

dict.insert("999", "minnie"); dict.remove("456");

System.out.println(dict.find("999") + " " + dict.find("123"));

// deve visualizzare minnie topolino

}

}