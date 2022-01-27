import java.util.Scanner;
public class QuadraticEquationTester {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		QuadraticEquation EQ = new QuadraticEquation();
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		EQ.setCoeff(a,b,c);
		if (EQ.hasTwoSolutions()) {
			System.out.println("Two solutions");
			System.out.println(EQ.getFirstSolution());
			System.out.println(EQ.getSecondSolution());
		} else if (EQ.hasOneSolution()) {
			System.out.println("One solution");
			System.out.println(EQ.getSolution());
		} else if (EQ.hasInfiniteSolutions()){
			System.out.println("Infinite solutions");
		} else {
			System.out.println("No solutions");
		}
	}
}