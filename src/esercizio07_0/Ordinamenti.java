/** 
  Classe che contiene metodi di ordinamento: l'array da ordinare
         viene passato al costruttore; si considera l'array pieno 
*/

public class Ordinamenti {

	private int[] a;
	private int conf;
	private int ass;


	public Ordinamenti(int v[]){
		a = v; 	
	}
	
		
/**ordinamento lineare con scambio */
	public void ordlineare() {
		int i,k,sc;
		for (i = 0 ; i < a.length-1 ; i++ )
			for ( k=i+1  ; k < a.length ; k++ )
		 	{
				if ( a[i] > a[k] ) 
				{
					sc = a[i];   
					a[i] = a[k];
					a[k] = sc;
   				}//fine if
			}//fine for interno
	}//fine ordlineare


/**ordinamento per selezione (selection sort)
*/
	public void selectionsort() 
	{
		int i, k, temp, min, posMin ;
		for (i = 0 ; i < a.length-1 ; i++ )
		{
			posMin=i;
			for ( k=i+1  ; k < a.length ; k++ )
				if ( a[posMin] > a[k] ) 
					posMin=k;
	   		// fine if e for interno
	  		temp = a[posMin];
	   		a[posMin] = a[i];
	  		a[i] = temp;
		}//fine for esterno
	}//fine selectionsort

/**ordinamento lineare con conteggio di confronti e
	assegnazioni: 
                         complessita' O(n^2) */
	public void complessitaordlin() {
		int i , k, temp;
		conf =0;
		ass =0;
		for (i = 0 ; i < a.length-1 ; i++ )
			for ( k = i+1  ; k < a.length ; k++ ){
				conf++;
				if ( a[i] > a[k] ) {
					temp = a[i];   
					a[i] = a[k];
					a[k] = temp;
					ass += 3; 
   				}//fine if
			}//fine for interno
		//fine for esterno
	}//fine complessitaordlin

	

	//bubblesort
	public void complessitabubble() {
		int i,k,sc;
		conf=0;	
		ass=0;
		for(i = 1;i<= a.length-1;++i){
           		for(k = 0;k < a.length-i;++k){ 
	        		conf++;
				if(a[k]>a[k+1]){
					sc=a[k];
					a[k]=a[k+1];
					a[k+1]=sc;
					ass=ass+3;  
				}//fine if
	   		}//fine for 

/*stampa dell'array durante l'ordinamento */
		AlgoritmiArray.stampa(a);

		}//fine for esterno
	}//fine complessitabubble


	public int quanticonf(){
		return conf;
	}

	public int quanteass(){
		return ass;
	}	


}//fine classe 