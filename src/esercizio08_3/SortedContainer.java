import java.util.*;
public class SortedContainer implements Container
{
 /*
 Costruisce un contenitore vuoto
 */
 protected Comparable v[];
 protected int vSize;
 
	public SortedContainer()
	{ 
		v = new Comparable[10];
		vSize = 0;
	} 

 /*
 ... metodi di Container da realizzare ...
 */
  /*
    verifica se il contenitore e' vuoto
    restituisce true se il contenitore e' vuoto, false altrimenti
  */
	public boolean isEmpty() {
		return (vSize==0);
	}

  /*
    rende vuoto il contenitore
  */
	public void makeEmpty() {
		vSize=0;
	}

 /*
 Aggiunge l'elemento compObj, ridimensionando l'array se necessario.
 L'elemento viene inserito in coda all'array e successivamente l'array
 viene ordinato. Andamento asintotico O(n) (prima dell'inserimento 
 l'array e' ordinato!)
 */
	public void add(Comparable compObj)
	{
		if (vSize>=v.length) {
		v = resize(v, vSize*2);
		}
		int i;
		for (i=vSize; i>0 && compObj.compareTo(v[i-1])<=0; i--) {
			v[i] = v[i-1];
		}
		v[i] = compObj;
		vSize++;
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
 restituisce il valore massimo del contenitore (massimo nel senso 
 definito dal metodo compareTo()), e lo cancella dal contenitore. 
 Andamento asintotico O(1).
 Lancia NoSuchElementException se l'array e' vuoto
 */
	public Comparable removeMax() throws NoSuchElementException
	{
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return v[--vSize];
	} 
}