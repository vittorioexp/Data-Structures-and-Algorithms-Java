/** 
 La classe fornisce uno strumento per misurare il tempo di esecuzione
	 di un programma
*/

public class Cronometro{
	private long tempoiniziale;
	private long tempofinale;
	
	public void start(){
		tempoiniziale = System.currentTimeMillis();
	}
	
	public void stop(){
		tempofinale = System.currentTimeMillis();
		
	}

	public long tempotrascorso (){
		return tempofinale - tempoiniziale;
		
	}
	
	public long inizio (){
		return tempoiniziale;
		
	}
	
	public long fine (){
		return tempofinale;
		
	}
}//fine classe