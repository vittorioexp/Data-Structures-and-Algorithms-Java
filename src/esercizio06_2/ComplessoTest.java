import java.util.Scanner;

public class ComplessoTest
{
   public static void main(String[] args)
   {    //acquisizione da standard input
        Scanner in = new Scanner(System.in);
      
        System.out.println("Inserire parte reale e immaginaria nella");
        System.out.println("stessa riga, separandoli con uno spazio\n");      

        // creazione del primo numero complesso
        System.out.print("numero complesso a = ");
        double aRe = in.nextDouble();
        double aIm = in.nextDouble();
        Complesso a = new Complesso(aRe, aIm);

        // creazione del secondo numero complesso
        System.out.print("numero complesso b = ");
        double bRe = in.nextDouble();
        double bIm = in.nextDouble();
        Complesso b = new Complesso(bRe, bIm);

        // test dei metodi di Complesso e visualizzazioni sullo standard output
        System.out.println("a = " + a + " , b = " + b);
        System.out.println("a + b = " + a.add(b));
        System.out.println("a - b = " + a.sub(b));
        System.out.println("a * b = " + a.mult(b));
        System.out.println("a / b = " + a.div(b));
        System.out.println("1 / a = " + a.inv());
        System.out.println("1 / b = " + b.inv());
        System.out.println("a^ = " + a.conj());
        System.out.println("b^ = " + b.conj());
        System.out.println("|a| = " + a.mod());
        System.out.println("|b| = " + b.mod());
        System.out.println("re(a) = " + a.getRe());
        System.out.println("re(b) = " + b.getRe());
        System.out.println("im(a) = " + a.getIm());
        System.out.println("im(b) = " + b.getIm());
        /*
          Quando il compilatore deve concatenare una stringa e un oggetto di tipo
          Complesso, trasforma quest ultimo in una stringa invocando implicitamente
          il metodo toString della classe Complesso: lo vedremo piu' avanti
        */
   }
}