import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
public class ArrayStudentSet implements StudentSet {
	public static void main(String[] args) {
		if (args.length!=2) {
			System.out.println("Necessario file di testo il cui nome viene passato come primo argomento da riga di comando;");
			System.out.println("Necessario file di testo il cui nome viene passato come secondo argomento da riga di comando;");
			System.exit(1);
		}
		StudentSet s1 = new ArrayStudentSet();
		try {
			FileReader fr = new FileReader(args[0]);
			Scanner file = new Scanner(fr);
			while (file.hasNextLine()) {
				String line = file.nextLine();
				Scanner tk = new Scanner(line);
				String matricola = tk.next();
				String cognome = tk.next();
				String nome = tk.next();
				s1.add(new Student(matricola,cognome,nome));
			}
			file.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("Errore con il file " + args[0]);
		}
		StudentSet s2 = new ArrayStudentSet();
		try {
			FileReader fr = new FileReader(args[1]);
			Scanner file = new Scanner(fr);
			while (file.hasNextLine()) {
				String line = file.nextLine();
				Scanner tk = new Scanner(line);
				String matricola = tk.next();
				String cognome = tk.next();
				String nome = tk.next();
				s2.add(new Student(matricola,cognome,nome));
			}
			file.close();
			fr.close();
		} catch (IOException e) {
			System.out.println("Errore con il file " + args[1]);
		}
		System.out.println((s1.intersection(s2)).toString());
	}
	
	private Student[] v;
	private int vSize;
	
	public ArrayStudentSet() {
		v = new Student[1];
		vSize = 0;
	}
	
	/* Restituisce un array di Student contenente i riferimenti 
      a tutti gli elementi presenti nell'insieme, in ordine 
      lessicografico crescente secondo il valore del cognome.*/
    public Student[] toArray() {
		Student[] arr = new Student[vSize];
		System.arraycopy(v,0,arr,0,vSize);
		return arr;
	}
    
    /* Restituisce true se e solo se lo studente stud appartiene
       all'insieme. */
    public boolean contains(Student stud){
		/*
		for (int i=0; i<vSize; i++) {
			if (stud.equals(v[i])) {
				return true;
			}
		}
		return false;
		*/
		return (binSearch(v,stud,0,vSize-1)!=(-1));
	}
    
    /* Inserisce lo studente stud nell'insieme, se non e' gia'
       presente, altrimenti fallisce silenziosamente. */
    public void add(Student Stud){
		if (contains(Stud)) return;
		if (vSize==v.length) v=resize(v, vSize*2);
		int j;
		for (j=vSize; j>0 && Stud.compareTo(v[j-1])<0; j--) {
			v[j]=v[j-1];
		}
		v[j]=Stud;
		vSize++;
	}
    
    /* Riceve un riferimento ad un oggetto di tipo StudentSet e
       restituisce un nuovo esemplare della classe che rappresenta
       l'insieme risultante dall'intersezione (in senso insiemistico e,
       quindi, senza elementi duplicati) degli insiemi ricevuti come
       parametro implicito ed esplicito. Il metodo deve avere prestazioni
       O(n logn) dove n e' la somma del numero di elementi presenti nei 
       due insiemi*/
    public StudentSet intersection(StudentSet s){
		Student[] v1 = this.toArray();
		Student[] v2 = s.toArray();
		StudentSet res = new ArrayStudentSet();
		int j=0;
		for (int i=0; i<v1.length; i++) {
			while (v1[i].compareTo(v2[j])>0 && j<v2.length) 
				j++;
			if (j==v2.length) break;
			if (v1[i].compareTo(v2[j])==0) 
				res.add(v2[j]);
		}
		return res;
	}
	
	public String toString() {
		String str = "";
		for (int i=0; i<vSize; i++) {
			str += v[i].getMatricola() + " ";
		}
		return str;
	}
	
	private static int binSearch(Student[] a, Student stud, int from, int to) {
		if (a==null) throw new IllegalArgumentException();
		if (from>to) return -1;
		int mid = (from+to)/2;
		if (stud.equals(a[mid])) {
			return mid;
		} else if (stud.compareTo(a[mid])>0) {
			return binSearch(a,stud,mid+1,to);
		} else {
			return binSearch(a,stud,from,mid-1);
		}
 	}
	
	private static Student[] resize(Student[] src, int length) {
		Student[] dst = new Student[length];
		for (int i=0; i<src.length && i<dst.length; i++) {
			dst[i]=src[i];
		}
		return dst;
	}
}