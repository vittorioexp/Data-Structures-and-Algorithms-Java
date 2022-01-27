import java.util.*;
public class Main2 {
	public static void main (String[] args) {
		MioTC tc = new MioTC();
		Scanner sc = new Scanner(System.in);
		String str;
		while (!(str=sc.nextLine()).equals("")) {
			try {
				Scanner tk = new Scanner(str);
				String valuta = tk.next();
				double valore = Double.parseDouble(tk.next());
				tc.setChange(valuta, valore);
			} catch (NumberFormatException e) {
				System.out.println("Not a number\nTry again");
			}
		}
		double bilancio = 0;
		String operazione = "+";
		while (true) {
			try {
				str = sc.nextLine();
				Scanner tk = new Scanner(str);
				double numero = Double.parseDouble(tk.next());
				String valuta = tk.next();
				if (operazione.equals("-")) {
					numero *= -1;
				}
				try {
					bilancio += numero * tc.euro(valuta);
				} catch (CurrencyNotFound e) {
					System.out.println("Unknown currency\nTry again");
				}
				operazione = tk.next();
				if (operazione.equals("=")) {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Not a number\nTry again");
			}
		}
		System.out.println(bilancio);
	}
}