import java.util.Iterator;
public class DoubleEndedQueue<E> implements Iterable<E> {//Deque, pronounced just like deck
    private Node<E> head, tail;
    public DoubleEndedQueue() {
        head = tail = null;
    }
    
    public static void main() {
        DoubleEndedQueue<Integer> deq = new DoubleEndedQueue<>();
        deq.addHead(5);
        deq.addTail(10);
        deq.addTail(1);
        deq.addTail(4);
        deq.addHead(7);
        print(deq.toString());
        
        Iterator<Integer> iter = deq.iterator();
        while(iter.hasNext())
            if(iter.next().equals(1))
                iter.remove();
        print(deq.toString());
    }
    
    public static void print(Object o) {
        System.out.println(o);
    }
    
    public void addHead(E x) {
        Node<E> neu = new Node(x);
        if(isEmpty())
            head = tail = neu;
        else {
            neu.next = head;
            head.prev = neu;
            head = neu;
        }
    }
    
    public void addTail(E x) {
        Node<E> neu = new Node(x);
        if(isEmpty())
            head = tail = neu;
        else {
            neu.prev = tail;
            tail.next = neu;
            tail = neu;
        }
    }
    
    public E removeHead() {
        if(isEmpty())
            return null;
        E temp = head.value;
        head = head.next;
        head.prev = null;
        if(head == null)
            tail = null;
        return temp;
    }
    
    public E removeTail() {
        if(isEmpty())
            return null;
        E temp = tail.value;
        tail = tail.prev;
        tail.next = null;
        if(tail == null)
            head = null;
        return temp;
    }
    
    public E peekHead() {
        return head.value;
    }
    
    public E peekTail() {
        return tail.value;
    }
    
    public boolean isEmpty() {
        return head == null && tail == null;
    }
    
    public Iterator<E> iterator() {
        Iterator<E> iter = new Iterator<E>() {
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
            
            @Override
            public void remove() {
                if(i != null) {
                    Node<E> temp = i.prev;
                    if(temp == head)
                        removeHead();
                    else {
                        temp.prev = temp.next;
                        temp.next = temp.prev;
                    }
                } else
                    removeTail();
            }
        };
        return iter;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(E e : this)
            sb.append(e + " ");
        return sb.toString();
    }
    public class Node<E> {
        public Node next, prev;
        public E value;
        public Node(E value) {
            next = prev = null;
            this.value = value;
        }
        
        public String toString() {
            return value+"";
        }
    }
}
