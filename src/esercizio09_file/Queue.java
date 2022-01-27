public interface Queue extends Container
{  void enqueue(Object obj);
   Object dequeue();
   Object getFront();
}