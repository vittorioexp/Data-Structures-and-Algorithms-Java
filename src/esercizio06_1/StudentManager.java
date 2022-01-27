import java.util.Scanner;

public class StudentManager {
	public static void main (String[] args) {
		Student[] studenti = new Student[10];
		Scanner sc = new Scanner(System.in);
		int i = 0;
		do {
			try {
			System.out.print("Input: ");
			String str;
			if (sc.hasNextLine()) {
				String tmp = sc.nextLine();
				if (tmp.equals("")) {
					break;
				}
				Scanner t = new Scanner(tmp);
				String cognome = t.next();
				double voto_scritto = Double.parseDouble(t.next());
				double voto_orale = Double.parseDouble(t.next());
				
				System.out.println(i + ">=" + studenti.length);
				if (i >= studenti.length) {
					studenti = resize(studenti);
				}
				Student st = new Student(cognome, voto_scritto, voto_orale);
				studenti[i] = st;
				i++;
			}
			} catch (IllegalArgumentException e) {};
		} while (true);
		
		for (int j=0; j<i; j++) {
			System.out.print(studenti[j].getCognome() + " ");
			System.out.print(studenti[j].getVotoScritto() + " ");
			System.out.println(studenti[j].getVotoOrale());
		}
		
		do {
			System.out.print("Comando: ");
			if (sc.hasNextLine()) {
				String str = sc.nextLine();
				if (str.equals("Q")) {
					System.exit(0);
				} else if (str.equals("S")) {
					System.out.print("Inserire cognome: ");
					String cognome = sc.nextLine();
					int pos = -1;
					for (int j=0; j<i; j++) {
						if (cognome.equals(studenti[j].getCognome())) {
							pos = j;
							break;
						}
					}
					if (pos!=-1) {
						double media = (studenti[pos].getVotoScritto() + studenti[pos].getVotoOrale())/2;
						System.out.println(media);
					} else {
						System.out.println("Cognome non presente");
					}
				} else {
					System.out.println("Comando errato");
				}
				
			}
		} while (true);
	}
	
	public static Student[] resize(Student[] s) {
		Student[] n = new Student[s.length*2];
		for (int i=0; i<s.length; i++) {
			String cognome = s[i].getCognome();
			double scritto = s[i].getVotoScritto();
			double orale = s[i].getVotoOrale();
			Student st = new Student(cognome, scritto, orale);
			n[i] = st;
		}
		return n;
	}
	
	
}