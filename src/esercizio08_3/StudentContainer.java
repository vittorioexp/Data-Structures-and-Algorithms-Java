import java.io.*;
import java.util.*;
public class StudentContainer extends SortedContainer
{
 /*
 Costruisce un contenitore vuoto
 */
 //private Student v[];
 //private int vSize;
 
 public StudentContainer()
 { 
	v = new Student[10];
	vSize = 0;
 } 

 /*
 Costruisce un contenitore e vi inserisce oggetti di tipo Student
 usando i dati letti dal file filename, nel formato nome:matricola
 */
 public StudentContainer(String filename) throws IOException
 { 
	this();
	try {
		FileReader fr = new FileReader(filename);
		Scanner sc = new Scanner(fr);
		while (sc.hasNextLine()) {
			String data;
			data = sc.nextLine();
			Scanner tk = new Scanner(data).useDelimiter(":");
			try {
				String name = tk.next();
				int matr = Integer.parseInt(tk.next());
				this.add(new Student(name, matr));
			} catch (NumberFormatException e) {
				System.out.println(e);
			}
		}
	} catch (IOException e) {
		System.out.println(e);
	}
 } 

 /*
 Inserisce il nuovo oggetto compObj di tipo Student nel contenitore. 
 Questo metodo sovrascrive il metodo omonimo di SortedContainer. Se 
 l'oggetto compObj non e` di tipo Student il metodo deve lanciare
 IllegalArgumentException. Per il resto il comportamento del metodo e` 
 identico a quello del metodo omonimo di SortedContainer
 */
 public void add(Comparable compObj)
 { 
	if (!(compObj instanceof Student)) {
		throw new IllegalArgumentException();
	}
	
	if (vSize>=v.length) {
		v = this.resize(v, vSize*2);
	}
	int i;
	for (i=vSize; i>0 && compObj.compareTo(v[i-1])<=0; i--) {
		v[i] = v[i-1];
	}
	v[i] = (Student) compObj;
	vSize++;
 } 

 /*
 Crea un nuovo oggetto Student con il nome n e la matricola m, e 
 successivamente lo inserisce nel contenitore con le stesse modalita`
 del metodo add(Comparable compObj)
 */
 public void add(String n, int m)
 { 
	this.add(new Student(n, m));
 } 
 
private Comparable[] resize(Comparable[] oldAr, int newLength)
	{ 
		Comparable[] newAr = new Comparable[newLength];
		for (int i=0; i<oldAr.length; i++) {
			newAr[i] = oldAr[i];
		}
		return newAr;
	} 

 /*
 ATTENZIONE: i metodi pubblici isEmpty(), makeEmpty(), removeMax() 
 sono ereditati dalla superclasse SortedContainer
 */
}