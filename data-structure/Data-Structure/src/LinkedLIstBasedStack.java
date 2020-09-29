public class LinkedListBasedStack {
    private Node top = null;

    private class Node {
        private Object item;
        private Node next;

        public Node(Object item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    public void push(Object item) {
        top = new Node(item, top);
    }

    public Object pop() {
        if (top == null){
            throw new IllegalStateException("Cannot pop from an empty stack");
        }
        Object result = peek();
        top = top.next;
        return result;
    }

    public Object peek(){
        if (top == null) {
            throw NoSuchElementException("Cannot peek from an empty stack");
        }
        return top.item;
    }

    public int size(){
        int size = 0;
        for (Node node = top; node != null; node = node.next){
            size++;
        }
        return size;
    }
}