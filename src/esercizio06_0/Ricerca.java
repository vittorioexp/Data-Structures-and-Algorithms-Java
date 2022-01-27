/** Classe contenente algoritmi di ricerca*/

public class Ricerca{
		
	private int posiz;	//posizione dell'elemento se presente
	private int [] v;	//array su cui eseguire la ricerca
	
	// costruttore
	public Ricerca (int [] vettore){
		v = vettore;
		posiz = -1;		
	}
	
/** ricerca lineare: il metodo restituisce vero, se l'elemento 
	      e' presente, falso se non e' presente*/

	public boolean presenteRiclineare (int b){
		boolean trovato = false;
		int i = -1;
		while((i != v.length-1) && (!trovato))  {
			++i;
			if(v[i] == b) {
				trovato=true;
				posiz = i;
			}
		}//fine while
	return trovato;
	}//fine algoritmo
	
/** il metodo restituisce la posizione dell'elemento nell'array:
	se l'elemento non e' presente, la posizione e' -1 */

	public int posizione() {
		return posiz;	
	}

}//fine classe Ricerca