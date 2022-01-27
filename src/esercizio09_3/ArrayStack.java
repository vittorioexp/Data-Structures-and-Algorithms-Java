public class ArrayStack implements Stack
{  protected Object[] v;
   protected int vSize;
   public ArrayStack()
   {  v = new Object[100];
      makeEmpty();
   }
   public void makeEmpty()
   {  vSize = 0;
   }
   public boolean isEmpty()
   {  return (vSize == 0);
   }
   public void push(Object obj)
   {  if (vSize == v.length)
         v = resize(v, 2*vSize);
      v[vSize++] = obj;
   }
   public Object top()
   {  if (isEmpty())
         throw new EmptyStackException();
      return v[vSize - 1];
   }
   public Object pop()
   {  Object obj = top();
      vSize--;
      return obj;
   }
   protected Object[] resize(Object[] oldArray, int newLength)
   {  if (newLength < oldArray.length)
         throw new IllegalArgumentException();
      Object[] newArray = new Object[newLength];
      System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
      return newArray;
   }
}
