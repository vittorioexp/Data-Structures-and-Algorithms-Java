import java.util.Scanner;
import java.util.Random;

/**
  Classe di prova della classe Ricerca:

	si costruisce un array di numeri casuali: l'utente definisce 
	l'intervallo dei valori da attribuire all'array di numeri casuali 
	(interi). 
	Se c'e' piu' di una occorrenza, il programma restituisce la prima.
*/
public class ProvaRicerca {

	public static void main(String argv []) {

		Scanner in = new Scanner(System.in);

		final int dim = 20; 	//dimensione dell'array
		int a[] = new int[dim];
		String line;
		int n,k,b;
		
		System.out.println("\nintrodurre un intero per " + 
			" stabilire l'intervallo di valori "
		                 + "\nda assegnare all'array");
	
		n = in.nextInt();
		System.out.println("i numeri interi saranno compresi " +
				" tra 0 e "+ (n-1));
			
		Random generatore = new Random();
		for (int i=0; i<a.length; i++) 
			a[i] = generatore.nextInt(n);
		
		//stampa dati
		System.out.println("vettore a");
		for ( k = 0 ; k < a.length ; k++)
   			System.out.println(a[k]);
		
		Ricerca ric = new Ricerca(a); 

    		//acquisire b
		System.out.println("introdurre un numero da cercare");
		b = in.nextInt();
		
		System.out.println("\nelemento cercato b = " + b);

	/** se l'elemento e' presente si stampa la sua posizione nell'array:
		  se c'e' piu' di un elemento (n<dim) viene stampato 
			 l'indice del primo */

		if(ric.presenteRiclineare(b))
			System.out.println("\ntrovato al posto di " + 	
			 "indice = " + ric.posizione());
		else System.out.println("\nelemento non trovato " );
				
	}//fine main
}//fine classe
				