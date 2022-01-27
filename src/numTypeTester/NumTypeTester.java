/*
Esempi di arrotondamenti e conversioni tra tipi numerici
*/

public class NumTypeTester
{
    public static void main(String[] args)
    {
	//overflow in somme di int
	System.out.println( "\n***** overflow in somme di int *****");
	int verylargeInt = 2100000000; 
	System.out.println("verylargeInt, un numero intero prossimo a 2^31: " + verylargeInt);
	/*
	 se verylargeInt ha un valore vicino a 2^31 (ovvero 2147500000) la somma (verylargeInt+verylargeInt) produce un 
	risultato inaspettato. Perche'? Ovewflow
	*/
	verylargeInt = verylargeInt + verylargeInt;
	System.out.println("se verylargeInt ha un valore vicino a 2^31 (ovvero 2147500000) la somma (verylargeInt+verylargeInt) produce un risultato inaspettato. Perche'?");
	System.out.println("verylargeInt + verylargeInt: " + verylargeInt);

	//conversione da double a int
	System.out.println("\n***** conversione da double a int*****"); 
	double smallDouble =1.93;
	System.out.println("smallDouble: " + smallDouble);
	// int smallInt = smallDouble;   //cosi` non funziona (provare). Perche`?
	int smallInt = (int) smallDouble; //cosi` si tronca la parte decimale 
	System.out.println("Con il cast a int si tronca la parte decimale");
	System.out.println("smallInt con cast: " + smallInt);
     	// smallInt = Math.round(smallDouble); //cosi` non funziona (provare). Perche`?
	System.out.println("Con Math.round si approssima all'int piu` vicino. ");
	smallInt = (int) Math.round(smallDouble);  //si approssima all'int piu` vicino
	System.out.println("smallInt con Math.round e cast: " + smallInt+":");
	System.out.println("NOTE BENE: Math.round applicato ad un numero double restituisce un numero in formato long");
	
	//conversione da double a long
	System.out.println("\n***** conversione da double a long *****");
	double largeDouble =3e9;
	System.out.println("largeDouble: " + largeDouble);
	// se largeDouble e' piu' grande di 2^31 (ovvero di 2.1475e9) il cast a int produce un risultato inaspettato.
        // Perche`?
	int largeInt = (int) largeDouble; 
	System.out.println("(int) largeDouble: " + largeInt);
	// il cast a long funziona  (e tronca alla parte intera).
        long largeLong = (long) largeDouble; 
	System.out.println(" (long) largeDouble: " + largeLong);

	largeLong = Math.round(largeDouble); 
	// non e` necessario effettuare il cast a long. Perche'?
	System.out.println("Math.round(largeDouble): " + largeLong);

        //errori di arrotondamento in numeri double
	System.out.println( "\n***** errori di arrotondamento in numeri double *****");
	double periodicDouble = 4.35; // 4.35 ha una rappresentazione periodica in base 2 (provare per credere)
	System.out.println("periodicDouble: " + periodicDouble);
	System.out.println("\nl'approssimazione introdotta dalla rappresentazione periodica diventa evidente se moltiplico questo numero per cento volte");
	System.out.print("100*periodicDouble: ");
	System.out.println(100*periodicDouble);
        System.out.println("\nAncora peggio: se converto in formato int il numero double 100*4.35, ottengo il numero intero 434 invece che 435!");
	int periodicint = (int) (100*periodicDouble);//ci vogliono le par. tonde
	System.out.println("(int) (100*periodicDouble): " + periodicint);

	//operazioni tra double "molto grandi"
	System.out.println("\n***** operazioni tra double \"molto grandi\"*****");
	double verylargeDouble1 = 1e15;
	double verylargeDouble2 = verylargeDouble1 +1;
	double result = verylargeDouble2-verylargeDouble1;
 	System.out.println("verylargeDouble1: " + verylargeDouble1);
	System.out.println("verylargeDouble2: " + verylargeDouble2);
	System.out.println("verylargeDouble2-verylargeDouble1: " + result);
	//Provare con verylargeDouble1 piu` grande di 1e16. In questo caso
	//succede che result vale 0 invece che 1. Come e` possibile??

        //operazioni tra double "super grandi"
	System.out.println(        "\n***** overflow con double \"molto molto grandi\"*****");
	double veryverylargeDouble1 = 1e308;
	double veryverylargeDouble2 = veryverylargeDouble1 * 2;
 	System.out.println("veryverylargeDouble1: " + veryverylargeDouble1);
	System.out.println("veryverylargeDouble * 2: " + veryverylargeDouble2);
	//Provare con veryverylargeDouble1 = 1e308. Cosa succede e perche'?
	//Poi provare con veryverylargeDouble1 = 2e308. Cosa succede e perche'?
    }
}