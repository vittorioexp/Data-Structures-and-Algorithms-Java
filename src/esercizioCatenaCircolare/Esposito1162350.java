import java.util.Scanner;
public class Esposito1162350 {
	public static void main (String[] args) {
		CircularChain chain = new CircularChain();
		Scanner sc = new Scanner(System.in);
		int count=0;
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			chain.add((Object) line);
			count++;
		}
		for (int j=0; j<((int) count/3); j++) {
			try { chain.remove(); }
			catch (IllegalStateException e) {}
		}
		Object[] v = chain.toArray();
		for (int i=0; i<v.length-1; i++) {
			int pos = i;
			for (int j=i+1; j<v.length; j++) {
				if (((String)v[j]).compareTo((String)v[pos])>0) {
					pos=j;
				}
			}
			if (pos!=i) {
				Object tmp = v[pos];
				v[pos] = v[i];
				v[i] = tmp;
			}
		}
		for (int i=0; i<v.length; i++) { 
			System.out.println(v[i]);
		}
	}
}
class CircularChain {
	private class ListNode {
		private ListNode next, prev;
		private Object element;
	}
	private ListNode head;
	public CircularChain() {
		head = null;
	}
	public void add(Object x) {
		ListNode tmp = new ListNode();
		tmp.element=x;
		if (head!=null) {
			tmp.prev=head.prev;
			tmp.next=head;
			head.prev.next=tmp;
			head.prev=tmp;
		} else {
			tmp.prev=tmp.next=tmp;
		}
		head=tmp;
	}
	public void remove() throws IllegalStateException  {
		if (head==null) {
			throw new IllegalStateException ();
		}
		head.prev=head.prev.prev;
	}
	public Object[] toArray() {
		Object[] obj = new Object[1];
		ListNode tmp = head;
		int i=0;
		while (tmp!=null && tmp.next!=head) {
			if (i==obj.length) {
				Object[] arr = new Object[obj.length*2];
				System.arraycopy(obj,0,arr,0,obj.length);
				obj = arr;
			}
			tmp = tmp.next;
			obj[i++] = tmp.element;
		}
		Object[] arr = new Object[i];
		System.arraycopy(obj,0,arr,0,i);
		return arr;
	}
}