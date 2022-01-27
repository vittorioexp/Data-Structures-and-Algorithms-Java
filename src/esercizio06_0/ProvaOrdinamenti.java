/** 
  Classe di prova per la classe Ordinamenti 
*/

import java.util.Scanner;
class ProvaOrdinamenti {

	public static void main(String argv [])  {

		Scanner in =new Scanner(System.in);
		int v[] = new int[50];

/** l'acquisizione dei dati e la stampa avvengono tramite 
	la chiamata dei metodi della classe AlgoritmiArray */

/* i dati sono acquisiti dal file casuali.txt, costruito con 
    il programma Generacasuali.java, che contiene: 
    il numero di elementi e gli elementi da ordinare */

		int n = in.nextInt();
		System.out.println("array di " + n +" componenti");
		v = AlgoritmiArray.leggi(v, in, n);
		
/* si costruisce una copia di v: la copia e' mantenuta non ordinata per 
poter eseguire l'ordinamento con metodi diversi */

		int w[] = new int[v.length];
		AlgoritmiArray.copia(v,w);
		
		System.out.println("\nGli elementi da ordinare sono " + 
						v.length );
		AlgoritmiArray.stampa(v);

/* costruzione dell'oggetto ordina di tipo Ordinamenti: l'array v  e' parametro
	di costruzione, l'oggetto puo' ordinare  v utilizzando diversi metodi */	
	
		Ordinamenti ordina = new Ordinamenti(v);
		
		Cronometro tempo = new Cronometro();

//ordinamento lineare con scambio	
		tempo.start();	
		ordina.ordlineare();
		tempo.stop();
		System.out.println("elementi ordinati con ordlineare\n");
	 	AlgoritmiArray.stampa(v);
		System.out.println("tempo ordlineare = " + 
					tempo.tempotrascorso());
		
//copiare w non ordinato in v
		AlgoritmiArray.copia(w,v); 

//ordinamento per selezione 
		tempo.start();
		ordina.selectionsort();
		tempo.stop();
		System.out.println("\nelementi ordinati con " + 
					 "selectionsort\n");
	 	AlgoritmiArray.stampa(v);
		System.out.println("tempo selectionsort = " + 
					 tempo.tempotrascorso());
		
//copiare w non ordinato in v
		AlgoritmiArray.copia(w,v);

//ordinamento lineare con calcolo della complessita'
		ordina.complessitaordlin();	
		System.out.println("\nelementi ordinati con " + 
			" complessitaordlin\n");
	 	AlgoritmiArray.stampa(v);
		System.out.println("complessita' ordinamento lineare " + 
				" (selezione)");
		System.out.println("\nsono stati effettuati " + 
				 ordina.quanticonf() + " confronti" + 
			" e " + ordina.quanteass() + " assegnazioni");

		System.out.println("caso peggiore: " + n*(n-1)/2 + 
				" confronti  " + 3*n*(n-1)/2 + 
				" assegnazioni");
		
	}//fine main
	
}//fine classe





/* Dare il comando

   java ProvaOrdinamenti < casuali.dati > ProvaOrdinamenti.ris

*/