// Vittorio Esposito, 1162350, 10 gennario 2018, adt12

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
public class CodificatoreTester
{   public static void main(String[] args)
    {
	if (args.length!=1) {
		System.out.println("Necessario riceve un nome di file di testo, file1, come argomento sulla riga di comando;");
	
	} 
	String file1 = args[0];
     	InvertibleDictionary c1 = new Codificatore();
	try {
		FileReader fr = new FileReader(file1);
		BufferedReader br = new BufferedReader(fr);
		String ln;
		while ((ln = br.readLine())!=null) {
			Scanner tk = new Scanner(ln);
			String w;
			String c;
			w = tk.next();
			c = tk.next();
			c1.insert(w, c);
		
		}
		br.close();
		fr.close();
	} catch (IOException e) {
		System.out.println("Errore nella lettura del file "+ file1);
	}
	Scanner sc = new Scanner(System.in);
	String m1 = sc.nextLine();
	String m2 = cifra(m1, c1);
	System.out.println(m2);
	InvertibleDictionary c2 = new Codificatore();
	c2 = c1.invert();
	String m3 = cifra(m2, c2);
	System.out.println(m3);
    }
	private static String cifra(String txt, InvertibleDictionary dict) {
		Scanner tk = new Scanner(txt);
		String out = "";
		while (tk.hasNext()) {
			Comparable tmp = (String) tk.next();
			try { 
				tmp = (String) dict.find((String) tmp);
			} catch (DictionaryItemNotFoundException e) {}
			
			out += tmp + " ";
		}
		return out;
	}
}


class Codificatore implements InvertibleDictionary
{

    //costruttori e metodi pubblici ......da completare ......
	private StringPair[] v;
	private int vSize;
	public Codificatore(){
		v = new StringPair[1];
		makeEmpty();
	}
	public boolean isEmpty() {
		return vSize==0;
	}
	public void makeEmpty() {
		vSize=0;
	}
	
	public void insert(Comparable key, Comparable value) {
		if (key==null) {
			throw new IllegalArgumentException();	
		}
		try { remove(key); } 
		catch (DictionaryItemNotFoundException e) {}
		if (vSize==v.length) {
			v = resize(v, vSize*2);
			
		}	
		v[vSize++]=new StringPair((String) key, (String) value);
	}
	public void remove(Comparable key) {
		for (int i=0; i<vSize; i++) {
			if (v[i].getWord().equals((String) key)) {
				break;
			}
		}
		throw new DictionaryItemNotFoundException();
	}
	public Object find(Comparable key){
		for (int i=0; i<vSize; i++) {
			if (v[i].getWord().equals((String) key)) {
				return v[i].getCode();
			}
		}
		throw new DictionaryItemNotFoundException();
	}
	public InvertibleDictionary invert() {
	InvertibleDictionary inv = new Codificatore();
		for (int i=0;i<vSize;i++) {
			inv.insert(v[i].getCode(), v[i].getWord());
			//s[i].word = v[i].getCode();
			//s[i].code = v[i].getWord();
		}
		return inv;
	}
	private static StringPair[] resize(StringPair[] src, int size) {
		StringPair[] dst = new StringPair[size];
		for (int i=0;i<src.length && i<dst.length; i++) {
			dst[i]=src[i];
		}
		return dst;
	}

    public String toString()
    { 
	String str = "";
	for (int i=0;i<vSize; i++) {
		str += v[i].getWord() + " " + v[i].getCode() + '\n'; 
	}
	return str;  
}   
    

    //classe privata StringPair: non modificare!!
    private class StringPair
    {   public StringPair(String word, String code)
        {   this.word = word; 
            this.code = code;
        }      
        public String getWord() 
        { return word; }
        public String getCode() 
        { return code; }
        /*
            Restituisce una stringa contenente
            - la parola "word"
            - uno spazio
            - il codice "code"
        */
        public String toString() 
        {   return word + " " + code;
        }
        //campi di esemplare
        private String word;
        private String code;
    }
}

interface InvertibleDictionary   //non modificare!!
{
    /*
     verifica se il dizionario contiene almeno una coppia chiave/valore
    */
    boolean isEmpty();

    /* 
     svuota il dizionario
    */
    void makeEmpty();

    /*
     Inserisce un elemento nel dizionario. L'inserimento va sempre a buon fine.
     Se la chiave non esiste la coppia key/value viene aggiunta al dizionario; 
     se la chiave esiste gia' il valore ad essa associato viene sovrascritto 
     con il nuovo valore; se key e` null lancia IllegalArgumentException
    */
    void insert(Comparable key, Comparable value);

    /*
     Rimuove dal dizionario l'elemento specificato dalla chiave key
     Se la chiave non esiste lancia DictionaryItemNotFoundException 
    */
    void remove(Comparable key);

    /*
     Cerca nel dizionario l'elemento specificato dalla chiave key
     La ricerca per chiave restituisce soltanto il valore ad essa associato
     Se la chiave non esiste lancia DictionaryItemNotFoundException
    */
    Object find(Comparable key);

    /* 
      Crea il "dizionario inverso", ovvero un nuovo oggetto di tipo 
      InvertibleDictionary che, per ogni coppia key/value presente nel 
      dizionario originale (parametro implicito del metodo), contiene una 
      corrispondente "coppia inversa" value/key.
      Notare che l'operazione e` possibile perche` key e value sono entrambi
      oggetti di tipo Comparable: quindi e` possibile usare i valori value 
      come chiavi del dizionario inverso.
      Notare che se il dizionario originale (parametro implicito del metodo) 
      contiene piu` occorrenze di uno stesso campo value, solo una di tali
      occorrenze sara` associata ad una coppia inversa nel dizionario inverso,
      in virtu` dell'ipotesi di unicita` della chiave nel dizionario.
      Se si presenta la situazione appena descritta, ovvero nel dizionario 
      originale sono presenti piu` coppie con lo stesso campo value, nel 
      dizionario inverso verra` inserita una qualsiasi delle coppie inverse.
    */
    InvertibleDictionary invert();
}

class DictionaryItemNotFoundException extends RuntimeException  {}

