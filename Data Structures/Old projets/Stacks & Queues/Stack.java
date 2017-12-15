import java.util.Iterator;
public class Stack<E> implements Iterable<E> {
    private Node<E> head;
    public Stack() {
        head = null;
    }
    
    public void push(E x) {
        Node<E> neu = new Node<>(x);
        neu.next = head;
        head = neu;
    }
    
    public E pop() {
        if(isEmpty())
            return null;
        Node<E> temp = head;
        head = head.next;
        return temp.value;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }
    
    public E peek() {
        if(isEmpty())
            return null;
        else
            return head.value;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(E e : this)
            sb.append(e + "");
        return sb.toString();
    }
    public class StackIterator implements Iterator<E> {
        private Node<E> i = head;
        @Override
        public boolean hasNext() {
            return i != null;
        }
        
        @Override
        public E next() {
            E temp = i.value;
            i = i.next;
            return temp;
        }
    }
    public class Node<E> {
        public Node<E> next;
        public E value;
        public Node(E value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return value.toString();
        }
    }
}