public class ArrayBasedStack {
    private Object[] array;
    private int size = 0;

    public ArrayBasedStack(int capacity){
        array = new Object[capacity];
    }

    public void push(Object item){
        if (size == array.length){
            throw new IllegalStateException("Cannot insert on full Stack");
        }
        array[size++] = item;
    }

    public Object pop(){
        if (size == 0){
            throw NoSuchElementException("Cannot delete from an empty Stack");
        }
        Object result = array[size-1];
        array[size-1] = null;
        size--;
        return result;
    }

    public Object peek(){
        if (size == 0){
            throw NoSuchElementException("Cannot delete from an empty Stack");
        }
        return array[size-1];
    }

    public int size(){
        return size; 
    }

    public boolean isEmpty(){
        return size == 0;
    }
}

