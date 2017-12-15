import java.util.Iterator;
/**
 * @Author: Danylo Mirin
 * @Date: 9/29/17
 */
public class Queue<E> implements Iterable<E> {
    private Node<E> head, tail;
    public Queue() {
        head = tail = null;
    }
    
    public static void main() {
        Queue<String> yes = new Queue<>();
        yes.enqueue("A");
        yes.enqueue("B");
        yes.enqueue("C");
        yes.enqueue("D");
        yes.enqueue("E");
        print(yes.toString());
        yes.dequeue();
        yes.dequeue();
        yes.dequeue();
        yes.dequeue();
        yes.dequeue();
        print(yes.toString());
        yes.dequeue();
        print(yes.toString());
    }
    
    public static void print(Object o) {
        System.out.println(o);
    }
    
    public void enqueue(E x) {
        Node<E> neu = new Node<>(x);
        if(isEmpty())
            head = tail = neu;
        else {
            tail.next = neu;
            tail = neu;
        }
    }
    
    public E dequeue() {
        if(isEmpty())
            return null;
        E temp = head.value;
        head = head.next;
        if(isEmpty())
            tail = null;
        return temp;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
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
    public class QueueIterator implements Iterator<E> {
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