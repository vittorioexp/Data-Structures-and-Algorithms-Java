import java.util.Scanner;
public class Esercizio03_6 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputStr = "";
		double sum = 0;
		double quadratic_sum = 0;
		int number = 0;
		boolean condition = true;
		do {
			inputStr = sc.nextLine();
			if (!inputStr.equals("q")) { 
				double value = Double.parseDouble(inputStr);
				sum += value;
				quadratic_sum += Math.pow(value, 2);
				number++;
			} else {
				condition = false;
			}
		} while (condition);
		double deviation = Math.sqrt((quadratic_sum - sum*sum/number)/(number - 1));
		double medium_value = sum / number;
		System.out.println("Sum: " + sum);
		System.out.println("Quadratic Sum: " + quadratic_sum);
		System.out.println("Number: " + number);
		System.out.println("Deviation: " + deviation);
		System.out.println("Medium value: " + medium_value);
	}
}