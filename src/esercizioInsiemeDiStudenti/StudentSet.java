public interface StudentSet
{  /* Restituisce un array di Student contenente i riferimenti 
      a tutti gli elementi presenti nell'insieme, in ordine 
      lessicografico crescente secondo il valore del cognome.*/
    Student[] toArray();
    
    /* Restituisce true se e solo se lo studente stud appartiene
       all'insieme. */
    boolean contains(Student stud);
    
    /* Inserisce lo studente stud nell'insieme, se non e' gia'
       presente, altrimenti fallisce silenziosamente. */
    void add(Student Stud);
    
    /* Riceve un riferimento ad un oggetto di tipo StudentSet e
       restituisce un nuovo esemplare della classe che rappresenta
       l'insieme risultante dall'intersezione (in senso insiemistico e,
       quindi, senza elementi duplicati) degli insiemi ricevuti come
       parametro implicito ed esplicito. Il metodo deve avere prestazioni
       O(n logn) dove n e' la somma del numero di elementi presenti nei 
       due insiemi*/
    StudentSet intersection(StudentSet s);
}

