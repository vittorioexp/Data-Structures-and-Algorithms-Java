public class QuadraticEquation {
	private double a;
	private double b;
	private double c;
	public QuadraticEquation() {
		a=0;
		b=0;
		c=0;
	}
	public QuadraticEquation(double a, double b, double c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public void setCoeff(double a, double b, double c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public boolean hasNoSolutions() {
		if (a==0 && b==0 && c!=0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean hasOneSolution() {
		if (a==0 && b!=0 && !this.hasTwoSolutions() && !this.hasNoSolutions()) {
			return true;
		} else {
			return false;
		}
	}
	public boolean hasTwoSolutions() {
		if (a!=0 && b!=0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean hasInfiniteSolutions() {
		if (a==0 && b==0 && c==0) {
			return true;
		} else {
			return false;
		}
	}
	public double getSolution() {
		double res;
		if (this.hasOneSolution()) {
			res = (- b + Math.sqrt(Math.pow(b,2)-4*a*c) ) / (2*a);
		} else {
			res = 0;
		}
		return res;
	}
	public double getFirstSolution() {
		double res;
		if (this.hasTwoSolutions()) {
			res = (- b + Math.sqrt(Math.pow(b,2)-4*a*c) ) / (2*a);
		} else {
			res = 0;
		}
		return res;
	}
	public double getSecondSolution() {
		double res;
		if (this.hasTwoSolutions()) {
			res = (- b - Math.sqrt(Math.pow(b,2)-4*a*c) ) / (2*a);
		} else {
			res = 0;
		}
		return res;
	}
}