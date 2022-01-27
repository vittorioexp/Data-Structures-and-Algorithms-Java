import java.util.Scanner;
public class Esercizio08_4 {
	public static void main(String[] args) {
		System.out.println("Inserire i numeri sulla stessa riga, separati dal carattere spazio (' ')");
		Scanner sc = new Scanner(System.in);
		ArrayStack a = new ArrayStack();
		String str;
		if (sc.hasNextLine()) {
			str = sc.nextLine();
			Scanner tk = new Scanner(str);
			while (tk.hasNext()) {
				try {
					int num = Integer.parseInt(tk.next());
					a.push(num);
				} catch (NumberFormatException e) {
					System.out.println("Not a integer number!");
					System.exit(1);
				}
			}
		}
		try {
			a = reverseNew(a);
			//a = reverseOld(a);
			while (!a.isEmpty()) {
				System.out.println(a.pop());
			}
		} catch(EmptyStackException e) {
			System.out.println("Stack is emtpy!");
			System.exit(1);
		}
		
	}
	public static ArrayStack reverseOld(ArrayStack a) {
		if (a.isEmpty()) {
			throw new EmptyStackException();
		}
		ArrayStack b = new ArrayStack();
		ArrayStack c = new ArrayStack();
		while (!a.isEmpty()) {
			b.push(a.pop());
		}
		while (!b.isEmpty()) {
			c.push(b.pop());
		}
		while (!c.isEmpty()) {
			a.push(c.pop());
		}
		return a;
	}
	public static ArrayStack reverseNew(ArrayStack a) {
		if (a.isEmpty()) {
			throw new EmptyStackException();
		}
		ArrayStack b = new ArrayStack();
		int count = 0;
		//Travaso iniziale: quanti sono gli elementi?
		//Salva su count
		while (!a.isEmpty()) {
			b.push(a.pop());
			count++;
		}
		while (!b.isEmpty()) {
			a.push(b.pop());
		}
		//Inizio algoritmo Inversione
		Object var;
		while (count>0) {
			var = a.pop();
			for (int i=0; i<count-1; i++) {
				b.push(a.pop());
			}
			a.push(var);
			for (int i=0; i<count-1; i++) {
				a.push(b.pop());
			}
			count--;
		}
		return a;
	}
}