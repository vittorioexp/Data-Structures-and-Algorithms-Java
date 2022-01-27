import java.io.*;
import java.util.*;
public class SortedContainerTester {
	public static void main(String[] args) {
		SortedContainer c = new SortedContainer();
		if (args.length!=2) {
			System.out.println("Invalid args length");
			System.exit(1);
		}
		try {
		FileReader fr = new FileReader(args[0]);
		Scanner sc = new Scanner(fr);
		
		while (sc.hasNextLine()) {
			String data;
			data = sc.nextLine();
			Scanner tk = new Scanner(data).useDelimiter(":");
			String name = tk.next();
			int matr = -1;
			try {
			matr = Integer.parseInt(tk.next());
			} catch (NumberFormatException e) {
				System.out.println("Invalid matricola");
				System.exit(1);
			}
			Student s = new Student(name, matr);
			c.add(s);
		}
		sc.close();
		fr.close();
		
		FileWriter fw = new FileWriter(args[1]);
		PrintWriter pw = new PrintWriter(fw);
		while (!c.isEmpty()) {
			pw.println(c.removeMax());
		}
		fw.close();
		pw.close();
		} catch (IOException e) {
			System.out.println("File not found");
			System.exit(1);
		} 
	}
}