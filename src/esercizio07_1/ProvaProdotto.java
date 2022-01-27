//Classe di prova della classe Prodotto

public class ProvaProdotto{

	public static void main(String [] arg){

/* poiche' ci sono due costruttori, si definiscono due oggetti 
*/
		Prodotto primo ;	
		Prodotto secondo ;


//attivare il primo costruttore, ad esempio .... new Prodotto("libro");
		primo = new Prodotto("libro");
		
		
//attivare il secondo costuttore
		secondo = new Prodotto("quaderno", 2.99);
		
//uso dei metodi di accesso; stampare i dati dei due oggetti
		System.out.println(primo.getNome() + ", " + primo.getPrezzo());
		System.out.println(secondo.getNome() + ", " + secondo.getPrezzo());
		
//uso del metodo di modifica
		primo.incrementPrice(2.1);
		secondo.incrementPrice(3.2);

//stampare i dati dei due oggetti e verificare che i dati sono cambiati
		System.out.println(primo.getNome() + ", " + primo.getPrezzo());
		System.out.println(secondo.getNome() + ", " + secondo.getPrezzo());

	}//fine main

}// fine classe ProvaProdotto