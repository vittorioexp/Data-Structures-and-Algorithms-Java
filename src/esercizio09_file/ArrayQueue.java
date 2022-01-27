public class ArrayQueue implements Queue
{  protected Object[] v;
   protected int front, back;
   public ArrayQueue()
   {  v = new Object[100];
      makeEmpty();
   }
   public void makeEmpty()
   {  front = back = 0;
   }
   public boolean isEmpty()
   {  return (back == front);
   }
   public Object getFront()
   {  if (isEmpty()) throw new EmptyQueueException();
      return v[front];
   }
   public void enqueue(Object obj)
   {  if (increment(back) == front)
      {  v = resize(v, 2*v.length);
         if (back < front)
         {  System.arraycopy(v, 0, v, v.length/2, back);
            back += v.length/2;
         }
      }
      v[back] = obj;
      back = increment(back);
   }
   public Object dequeue()
   {  Object obj = getFront();
      front = increment(front);
      return obj;
   }
   protected int increment(int index)
   {  return (index + 1) % v.length;
   }
   protected Object[] resize(Object[] oldArray, int newLength)
   {  if (newLength < oldArray.length)
         throw new IllegalArgumentException();
      Object[] newArray = new Object[newLength];
      System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
      return newArray;
   }
}