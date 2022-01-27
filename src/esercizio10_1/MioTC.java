public class MioTC implements TC {
	private class Pair {
		private String key;
		private double val;
		public Pair() {
			key="";
			val=0;
		}
		public Pair(String k, double v) {
			key=k;
			val=v;
		}
		public String getKey() {
			return key;
		}
		public double getVal() {
			return val;
		}
	}
	private Pair[] p = new Pair[1];
	private int pSize=0;
	public void  setChange(String valuta, double valore) {
		//Insert
		try {
			remove(valuta);
		} catch (CurrencyNotFound e) {}
		if (pSize==p.length) {
			p = resize(p, pSize*2);
		}
		p[pSize++] = new Pair(valuta, valore);
	}
	public double euro(String valuta) throws CurrencyNotFound {
		//Find
		for (int i=0; i<pSize; i++) {
			if (p[i].getKey().equals(valuta)) {
				return p[i].getVal();
			}
		}
		throw new CurrencyNotFound();
	}
	private void remove(String valuta) {
		//Remove
		if (valuta==null) {
			throw new IllegalArgumentException();
		}
		for (int i=0; i<pSize; i++) {
			if (p[i].getKey().equals(valuta)) {
				p[i] = p[--pSize];
				return;
			}
		}
		throw new CurrencyNotFound();
		
	}
	private Pair[] resize(Pair[] a, int length) {
		Pair[] b = new Pair[length];
		for (int i=0; i<a.length && i<b.length; i++) {
			b[i]=a[i];
		}
		return b;
	}
}