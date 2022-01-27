import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		CD uno = new MiaCD();
		CD due = new MiaCD();
		CD tre = new MiaCD();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			int num = 0;
			try {
				num = Integer.parseInt(line);
			} catch (NumberFormatException e) {
				System.out.println("Not a number");
				System.exit(1);
			}
			uno.addLast(new Integer(num));
		}
		while (!uno.isEmpty()) {
			due.addFirst(uno.removeLast());
		}
		while (!due.isEmpty()) {
			tre.addLast(due.removeFirst());
		}
		while (!tre.isEmpty()) {
			System.out.println(tre.removeFirst());
		}
	}
}