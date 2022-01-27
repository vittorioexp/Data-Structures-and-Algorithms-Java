/**
  Questa classe contiene metodi statici per l'uso di array: 
           leggi, stampa, raddoppio, copia, ridimensiona, aumenta 
*/

import java.util.Scanner;

public class AlgoritmiArray{
	
/** metodi per la lettura di un array di tipo intero: si costruisce
un metodo  leggi che restituisce la referenza dell'array (pieno) che e' 
stato acquisito; si forniscono diverse possibilita' di lettura: 
il metodo leggi e' sovraccarico */

/** public static int[] leggi(int [] v) :  
 
      restituisce la referenza dell'array letto; 
          la variabile in (di tipo Scanner) e' locale; 
              la lettura termina con q oppure Q */

	public static int [] leggi(int v[]) {
 		Scanner in =new Scanner(System.in);

		String st;
		int n=0;
		System.out.println("inserire dei numeri interi " +
			" per terminare battere q o Q");
		st = in.next();
		while(!(st.equals("q")) && !(st.equals("Q")) ) {
	/** acquisizione dei dati ed eventuale 
				ridimensionamento*/
			v[n]=Integer.parseInt(st);
			n++;
			if(n == v.length)
				v=raddoppio(v);
			st=in.next();
		}//fine while

     
	/* se n < dimensione di v, togliamo gli spazi vuoti */
		if(n < v.length)
			v= ridimensiona(v,n);

	 	return v;
	}//fine leggi


/* public static int[] leggi(int [] v, Scanner in) : 
  
    restituisce la referenza dell'array letto; 
      la variabile in (di tipo Scanner) e' passata dal metodo chiamante; 
           la lettura termina con q oppure Q*/

public static int [] leggi(int v[], Scanner in) {
 		
		String st;
		int n=0;
		System.out.println("inserire dei numeri interi " +
			" per terminare battere q o Q");
		st = in.next();
		while(!(st.equals( "q")) && !(st.equals("Q")) ) {
	/** acquisizione dei dati ed eventuale 
				ridimensionamento*/
			v[n]=Integer.parseInt(st);
			n++;
			if(n == v.length)
				v=raddoppio(v);
			st=in.next();
		}//fine while

     
	/* se n < dimensione di v, togliamo gli spazi vuoti */
		if(n < v.length)
			v= ridimensiona(v,n);

	 	return v;
	}//fine leggi


/* public static int[] leggi(int [] v, Scanner in, int dim) :  

 restituisce la referenza dell'array letto; 
    la variabile in (di tipo Scanner) e' passata dal metodo chiamante;
      viene passato anche il numero dim di elementi da leggere  
*/
public static int [] leggi(int v[], Scanner in, int dim) {
 		
		int n;
		for (n=0; n< dim ; n++){
			v[n]=in.nextInt();
			if(n == v.length -1)
				v=raddoppio(v);
		}//fine for

	       //se n < dimensione di v, togliamo gli spazi vuoti
		if(n < v.length)
			v= ridimensiona(v,n);

	 	return v;
	}//fine leggi




/** public static void stampa(int t[]):

        si effettua la stampa dell'array, scrivendo 8 elementi 
			per riga */

	public static void stampa(int t[]) {
		int i;
		for (i=0; i < t.length ; i++) {
 			System.out.print(t[i] + "\t");
			if ((i+1) % 8 == 0 ) 
				System.out.println();
		}
		System.out.println();
 	}//fine stampa



/** public static int[] raddoppio(int t[]):

	raddoppio dell'array, viene restituita la referenza dell'array
		di dimensione doppia*/
	public static int[] raddoppio(int t[]){
		int w[] = new int[t.length*2];
		for(int k=0; k < t.length; k++)
			w[k]=t[k];
		//copiamo la referenza;
		t=w;
		return t;	
	}//fine raddoppio



/** public static int[] ridimensiona(int t[], int n):
 
     ridimensionamento: l'array viene reso "pieno", copiandolo su 
	un array di dimensione uguale al numero di elementi 
		effettivamente inseriti */

public static int[] ridimensiona(int t[], int n){
		int w[] = new int[n];
			for(int k=0; k < n; k++)
				w[k]=t[k];
		//copiamo la referenza;
			t=w;
		return t;	
	}//fine ridimensiona



/** public static int[] aumenta(int t[], int n):
	copia l'array in un array piu' grande (es. n = t.length+1)
         per poter inserire una componente in un array pieno */

public static int[] aumenta(int t[], int n){
		int w[] = new int[n];
			for(int k=0; k < t.length; k++)
				w[k]=t[k];
		//copiamo la referenza;
			t=w;
		return t;	
	}//fine ridimensiona


/** public static void copia(int t[], int w[]):

	copia i valori dell'array  t in un nuovo array w 
	   della stessa dimensione e creato precedentemente */
	public static void copia(int t[], int w[]){
		for(int k=0; k < t.length; k++)
			w[k]=t[k];
	}//fine copiarray

}//fine classe