public class CognomeMatricolaSvolto
{ // MODIFICARE CognomeMatricola, ma NON il contenuto
    public static void main(String[] args)
    {
      MultiSet s = new MyMultiSet();
      String s1 = "ok";
      String s2 = "no";
      s.add("ok");
      s.add("ok");
      s.add("ok");
      s.add("no");
      s.add("no");
      s.remove("ok");
      s.remove("no");
      System.out.print(s.molt(s1) + s.molt(s2));
      // deve visualizzare 3
	  System.out.println("*******\n" + s.toString() + "*******");
    }
}

interface Container
{ // comportamento definito a lezione
   void makeEmpty();
   boolean isEmpty();
}

interface MultiSet extends Container

{
   //aggiunge x in una posizione qualunque di this
   //richiede x!= null;
   void add(Object x);

   //viene eliminata una qualunque (e una sola) occorrenza di x ;
   //richiede x!= null;
   void remove(Object x) throws IllegalStateException;

   //restituisce la molteplicita' di x, cioe' il numero di elementi E di this per i quali x.equals(E) vale true
   //richiede x!= null;
   int molt(Object x);
}

interface Set extends Container
{ // comportamento definito a lezione
   void add(Object x);
   boolean contains(Object x);
   Object[] toArray();
}

class MySet implements Set
{
   private Object[] insieme = new Object[100];
   private int vSize = 0;
   public void add(Object x)
   {
     if(contains(x))
       return;
     if(vSize == insieme.length)
     {
        Object[] nuovo = new Object[2*insieme.length];
        System.arraycopy(insieme,0,nuovo,0,vSize);
        insieme = nuovo;
     }
     insieme[vSize++] = x;
   }
   public boolean contains(Object x)
   {
     for(int i=0;i<vSize;i++)
     {
       if(insieme[i].equals(x))
          return true;
     }
     return false;
   }
   public Object[] toArray()
   {
     Object[] nuovo = new Object[vSize];
     System.arraycopy(insieme,0,nuovo,0,vSize);
     return nuovo;
   }
   public void makeEmpty()
   {
      vSize = 0;
   }
   public boolean isEmpty()
   {
      if(vSize == 0)
        return true;
      return false;
   }
   
}

class MyMultiSet implements MultiSet
{
    public MyMultiSet()
    {
      s = new MySet();
    }
    //aggiunge x in una posizione qualunque di this
   //richiede x!= null;
   public void add(Object x)
   {
      if(x == null)
        return;
      Object[] setInsieme = s.toArray();
      boolean done = false;
      for(int i = 0;i<setInsieme.length && !done;i++)
      {
        Coppia pair = (Coppia)setInsieme[i];
        if(pair.obj.equals(x))  //o pair.equals(x) cambiando equals
        {
           done = true;
           
           pair.i++;
        }
      }
      if(!done)
      s.add(new Coppia(x,1));
   }

   //viene eliminata una qualunque (e una sola) occorrenza di x ;
   //richiede x!= null;
   public void remove(Object x) throws IllegalStateException
   {
      if(x == null)
       throw new IllegalStateException();
       Object[] setInsieme = s.toArray();
       boolean done = false;
      for(int i = 0;i<setInsieme.length && !done;i++)
      {
         Coppia pair = (Coppia)setInsieme[i];
         if(pair.obj.equals(x));  //o pair.equals(x) cambiando equals
         {  
            if(pair.i>1)
            {
            done = true;
            pair.i--;
            }
         }
      }
      if(!done)
        throw new IllegalStateException();
   }

   //restituisce la molteplicita' di x, cioe' il numero di elementi E di this per i quali x.equals(E) vale true
   //richiede x!= null;
   public int molt(Object x)
   {
      if(x == null)
        return 0;
      Object[] setInsieme = s.toArray();
      for(int i=0;i<setInsieme.length;i++)
      {
        Coppia pair = (Coppia)setInsieme[i];
        if(pair.obj.equals(x)) //o pair.equals(x) cambiando equals
          return pair.i;
      }
      return 0;
   }
   public void makeEmpty()
   {
      s.makeEmpty();
   }
   public boolean isEmpty()
   {
     return s.isEmpty();
   }
	public String toString() {
		String str="";
		Object[] c = s.toArray();
		for (int i=0; i<c.length; i++) {
			str += ((Coppia)c[i]).obj + "," + ((Coppia)c[i]).i + "\n";
		}
		return str;
	}
   // questa classe non puo' avere variabili statiche;
   private class Coppia    //classe interna a MyMultiSet
   {
     //rappresenta una coppia (Object,int)
     Object obj;
     int i;

     Coppia(Object o, int m)
     {  obj=o; i= m;
     }

     public boolean equals(Object z)   //e' necessario sovrascrivere equals
     {
        if(!(z instanceof Coppia))
           return false;
        Coppia pair = (Coppia)z;
        if(pair.obj.equals(this.obj) && pair.i == this.i)
           return true;
        return false;
     }

   }
   private MySet s; // non ci possono essere altre variabili di esemplare
}
