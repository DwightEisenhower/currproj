import java.util.Iterator;
public class DLL<E> implements Iterable<E> {
    private Node<E> head, tail;
    private int size;
    public static void main() {
        DLL<Integer> x = new DLL<>();
        x.add(new Integer(0));
        x.add(new Integer(4));
        x.add(new Integer(1));
        x.add(new Integer(9));
        x.add(new Integer(6));
        for(Integer in : x)
            System.out.println(in);
    }
    
    //O(1)
    public void add(E x) {
        Node<E> n = new Node<E>(x);
        size++;
        if(head == null) {
            head = n;
            tail = n;
            return;
        } else {
            tail.next = n;
            tail.next.prev = tail;
            tail = n;
        }
    }
    
    //O(n)
    public boolean remove(E x) {
        if(head == null)
            return false;
        Node<E> i = head;
        while(i != null) {
            if(i.value == x) {
                size--;
                if(i == tail)
                    tail = tail.prev;
                if(i == head)
                    head = head.next;
                if(i.prev != null)
                    i.prev.next = i.next;
                if(i.next != null)
                    i.next.prev = i.prev;
                return true;
            }
            i = i.next;
        }
        return false;
    }
    
    //O(n)
    public boolean contains(E x) {
        Node<E> i = head;
        while(i != null) {
            if(i.value.equals(x))
                return true;
            i = i.next;
        }
        return false;
    }
    
    public int size(){return size;}
    
    //O(n)
    public String toString() {
        if(size == 0)
            return null;
        StringBuilder sb = new StringBuilder();
        sb.ensureCapacity(size*2);
        for(E e : this)
            sb.append(e + "");
        return sb.toString();
    }
    
    public Iterator<E> iterator() {
        return new DLLIterator();
    }
    public class DLLIterator implements Iterator<E>{
        private Node<E> i;
        public DLLIterator() {
            i = head;
        }
        
        public boolean hasNext() {
            return i != null;
        }
        
        public E next() {
            E r = i.value;
            i = i.next;
            return r;
        }
    }
    public static class Node<E> {
        public E value;
        public Node<E> next, prev;
        public Node(E value) {
           this.value = value;
        }
        
        public String toString() {
            return value.toString();
        }
    }
}