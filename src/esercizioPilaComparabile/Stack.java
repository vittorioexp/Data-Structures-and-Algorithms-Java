public interface Stack extends Comparable  //--ADT pila comparabile
{   
   /** 
      @return true se il contenitore e' vuoto, false altrimenti
   */
  boolean isEmpty();
  
    /**
    ispeziona, estraendolo, l'elemento in cima alla pila
    @return l'elemento in cima alla pila
    @throws java.util.EmptyStackException se la pila e' vuota
  */
  Object pop() throws java.util.EmptyStackException;
  
  /**
    inserisce l'elemento specificato in cima alla pila
    @param x elemento specificato.
    @throws java.lang.IllegalArgumentException se x e' null   
  */
  void push(Comparable x);
  
  /** 
     @return numero di elementi presenti nella pila
  */
  int size(); 
  
  /**
    ispeziona, senza estrarlo, l'elemento in cima alla pila
    @return l'elemento in cima alla pila
    @throws java.util.EmptyStackException se la pila e' vuota
  */
  Object top() throws java.util.EmptyStackException;
   
  /**
    restituisce un array contenente gli elementi presenti nella pila ordinati in senso crescente
    @return array contenente gli elementi presenti nella pila in ordine crescente
     */
  Object[] toSortedArray();   
}