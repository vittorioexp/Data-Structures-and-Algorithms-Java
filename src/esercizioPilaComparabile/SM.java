public class SM //-- Pila Comparabile Multipla
{  // parte privata
    //---     
	private Stack[] v;
	private int vSize;
    /** costruttore: inizializza una pila multipla formata da k pile comparabili vuote
       @param k numero di pile comparabili
       @throws java.lang.IllegalArgumentException se k < 0
    */  public SM(int k) throws java.lang.IllegalArgumentException {
			if (k<0) {
				throw new java.lang.IllegalArgumentException();
			}
			v = new S[k];
			for (int i=0; i<k; i++) {
				v[i] = new S();
			}
		}
           
    /**costruttore: inizializza una pila multipla con le pile comparabili presenti nell'array
       specificato (copia le pile dell'array sAr nella struttura interna)
       @param sAr array specificato di pile comparabili
       @throws java.lang.IllegalArgumentException se il riferimento sAr vale null o se l'array sAr contiene elementi di valore null
    */  public SM(Stack[] sAr) throws java.lang.IllegalArgumentException{
			this(sAr.length);
			if (sAr==null) {
			 throw new java.lang.IllegalArgumentException();	
			}
			for (int i=0; i<sAr.length; i++) {
				if (sAr[i]==null) {
					throw new java.lang.IllegalArgumentException();	
				}
				v[i]=sAr[i];
			}
		}
    
    /** @return true se tutte le pile della pila multipla sono vuote o altrimenti false 
    */  public boolean isTotallyEmpty() {
		for (int i=0; i<v.length; i++) {
			if (v[i].size()>0) {
				return false;
			}
		}
		return true;
		}         
    
    /**estrae l'elemento in cima alla pila massima (nel senso dell'ordinamento naturale)
       @return elemento in cima alla pila massima  
    */  public Object maxPop() {
		int indexMax=0;
		int sizeMax=v[0].size();
		for (int i=1; i<v.length; i++) {
			if (v[i].size()>sizeMax) {
				indexMax=i;
				sizeMax=v[i].size();
			}
		}
		return v[indexMax].pop();
		}  
    
    /**inserisce l'elemento specificato nella pila minima (nel senso dell'ordinamento naturale)
       @param x elemento specificato  
    */ public void minPush(Comparable x) {
		int indexMin=0;
		int sizeMin=v[0].size();
		for (int i=1; i<v.length; i++) {
			if (v[i].size()<sizeMin) {
				indexMin=i;
				sizeMin=v[i].size();
			}
		}
		v[indexMin].push(x);
		}
           
    /**@return numero totale di elementi presenti nelle pile comparabili della pila multipla
    */ public int totalSize() {
		int c=0;
		for (int i=0; i<v.length; i++) {
			c+=v[i].size();
		}
		return c;
		}           
}