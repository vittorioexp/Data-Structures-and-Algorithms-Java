public interface CD
{ int size();
boolean isEmpty();
void addFirst (Object x); // aggiunge all'inizio della coda
void addLast (Object x); // aggiunge alla fine della coda
Object removeFirst () throws EmptyCDException; // toglie dall'inizio
Object removeLast () throws EmptyCDException; // toglie dalla fine
Object getFirst () throws EmptyCDException; // elemento all'inizio
Object getLast () throws EmptyCDException; // elemento alla fine
}