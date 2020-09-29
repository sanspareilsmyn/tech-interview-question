import java.util.LinkedList;

public class QueueBasedStack {
    private LinkedList<T> queue = null;

    public QueueBasedStack(){
        queue = new LinkedList<T>();
    }

    public void push(T item){
        queue.add(item);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }
    
    public T pop(){
        return queue.remove();
    }
    
    public T peek(){
        return queue.peek();
    }
    
    public int size(){
        return queue.size();
    }
    
    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
