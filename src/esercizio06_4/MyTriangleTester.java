import java.util.Scanner;

public class MyTriangleTester
{
   public static void main (String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print ("Introduci lati a, b, c: ");
      double a = in.nextDouble();
      double b = in.nextDouble();
      double c = in.nextDouble();

      MyTriangle triangolo = new MyTriangle(a, b, c);

      System.out.println("Triangolo: " + triangolo.info());
      System.out.println("area = " + triangolo.area());
      System.out.println("altezza = " + triangolo.h());
   }
}