import java.io.*;
public class StudentContainerTester {
	public static void main(String[] args) {
		if (args.length!=2) {
			System.out.println("$java StudentContainerTester <inputfile.txt> <outputfile.txt>");
			System.exit(1);
		}
		try {
			StudentContainer cont = new StudentContainer(args[0]);
			FileWriter fw = new FileWriter(args[1]);
			PrintWriter pw = new PrintWriter(fw);
			while (!cont.isEmpty()) {
				Student s = (Student) cont.removeMax();
				//System.out.println(s);
				pw.println(s.getNome() + ":" + s.getMatricola());
			}
			pw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
	}
}