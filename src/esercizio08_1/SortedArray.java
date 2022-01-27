import java.util.*;
public class SortedArray
{
	private int[] v;
	private int vSize;
    /*  Crea un oggetto SortedArray vuoto     */
    public SortedArray()
    { 	
		v = new int[10];
		vSize = 0;
	}

    /*  Verifica se l'array e` vuoto. Prestazioni O(1)    */
    public boolean isEmpty()
    { 
		return (vSize==0);
	}

    /*  Aggiunge il valore value all'array ordinato, conservando l'ordinamento.
        Prestazioni O(n) (prima dell'inserimento l'array e' ordinato!)
    */
    public void add(int value)
    { 
		if (vSize>=v.length) {
			v = resize(v, v.length*2);
		}
		int i;
		for (i=vSize; i>0 && value<v[i-1]; i--) {
			v[i] = v[i-1];
		}
		v[i]=value;
		vSize++;
	}

    /* Cancella il valore massimo dall'array, e lo restituisce.
        Prestazioni O(1). Lancia NoSuchElementException se l'array e' vuoto
    */
    public int removeMax() throws NoSuchElementException
    { 
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return v[--vSize];
	}

    /*  Restituisce la media (average) dei valori dell'array
        Prestazioni O(n)
    */
    public double avg()
    {
		double sum=0;
		for (int i=0;i<vSize;i++) {
			sum+=v[i];
		}
		return (double) sum/vSize;
	}
	public static int[] resize(int a[], int length) {
		int b[] = new int[length];
		for (int i=0; i<a.length; i++) {
			b[i]=a[i];
		}
		return b;
	}
}