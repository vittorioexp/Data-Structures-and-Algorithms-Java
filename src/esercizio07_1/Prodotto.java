/**Costruzione di una classe che rappresenta un prodotto commerciale. 
 Un prodotto e' individuato dal suo nome e dal suo prezzo (dati); 
   le operazioni (metodi) che si possono compiere sono: conoscere il nome e 
	il prezzo, modificare il prezzo. 
*/

public class Prodotto{

//dati dell'oggetto

	private String nome;
	private double prezzo;


/*costruttori 
     	1) con solo nome del prodotto
     	2) con nome e prezzo
*/
	public Prodotto(String nome) {
		this.nome=nome;
		this.prezzo=0.0;
	}
	public Prodotto(String nome, double prezzo) {
		this.nome=nome;
		this.prezzo=prezzo;
	}

//metodi di accesso
	
	/* conoscere il nome */
	public String getNome() {
		return this.nome;
	}
	
	/* conoscere il prezzo */
	public double getPrezzo() {
		return this.prezzo;
	}

//metodo modificatore

	/* aumentare il prezzo */
	public void incrementPrice(double amount) {
		this.prezzo+=amount;
	}

}