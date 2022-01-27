public class MyTriangle
{
	private double a;
	private double b;
	private double c;
   /*
      Costruttore della classe MyTriangle
   */
   public MyTriangle(double la, double lb, double lc) {
	   // inizializzazione delle variabili di esemplare
        a = la;
        b = lb;
        c = lc;
    
        // Ordinamento dei lati c >= b >= a
        if (a > b)       //se a > b scambio a con b
        {
            double tmp = b;
            b = a;
            a = tmp;
        }
        if (a > c)       //se a > c scambio a con c
        {
            double tmp = c;
            c = a;
            a = tmp;
        }
        if (b > c)       //se b > c scambio b con c
        {
             double tmp = c;
             c = b;
             b = tmp;
        }
   }

   /*
      restituisce informazioni sul triangolo. le informazioni sono relative
      ai lati:     equilatero,  isoscele,    scaleno.
      agli angoli: acutangolo,  rettangolo,  ottusangolo.
      Esempio: per il triangolo di lati 3, 4, 5 restituisce la stringa
      "scaleno rettangolo".
   */
   public String info()
   {
	    if (a + b <= c)
            return "non e' un triangolo!";
		String txt = "";
		if (a==b && b==c) {
			txt += "Equilatero";
		} else if (a!=b && b!=c && c!=a) {
			txt += "Scaleno";
		} else {
			txt += "Isoscele";
		}
		// Classificazione secondo gli angoli
        if (c * c - a * a - b * b == 0)  // Rettangolo: un angolo di 90 gradi
            txt += " rettangolo";
        else if ( c * c - a * a - b * b < 0) //Acutangolo: tutti gli angoli 
            txt += " acutangolo";        //inferiori a 90 gradi
        else  // Ottusangolo: un angolo superiore a 90 gradi
            txt +=  " ottusangolo";
		return txt;
   }
   
   /*
      restituisce una stringa contenente una descrizione testuale dell'oggetto
      nel formato T(a, b, c)
      Esempio "T(3, 4, 5)"
   */
   public String toString()
   {
	   return "T(" + a + ", " + b + ", " + c + ")";
   }

    /*
       calcola e restituisce l'area del triangolo.
       Usa la formula di Erone:
            area * area = p * (p - a) * (p - b) * (p - c)
       dove p e` il semiperimetro, ovvero p = (a + b + c) / 2
    */
    public double area()
    {
		double p = (a+b+c)/2;
		double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		return area;
    }
   
    /*
       calcola e restituisce l'altezze del triangolo relativa al lato maggiore:
    */
    public double h()
    {
		return 2*area()/c;
    }

}