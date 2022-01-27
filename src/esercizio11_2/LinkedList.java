public class LinkedList implements List {
	public static void main(String[] args) {  
		
		LinkedList list = new LinkedList();
   		list.addFirst("A");
   		list.addLast("B");
   		list.addFirst("C");
   		ListIterator iter = list.getIterator();
   		iter.next();
   		iter.add("I");
   		while (iter.hasNext())
      			iter.next();
   		iter.remove();
   		list.addLast("O");
   		iter = list.getIterator();
   		while (iter.hasNext())
     	 		System.out.print(iter.next());
	
		
	}	
	private class ListNode {
		ListNode next;
		Object element;
		public ListNode() {
			next=null;
			element=null;
		}
		public ListNode(ListNode c, Object o) {
			next=c;
			element=o;
		}
		public void makeEmpty() {
			next=null;
			element=null;
		}
		public void setNext(ListNode n) {
			next=n;
		}
		public void setElement(Object o) {
			element=o;
		}
		public ListNode getNext() {
			return next;
		}
		public Object getElement() {
			return element;
		}
	}
	private class LinkedListIterator implements ListIterator {
		private ListNode current, previous;
		public LinkedListIterator (ListNode h) {
			current=h;
			previous=null;
		}
		public Object next() {
			if (!hasNext()) {
				throw new IllegalStateException();
			}
			previous = current;
			current = current.getNext();
			return current.getElement();
		}
		public boolean hasNext() {
			return current.getNext()!=null;
		}
		public void add(Object obj) {
			ListNode tmp = new ListNode(current.getNext(), obj);
			current.setNext(tmp);
			previous = current;
			current = current.getNext();
			if (!hasNext()) {
				tail = current;
			}
		}
		public void remove() {
			if (previous==null) {
				throw new IllegalStateException();
			}
			previous.setNext(current.getNext());
			current = previous;
			previous = null;
			if (!hasNext()) {
				LinkedList.this.tail = current;
			}
		}
	}
	private ListNode head, tail;
	public LinkedList() {
		head = new ListNode();
		tail = head;
	}
	public ListIterator getIterator() {
		return new LinkedListIterator(head);
	}
	public void makeEmpty() {
		head = new ListNode();
		tail = head;
	}
	public boolean isEmpty() {
		return head.getNext()==null;
	}
	public void addFirst(Object e) {
		head.setElement(e);
		head = new ListNode(head, null);
	}
	public void addLast(Object e) {
		ListNode n = new ListNode(null, e);
		tail.setNext(n);
		tail = n;
	}

	public Object removeFirst() {
		head = head.getNext();
		Object data = head.getElement();
		head.setElement(null);
		return data;
	} 

	public Object removeLast() {
		Object data = tail.getElement();
		ListNode tmp = head;
		while (tmp.getNext()!=tail) {
			tmp = tmp.getNext();
		}
		tail = tmp;
		tail.setNext(null);
		return data;
	}

	public Object getFirst() {
		return head.getNext().getElement();
	}

	public Object getLast() {
		return head.getElement();
	}

	
}



