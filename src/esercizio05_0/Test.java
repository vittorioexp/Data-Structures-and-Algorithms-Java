import java.util.Scanner;

public class Test {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		double v[] = new double[10];
		System.out.println("Array input: ");
		for (int i=0; i<v.length; i++) {
			v[i]=sc.nextDouble();
		}
		System.out.print("Hai inserito i valori ");
		printArray(v);
		System.out.print("Index to remove: ");
		int indexSenzaOrd = sc.nextInt();
		if (indexSenzaOrd >= 0 && indexSenzaOrd < v.length) {
			v = AlgoritmiArray.eliminaSenzaOrd(v, indexSenzaOrd);
			System.out.print("Array con valore eliminato senza ordine: ");
			printArray(v);
			v = selectionSort(v);
			System.out.print("Array ordinato con selection sort: ");
			printArray(v);
			System.out.print("Index to remove: ");
			int indexConOrd = sc.nextInt();
			if (indexConOrd >= 0 && indexConOrd < v.length) {
				v = AlgoritmiArray.eliminaConOrd(v, indexConOrd);
				System.out.print("Array con valore eliminato con ordine: ");
				printArray(v);
			} else {
				System.out.println("Indice non valido");
			}
		} else {
			System.out.println("Indice non valido");
		}
	}
	public static void printArray(double v[]) {
		for (int i=0; i<v.length; i++) {
			System.out.print(v[i] + " ");
		}
		System.out.print("\n");
	}
	public static double[] selectionSort(double v[]) {
		for (int i=0; i<v.length-1; i++) {
			// Trova il minimo
			double min = v[i];
			int minPos = i;
			for (int j=i; j<v.length; j++) {
				if (v[j]<min) {
					min = v[j];
					minPos = j;
				}
			}
			if (v[i]!=min) {
				double temp = v[minPos];
				v[minPos] = v[i];
				v[i] = temp;
			}
		}
		return v;
	}
}