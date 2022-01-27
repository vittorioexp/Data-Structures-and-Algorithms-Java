public class Student implements Comparable
{
    public Student(String n, int m)
    {   nome = n;
        matricola = m;
    }

    /*
        restituisce il numero di matricola
    */
    public int getMatricola()
    { return matricola; }

    /*
        restituisce il nome
    */
    public String getNome()
    { return nome; }

    /*
        restituisce la stringa "matricola:nome"
    */
    public String toString() 
    { return matricola + ":" + nome; }

    /*
        confronta in base al numero di matricola (in particolare due oggetti di 
        tipo Student sono "uguali" quando hanno la stessa matricola)
        Lancia ClassCastException se s non si riferisce ad un oggetto Student 
    */
    public int compareTo(Object s)
    {   return matricola - ((Student) s).matricola;
    }

    private final String nome;
    private final int matricola;
}