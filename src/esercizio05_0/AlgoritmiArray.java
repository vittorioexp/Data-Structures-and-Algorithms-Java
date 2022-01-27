public class AlgoritmiArray {
	
	public static double[] eliminaSenzaOrd (double[] v, int indexToRemove) {
		v[indexToRemove] = v[v.length - 1];
		return resize(v, v.length - 1);
	}
	public static double[] eliminaConOrd(double[] v, int indexToRemove) {
		for (int i = indexToRemove; i<v.length-1; i++) {
			v[i] = v[i+1];
		}
		return resize(v, v.length - 1);
	}
	private static double[] resize(double[] v, int newDim) {
		double c[] = new double[newDim];
		for (int i=0; i<newDim; i++) {
			c[i] = v[i];
		}
		return c;
	}
}