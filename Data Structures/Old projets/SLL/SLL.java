/**
 * Singly Linked List
 */
public class SLL
{
    private Node head, tail;
    private int size = 0;
    public static void main() {
        SLL x = new SLL();
        for(int i = 0; i < 2000; i++) {
            x.add((int)(Math.random()*100));
            System.out.println("Added element "+i);
        }
        System.out.println(x.size());
    }
    
    //O(1)
    public void add(Integer x) {//works
        Node n = new Node(x);
        size++;
        if(head == null) {
            head = n;
            tail = n;
            return;
        }
        tail.next = n;
        tail = n;
    }
    
    //O(n)
    public boolean remove(Integer x) {
        if(head == null)
            return false;
        else if(head.value == x) {
            head = head.next;
            size--;
            return true;
        }
        Node i = head;
        while(i.next != null) {
            if(i.next.value == x) {
                if(i.next == tail)
                    tail = i;
                i.next = i.next.next;
                size--;
                return true;
            }
            i = i.next;
        }
        return false;
    }
    
    //O(n)
    public boolean contains(Integer x) {//works
        Node n = new Node(x);
        Node i = head;
        while(i.next != null)
            if(i == n)
                return true;
            else
                i = i.next;
        return false;
    }
    
    //O(1)
    public int size() {
        return size;
    }
    
    //O(n)
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.ensureCapacity(size*2);
        Node i = head;
        while(i.next != null) {
            sb.append(i.value + " ");
            i = i.next;
        }
        return sb.toString();
    }
}
