/** 
 Classe di prova per la classe AlgoritmiArray. 
 Per la stampa si effettua la chiamata di un metodo della classe 
  AlgoritmiArray e successivamente la chiamata di un altro metodo 
 di stampa contenuto nella classe di prova
 */

import java.util.Scanner;

class ProvaAlgoritmiArray {

	public static void main(String argv []) {

		Scanner input =new Scanner(System.in);

		int v[] = new int[5];
	
/* introdurre piu' di 5 elementi per testare i metodi:
			raddoppio e ridimensiona */	
	
		v = AlgoritmiArray.leggi(v, input);

		System.out.println(" nell'array ci sono " + v.length +"  elementi");
		AlgoritmiArray.stampa(v);

		System.out.println("\nl'array v aumenta di un posto");
		v=AlgoritmiArray.aumenta(v,v.length+1);
		System.out.println("\nla sua lunghezza e' " + v.length);

		System.out.println("introdurre un numero intero per la " +
				" nuova componente");
		v[v.length-1] = input.nextInt();

// chiamata di un metodo di stampa della classe AlgoritmiArray
		System.out.println("stampa dell'array con il metodo stampa");
		AlgoritmiArray.stampa(v);

// chiamata di un metodo di stampa contenuto nella classe di prova
		System.out.println("stampa della'array con il metodo " +
			"stamparray");
		stamparray(v);
		
	}//fine main

	public static void stamparray(int t[]) {
		int i;
		for (i=0; i < t.length ; i++) {
 			System.out.print(t[i] + "\t");
			if ((i+1) % 5 == 0 ) 
				System.out.println();
		}
		System.out.println();
 	}//fine stamparray
}