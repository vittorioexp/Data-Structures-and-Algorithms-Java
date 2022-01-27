import java.io.*;
import java.util.*;
public class IntSorter {
	public static void main (String[] args) {
		if (args.length!=2) {
			System.exit(1);
		} 
		int n = -1;
		String str = args[1];;
		try {
			n = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("Not a number");
			System.exit(1);
		}
		SortedArray sa = new SortedArray();
		for (int i=0; i<n; i++) {
			int rnd =  (int)(1 + n*Math.random());
			sa.add(rnd);
			System.out.println(rnd);
		}
		try {
			System.out.println("\nAvg: "+sa.avg());
			System.out.println("Max: "+sa.removeMax());
			try {
				FileWriter fw = new FileWriter(str);
				PrintWriter pw = new PrintWriter(fw);
				for (int i=0; i<n-1; i++) {
					pw.println(sa.removeMax());
				}
				pw.close();
				fw.close();
			} catch (IOException e) {
				System.out.println("Wrong namefile");
				System.exit(1);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Empty array");
			System.exit(1);
		}
	}
}