import java.util.Scanner;
import java.io.FileReader;
public class SMTester //-- Classe di prova della pila multipla
{  public static void main(String[] args) throws java.io.IOException
   {  Scanner in = new Scanner(new FileReader(args[0]));
      Stack s = new S();                   // pila per memorizzazione temporanea
      
      while(in.hasNext())                 
      {  Scanner tok = new Scanner(in.nextLine()); // lettura di dati da file
         Stack tmp = new S();              // altra pila per memorizzazione temporanea
         while (tok.hasNext())
            tmp.push(tok.next());          // prova del metodo push    
         s.push(tmp);                 
         tok.close();   
      }      
      in.close();
      
      Stack[] sAr = new S[s.size()];        // creazione di un array di pile
      int i = 0;
      while (!s.isEmpty())                  // copia nell'array di pile
         sAr[i++] = (Stack)s.pop();         // prova del metodo pop

      SM sm1 = new SM(sAr);                 // pila multipla popolata con l'array sAr  
      SM sm2 = new SM(sAr.length);          // pila multipla vuota di lunghezza pari a sm1

      System.out.println("***TOTALSIZE SM1 " + sm1.totalSize()); // prova del metodo totalSize
      System.out.println("***SM1***");      // estrazione e stampa degli elementi di sm1
      while (!sm1.isTotallyEmpty())
      {  Object x = sm1.maxPop();           // estrazione  da sm1 e prova del metodo maxPop
         sm2.minPush((Comparable)x);        // inserimento in sm2 e prova del metodo minPush
         s.push((Comparable)x);             // inserimento in s
         System.out.println(x);             // stampa del valore estratto      
      }
      System.out.println("***TOTALSIZE SM1 " + sm1.totalSize()); // prova del metodo totalSize
      System.out.println("***TOTALSIZE SM2 " + sm2.totalSize()); // prova del metodo totalSize
      System.out.println("***SM2***");      // estrazione e stampa degli elementi di sm2
      while (!sm2.isTotallyEmpty())
         System.out.println(sm2.maxPop());  // prova del motodo maxPop
      System.out.println("***TOTALSIZE SM2 " + sm2.totalSize()); // prova del metodo totalSize
               
      System.out.println("***SORT***");
      Object[] v = s.toSortedArray();       // prova del metodo toSortedArray
      for(i = 0; i < v.length; i++)
         System.out.println(v[i]);                          
   }
}