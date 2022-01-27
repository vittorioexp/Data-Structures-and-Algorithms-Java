import java.util.*;
public class ArrayStringSet implements StringSet {
	private String[] v = new String[1];
	private int vSize=0;
	/*
      Restituisce un array di stringhe contenente i riferimenti
      a tutti gli elementi presenti nell'insieme, in ordine
      lessicografico crescente.
   */
   public String[] getElements(){
	   String[] newArr = new String[vSize];
	   for (int i=0; i<vSize; i++) {
		   newArr[i]=v[i];
	   }
	   return newArr;
   }

   /*
      Restituisce true se e solo se la stringa s appartiene
      all'insieme.
   */
   public boolean contains(String s){
	   //Ricerca binaria probabilmente
	   return (binarySearch(s, v, 0, vSize-1)!=-1);
   }
   
   private static int binarySearch(String val, String vett[], int from, int to) {
	   if (from>to) return -1;
	   int mid = (from+to)/2;
	   String middle = vett[mid];
	   if (val.compareTo(middle)==0) {
		   return mid;
	   } else if (val.compareTo(middle)>0) {
		   return binarySearch(val, vett, mid+1, to);
	   } else {
		   return binarySearch(val, vett, from, mid-1);
	   }
   }
   

   /*
      Inserisce la stringa s nell'insieme, se non è già presente,
      altrimenti fallisce silenziosamente.
   */
   public void add(String s){
	   if (contains(s)) {
		   return;
	   }
	   if (vSize==v.length) {
		   v = resize(v, vSize*2);
	   }
	   int i;
	   for (i=vSize; i>0 && s.compareTo(v[i-1])<0; i--) {
			v[i]=v[i-1];
	   }
	   v[i]=s;
	   vSize++;
   }
   
   private static String[] resize(String[] a, int length) {
	   String[] b = new String[length];
	   for (int i=0; i<a.length && i<b.length; i++) {
		   b[i] = a[i];
	   }
	   return b;
   }
   
   public ArrayStringSet union(ArrayStringSet str) {
	   String[] a = this.getElements();
	   String[] b = str.getElements();
	   ArrayStringSet newArr = new ArrayStringSet();
	   int i=0;
	   int j=0;
	   while (i<a.length && j<b.length) {
		   if (a[i].compareTo(b[j])>0) {
			   newArr.add(b[j++]);
		   } else if (a[i].compareTo(b[j])<0) {
			   newArr.add(a[i++]);
		   } else {
			   newArr.add(a[i]);
			   i++;
			   j++;
		   }
	   }
	   //Possibili rimasugli
	   while (i<a.length) {
		   newArr.add(a[i++]);
	   }
	   while (j<b.length) {
		   newArr.add(b[j++]);
	   }
	   return newArr;
   }
   
   public String toString() {
	   String res = "";
	   for (int i=0; i<vSize; i++) {
		   res += v[i] + " ";
	   }
	   return res;
   }
   
   public static void main (String[] args) {
	   ArrayStringSet s1 = new ArrayStringSet();
	   for (int i=0; i<args.length; i++) {
		   s1.add(args[i]);
	   }
	   Scanner sc = new Scanner(System.in);
	   ArrayStringSet s2 = new ArrayStringSet();
	   String str;
	   // Usare Ctrl+z su windows
		while (sc.hasNextLine()) {
			str = sc.nextLine();
		   Scanner tk = new Scanner(str);
		   while (tk.hasNext()) {
			   s2.add(tk.next());
		   }
	   }
	   System.out.println(s1.union(s2).toString());
   }
}