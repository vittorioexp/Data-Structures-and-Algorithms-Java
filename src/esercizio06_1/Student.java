public class Student {
	private String cognome;
	private double voto_scritto;
	private double voto_orale;
	public Student(String cognome, double voto_scritto, double voto_orale) {
		this.cognome=cognome;
		this.voto_scritto=voto_scritto;
		this.voto_orale=voto_orale;
	}
	public String getCognome() {
		return this.cognome;
	}
	public double getVotoScritto() {
		return this.voto_scritto;
	}
	public double getVotoOrale() {
		return this.voto_orale;
	}
	public String toString() {
		return this.cognome + " " + voto_scritto + " " + voto_orale;
	}
}