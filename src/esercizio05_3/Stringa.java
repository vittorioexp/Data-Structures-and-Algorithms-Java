public class Stringa {
	
	private char[] c;
	
	public Stringa(String s) {
		if (s == null)  {
			throw new NullPointerException();
		}
		c = s.toCharArray();
	}
	public Stringa(char[] v) {
		c = v;
	}
	public char charAt(int index) {
		if (index<0 || index>=c.length) {
			throw new IllegalArgumentException();
		}
		return c[index];
	}
	public int compareTo(Stringa s) {
		if (s == null) {
			throw new NullPointerException();
		}
		int minLength=0;
		if (this.length() <= s.length()) {
			minLength=this.length();
		} else {
			minLength=s.length();
		}
		int i=0;
		while (i<minLength) {
			if (this.charAt(i) > s.charAt(i)) {
				return 1;
			} else if (this.charAt(i) < s.charAt(i)) {
				return -1;
			}
			i++;
		}
		// A questo punto le stringhe sono uguali, ma forse di lunghezza diversa
		if (this.length() > s.length()) {
			return 1;
		} else if (this.length() < s.length()) {
			return -1;
		} else {
			return 0;
		}
	}
	public Stringa concat(Stringa s) {
		if (s == null) {
			throw new NullPointerException();
		}
		int length = this.length()+s.length();
		char[] v = new char[length];
		for (int i=0; i<this.length(); i++) {
			v[i]=this.charAt(i);
		}
		int offset = this.length();
		for (int i=0; i<s.length(); i++) {
			v[i+offset]=s.charAt(i);
		}
		// Ritorna stringa
		return new Stringa(v);
	}
	public boolean endsWith(Stringa s) {
		if (s == null) {
			throw new NullPointerException();
		}
		boolean endsWith = true;
		int i = this.length() - s.length();
		int j = 0;
		while (i<this.length() && endsWith) {
			if (this.charAt(i)!=s.charAt(j)) {
				endsWith = false;
			}
			i++;
			j++;
		}
		return endsWith;
	}
	public int indexOf(Stringa s) {
		return this.indexOf(s, 0);
	}
	
	public int indexOf(Stringa s, int fromIndex) {
		if (s == null) {
			throw new NullPointerException();
		}
		if (this.length()<s.length()) {
			throw new IllegalArgumentException();
		}
		int i=fromIndex;
		int index = -1;
		boolean found = false;
		while (i<=this.length()-s.length() && !found) {
			int j=i;
			int k=0;
			boolean equals = true;
			while (k<s.length()) {
				if (this.charAt(j)!=s.charAt(k) && equals) {
					equals = false;
				}
				j++;
				k++;
			}
			if (equals) {
				index = i;
				found = equals;
			}
			i++;
		}
		if (!found) return -1;
		else return i-1;
	}
	
	public int lastIndexOf(Stringa s) {
		return this.lastIndexOf(s, 0);
	}
	
	public int lastIndexOf(Stringa s, int fromIndex) {
		if (s == null) {
			throw new NullPointerException();
		}
		if (this.length()<s.length()) {
			throw new IllegalArgumentException();
		}
		int i=fromIndex;
		boolean found = false;
		int index = -1;
		while (i<=this.length()-s.length()) {
			int j=i;
			int k=0;
			boolean equals = true;
			while (k<s.length() && equals) {
				if (this.charAt(j)!=s.charAt(k)) {
					equals = false;
				}
				j++;
				k++;
			}
			if (equals) {
				index = i;
				found = equals;
			}
			
			i++;
		}
		if (!found) return -1;
		else return index;
	}
	
	public int length() {
		return c.length;
	}
	
	public Stringa substring(int beginIndex) {
		return this.substring(beginIndex, this.length());
	}
	
	public Stringa substring(int beginIndex, int endIndex) {
		//Controllo indici
		if (beginIndex>endIndex) {
			throw new IllegalArgumentException();
		}
		int newLength = endIndex - beginIndex;
		char v[] = new char[newLength];
		int i=0;
		int j=beginIndex;
		while (j<endIndex) {
			v[i] = this.charAt(j);
			i++;
			j++;
		}
		return new Stringa(v);
	}
	
}