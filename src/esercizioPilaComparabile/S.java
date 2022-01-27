public class S implements Stack {
	
	private Object[] v;
	private int vSize;
	
	
	public S() {
		v=new Object[1];
		makeEmpty();
	}
	 /**
      @return true se il contenitore e' vuoto, false altrimenti
   */
	public boolean isEmpty() {
		return vSize==0;
	}
  
	public void makeEmpty() {
		vSize=0;
	}
  
    /**
    ispeziona, estraendolo, l'elemento in cima alla pila
    @return l'elemento in cima alla pila
    @throws java.util.EmptyStackException se la pila e' vuota
  */
  public Object pop() throws java.util.EmptyStackException {
	  Object obj = top();
	  vSize--;
	  return obj;
  }
  
  /**
    inserisce l'elemento specificato in cima alla pila
    @param x elemento specificato.
    @throws java.lang.IllegalArgumentException se x e' null   
  */
  public void push(Comparable x) {
	  if (vSize==v.length) {
		  v = resize(v, vSize*2);
	  }
	  v[vSize++] = (Object) x;
  }
  
  private static Object[] resize(Object[] src, int length) {
	  Object[] dst = new Object[length];
	  for (int i=0; i<src.length && i<dst.length; i++) {
		 dst[i]=src[i]; 
	  }
	  return dst;
  }
  
  /**
     @return numero di elementi presenti nella pila
  */
  public int size() {
	  return vSize;
  }
  
  /**
    ispeziona, senza estrarlo, l'elemento in cima alla pila
    @return l'elemento in cima alla pila
    @throws java.util.EmptyStackException se la pila e' vuota
  */
  public Object top() throws java.util.EmptyStackException {
	  if (isEmpty()) {
		  throw new java.util.EmptyStackException();
	  }
	  return v[vSize-1];
  }
   
  /**
    restituisce un array contenente gli elementi presenti nella pila ordinati in senso crescente
    @return array contenente gli elementi presenti nella pila in ordine crescente
     */
  public Object[] toSortedArray() {
	  return mergeSort(v);
  }
  private static Object[] mergeSort(Object[] s) {
	 if (s.length==1) {
		 return s;
	 }
	int mid = (s.length+1)/2;
	Object[] left, right;
	left = arrayCopy(s, 0, mid);
	right = arrayCopy(s, mid, s.length);
	mergeSort(left);
	mergeSort(right);
	return merge(left, right);
  }
  private static Object[] merge(Object[] a, Object[] b) {
	int i=0, j=0, k=0;
	Object[] c = new Object[a.length + b.length];
	while (i<a.length && j<b.length) {
		if (a[i]==null)  {i++;}
		else if (b[j]==null) {j++;}
		else {
			if (((Comparable) a[i]).compareTo(b[j])<0) {
				c[k++]=a[i++];
			} else if (((Comparable) a[i]).compareTo(b[j])>0) {
				c[k++]=b[j++];
			} else {
				c[k++]=a[i++];
				j++;
			}
		}
	}
	while (i<a.length) {
		if (a[i]==null) {i++;}
		else {c[k++]=a[i++];}
	}
	while (j<b.length) {
		if (b[j]==null)  {j++;}
		else {c[k++]=b[j++];}
	}
	return resize(c, k);
  }
  private static Object[] arrayCopy(Object[] src, int from, int to) {
	  Object[] dst = new Object[to-from];
	  int i=0, j=from;
	  while (j<to) {
		  dst[i++]=src[j++]; 
	  }
	  return dst;
  }
  public int compareTo(Object s) {
	  return this.size()-((Stack) s).size();
  }
} 