import java.util.Scanner;
public class Esercizio09_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner tk = new Scanner(sc.nextLine());
		Stack stack = new ArrayStack();
		try {
			String in;
			while (tk.hasNext()) {
				in = tk.next();
				System.out.println(in + "**");
				stack.push(Integer.parseInt(in));
			}
			stack = removeDuplicates(stack);
			while (!stack.isEmpty()) {
				System.out.println(stack.pop());
				
			}
		} catch (NumberFormatException e) {
			System.out.println("Not a number");
			System.exit(1);
		}
	}
	public static Stack removeDuplicates(Stack st) {
		Stack tmp = new ArrayStack();
		Object a = null;
		Object b = null;
		while (!st.isEmpty()) {
			a = st.pop();
			if (b!=null && !a.equals(b)) {
				tmp.push(b);
			} 
			b=a;
		}
		tmp.push(b);
		while (!tmp.isEmpty()) {
			st.push(tmp.pop());
		}
		return st;
	}
}