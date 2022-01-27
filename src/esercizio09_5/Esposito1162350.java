import java.util.Scanner;
public class Esposito1162350
{
public static void main(String[] args)
 {
	if (args.length==0) {
		System.out.println("Invalid prompt arguments");
		System.exit(1);
	}
	int size=0;
	try {
		size = Integer.parseInt(args[0]);
	} catch (NumberFormatException e) {
		System.out.println("Not a number");
		System.exit(1);
	}
	MultiStack s = new MyMultiStack(size);
	for (int i=1; i<args.length; i++) {
		s.add(new String(args[i]), size-1);
	}
	Scanner sc = new Scanner(System.in);
	Scanner tk;
	while (sc.hasNextLine()) {
		String str = sc.nextLine();
		tk = new Scanner(str);
		while (tk.hasNext()) {
			s.add(tk.next());
		}
	}
	//Conta il numero di elementi complessivamente inseriti (soluzione più onerosa)
	//Alternativamente conto gli inserimenti con un indice int
	int count=0;
	for (int i=0;i<size; i++) {
		count+=s.dim(i);
	}
	for (int i=0; i<count/2; i++) {
		s.remove();
	}
	System.out.print(s.toString());
 }
}   

interface MultiStack extends Container
{
//restituisce la dimensione della pila di indice i, cioe' il numero di elementi 
//contenuti nella pila di indice i;lancia IllegalArgumentException se il valore  di    
//i non è corretto;
 int dim(int i);
 
//aggiunge x nella pila di indice i della multipila
//richiede x!= null; 
//lancia IllegalArgumentException se il valore di i non è corretto;
 void add(Object x, int i);                                                     
 
 //aggiunge x nella pila della multipila che contiene il minor numero di elementi
//richiede x!= null;
 void add(Object x);
 
//viene eliminato il dato dalla pila che contiene il maggior numero di elementi;
//richiede che la multipila non sia vuota    
void remove();
}

class MyMultiStack implements MultiStack
{
	private Stack v;
	private int maxSize;
	public MyMultiStack(int n) {
		if (n<2) {
			throw new IllegalArgumentException();
		}
		v = new ArrayStack();
		maxSize=n;
		for (int i=0; i<n; i++) {
			v.push(new ArrayStack());
		}
	}
	public void makeEmpty() {
		v.makeEmpty();
	}
	public boolean isEmpty() {
		return v.isEmpty();
	}
//restituisce la dimensione della pila di indice i, cioe' il numero di elementi 
//contenuti nella pila di indice i;lancia IllegalArgumentException se il valore  di    
//i non è corretto;
	public int dim(int i) {
		if (i>=maxSize || i<0) {
			throw new IllegalArgumentException();
		}
		if (v.isEmpty()) {
			return 0;
		}
		
		Stack tmp = new ArrayStack();
		int count=0;
		//Sposta elementi sovrastanti
		while (count<maxSize-i-1) {
			tmp.push(v.pop());
			count++;
		}
		
		//Analizza numero elementi pila i-esima
		int result=0;
		Stack tmp1 = new ArrayStack();
		while (!((Stack) v.top()).isEmpty()) {
			tmp1.push(((Stack) v.top()).pop());
			result++;
		}
		while (!tmp1.isEmpty()) {
			((Stack) v.top()).push(tmp1.pop());
		}
		
		//Rimetti gli elementi
		while (!tmp.isEmpty()) {
			v.push(tmp.pop());
		}
		return result;
	}
//aggiunge x nella pila di indice i della multipila
//richiede x!= null; 
//lancia IllegalArgumentException se il valore di i non è corretto;
	public void add(Object x, int i) {
		if (i>=maxSize || x==null) {
			System.out.println("Err: " + i);
			throw new IllegalArgumentException();
		}
		Stack tmp = new ArrayStack();
		int count=0;
		//Sposta elementi sovrastanti
		while (count<maxSize-i-1) {
			tmp.push(v.pop());
			count++;
		}
		
		((Stack) v.top()).push(x);
		
		//Rimetti gli elementi
		while (!tmp.isEmpty()) {
			v.push(tmp.pop());
		}
	}
//aggiunge x nella pila della multipila che contiene il minor numero di elementi
//richiede x!= null;
	public void add(Object x) {
		if (x==null) {
			throw new IllegalArgumentException();
		}
		//Trova pila con minor numero di elementi
		int min = dim(0);
		int minPos = 0;
		for (int i=1; i<maxSize; i++) {
			int tmp_dim = dim(i);
			if (tmp_dim<min) {
				min=tmp_dim;
				minPos=i;
			}
		}
		add(x, minPos);
	}
//viene eliminato il dato dalla pila che contiene il maggior numero di elementi;
//richiede che la multipila non sia vuota 
	public void remove() {
		if (maxSize==0) return;
		//Trova pila con maggior numero di elementi
		int max = dim(0);
		int maxPos = 0;
		for (int i=1; i<maxSize; i++) {
			int tmp_dim = dim(i);
			if (tmp_dim>max) {
				max=tmp_dim;
				maxPos=i;
			}
		}
		Stack tmp = new ArrayStack();
		int count=0;
		//Sposta elementi sovrastanti
		while (count<maxSize-maxPos-1) {
			tmp.push(v.pop());
			count++;
		}
		
		if (!((Stack) v.top()).isEmpty()) {
			((Stack) v.top()).pop();
		}
		
		
		//Rimetti gli elementi
		while (!tmp.isEmpty()) {
			v.push(tmp.pop());
		}
		
	}
	
	public String toString() {
		if (v.isEmpty()) return "";
		String str="";
		Stack tmp = new ArrayStack();
		//Reverse
		while (!v.isEmpty()) {
			tmp.push(v.pop());
		}
		while (!tmp.isEmpty()) {
			str += toStringStack((Stack) tmp.top()) + '\n';
			v.push(tmp.pop());
		}
		return str;
	}
	private String toStringStack(Stack s) {
		if (s.isEmpty()) return "";
		String tmpStr="";
		Stack tmp1 = new ArrayStack();
		//Reverse
		while (!s.isEmpty()) {
			tmp1.push(s.pop());
		}
		while (!tmp1.isEmpty()) {
			tmpStr += tmp1.top() + " ";
			s.push(tmp1.pop());
		}
		return tmpStr;
	}
 // questa classe non può avere variabili statiche;
}