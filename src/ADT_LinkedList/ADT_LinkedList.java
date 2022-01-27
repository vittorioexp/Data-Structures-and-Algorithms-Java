import java.util.NoSuchElementException;
import java.util.Scanner;
public class ADT_LinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		Stack s = new LinkedStack();
		while (sc.hasNextLine()) {
			s.push(sc.nextLine());
		}
		System.out.println("**Stack**\n" + s.toString() + "\n");
		Queue q = new LinkedQueue();
		while (!s.isEmpty()) {
			q.enqueue(s.pop());
		}
		System.out.println("**Queue**\n" + q.toString() + "\n");
		Dictionary d = new LinkedDictionary();
		int count = 0;
		while (!q.isEmpty()) {
			d.insert(count++, q.dequeue());
		}
		System.out.println("**Dictionary**\n" + d.toString() + "\n");
		Set se = new LinkedSet();
		count=0;
		while (!d.isEmpty()) {
			se.insert(d.find(count));
			d.remove(count++);
		}
		System.out.println("**Set**\n" + se.toString() + "\n");
		
	}
}
class LinkedList implements List {
	public class ListNode {
		private ListNode next;
		private Object element;
		public ListNode() {
			next=null;
			element=null;
		}
		public ListNode(ListNode n, Object e) {
			next=n;
			element=e;
		}
		public void setNext(ListNode n) {
			next=n;
		}
		public void setElement(Object e) {
			element=e;
		}
		public ListNode getNext() {
			return next;
		}
		public Object getElement() {
			return element;
		}
	}
	public class LinkedListIterator implements ListIterator  {
		private ListNode previous, current;
		public LinkedListIterator() {
			previous=null;
			current=head;
		}
		public LinkedListIterator(ListNode h) {
			previous=null;
			current=h;
		}
		public boolean hasNext() {
			return (current.getNext()!=null);
		}
		public Object next() {
			if (!hasNext()) {
				throw new IllegalStateException();
			}
			previous=current;
			current=current.getNext();
			return current.getElement();
		}
		public void add(Object obj) {
			ListNode l = new ListNode(current.getNext(), obj);
			current.setNext(l);
			previous=current;
			current=l;
			if (!hasNext()) {
				LinkedList.this.tail=current;
			}
		}
		public void remove() {
			if (previous==null) {
				throw new IllegalStateException();
			}
			previous.setNext(current.getNext());
			current=previous;
			previous=null;
			if (!hasNext()) {
				LinkedList.this.tail=current;
			}
		}
	}
	private ListNode head, tail;
	public LinkedList() {
		head=tail=new ListNode(null, null);
	}
	public void addFirst(Object obj){
		head.setElement(obj);
		head = new ListNode(head, null);
	}
	public void addLast(Object obj){
		ListNode n = new ListNode(null, obj);
		tail.setNext(n);
		tail=n;
	}
	public Object getFirst(){
		return head.getNext().getElement();
	}
	public Object getLast(){
		return tail.getElement();
	}
	public Object removeFirst(){
		Object obj = getFirst();
		head = head.getNext();
		head.setElement(null);
		return obj;
	}
	public Object removeLast(){
		ListNode tmp = head;
		while (tmp.getNext()!=tail) {
			tmp = tmp.getNext();
		}
		Object obj = tmp.getNext().getElement();
		tail = tmp;
		tail.setNext(null);
		return obj;
	}
	public void makeEmpty(){
		head=tail=new ListNode(null, null);
	}
	public boolean isEmpty(){
		return (head==tail);
	}
	public ListIterator getIterator() {
		return new LinkedListIterator(head);
	}
	
}
class LinkedStack implements Stack {
	List list;
	public LinkedStack() {
		list = new LinkedList();
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	public void makeEmpty(){
		list.makeEmpty();
	}
	public void push(Object obj){
		list.addFirst(obj);
	}
	public Object pop() {
		return list.removeFirst();
	}
	public Object top() {
		return list.getFirst();
	}
	public String toString() {
		String str = "";
		ListIterator iter = list.getIterator();
		while (iter.hasNext()) {
			str = ((String) iter.next()) + "\n" + str;
		}
		return str;
	}
	
}
class LinkedQueue implements Queue {
	List list;
	public LinkedQueue() {
		list = new LinkedList();
	}
	public void makeEmpty() {
		list = new LinkedList();
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public void enqueue(Object obj) {
		list.addLast(obj);
	}
	public Object dequeue() {
		return list.removeFirst();
	}
	public Object getFront() {
		return list.getFirst();
	}
	public String toString() {
		String str = "";
		ListIterator iter = list.getIterator();
		while (iter.hasNext()) {
			str += ((String) iter.next()) + "\n";
		}
		return str;
	}
}
class LinkedDictionary implements Dictionary {
	private class Pair {
		private Comparable key;
		private Object value;
		public Pair() {
			key=null;
			value=null;
		}
		public Pair(Comparable k, Object o) {
			key=k;
			value=o;
		}
		public void setKey(Comparable k) {
			key=k;
		}		
		public void setValue(Object o) {
			value=o;
		}
		public Comparable getKey() {
			return key;
		}
		public Object getValue() {
			return value;
		}
	}
	List list;
	public LinkedDictionary() {
		list = new LinkedList();
	}
	public void makeEmpty() {
		list.makeEmpty();
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public void insert(Comparable key, Object obj) {
		try {remove(key); }
		catch(NoSuchElementException e) {}
		list.addLast(new Pair(key,obj));
	}
	public void remove(Comparable key) {
		ListIterator iter = list.getIterator();
		while (iter.hasNext()) {
			Object tmp = iter.next();
			if (((Pair) tmp).getKey().equals(key)) {
				iter.remove();
				break;
			}
		}
	}
	public Object find(Comparable key) {
		ListIterator iter = list.getIterator();
		while (iter.hasNext()) {
			Pair tmp = (Pair) iter.next();
			if (tmp.getKey().equals(key)) {
				return ((Pair)tmp).getValue();
			}
		}
		throw new NoSuchElementException();
	}
	public String toString() {
		String str = "";
		ListIterator iter = list.getIterator();
		while (iter.hasNext()) {
			str += ((Pair) iter.next()).getValue() + "\n";
		}
		return str;
	}
}
class LinkedSet implements Set {
	List list;
	public LinkedSet() {
		list = new LinkedList();
	}
	public void makeEmpty() {
		list.makeEmpty();
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public Object[] toArray() {
		int size = size();
		ListIterator iter = list.getIterator();
		Object[] v = new Object[size];
		for (int i=0; i<size; i++) {
			v[i]=iter.next();
		}
		return v;
	}
	public void insert(Object obj) {
		list.addLast(obj);
	}
	private int size() {
		int count=0;
		ListIterator iter = list.getIterator();
		while (iter.hasNext()) {
			iter.next();
			count++;
		}
		return count;
	}
	public boolean contains(Object obj) {
		return false;
	}
	public String toString() {
		String str = "";
		Object[] o = toArray();
		for (int i=0; i<o.length; i++) {
			str += o[i] + "\n";
		}
		return str;
	}
}
interface Set extends Container {
	Object[] toArray();
	void insert(Object obj);
	boolean contains(Object obj);
}
interface Dictionary extends Container {
	void insert(Comparable key, Object obj);
	void remove(Comparable key);
	Object find(Comparable key);
}	
interface Queue extends Container {
	void enqueue(Object obj);
	Object dequeue();
	Object getFront();
}
interface Stack extends Container {
	void push(Object obj);
	Object pop();
	Object top();
}

interface List extends Container {
	void addFirst(Object obj);
	void addLast(Object obj);
	Object getFirst();
	Object getLast();
	Object removeFirst();
	Object removeLast();
	ListIterator getIterator();
}
interface Container {
	boolean isEmpty();
	void makeEmpty();
}
interface ListIterator {  
	Object next();
	boolean hasNext();
	void add(Object obj);
	void remove();
}