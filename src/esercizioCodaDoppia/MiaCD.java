public class MiaCD implements CD {
private Object[] v;
private int front, back;
public MiaCD () {
	v = new Object[1];
	front=back=0;
}
public int size() {
	return back-front;
}
public boolean isEmpty() {
	return front==back;
}
public void addFirst (Object x) // aggiunge all'inizio della coda
{
	if (front==0) {
		Object[] tmp = new Object[v.length*2];
		System.arraycopy(v,0,tmp,v.length,back-front);
		front+=v.length;
		back+=v.length;
		v = tmp;
	}
	v[--front]=x;
}
public void addLast (Object x) // aggiunge alla fine della coda
{
	if (back==v.length) {
		Object[] tmp = new Object[v.length*2];
		System.arraycopy(v,front,tmp,0,back-front);
		back-=front;
		front=0;
		v = tmp;
	}
	v[back++]=x;
}
public Object removeFirst () throws EmptyCDException // toglie dall'inizio
{
	if (isEmpty()) {
		throw new EmptyCDException();
	}
	return v[front++];
}
public Object removeLast () throws EmptyCDException // toglie dalla fine
{
	if (isEmpty()) {
		throw new EmptyCDException();
	}
	return v[--back];
}
public Object getFirst () throws EmptyCDException // elemento all'inizio
{
	if (isEmpty()) {
		throw new EmptyCDException();
	}
	return v[front];
}
public Object getLast () throws EmptyCDException // elemento alla fine
{
	if (isEmpty()) {
		throw new EmptyCDException();
	}
	return v[back-1];
}
}