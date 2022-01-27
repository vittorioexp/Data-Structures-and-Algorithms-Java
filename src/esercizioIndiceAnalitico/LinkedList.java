public class LinkedList {
	private class ListNode {
		private int value;
		private ListNode next;
		public ListNode() {
			value=0;
			next=null;
		}
		public ListNode(int v, ListNode n) {
			value=v;
			next=n;
		}
		public int getValue() {
			return value;
		}
		public ListNode getNext() {
			return next;
		}
		public void setValue(int v) {
			value=v;
		}
		public void setNext(ListNode n) {
			next=n;
		}
	}
	private ListNode head, tail;
	public LinkedList() {
		head = tail = new ListNode(0, null);
	}
	//getFirst
	public int getFirst() {
		return head.getNext().getValue();
	}
	//getLast
	public int getLast() {
		return tail.getValue();
	}
	//addFirst
	public void addFirst(int v) {
		head.setValue(v);
		head = new ListNode(0, head);
	}
	//addLast
	public void addLast(int v) {
		ListNode n = new ListNode(v, null);
		tail.setNext(n);
		tail = n;
	}
	//removeFirst
	public int removeFirst() {
		int v = head.getNext().getValue();
		head = head.getNext();
		head.setValue(0);
		return v;
	}
	//removeLast    O(n)
	public int removeLast() {
		ListNode tmp = head;
		while (tmp.getNext()!=tail) {
			tmp = tmp.getNext();
		}
		int v = tmp.getNext().getValue();
		tmp.setNext(null);
		tail = tmp;
		return v;
	}
	//toString     O(n)
	public String toStringLinkedList() {
		String str="";
		ListNode tmp = head;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			str += tmp.getValue() + ", ";
		}
		return (str.substring(0, str.length()-2));
	}
}