public interface StringSet
{  /*
      Restituisce un array di stringhe contenente i riferimenti
      a tutti gli elementi presenti nell'insieme, in ordine
      lessicografico crescente.
   */
   String[] getElements();

   /*
      Restituisce true se e solo se la stringa s appartiene
      all'insieme.
   */
   boolean contains(String s);

   /*
      Inserisce la stringa s nell'insieme, se non è già presente,
      altrimenti fallisce silenziosamente.
   */
   void add(String s);
}