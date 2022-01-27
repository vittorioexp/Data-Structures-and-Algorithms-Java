public class MDM {
	
	private int dimensions;
	private int arrayLength;
	private char[] matrix;
	
	public MDM(int dimensions, int array_length) {
		this.dimensions = dimensions;
		this.arrayLength = arrayLength;
		matrix = new matrix[];
	}
	public void setDimensions(int dimensions) {
		this.dimensions = dimensions;
	}
	public void setArrayLength(int arrayLength) {
		this.arrayLength = arrayLength;
	}
	public int getDimensions(int dimensions) {
		return this.dimensions;
	}
	public int getArrayLength(int arrayLength) {
		return this.arrayLength;
	}
	public void loadMatrix(char[] vect) {
		
	}
}