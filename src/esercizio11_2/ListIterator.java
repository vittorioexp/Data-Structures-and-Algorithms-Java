public interface ListIterator
{  /*
      comportamento del costruttore di una
      classe che realizza questa interfaccia:
      quando viene costruito, l'iteratore si
      trova nella sua prima posizione valida,
      cio� PRIMA del primo elemento; l'ultima
      posizione valida dell'iteratore � quella
      che si trova DOPO l'ultimo elemento
   */

/*
      se l'iteratore si trova nella sua ultima
      posizione valida, lancia IllegalStateException;
      altrimenti restituisce un riferimento all'oggetto
      che si trova nella posizione successiva alla
      posizione dell'iteratore e fa avanzare di una
      posizione l'iteratore
   */
Object next();

/*
     restituisce true se e solo se � possibile invocare 
next senza che venga lanciata un'eccezione
   */
boolean hasNext();

/*
     inserisce l'oggetto ricevuto in un nuovo nodo che
     viene collocato PRIMA della posizione dell'iteratore,
     senza modificare la posizione dell'iteratore
   */
void add(Object obj);

/*
     se, a partire dal momento della costruzione dell'iteratore
     o dall'ultima invocazione del metodo remove, non � stato invocato
     il metodo next o il metodo add, lancia IllegalStateException;
     altrimenti elimina il nodo che si trova nella posizione che
     precede la posizione dell'iteratore (cio� il nodo pi�
     recentemente esaminato da next o inserito da add), senza
     modificare la posizione dell'iteratore (cio� il nodo che
     verr� restituito da una successiva invocazione di next �
     lo stesso che sarebbe stato restituito se non fosse stato
     invocato il metodo remove)
   */
void remove();
}

