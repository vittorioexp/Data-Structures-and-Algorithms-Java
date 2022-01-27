import java.util.Scanner;
public class Esposito1162350 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner tk;
		Dictionary diz = new Dictionary();
		int row=1;
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			String[] vect = str.split("[-<>'() ,.0123456789]/*");
			for (int i=0; i<vect.length; i++) {
				tk = new Scanner(vect[i]);
				while (tk.hasNext()) {
					String tmp = tk.next();
					if (tmp.length()>3) {
						diz.insert(tmp, row);
					}
				}
			}
			row++;
		}
		System.out.print(diz.toString());
	}
}