import java.util.Scanner;
import java.util.NoSuchElementException;
public class Ripasso {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] words = line.split(" ");
		for (int i=0; i<words.length; i++) {
			System.out.println("< " + words[i] + " >");
		}
	}
	public static void mergeSortQueue(Queue q) {
		if (q==null) throw new IllegalArgumentException();
		if (q.isEmpty()) return;
		Comparable tmp = q.dequeue();
		if (q.isEmpty()) {
			q.enqueue(tmp);
			return;
		}
		Queue left = new MyQueue();
		Queue right = new MyQueue();
		left.enqueue(tmp);
		boolean flag = false;
		while (!q.isEmpty()) {
			if (flag = !flag) {
				right.enqueue(q.dequeue());
			} else {
				right.enqueue(q.dequeue());
			}
		}
		mergeSortQueue(left);
		mergeSortQueue(right);
		mergeQueue(q, left, right);
	}
	public static void mergeQueue(Queue a, Queue b, Queue c) {
		while (!b.isEmpty() && !c.isEmpty()) {
			if (b.getFront().compareTo(c.getFront())<0) {
				a.enqueue(b.dequeue());
			} else if (b.getFront().compareTo(c.getFront())>0) {
				a.enqueue(c.dequeue());
			} else {
				a.enqueue(b.dequeue());
				c.dequeue();
			}
		}
		while (!b.isEmpty()) {
			a.enqueue(b.dequeue());
		}
		while (!c.isEmpty()) {
			a.enqueue(c.dequeue());
		}
	}
	public static void mergeSortStack(Stack s) {
		if (s==null) throw new IllegalArgumentException();
		if (s.isEmpty()) return;
		Comparable tmp = s.pop();
		if (s.isEmpty()) {
			s.push(tmp);
			return;
		}
		Stack left = new MyStack();
		Stack right = new MyStack();
		boolean flag = false;
		left.push(tmp);
		while (!s.isEmpty()) {
			if (flag = !flag) {
				right.push(s.pop());
			} else {
				left.push(s.pop());
			}
		}
		mergeSortStack(left);
		mergeSortStack(right);
		mergeStack(s, left, right);
	}
	public static void mergeStack(Stack a, Stack b, Stack c) {
		Stack tmp = new MyStack();
		while (!b.isEmpty() && !c.isEmpty()) {
			if (b.top().compareTo(c.top())<0) {
				tmp.push(b.pop());
			} else if (b.top().compareTo(c.top())>0) {
				tmp.push(c.pop());
			} else {
				tmp.push(c.pop());
				b.pop();
			}
		}
		while (!b.isEmpty()) {
			tmp.push(b.pop());
		}
		while (!c.isEmpty()) {
			tmp.push(c.pop());
		}
		while (!tmp.isEmpty()) {
			a.push(tmp.pop());
		}
	}
}

class LinkedList implements List {
	private class LinkedListIterator implements ListIterator {
		private ListNode current, previous;
		public LinkedListIterator() {
			current = head;
			previous = null;
		}
		public boolean hasNext() {
			return current.getNext()!=null;
		}
		public Object next() {
			if (!hasNext()) {
				throw new IllegalStateException();
			}
			previous = current;
			current = current.getNext();
			return current.getElement();
		}
		public void add(Object x) {
			ListNode n = new ListNode(x, current.getNext());
			current.setNext(n);
			previous = current;
			current = n;
			if (!hasNext()) {
				LinkedList.this.tail=current;
			}
		}
		public void remove() {
			if (previous==null) {
				throw new IllegalStateException();
			}
			previous.setNext(current.getNext());
			current = previous;
			previous=null;
			if (!hasNext()) {
				LinkedList.this.tail = current;
			}
		}
	}
	private class ListNode {
		private Object element;
		private ListNode next;
		public ListNode() {
			element=null;
			next=null;
		}
		public ListNode(Object x, ListNode n) {
			element=x;
			next=n;
		}
		public Object getElement() {
			return element;
		}
		public ListNode getNext() {
			return next;
		}
		public void setElement(Object x) {
			element=x;
		}
		public void setNext(ListNode n) {
			next=n;
		}
	}
	private ListNode head, tail;
	public LinkedList() {
		head=tail=new ListNode(null, null);
	}
	public boolean isEmpty() {
		return head==tail;
	}
	public void makeEmpty() {
		head=tail=new ListNode(null, null);
	}
	public void addFirst(Object x) {
		head.setElement(x);
		head = new ListNode(null, head);
	}
	public void addLast(Object x){
		ListNode n = new ListNode(x, null);
		tail.setNext(n);
		tail=n;
	}
	public Object getFirst(){
		return head.getNext().getElement();
	}
	public Object getLast(){
		return tail.getElement();
	}
	public void removeFirst(){
		head = head.getNext();
		head.setElement(null);
	}
	public void removeLast(){
		ListNode tmp = head;
		while (tmp.getNext()!=tail) {
			tmp = tmp.getNext();
		}
		tail=tmp;
		tail.setNext(null);
	}
	public ListIterator getIterator() {
		return new LinkedListIterator();
	}
}
interface List extends Container {
	void addFirst(Object x);
	void addLast(Object x);
	Object getFirst();
	Object getLast();
	void removeFirst();
	void removeLast();
	ListIterator getIterator();
}
interface ListIterator {
	boolean hasNext();
	Object next();
	void add(Object x);
	void remove();
}
class MySet implements Set {
	private Comparable[] v;
	private int vSize;
	public MySet() {
		v = new Comparable[1];
		makeEmpty();
	}
	public boolean isEmpty(){
		return vSize==0;
	}
	public void makeEmpty(){
		vSize=0;
	}
	public void add(Comparable x){
		if (contains(x)) return;
		if (vSize==v.length) {
			Comparable[] arr = new Comparable[vSize*2];
			System.arraycopy(v,0,arr,0,vSize);
			v=arr;
		}
		int j;
		for (j=vSize; j>0 && x.compareTo(v[j-1])<0; j--) {
			v[j]=v[j-1];
		}
		v[j]=x;
		vSize++;
	}
	public boolean contains(Comparable x){
		return binSearch(v,x,0,vSize-1);
	}
	public Comparable[] toArray(){
		Comparable[] arr = new Comparable[vSize];
		System.arraycopy(v,0,arr,0,vSize);
		return arr;
	}
	private static boolean binSearch(Comparable[] a, Comparable obj, int from, int to) {
		if (a==null) throw new IllegalArgumentException();
		if (from>to) return false;
		int mid = (from+to)/2;
		if (obj.equals(a[mid])) {
			return true;
		}
		if (obj.compareTo(a[mid])>0) {
			return binSearch(a,obj,mid+1,to);
		}
		return binSearch(a,obj,from,mid-1);
	}
	public Set union(Set s) {
		Comparable[] s1 = this.toArray();
		Comparable[] s2 = s.toArray();
		Set res = new MySet();
		int i=0;
		int j=0;
		while (i<s1.length && j<s2.length) {
			if (s1[i].compareTo(s2[j])>0) {
				res.add(s2[j++]);
			} else if (s1[i].compareTo(s2[j])<0) {
				res.add(s1[i++]);
			} else {
				res.add(s2[j++]);
				i++;
			}
		}
		while (i<s1.length) {
			res.add(s1[i++]);
		}
		while (j<s2.length) {
			res.add(s2[j++]);
		}
		return res;
	}
	public Set intersection(Set s) {
		Comparable[] s1 = this.toArray();
		Comparable[] s2 = s.toArray();
		Set res = new MySet();
		int i=0;
		int j=0;
		while (i<s1.length) {
			while (j<s2.length && s1[i].compareTo(s2[j])>0) {
				j++;
			}
			if (j==s2.length) { break; }
			if (s1[i].equals(s2[j])) {
				res.add(s2[j]);
			}
			i++;
		}
		return res;
	}
	public Set subtraction(Set s) {
		Comparable[] s1 = this.toArray();
		Comparable[] s2 = s.toArray();
		Set res = new MySet();
		int i=0;
		int j=0;
		while (i<s1.length) {
			while (j<s2.length && s1[i].compareTo(s2[j])>0) {
				j++;
			}
			if (j==s2.length) { break; }
			if (!s1[i].equals(s2[j])) {
				res.add(s1[i]);
			}
			i++;
		}
		while (i<s1.length) {
			res.add(s1[i++]);
		}
		return res;
	}
	public String toString() {
		String str = "[ ";
		for (int i=0; i<vSize; i++) {
			str += v[i] + " ";
		}
		return str + "]";
	}
}
interface Set extends Container {
	void add(Comparable x);
	boolean contains(Comparable x);
	Comparable[] toArray();
	Set union(Set s);
	Set intersection(Set s);
	Set subtraction(Set s);
	String toString();
}
class MyDictionary implements Dictionary {
	private class Pair {
		private Comparable key;
		private Object value;
	}
	private Pair[] v;
	private int vSize;
	public MyDictionary() {
		v = new Pair[1];
		makeEmpty();
	}
	public boolean isEmpty() {
		return vSize==0;
	}
	public void makeEmpty() {
		vSize=0;
	}
	public void insert(Comparable k, Object x) {
		try { remove(k);  }
		catch (NoSuchElementException e) {}
		if (vSize==v.length) {
			Pair[] arr = new Pair[vSize*2];
			System.arraycopy(v,0,arr,0,vSize);
			v=arr;
		}
		int j;
		for (j=vSize; j>0 && k.compareTo(v[j-1].key)<0; j--) {
			v[j]=v[j-1];
		}
		v[j]=new Pair();
		v[j].key=k;
		v[j].value=x;
		vSize++;
	}
	public Object find(Comparable k){
		int index = binSearch(v, k, 0, vSize-1);
		if (index!=(-1)) {
			return v[index].value;
		} else {
			throw new EmptyDictionaryException();
		}
	}
	public void remove(Comparable k){
		int index = binSearch(v, k, 0, vSize-1);
		if (index!=(-1)) {
			for (int i=index; i<vSize-1; i++) {
				v[i]=v[i+1];
			}
		} else {
			throw new EmptyDictionaryException();
		}
	}
	private static int binSearch(Pair[] a, Comparable key, int from, int to) {
		if (a==null) throw new IllegalArgumentException();
		if (from>to) return -1;
		int mid = (from+to)/2;
		if (key.equals(a[mid].key)) {
			return mid;
		}
		if (key.compareTo(a[mid].key)>0) {
			return binSearch(a, key, mid+1, to);
		}
		return binSearch(a, key, from, mid-1);
	}
}
interface Dictionary extends Container {
	void insert(Comparable k, Object x);
	Object find(Comparable k);
	void remove(Comparable k);
}
class GrowingQueue extends MyQueue {
	private int increment(int index) {
		return (index+1)%v.length;
	}
	public void enqueue(Comparable obj) {
		if (increment(back)==front) {
			Comparable[] arr = new Comparable[v.length*2];
			System.arraycopy(v,front,arr,0,v.length-front);
			if (back<front) {
				System.arraycopy(v,0,arr,v.length-front,back);
				back+=v.length-front;
			} else {
				back=back-front;
			}
			front=0;
			v=arr;
		}
		v[back]=obj;
		back = increment(back);
	}
	public Comparable dequeue(){
		Comparable tmp = getFront();
		front = increment(front);
		return tmp;
	}
}
class MyQueue implements Queue {
	protected Comparable[] v;
	protected int front, back;
	public MyQueue() {
		v = new Comparable[1];
		makeEmpty();
	}
	public boolean isEmpty() {
		return front == back;
	}
	public void makeEmpty() {
		front = back = 0;
	}
	public void enqueue(Comparable obj){
		if (back==v.length) {
			Comparable[] arr = new Comparable[v.length*2];
			System.arraycopy(v,0,arr,0,back);
			v = arr;
		}
		v[back++]=obj;
	}
	public Comparable dequeue(){
		Comparable tmp = getFront();
		front++;
		return tmp;
	}
	public Comparable getFront(){
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return v[front];
	}
}
interface Queue extends Container {
	void enqueue(Comparable obj);
	Comparable dequeue();
	Comparable getFront();
}
class MyStack implements Stack {
	private Comparable[] v;
	private int vSize;
	
	public MyStack() {
		v = new Comparable[1];
		makeEmpty();
	}
	public boolean isEmpty(){
		return vSize==0;
	}
	public void makeEmpty(){
		vSize=0;
	}
	public void push(Comparable obj) {
		if (vSize==v.length) {
			Comparable[] arr = new Comparable[vSize*2];
			System.arraycopy(v,0,arr,0,vSize);
			v=arr;
		}
		v[vSize++]=obj;
	}
	public Comparable top() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return v[vSize-1];
	}
	public Comparable pop() {
		Comparable tmp = top();
		vSize--;
		return tmp;
	}
}
interface Stack extends Container {
	void push(Comparable obj);
	Comparable pop();
	Comparable top();
}
interface Container {
	boolean isEmpty();
	void makeEmpty();
}
class EmptyStackException extends RuntimeException {}
class EmptyQueueException extends RuntimeException {}
class EmptyDictionaryException extends RuntimeException {}